package models;

import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SportModelTest extends WithApplication {

    @Test
    public void testCanSaveAndFindSport() {
        Sport sport = new Sport("volleyball", 5);
        sport.save();
        Sport sportFound = Sport.find.all().get(0);
        assertNotNull(sportFound);
        assertEquals("volleyball", sportFound.getName());
        assertEquals(1, sportFound.getId().intValue());
        assertEquals(5, sportFound.getPointValue().intValue());
    }

    @Test
    public void testSportCanUpdateValues() {
        Sport sport = new Sport("Hockey", 10);
        sport.save();
        sport.setName("Hky");
        sport.setPointValue(3);
        assertEquals("Hky", sport.getName());
        assertEquals(3, sport.getPointValue().intValue());
    }
}
