package strings;

/**
 * @author Michael Placzek
 */
public class BasicTextManipulations {
    public String reverse(String in) {
        StringBuilder reversed = new StringBuilder();

		// Loops through all characters of in backwards
        for (int i = in.length() - 1; i >= 0; i--) {
			// and appends it to reverse
            reversed.append(in.charAt(i));
        }
        return reversed.toString();
    }

    public int count(String within, char find) {
        int num = 0;

		// Loops through all characters of within
        for (int i = 0; i < within.length(); i++) {
			// Checks if it is the same as find
            if (find == within.charAt(i)) {
				// and increments num
                num++;
            }
        }
        return num;
    }

    public String onlyAlpha(String within) {
        StringBuilder alpha = new StringBuilder(within);

		// Loops through all characters of alpha
        for (int i = 0; i < alpha.length(); i++) {
			// Checks if it is not a digit OR if it is a space
            if (!Character.isLetterOrDigit(alpha.charAt(i)) || Character.isSpaceChar(alpha.charAt(i))) {
				// deletes the character
                alpha.deleteCharAt(i);

				// necessary or else it'll skip a character
                i--;
            }
        }
        return alpha.toString();
    }

    public int count(String within, String find) {
        int num = 0;
        int findLength = find.length();

		// Loops through all characters of within
        for (int i = 0; within.length() - i > findLength; i++) {
			// Checks if within's substring is the same as find
            if (find.equals(within.substring(i, i + findLength))) {
				// and increments num
                num++;
            }
        }
        return num;
    }

    public String markDoubles(String within) {
        char toFind = 0;

        // Special case to assign toFind
        if (within.length() > 0) {
            toFind = within.charAt(0);
        }

        for (int i = 1; i < within.length(); i++) {
            // Compares the next letter with toFind
            if (within.charAt(i) == toFind) {
                // Add a 2 between the repeating letters
                within = within.substring(0, i) + 2 + within.substring(i);
            }
            // Update toFind
            toFind = within.charAt(i);
        }
        return within;
    }

    public boolean isPalindrome(String within) {
		// Special case
        if (within.length() == 0) {
            return true;
        }

        // Gets first half of a word
        String firstHalf = within.substring(0, within.length() / 2);

        // Returns if the second half (odd length middle character is not counted)
        // is the same as reversed firstHalf
        return within.substring((within.length() / 2) + 1).equals(reverse(firstHalf));
    }

    public String swapCase(String within) {
		StringBuilder withinBuilder = new StringBuilder();

		// Loop through all characters in within
		for (int i = 0; i < within.length(); i ++) {
			char letter = within.charAt(i);

			// Check if letter is uppercase
			if (Character.isUpperCase(letter)) {
				// and make it lowercase + append it to withinBuilder
				withinBuilder.append(Character.toLowerCase(letter));
			} else {
				// and make it uppercase + append it to withinBuilder
				withinBuilder.append(Character.toUpperCase(letter));
			}
		}
		return withinBuilder.toString();
    }

    public int countNs(String within) {
        int num = 0;

		// Loops through all characters of within
        for (int i = 0; i < within.length(); i++) {
			// Checks if the character is 'n'
            if (within.charAt(i) == 'n') {
				// and increments num
                num++;
            }
        }
        return num;
    }
}