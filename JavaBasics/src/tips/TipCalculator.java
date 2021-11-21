package tips;

/**
 * @author Michael Placzek
 */
public class TipCalculator {
	/**
	 * Compute the tip based on the provided amount and percentage. If the roundUp
	 * flag is set, the tip should round the total up to the next full dollar
	 * amount.
	 * 
	 * @param billTotal     - total of the purchase
	 * @param percentage - the percentage tip (e.g., .2 = 20%, 1 = 100%)
	 * @param roundUp    - if true, add to the tip so the amount + tip is an even
	 *                   dollar amount
	 * @return	- the calculated tip
	 */
	public double computeTip(double billTotal, double percentage, boolean roundUp) {
		if (!roundUp) {
			return billTotal * percentage;
		}

		double billPart = billTotal - ((int) billTotal);

		return (int) (billTotal * percentage) + (1 - billPart);
	}

	/**
	 * Run a command line version of the tip calculator. It does NOT prompt the
	 * user. The user must call using the following arguments: <REQUIRED> -price
	 * xx.xx => the -price flag followed by a price -percent xx.x => the -percent
	 * flag followed by a percent tip (e.g., 15.5 would be a 15.5% tip) <OPTIONAL>
	 * roundup => the flag indicating to add an extra amount to the tip to round up
	 * to the next dollar value For example, java tips.TipCalculator -price 10.00
	 * -percent 25 or java tips.TipCalculator -price 10.00 -percent 25 roundup
	 * 
	 * @param args - may contain -price x -percent x roundup
	 */
	public static void main(String[] args) {
		boolean roundUp = false; // temporary value
		double price = 10.0; // temporary value
		double percent = 0.15; // temporary value

		// Check if the args has certain flags
		for (int i = 0; i < args.length; i ++) {
			switch (args[i]) {
				case "-price":
					price = Double.parseDouble(args[i + 1]);
					i++;
				break;
				case "-percent":
					percent = Double.parseDouble(args[i + 1]) / 100;
					// I feel that adding / 100 was necessary, even though it goes against what I thought the parameter
					// for percentage actually was
					i++;
				break;

				case "roundup":
					roundUp = true;
				break;
			}
		}

		// Fill the values above from the command line parameters (args) so the rest of
		// this call works.

		TipCalculator tc = new TipCalculator();
		double tip = tc.computeTip(price, percent, roundUp);
		double total = price + tip;
		System.out.printf("For $%.2f at a tip of %.1f%%%s\nTip: $%.2f\nTotal: $%.2f\n", price, percent * 100,
				(roundUp ? " rounded up" : ""), tip, total);
	}
}