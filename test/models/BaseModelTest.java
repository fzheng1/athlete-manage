package models;

import org.junit.*;
import play.test.WithApplication;
import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;
import static play.test.Helpers.*;

public class BaseModelTest extends WithApplication {

    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void testUpdatesCreatedAt() {
        new Sport("Hockey", 10).save();
        Sport sport = Sport.find.query().where()
                .eq("name", "Hockey").findOne();
        LocalDateTime now = LocalDateTime.now().plusSeconds(1);
        System.out.println("now = " + now.toString());
        System.out.println("sport.createdAt = " + sport.createdAt.toString());
        assertTrue("Time now should be after time created.", now.isAfter(sport.createdAt));
    }

    @Test
    public void testUpdatedUpdatedAt() {
        new Sport("Hockey", 10).save();
        Sport sport = Sport.find.query().where()
                .eq("name", "Hockey").findOne();
        sport.createdAt = sport.updatedAt = LocalDateTime.now().minusSeconds(1);
        sport.pointValue = 5;
        sport.update();
        assertTrue("Updated time should be after previous update time", sport.updatedAt.isAfter(sport.createdAt));
    }
}
