package impersonator;

/**
 * @author Michael Placzek
 */
public class CelebrityImpersonator {
    public String generateQuote(String quote, String generatorName) {
        StringBuilder result = new StringBuilder();

        // Breaks the quote by spaces and puts the results into words
        String[] words = quote.split(" ");

        switch (generatorName) {
            case "Canadian":
                // Adds ", eh?" to the quote
                result.append(quote).append(", eh?");
                break;
            case "Valley Girl":
                // Loops through every word in words
                for (int i = 0; i < words.length; i++) {
                    // adds "like " before every word
                    result.append("like ").append(words[i]);

                    if (i != words.length - 1) {
                        // adds a space if the word is not the last
                        result.append(" ");
                    }
                }
                break;
            case "Shatner":
                // Loops through every word in words
                for (String word : words) {
                    // adds the word followed by "...\n"
                    result.append(word).append("...\n");
                }
                break;
            case "Pirate":
                // Breaks the quote by r's and puts the results into rs
                String[] rs = quote.split("r");

                // Loops through every r-part in rs
                for (int i = 0; i < rs.length; i++) {
                    // adds every r-part
                    result.append(rs[i]);

                    if (i != rs.length - 1) {
                        // adds "RRRr" if the r-part is not the last
                        result.append("RRRr");
                    }
                }
                break;
            case "Zatanna":
                // Loops through every word in words
                for (int i = 0; i < words.length; i++) {
                    // and reverses the word and adds it
                    result.append(ModifiedBasicTextManipulations.reverse(words[i]));

                    if (i != words.length - 1) {
                        // adds a space if the word is not the last
                        result.append(" ");
                    }
                }
                break;
            case "Yoda":
                // Loops through every word in words
                for (int i = 0; i < words.length - 1; i += 2) {
                    result.append(words[i + 1]).append(" ").append(words[i]);

                    if (i != words.length - 2) {
                        // adds a space if the word is not the last two
                        result.append(" ");
                    }
                }
                break;
        }
        return result.toString();
    }

    /**
     * @author Michael Placzek
     */
    public static class ModifiedBasicTextManipulations {
        public static String reverse(String in) {
            StringBuilder reversed = new StringBuilder();

            // Loops through all characters of in backwards
            for (int i = in.length() - 1; i >= 0; i--) {
                // and appends it to reverse
                reversed.append(in.charAt(i));
            }
            return reversed.toString();
        }
    }
}
