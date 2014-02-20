package adapter;

import bean.PriceBean;
import bean.ProductBean;
import bean.ProductDetailBean;
import models.Price;
import models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * User: stephane
 * Date: 17/02/14
 */
public class ProductAdapter {

    public static ProductBean adaptProductToProductBean(Product product){
        ProductBean productBean = new ProductBean();
        productBean.setId(product.id);
        productBean.setName(product.name);
        productBean.setDescription(product.description);
        productBean.setPicture(product.picture);
        productBean.setCategories(product.categories);

        if(product.prices != null && product.prices.size() > 0){
            productBean.setUser(product.prices.get(product.prices.size()-1).user.login);
            productBean.setStore(product.prices.get(product.prices.size()-1).store);
            productBean.setLastPrice(product.prices.get(product.prices.size()-1).value);
            productBean.setLastUpdate(product.prices.get(product.prices.size()-1).date);
        }
        return productBean;
    }

    public static ProductDetailBean adaptProductToProductDetailBean(Product product){
        ProductDetailBean productDetailBean = new ProductDetailBean();
        productDetailBean.setId(product.id);
        productDetailBean.setName(product.name);
        productDetailBean.setDescription(product.description);
        productDetailBean.setPicture(product.picture);
        productDetailBean.setCategories(product.categories);

        if(product.prices != null){
            List<PriceBean> priceBeans = new ArrayList<PriceBean>();
            for(Price price : product.prices){
                PriceBean priceBean = new PriceBean(price.value, price.date.getTime(), price.user.login, price.store.name);
                priceBeans.add(priceBean);
            }
            productDetailBean.setPrices(priceBeans);
        }
        return productDetailBean;
    }
}