package helpers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;

public class SchoolYearTest {

    @Test
    public void testCurrentSchoolYear(){
        LocalDateTime currentSchoolYear = SchoolYear.currentSchoolYear();
        LocalDateTime now = LocalDateTime.now();
        int month = now.getMonthValue();
        int year =  month < 9 ? now.getYear() - 1 : now.getYear();

        assertEquals((LocalDateTime.of(year, 9,1,0,0,0)),currentSchoolYear);
    }

    @Test
    public void testOctoberSchoolYearShouldBeSameYear() {
        LocalDateTime october = LocalDateTime.of(2017, 10, 1, 0, 0, 0);
        LocalDateTime schoolYear = SchoolYear.toSchoolYear(october);
        assertEquals("October's school year should be september of the same year", LocalDateTime.of(2017, 9, 1, 0, 0, 0), schoolYear);
    }

    @Test
    public void testJanuarySchoolYearShouldBePreviousYear() {
        LocalDateTime january = LocalDateTime.of(2017, 1, 1, 0, 0, 0);
        LocalDateTime schoolYear = SchoolYear.toSchoolYear(january);
        assertEquals("January's school year should be september of the previous year", LocalDateTime.of(2016, 9, 1, 0, 0, 0), schoolYear);
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

    @Test
    public void testFormatSchoolYearOctober(){
        LocalDateTime october = LocalDateTime.of(2017, 10, 1, 0, 0, 0);
        String result = SchoolYear.formatSchoolYear(october);
        assertEquals("October '17 should be rendered as '2017-2018'", "2017-2018", result);
    }

    @Test
    public void testFormatSchoolYearApril(){
        LocalDateTime april = LocalDateTime.of(2018, 4, 1, 0, 0, 0);
        String result = SchoolYear.formatSchoolYear(april);
        assertEquals("April '18 should be rendered as '2017-2018'", "2017-2018", result);
    }

    @Test
    public void testConvertStringYearToDateTime(){
        String year = "  2016 -2017";
        LocalDateTime result = SchoolYear.getSchoolYear(year);
        LocalDateTime expected = LocalDateTime.of(2016, 9, 1, 0, 0, 0);
        assertEquals("The school year should be 2016/9/1", expected, result);

    }


}

