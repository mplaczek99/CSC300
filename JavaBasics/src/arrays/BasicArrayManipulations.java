package arrays;

import java.util.Arrays;

/**
 * @author Michael Placzek
 */
public class BasicArrayManipulations {
	public int total(int[] values) {
		int num = 0;

		for (int n : values) {
			num += n;
		}
		return num;
	}

	public double mean(int[] values) {
		if (values.length != 0) {
			return (double) total(values) / values.length;
		}
		return 0;
	}

	public int count(int[] values, int find) {
		int num = 0;

		for (int i : values) {
			if (i == find) {
				num++;
			}
		}
		return num;
	}

	public double median(int[] values) {
		if (values.length != 0) {
			Arrays.sort(values);

			// Check if values is odd
			if (values.length % 2 != 0) {
				return values[values.length / 2];
			}

			int[] nums = { values[(values.length / 2)], values[(values.length / 2) - 1] };

			return mean(nums);
		}
		return 0;
	}

	public int largest(int[] values) {
		int num = 0;

		for (int i : values) {
			if (num < i) {
				num = i;
			}
		}
		return num;
	}

	public int smallest(int[] values) {
		int num = 0;

		if (values.length != 0) {
			num = values[0];

			for (int i = 1; i < values.length; i++) {
				if (num > values[i]) {
					num = values[i];
				}
			}
		}
		return num;
	}

	public boolean tenTimes(int[] values) {
		for (int i : values) {
			for (int j : values) {
				if (i == j) {
					continue;
				}

				if (i == 10 * j) {
					return true;
				}
			}
		}

		return false;
	}
}