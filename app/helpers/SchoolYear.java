package helpers;

import java.time.LocalDateTime;

public class SchoolYear {

    public static LocalDateTime currentSchoolYear(){
        return toSchoolYear(LocalDateTime.now());
    }

    public static LocalDateTime toSchoolYear(LocalDateTime dateTime) {
        if(dateTime.getMonthValue() < 9)
            return LocalDateTime.of(dateTime.getYear()-1, 9,1,0,0,0);
        return LocalDateTime.of(dateTime.getYear(), 9, 1, 0, 0);
    }

    public static LocalDateTime toSchoolYear(int year, int month, int dayOfMonth){
        LocalDateTime dateTime = LocalDateTime.of(year, month, dayOfMonth, 0, 0, 0);
        return toSchoolYear(dateTime);
    }

    public static String formatSchoolYear(int year, int month, int dayOfMonth){
        LocalDateTime dateTime = LocalDateTime.of(year, month, dayOfMonth, 0, 0, 0);
        return formatSchoolYear(dateTime);
    }

    public static String formatSchoolYear(LocalDateTime dateTime) {
        if(dateTime.getMonthValue() < 9)
            return (dateTime.getYear() - 1) + "-" + (dateTime.getYear());
        return (dateTime.getYear()) + "-" + (dateTime.getYear() + 1);
    }

    public static LocalDateTime getSchoolYear(String schoolYear){
        String yearStart = schoolYear.trim().substring(0, schoolYear.trim().indexOf("-"));
        int year = Integer.parseInt(yearStart.trim());
        return toSchoolYear(year, 9, 1);
    }
}
