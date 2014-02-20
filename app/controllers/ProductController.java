package controllers;

import adapter.ProductAdapter;
import bean.ProductBean;
import models.Product;
import play.data.validation.Required;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * User: stephane
 * Date: 17/02/14
 */
public class ProductController extends Controller {

    public static final String LINK_HOME = "ProductController/home.html";

    public static void getAll(){
        List<Product> products = Product.findAll();
        renderJSON(formatSearch(products));
    }

    public static void getById(Long id){
        Product product = Product.findById(id);
        renderJSON(ProductAdapter.adaptProductToProductDetailBean(product));
    }

    public static void searchByCategory(@Required String category){
        List<Product> products = Product.findProductByCategory(category);
        renderJSON(formatSearch(products));
    }

    public static void searchByName(@Required String name){
        List<Product> products =  Product.findProductByName(name);
        renderJSON(formatSearch(products));
    }

    private static List<ProductBean> formatSearch(List<Product> products){
        List<ProductBean> result = new ArrayList<ProductBean>();
        if(products != null){
            for(Product product : products){
                result.add(ProductAdapter.adaptProductToProductBean(product));
            }
        }
        return result;
    }

}
