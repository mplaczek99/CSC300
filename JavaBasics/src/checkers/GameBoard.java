package checkers;

import java.util.Stack;

/**
 * @author Michael Placzek
 */
public class GameBoard implements Checkers {
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;

    /**
     * A move a player can make on this board
     */
    public class Move {
        char player;
        int fromRow;
        int fromColumn;
        int toRow;
        int toColumn;

        public Move(char p, int fc, int fr, int tc, int tr) {
            player = p;
            fromRow = fr;
            fromColumn = fc;
            toRow = tr;
            toColumn = tc;
        }

        @Override
        public String toString() {
            return "Move [player=" + player + ", fromRow=" + fromRow + ", fromColumn=" + fromColumn + ", toRow=" + toRow
                    + ", toColumn=" + toColumn + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + fromColumn;
            result = prime * result + fromRow;
            result = prime * result + toColumn;
            result = prime * result + toRow;
            return result;
        }
    }

    private char[][] board;
    private final Stack<Move> moves = new Stack<>(); //never used

    /**
     * Start a new game by reseting the pieces to their starting place on the board
     */
    public void startGame() {
        board = new char[WIDTH][HEIGHT]; // 8x8

        boolean ping = false;

        // Seems like an inefficient way... but, this actually is most efficient?
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (y > board.length - 4) {
                    board[y][x] = (ping) ? Checkers.PLAYER_1 : Checkers.EMPTY;

                    if (x < board.length - 1) {
                        ping = !ping;
                    }
                } else if (y < 3) {
                    board[y][x] = (ping) ? Checkers.PLAYER_2 : Checkers.EMPTY;

                    if (x < board.length - 1) {
                        ping = !ping;
                    }
                } else {
                    board[y][x] = Checkers.EMPTY;
                }
            }
        }
    }

    /**
     * Update the board with the provided move
     *
     * @param m the move to make Note: This does not need to determine if the move
     *          is valid, save that for the validateMove method
     */
    public void makeMove(Move m) {
        // Removes old piece and moves it on the board
        board[m.fromRow][m.fromColumn] = Checkers.EMPTY;
        board[m.toRow][m.toColumn] = m.player;

        // Check if the move was a Jump
        if (Math.abs(m.toRow - m.fromRow) == 2) {
            // if so, set square at midpoint of jump to be EMPTY
            board[(m.toRow + m.fromRow) / 2][(m.toColumn + m.fromColumn) / 2] = Checkers.EMPTY;
        }
    }

    /**
     * Validate the proposed move on the current game board
     *
     * @param m - the proposed move
     * @return one of the constants from the Checkers interface, OK_MOVE if valid
     */
    public String validateMove(Move m) {
        // Check if the player is the wrong piece
        if (board[m.fromRow][m.fromColumn] != m.player) {
            return Checkers.WRONG_PIECE;
        }

        // Checks if it is a valid jump
        if (Math.abs(m.toRow - m.fromRow) >= 2 || Math.abs(m.toColumn - m.fromColumn) >= 2) {
            // checks if the jump was like a "right triangle"
            if (Math.abs(m.toRow - m.fromRow) != 2 || Math.abs(m.toColumn - m.fromColumn) != 2) {
                return Checkers.ONLY_2;
            }

            // check if there is a friendly in the midpoint of the jump
            if (board[(m.toRow + m.fromRow) / 2][(m.toColumn + m.fromColumn) / 2] == m.player) {
                return Checkers.JUMP_SELF;
            }

            // check if there is an empty spot in the midpoint of the jump
            if (board[(m.toRow + m.fromRow) / 2][(m.toColumn + m.fromColumn) / 2] == Checkers.EMPTY) {
                return Checkers.JUMP_EMPTY;
            }
        }

        // Checks if Player 1 is going up and checks if Player 2 is going down
        if (m.player == Checkers.PLAYER_1) {
            if (m.toRow - m.fromRow > 0) {
                return Checkers.PLAYER_1_UP;
            }
        } else if (m.toRow - m.fromRow < 0) {
            return Checkers.PLAYER_2_DOWN;
        }

        // Checks if the space is not empty
        if (board[m.toRow][m.toColumn] != Checkers.EMPTY) {
            return Checkers.SPACE_TAKEN;
        }

        return Checkers.OK_MOVE;
    }

    private void printBorder(int width) {
        for (int c = 0; c < width; c++) {
            System.out.print("+---");
        }
        System.out.println("+ ");
    }

    private void printSquares(char[] r, int rowNumber) {
        for (char piece : r) {
            System.out.print("| " + piece + " ");
        }
        System.out.println("| " + rowNumber);
    }

    public void drawBoard() {
        int rowNumber = 0;
        for (char[] r : board) {
            printBorder(r.length);
            printSquares(r, rowNumber++);
        }
        printBorder(board[0].length);
        for (int i = 0; i < WIDTH; i++) {
            System.out.print("  " + i + " ");
        }
        System.out.println();
    }

    public char[][] getBoard() {
        return board;
    }
}