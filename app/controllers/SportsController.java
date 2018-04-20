package controllers;

import models.Sport;
import play.mvc.*;
import views.html.sports.*;

import java.util.List;

public class SportsController extends Controller {

    public Result index() {
        List<Sport> sports = Sport.find.all();
        return ok(index.render(sports));
    }
}
