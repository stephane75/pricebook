package controllers;

import utils.adapter.ProductAdapter;
import bean.PriceBean;
import bean.ProductBean;
import models.Price;
import models.Product;
import models.Store;
import models.User;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import play.data.validation.Required;
import play.mvc.Controller;

import java.io.IOException;
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

    public static void add(Long productId){
        params.allSimple();
        String param = params.data.get("body")[0];
        ObjectMapper mapper = new ObjectMapper();
        try {
            PriceBean priceBean = mapper.readValue(param, PriceBean.class);
            if(priceBean != null && productId != null){
                Store store = Store.findById(Long.parseLong(priceBean.getStore()));
                Product product = Product.findById(productId);
                User user = User.findByEmail(priceBean.getEmail());
                if(user == null){
                    user = new User(priceBean.getEmail(), priceBean.getUser(), "").save();
                }

                new Price(priceBean.getValue(), user, store, product).save();
            }
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getById(productId);
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
