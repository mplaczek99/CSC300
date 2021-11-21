package clock;

/**
 * Objects of the Time class hold a time value for a European-style 24-hour
 * clock. The value consists of hours, minutes and seconds. The range of the
 * value is 00:00:00 (midnight) to 23:59:59 (one second before midnight).
 *
 * @author Michael Placzek
 */
public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    /**
     * Creates a new Time object set to h:m:s. Assumes, without checking, that the
     * parameter values are within bounds. * For this task, you don't need to worry
     * about invalid parameter values. Do not change this constructor.
     */
    public Time(int h, int m, int s) {
        this.hours = h;
        this.minutes = m;
        this.seconds = s;
    }

    /**
     * Assumes Time is valid
     * <p>
     * Add one second to the current time. When the seconds value reaches 60, it
     * rolls over to zero. When the seconds roll over to zero, the minutes advance.
     * So 00:00:59 rolls over to 00:01:00. When the minutes reach 60, they roll over
     * and the hours advance. So 00:59:59 rolls over to 01:00:00. When the hours
     * reach 24, they roll over to zero. So 23:59:59 rolls over to 00:00:00.
     */
    public void advanceOneSecond() {
        // Increment seconds
        seconds++;

        rollOver();
    }

    /**
     * Compare this time to otherTime. Assumes that both times are in the same day.
     * Returns -1 if this Time is before otherTime. Returns 0 if this Time is the
     * same as otherTime. Returns 1 if this Time is after otherTime.
     */
    public int compareTo(Time otherTime) {
        // Checks if this Time comes before otherTime
        if (this.hours < otherTime.hours) {
            return -1;
        } else if (this.minutes < otherTime.minutes) {
            return -1;
        } else if (this.minutes == otherTime.minutes) {
            if (this.seconds < otherTime.seconds) {
                return -1;
            }
        }

        // Checks if this Time is after otherTime
        if (this.hours > otherTime.hours) {
            return 1;
        } else if (this.minutes > otherTime.minutes) {
            return 1;
        } else {
            if (this.seconds > otherTime.seconds) {
                return 1;
            }
        }

        // Otherwise, return that this Time and otherTime are equal
        return 0;
    }

    /**
     * Add an offset to this Time. Rolls over the hours, minutes and seconds fields
     * when needed.
     */
    public void add(Time offset) {
        // Add this time with the offset
        this.hours += offset.hours;
        this.minutes += offset.minutes;
        this.seconds += offset.seconds;

        rollOver();
    }

    /**
     * Subtract an offset from this Time. Rolls over (under?) the hours, minutes and
     * seconds fields when needed.
     */
    public void subtract(Time offset) {
        // Convert this Time and offset to seconds
        int this_seconds = (this.hours * 3600) + (this.minutes * 60) + this.seconds;
        int offset_seconds = (offset.hours * 3600) + (offset.minutes * 60) + offset.seconds;

        int subtraction = this_seconds - offset_seconds;

        // Convert subtraction back into hours
        this.hours = subtraction / 3600;
        subtraction -= this.hours * 3600;
        this.minutes = subtraction / 60;
        subtraction -= this.minutes * 60;
        this.seconds = subtraction;

        // Rolls under
        if (seconds < 0) {
            seconds = 60 + seconds;
            minutes--;
        }
        if (minutes < 0) {
            minutes = 60 + minutes;
            hours--;
        }
        if (hours < 0) {
            hours = 24 + hours;
        }
    }


    private void rollOver() {
        // Increment minutes if there are 60 seconds or more
        while (seconds >= 60) {
            minutes++;
            seconds -= 60;
        }

        // Increment hours if there are 60 minutes or more
        while (minutes >= 60) {
            hours++;
            minutes -= 60;
        }

        // Clears the Time if there are 24 hours or more
        while (hours >= 24) {
            hours -= 24;
        }
    }

    /*
     * =============================================================================
     * ==================
     */
    // You can ignore the rest of the code as it just supports testing and debugging

    /**
     * Constructor for objects of class Time. Creates a new Time object set to
     * 00:00:00. Do not change this constructor.
     */
    public Time() { // never used
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object obj) {
        Time other = (Time) obj;
        if (hours != other.hours)
            return false;
        if (minutes != other.minutes)
            return false;
        return seconds == other.seconds;
    }

    /*
     * Return a string representation of this Time. String is of the form hh:mm:ss
     * with always two digits for h, m and s. Do not change this.
     */
    public String toString() {
        return pad(hours) + ":" + pad(minutes) + ":" + pad(seconds);
    }

    /**
     * Returns a string representing the argument value, adding a leading "0" if
     * needed to make it at least two digits long. Do not change this.
     */
    private String pad(int value) {
        String sign = "";
        if (value < 0) {
            sign = "-";
            value = -value;
        }

        if (value < 10) {
            return sign + "0" + value;
        } else {
            return sign + value;
        }
    }
}