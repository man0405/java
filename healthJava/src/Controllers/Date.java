package Controllers;

public class Date {
    private static final int MIN_YEAR = 1;
    private static final int MAX_YEAR = 9999;

    private static final int MIN_MONTH =1;
    private static final int MAX_MONTH = 12;

    private int year, month, day;

    private static final String[] MONTHS ={
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    };

    private static final String[] DAYS = {
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    };

    private static final int[] daysInMonth = {
        31,
        28,
        31,
        30,
        31,
        30,
        31,
        31,
        30,
        31,
        30,
        31
    };

    private static final int[] nonLeapYearMonthNumber = {
        0,
        3,
        3,
        6,
        1,
        4,
        6,
        2,
        5,
        0,
        3,
        5
    };

    private static final int[] leapYearMonthNumber = {
        6,
        2,
        3,
        6,
        1,
        4,
        6,
        2,
        5,
        0,
        3,
        5
    };

    public static boolean isLeapYear ( int year){
        return ( year %4 ==0 && year % 100 != 0 ) || ( year % 400 == 0 );
    }

    public static int getMonthLastDay(int year, int month){
        return daysInMonth[month - 1] + (isLeapYear(year) && month == 2 ? 1:0);
    } 

    public static boolean isValidDate (int year, int month, int day){
        return (MIN_YEAR <= year && year <= MAX_YEAR) 
        && (MIN_MONTH <= month && month <= MAX_MONTH)
        && (1 <= day && day <= getMonthLastDay(year, month));
    }

    public static int getDayOfWeek(int year, int month, int day){
        if(! isValidDate(year, month, day)) return -1;
        else {
            // Based on the two digit of year, get the number "century"
            int magicCenturyNumber = 6 - 2*((year / 100)%4); 

            int lastTwoDigitOfYear = (year % 100);

            int magicYearNumber = lastTwoDigitOfYear /4;

            int magicMonthNumber = isLeapYear(year) ? leapYearMonthNumber[month -1] : nonLeapYearMonthNumber[month -1];

            int magicDayNumber = day;

            return (magicCenturyNumber + lastTwoDigitOfYear + magicYearNumber + magicMonthNumber + magicDayNumber)%7;

        }
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > MAX_YEAR || year < MIN_YEAR){
            throw new IllegalArgumentException ("Invalid year");
        } 
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month < MIN_MONTH || month > MAX_MONTH){
            throw new IllegalArgumentException ("Invalid month");
        } 
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        int maxDay = getMonthLastDay(year,month);
        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException ("Invalid day");
        }
        this.day = day; 

    }

    @Override
    public String toString() {
        int weekDay = getDayOfWeek(year , month , day);
        return String.format("%1$s %2$d %3$s %4$d", DAYS[weekDay] , day, MONTHS[month -1], year);
    }

    

}
