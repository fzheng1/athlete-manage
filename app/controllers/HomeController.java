package controllers;

import play.mvc.*;

/**
 * Handles simple base-level request of /
 */
public class HomeController extends Controller {

    /**
     * The index page will be locked to general traffic and coaches.
     * Only admins will be able to access by signing in.
     *
     * @return Result 200
     */
    public Result index() {
        return ok(views.html.index.render());
    }
}
