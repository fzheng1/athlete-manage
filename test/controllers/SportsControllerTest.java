package controllers;

import models.Sport;
import org.junit.Before;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.route;

public class SportsControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Before
    public void setUp() {
        Sport sport1 = new Sport("sport1", 10);
        Sport sport2 = new Sport("sport2", 5);
        sport1.save();
        sport2.save();
    }

    @Test
    public void testIndexOK() {
        Result result = new SportsController().index();
        assertEquals(OK, result.status());
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
        assertTrue("Index should have 'Sports' in the title", contentAsString(result).contains("Sports"));
    }

    @Test
    public void testIndexShowsListOfSports() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/sports");

        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("sport1"));
        assertTrue(contentAsString(result).contains("10"));
        assertTrue(contentAsString(result).contains("sport2"));
        assertTrue(contentAsString(result).contains("5"));
    }

}
