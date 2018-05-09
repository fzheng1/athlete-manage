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
        assertEquals((LocalDateTime.of(2017, 9,1,0,0,0)),time);
    }




    @Test
    public void testSportCanBeCreated(){
        new Sport("Volleyball", 10).save();
        Sport s = Sport.find.query()
                .where()
                .eq("name", "Volleyball")
                .findOne();

        assertEquals("Volleyball", s.name);
        assertEquals(10, s.pointValue.intValue());

    }

    @Test
    public void myFirstTest(){
        int expected = 4;
        int actual = 2+2;
        System.out.println(2+2);
        assertEquals(expected, actual);
    }




}
