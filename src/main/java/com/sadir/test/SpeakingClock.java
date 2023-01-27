package com.sadir.test;

/**
 Specification
 -------------
 1. Given a 24 hour clock convert the current time into words
 e.g. "08:34" should be converted to "It's eight thirty four"

 2. Return Midday and Midnight as "It's Midday" and "It's Midnight"
 */
public class SpeakingClock {

    public static final String[] HOURS = {"twelve", "one","two", "three", "four", "five", "six", "seven", "eight","nine", "ten", "eleven"};
    public static final String[] ONES = {"", "one","two", "three", "four", "five", "six", "seven", "eight","nine"};

    public static final String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty"};
    public String speakTimeInWords(String time) {
        String[] times = time.split(":");
        if (times[0].length() > 2 || times[1].length() > 2) {
            throw new IllegalArgumentException("Invalid time. Please provide correct time in HH:MM format.");
        }
        int hour;
        int minute;
        try {
            hour = Integer.parseInt(times[0]);
            minute = Integer.parseInt(times[1]);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid time. Please provide correct time in HH:MM format.");
        }

        if (hour < 0 || hour > 24 || minute < 0 || minute > 60) {
            throw new IllegalArgumentException("Invalid time.");
        }
       // String amOrPm = hour < 12 ? "am" : "pm";
        String hourWord = "";
        String minuteWord = "";
        if(minute < 10) {
            minuteWord = ONES[minute];
        } else if (minute < 20) {
            minuteWord = TEENS[minute % 10];
        } else {
            minuteWord = TENS[minute/10] + " " + ONES[minute % 10];
        }
        if (hour == 12 && minute == 0) {
            hourWord = "midday";
        } else if ((hour == 0 || hour == 24) && minute == 0){
            hourWord = "midnight";
        } else {
            hourWord = HOURS[hour % 12];
        }
        String result = String.join(" ", "It's", hourWord, minuteWord.toString());

        return result.trim();
    }

    public static void main(String[] args) {
        SpeakingClock clock = new SpeakingClock();
        System.out.print(clock.speakTimeInWords("00:30"));
    }
}
