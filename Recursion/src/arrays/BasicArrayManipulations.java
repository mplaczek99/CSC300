package arrays;

import java.util.Arrays;

/**
 * @author Michael Placzek
 */
public class BasicArrayManipulations {
    public int total(int[] values) {
        return totalHelper(values, 0);
    }

    private int totalHelper(int[] values, int num) {
        if (num == values.length) {
            return 0;
        }

        return values[num] + totalHelper(values, num + 1);
    }

    public double mean(int[] values) {
        if (values.length == 0) {
            return 0;
        }
        return (double) total(values) / values.length;
    }

    public int count(int[] values, int find) {
        return countHelper(values, find, 0, 0);
    }

    private int countHelper(int[] values, int find, int num, int found) {
        if (num == values.length) {
            return found;
        }

        if (values[num] == find) {
            found++;
        }

        return countHelper(values, find, num + 1, found);
    }

    public double median(int[] values) {
        if (values.length == 0) {
            return 0.0;
        }

        Arrays.sort(values); // Is this acceptable? Please let me know if it is not

        // Check if values length is even or odd
        if (values.length % 2 != 0) {
            return values[values.length / 2];
        }

        return (double) (values[(values.length - 1) / 2] + values[values.length / 2]) / 2.0;
    }

    public int largest(int[] values) {
        return largestHelper(values, 0, 0);
    }

    private int largestHelper(int[] values, int num, int largest) {
        if (num == values.length) {
            return largest;
        }

        if (values[num] > largest) {
            largest = values[num];
        }

        return largestHelper(values, num + 1, largest);
    }

    public int smallest(int[] values) {
        return smallestHelper(values, 0, 0);
    }

    private int smallestHelper(int[] values, int num, int smallest) {
        if (num == values.length) {
            return smallest;
        }

        if (num == 0) {
            smallest = values[0];
        }

        if (values[num] < smallest) {
            smallest = values[num];
        }

        return smallestHelper(values, num + 1, smallest);
    }

    public boolean tenTimes(int[] values) {
        return tenTimesHelper(values, 0, 0);
    }

    private boolean tenTimesHelper(int[] values, int arrNum1, int arrNum2) {
        // Base case if all numbers are done in values
        if (arrNum1 == values.length) {
            return false;
        }

        if (arrNum2 == values.length) {
            // do this and increment arrNum1
            return tenTimesHelper(values, arrNum1 + 1, 0);
        }

        if (values [arrNum1] != 0 || values[arrNum2] != 0) {
            if (values[arrNum1] == 10 * values[arrNum2]) {
                return true;
            }
        }

        // do this and increment arrNum2
        return tenTimesHelper(values, arrNum1, arrNum2 + 1);
    }
}