import java.util.Calendar;

public class Date implements DisplayToString{
    private int year;
    private int month;
    private int day;

    Date() {
    }

    public Date(int year, int month, int day) {
        if (Valid_Date(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid date.");
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        if (Valid_Date(year, this.month, this.day)) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid year.");
        }
    }

    public void setMonth(int month) {
        if (Valid_Date(this.year, month, this.day)) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid month.");
        }
    }

    public void setDay(int day) {
        if (Valid_Date(this.year, this.month, day)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid day.");
        }
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static boolean Valid_Date(int year, int month, int day) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(year, month - 1, day);

        try {
            calendar.getTime();
            return true;
            }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean hasDatePassed(Date date) {
        Calendar currentDate = Calendar.getInstance();
        Calendar inputDate = Calendar.getInstance();
        inputDate.setLenient(false);
        inputDate.set(date.getYear(), date.getMonth() - 1, date.getDay());

        return inputDate.before(currentDate);
    }

    public static void DeadlineReached(Task t) {
        if (Date.hasDatePassed(t.getDate())) {
            t.setColumn_e("Stuck");
        }
    }
}

