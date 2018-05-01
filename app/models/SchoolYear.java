package models;

import java.time.LocalDateTime;

public class SchoolYear {

    public static LocalDateTime currentSchoolYear(){
        LocalDateTime time = LocalDateTime.now();

        int month = time.getMonthValue();
        if(month < 9){
            return LocalDateTime.of(time.getYear() - 1, 9, 1, 0, 0);
        }

        else {
            return LocalDateTime.of(time.getYear(), 9, 1, 0, 0);
        }

    }

    public static LocalDateTime toSchoolYear(LocalDateTime date){
        if(date.getMonthValue() < 9){
            return LocalDateTime.of(date.getYear()-1, 9,1,0,0,0);
        }

        else {
            return LocalDateTime.of(date.getYear(), 9, 1, 0, 0);
        }
    }

    public static String formatSchoolYear(LocalDateTime date){
        LocalDateTime time = LocalDateTime.now();

        if(date.getMonthValue() < 9){
            return (date.getYear() - 1) + "-" + (date.getYear());
        }

        else {
            return (date.getYear()) + "-" + (date.getYear() + 1);
        }
    }

}
