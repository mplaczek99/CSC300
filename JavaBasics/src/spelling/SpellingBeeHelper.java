package spelling;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Michael Placzek
 */
public class SpellingBeeHelper {
	public static final String PROMPT = "Your Answer>> ";
	public static final String NO_INPUT_RESPONSE = "Please at least guess at the spelling";
	public static final String INCORRECT = "That was not correct, hit enter to try again, or n to move on";
	public static final String SKIP_RESPONSE = "n";
	public static final String COMPLETED = "You have completed the test";

	public static final String ATTEMPT_FILE = "spellingTest.txt";

	/**
	 * Load the spelling words from the specified file
	 * 
	 * @param filename - the name of the file
	 * @return a list of SpellingWord objects
	 */
	public List<SpellingWord> loadWords(String filename) throws IOException {
		Scanner input = new Scanner(new FileReader(filename));
		List<SpellingWord> words = new ArrayList<>();

		while (input.hasNext()) {
			String word = input.next().replace(",", "");
			// I feel like using a delimiter is better, but I'm not sure
			String audioFile = input.next();

			words.add(new SpellingWord(word, audioFile));
		}
		input.close();
		return words;
	}

	/**
	 * Prompt the test taker through the test as described in the design
	 * 
	 * @param words - the spelling words for the test
	 * @param in    - The input from the user
	 * @param out   - The output to the user
	 */
	public void promptTestTaker(List<SpellingWord> words, BufferedReader in, PrintStream out)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		for (SpellingWord word : words) {
			boolean hasErrors;

			do {
				hasErrors = false;
				AudioHelper.play(word.getAudioFile());

				long start = System.currentTimeMillis();

				// Prompt the user
				out.print(PROMPT);

				String answer = in.readLine();
				recordAttempt(word, answer, System.currentTimeMillis() - start);

				// Checks if there are any spaces
				if (answer.contains(" ") || answer.equals("")) {
					hasErrors = true;

					out.println(NO_INPUT_RESPONSE);
					continue;
				}

				if (!answer.equals(word.getWord())) {
					hasErrors = true;

					out.println(INCORRECT);

					String response = in.readLine();
					if (response.equals(SKIP_RESPONSE)) {
						break;
					}
				}
			} while (hasErrors);
		}
		out.println(COMPLETED);
	}

	/**
	 * Record a spelling word attempt by the user in their file.
	 * 
	 * @param word     - the attempted word
	 * @param answer   - their provided answer
	 * @param duration - the amount of time they took from the time the word was
	 *                 presented to the time they entered their answer in
	 *                 milliseconds
	 * @throws IOException //
	 */
	public void recordAttempt(SpellingWord word, String answer, long duration) throws IOException {
		PrintWriter out = new PrintWriter(new FileOutputStream(ATTEMPT_FILE, true));
		out.println(word.getWord() + "," + answer + "," + duration);
		out.close();
	}

	/**
	 * Open the provided file and evaluate the answers to the test
	 * 
	 * @param filename the test file
	 * @return a filled TestResults object
	 */
	public TestResults gradeTest(String filename) throws IOException {
		TestResults results = new TestResults();
		BufferedReader in = new BufferedReader(new FileReader(filename));

		for (String line = in.readLine(); line != null; line = in.readLine()) {
			// Splits the line to be in question
			String[] question = line.split(",");

			// Checks if the word is the answer
			if (question[0].equals(question[1])) {
				results.correct++;
			} else {
				results.incorrectAttempts++;
			}

			// Increments totalWords
			results.totalWords = Integer.parseInt(question[0].substring(4)) + 1;

			// Increments totalDuration
			results.totalDuration += Integer.parseInt(question[2]);
		}
		in.close();
		return results;
	}
}