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

    public String schoolYear(){
        LocalDateTime time = LocalDateTime.now();

        if(time.getMonthValue() < 9){
            return (time.getYear() - 1) + "-" + (time.getYear());
        }

        else {
            return (time.getYear()) + "-" + (time.getYear() + 1);
        }
    }

}
