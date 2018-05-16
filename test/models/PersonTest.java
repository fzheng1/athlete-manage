package models;

import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;

public class PersonTest extends WithApplication {

    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void testCanSaveAndFindUser() {
        new Person("Abtin", "Sepanlou", "abtin.sepanlou@example.com").save();
        Person person = Person.find.query()
                .where()
                .eq("email", "abtin.sepanlou@example.com")
                .findOne();

        assertNotNull(person);
        assertEquals("abtin.sepanlou@example.com", person.email);
    }

    @Test
    public void testUserGetFirstLast() {
        Person person = new Person("Abtin", "Sepanlou", "abtin.sepanlou@example.com");
        assertEquals("Abtin Sepanlou", person.getFirstLast());
    }

    @Test
    public void testUserGetLastFirst() {
        Person person = new Person("Abtin", "Sepanlou", "abtin.sepanlou@example.com");
        assertEquals("Sepanlou, Abtin", person.getLastFirst());
    }
}
