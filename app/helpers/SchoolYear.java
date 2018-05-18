package helpers;

import java.time.LocalDateTime;

public class SchoolYear {
    
    /**
    * @return the current date-time using system clock and default time zone
    */
    public static LocalDateTime currentSchoolYear(){
        return toSchoolYear(LocalDateTime.now());
    }
    
    /**
    * @param dateTime LocalDateTime of current date-time
    * @return current year if in September or last year if before September
    */
    public static LocalDateTime toSchoolYear(LocalDateTime dateTime) {
        if(dateTime.getMonthValue() < 9)
            return LocalDateTime.of(dateTime.getYear()-1, 9,1,0,0,0);
        return LocalDateTime.of(dateTime.getYear(), 9, 1, 0, 0);
    }
    
    /**
    * @param year int of current year
    * @param month int of current month
    * @param dayOfMonth int of current day
    * @return an instance of LocalDateTime from year, month and day, setting minutes, seconds and nanoseconds to zero
    */
    public static LocalDateTime toSchoolYear(int year, int month, int dayOfMonth){
        LocalDateTime dateTime = LocalDateTime.of(year, month, dayOfMonth, 0, 0, 0);
        return toSchoolYear(dateTime);
    }
    
    /**
    * @param year int of current year
    * @param month int of current month
    * @param dayOfMonth int of current day
    * @return a formatted dateTime
    */
    public static String formatSchoolYear(int year, int month, int dayOfMonth){
        LocalDateTime dateTime = LocalDateTime.of(year, month, dayOfMonth, 0, 0, 0);
        return formatSchoolYear(dateTime);
    }
    
    /**
    * @param dateTime LocalDateTime
    * @return school year range from this year to next year if in September
    *   or school year range from last year to this current year if before September
    */
    public static String formatSchoolYear(LocalDateTime dateTime) {
        if(dateTime.getMonthValue() < 9)
            return (dateTime.getYear() - 1) + "-" + (dateTime.getYear());
        return (dateTime.getYear()) + "-" + (dateTime.getYear() + 1);
    }
    
    
    /**
    * @param schoolYear String of current school year
    * @return int values of start year, and September the 1st
    */
    public static LocalDateTime getSchoolYear(String schoolYear){
        String yearStart = schoolYear.trim().substring(0, schoolYear.trim().indexOf("-"));
        int year = Integer.parseInt(yearStart.trim());
        return toSchoolYear(year, 9, 1);
    }
}
