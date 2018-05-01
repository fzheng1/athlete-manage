package models;

import org.junit.*;
import play.test.WithApplication;

import static org.junit.Assert.*;
import static play.test.Helpers.*;

public class SportModelTest extends WithApplication {

    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void testCanSaveAndFindSport() {
        new Sport("Hockey", 10).save();
        Sport sport = Sport.find.query().where()
                .eq("name", "Hockey")
                .findOne();
        assertEquals("Hockey", sport.name);
        assertEquals(10, sport.pointValue.intValue());
    }
}
