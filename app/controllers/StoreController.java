package controllers;

import models.Store;
import play.mvc.Controller;

import java.util.List;

/**
 * User: stephane
 * Date: 21/02/14
 */
public class StoreController extends Controller {

    public static void getAll(){
        List<Store> stores = Store.findAll();
        renderJSON(stores);
    }

}
