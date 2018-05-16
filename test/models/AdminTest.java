package models;

import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;

public class AdminTest extends WithApplication {

    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void canCreateAndSaveAdmin() {
        new Admin("first", "last", "email@example.com").save();
        Admin admin = Admin.find.query()
                .where()
                .eq("email", "email@example.com")
                .findOne();

        assertNotNull(admin);
        assertEquals("email@example.com", admin.email);
    }

    @Test
    public void testUserGetFirstLast() {
        Admin admin = new Admin("Abtin", "Sepanlou", "abtin.sepanlou@example.com");
        assertEquals("Abtin Sepanlou", admin.getFirstLast());
    }

    @Test
    public void testUserGetLastFirst() {
        Admin admin = new Admin("Abtin", "Sepanlou", "abtin.sepanlou@example.com");
        assertEquals("Sepanlou, Abtin", admin.getLastFirst());
    }
}
