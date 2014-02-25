package controllers;

import models.Category;
import play.mvc.Controller;

import java.util.List;

/**
 * User: stephane
 * Date: 21/02/14
 */
public class CategoryController  extends Controller {

    public static void getAll(){
        List<Category> categories = Category.findAll();
        renderJSON(categories);
    }
}
