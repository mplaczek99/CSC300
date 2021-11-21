package strings;

/**
 * @author Michael Placzek
 */
public class BasicTextManipulations {
    public String reverse(String in) {
        // Special case
        if (in == null) {
            return null;
        }

        return reverseHelper(in, in.length() - 1);
    }

    private String reverseHelper(String in, int i) {
        // Base case
        if (i < 0) {
            return "";
        }

        return in.charAt(i) + reverseHelper(in, i - 1);
    }

    public int count(String within, char find) {
        if (within.isEmpty()) {
            return 0;
        }

        return countHelper(within, find, 0, 0);
    }

    private int countHelper(String in, char find, int i, int sum) {
        // Base case
        if (i >= in.length()) {
            return sum;
        }

        if (in.charAt(i) == find) {
            sum++;
        }

        return countHelper(in, find, i + 1, sum);
    }

    public String onlyAlpha(String within) {
        // Base case
        if (within.length() == 0) {
            return "";
        }

        char current = within.charAt(0);

        if (Character.isLetter(current)) {
            return current + onlyAlpha(within.substring(1));
        }

        return onlyAlpha(within.substring(1));
    }

    public int count(String within, String find) {
        return countHelper(within, find, 0, 0);
    }

    private int countHelper(String within, String find, int index, int sum) {
        // Base case
        if (index >= within.length()) {
            return sum;
        }

        if (index + find.length() < within.length())
            if (within.startsWith(find, index)) sum++;

        return countHelper(within, find, index + 1, sum);
    }

    public String markDoubles(String within) {
        return markDoublesHelper(within, 0, "");
    }

    private String markDoublesHelper(String within, int index, String newWord) {
        // Base case
        if (index >= within.length()) {
            return newWord;
        }

        char letter = within.charAt(index);

        newWord += letter;

        if (index < within.length() - 1) if (letter == within.charAt(index + 1)) newWord += 2;

        return markDoublesHelper(within, index + 1, newWord);
    }


    public boolean isPalindrome(String within) {
        return reverse(within).equals(within);
    }

    public String swapCase(String within) {
        return swapCaseHelper(within, 0, "");
    }

    private String swapCaseHelper(String within, int index, String newWord) {
        // Base case
        if (index >= within.length()) {
            return newWord;
        }

        char letter = within.charAt(index);

        if (Character.isLetter(letter)) {
            if (Character.isLowerCase(letter)) newWord += Character.toUpperCase(letter);
            if (Character.isUpperCase(letter)) newWord += Character.toLowerCase(letter);
        } else {
            newWord += letter; // letter is a special character
        }

        return swapCaseHelper(within, index + 1, newWord);
    }

    public int countNs(String within) {
        return count(within, 'n');
    }
}