package validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class ValidationHelper {
    private final PrintStream out;
    private final BufferedReader in;

    /**
     * Prompt the user until they provide a non-empty that is also not whitespace
     *
     * @param prompt - the message to show the user prompting for input
     * @param error  - the error message to show the user when incorrect
     * @return the user's non-blank String
     * @throws IOException
     */
    public String getRequiredString(String prompt, String error) throws IOException {
        // Always loops until input.length > 0
        while (true) {
            out.print(prompt);
            String input = in.readLine();

            // Removes leading and trailing spaces
            input = input.trim();

            // Case to end the while loop
            if (input.length() > 0) {
                return input;
            } else {
                out.print(error);
            }
        }
    }

    /**
     * Prompt the user until they provide valid integer value
     *
     * @param prompt - the message to show the user prompting for input
     * @param error  - the error message to show the user when incorrect
     * @return the user's integer value
     * @throws IOException
     */
    public int getIntegerInput(String prompt, String error) throws IOException {
        while (true) {
            try {
                out.print(prompt);
                String input = in.readLine();

                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                out.print(error);
            }
        }
    }

    /**
     * Prompt the user until they provide valid positive value
     *
     * @param prompt - the message to show the user prompting for input
     * @param error  - the error message to show the user when incorrect
     * @return
     * @throws IOException
     */
    public double getDoubleInput(String prompt, String error) throws IOException {
        while (true) {
            try {
                out.print(prompt);
                String input = in.readLine();

                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                out.print(error);
            }
        }
    }

    /**
     * Prompt the user until they provide valid floating point number
     *
     * @param prompt - the message to show the user prompting for input
     * @param error  - the error message to show the user when incorrect
     * @return the user's positive integer
     * @throws IOException
     */
    public int getPositiveInteger(String prompt, String error) throws IOException {
        while (true) {
            try {
                int input = getIntegerInput(prompt, error);

                if (input < 0) {
                    out.print(error);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                out.print(error);
            }
        }
    }

    /**
     * Prompt the user until they provide an integer greater than or equal to the
     * minimum
     *
     * @param prompt - the message to show the user prompting for input
     * @param error  - the error message to show the user when incorrect
     * @param min    - the minimum value acceptable
     * @return the user's selected integer at or above the minimum
     * @throws IOException
     */
    public int getMinimumIntegerInput(String prompt, String error, int min) throws IOException {
        while (true) {
            try {
                int input = getIntegerInput(prompt, error);

                if (input < min) {
                    out.print(error);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                out.print(error);
            }
        }
    }

    /**
     * Prompt the user until they provide a predetermined number of integer values
     * e.g., if you passed in "Test Score " this function would prompt Test Score 1:
     * Test Score 2: Test Score ....(up to the count)
     *
     * @param prompt - the message to show the user prompting for input
     * @param error  - the error message to show the user when incorrect
     * @param count  - the number of required integers from the user
     * @return an array equal to the size of count filled with the user's integers
     * @throws IOException
     */
    public int[] getSeveralIntegers(String prompt, String error, int count) throws IOException {
        int[] values = new int[count];

        while (true) {
            try {
                // Assigns every value in values to be an integer
                for (int i = 0; i < values.length; i ++) {
                    values[i] = getIntegerInput(prompt, error);
                }
                return values;
            } catch (NumberFormatException e) {
                out.print(error);
            }
        }
    }

    public ValidationHelper(PrintStream out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }
}