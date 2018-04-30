package models;

import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;

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
