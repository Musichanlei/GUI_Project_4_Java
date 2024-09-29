public class Date212 implements Comparable<Date212> {

private int day;

private int month;

private int year;

// array to represent days in a month, assuming february has 29 days

private static int[] daysInMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30,

31, 30, 31 };

public Date212(String str) throws Date212Exception {

str = str.trim();// removing trailing spaces

// checking if string contains valid date

if (!isValid(str)) {

// throwing exception

throw new Date212Exception(str + " represents an invalid date!");

} else {

// valid date, assigning values

this.year = Integer.parseInt(str.substring(0, 4));

this.month = Integer.parseInt(str.substring(4, 6));

this.day = Integer.parseInt(str.substring(6));

}

}

// getters and setters

public int getDay() {

return day;

}

public int getMonth() {

return month;

}

public int getYear() {

return year;

}

public void setDay(int day) {

this.day = day;

}

public void setMonth(int month) {

this.month = month;

}

public void setYear(int year) {

this.year = year;

}

@Override

public String toString() {

// returns date in mm/dd/yyyy format

return format(month) + "/" + format(day) + "/" + year;

}

// method to format a date/month value, to have a leading 0 if it is below

// 10. Example format(7) will return 07, format(11) will return 11

private String format(int value) {

if (value > 9) {

return "" + value;

} else {

return "0" + value;

}

}



// private helper method to check if a String contains valid date


private boolean isValid(String str) {

if (str.length() == 8) {

try {

int year = Integer.parseInt(str.substring(0, 4));

int month = Integer.parseInt(str.substring(4, 6));

int day = Integer.parseInt(str.substring(6));

if (month > 0 && month <= 12) {

// not considering leap years

if (day > 0 && day <= daysInMonth[month - 1]) {

// valid date

return true;

}

}

} catch (Exception e) {

}

}

// some test failed, invalid date

return false;

}



public int compareTo(Date212 other) {

// comparing by year

if (this.year < other.year) {

return -1;

} else if (this.year > other.year) {

return 1;

} else {

// years are same, comparing by month

if (this.month < other.month) {

return -1;

} else if (this.month > other.month) {

return 1;

} else {

// months are same, comparing by day

if (this.day < other.day) {

return -1;

} else if (this.day > other.day) {

return 1;

}

}

}

return 0; // dates are equal

}

}

