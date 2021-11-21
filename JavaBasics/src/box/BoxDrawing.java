package box;

/**
 * @author Michael Placzek
 */
public class BoxDrawing {
	public static final String EXAMPLE_SOLID_BOX = "*****\n*****\n*****\n*****\n*****\n";

	public String drawFilledBox(int height, int width) {
		String box = "";

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				box += "*";
			}
			box += "\n";
		}

		return box;
	}

	public static final String EXAMPLE_EMPTY_BOX = "*****\n*   *\n*   *\n*   *\n*****\n";

	public String drawEmptyBox(int height, int width) {
		String box = "";

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i == 0 || i == height - 1) {
					box += "*";
				} else {
					if (j == 0 || j == width - 1) {
						box += "*"; // The wall of the box
					} else {
						box += " "; // The empty part of the box
					}
				}
			}
			box += "\n";
		}

		return box;
	}

	public static final String EXAMPLE_RIGHT_TRIANGLE = "*\n**\n***\n****\n*****\n";

	public String drawRightTriangle(int length) {
		String triangle = "";

		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				triangle += "*";
			}
			triangle += "\n";
		}

		return triangle;
	}

	public static final String EXAMPLE_FLIPPED_RIGHT_TRIANGLE = "*****\n****\n***\n**\n*\n";

	public String drawFlippedRightTriangle(int length) {
		String triangle = "";

		for (int i = length; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				triangle += "*";
			}
			triangle += "\n";
		}

		return triangle;
	}

	public static final String EXAMPLE_MIRRORED_RIGHT_TRIANGLE = "    *\n   **\n  ***\n ****\n*****\n";

	public String drawMirroredRightTriangle(int length) {
		String triangle = "";

		for (int i = 0; i < length; i++) {
			// Print as many spaces from length - what line it is (i)
			for (int j = length - (i + 1); j > 0; j--) {
				triangle += " ";
			}

			// Print as much *s until i (end of line) is reached
			for (int z = 0; z < i + 1; z++) {
				triangle += "*";
			}
			triangle += "\n";
		}

		return triangle;
	}

	public static final String EXAMPLE_ISOSOLESE_TRIANGLE = "    *\n   ***\n  *****\n *******\n*********\n";

	public String drawIsosoleseTriangle(int length) {
		String triangle = "";

		for (int i = 0; i < length; i++) {
			// Print as many spaces from length - what line it is (i)
			for (int j = length - (i + 1); j > 0; j--) {
				triangle += " ";
			}

			// Print as much *s until i (end of line) is reached
			for (int z = 0; z < 2 * i + 1; z++) {
				triangle += "*";
			}
			triangle += "\n";
		}

		return triangle;
	}
}