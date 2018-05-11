package models;

import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;

public class SchoolYearTest extends WithApplication {

    @Test
    public void testCurrentSchoolYear(){
        LocalDateTime time = SchoolYear.currentSchoolYear();
        int year = time.getYear();
        int month = time.getMonthValue();

        if (month < 9) assertEquals((LocalDateTime.of(year-1, 9,1,0,0,0)),time);
        else assertEquals(LocalDateTime.of(year, 9, 1, 0, 0, 0), time);

    }

    @Test
    public void testToSchoolYear(){
        LocalDateTime time = SchoolYear.toSchoolYear(2017, 10, 4);
        assertEquals(LocalDateTime.of(2017, 9,1,0,0,0), time);
    }

    @Test
    public void testFormatSchoolYear(){
        String schoolYear = SchoolYear.formatSchoolYear(2018, 3, 4);
        assertEquals("2017-2018", schoolYear);
    }


}

