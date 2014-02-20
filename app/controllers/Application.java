package controllers;

import play.mvc.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void add() {
        render("partials/add.html");
    }

    public static void detail() {
        render("partials/detail.html");
    }

    public static void list() {
        render("partials/list.html");
    }
}