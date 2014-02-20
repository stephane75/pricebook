package bean;

import java.io.Serializable;
import java.util.List;

/**
 * User: stephane
 * Date: 17/02/14
 */
public class ProductDetailBean extends ProductBean implements Serializable{

    private List<PriceBean> prices;

    public ProductDetailBean(){
    }

    public List<PriceBean> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceBean> prices) {
        this.prices = prices;
    }
}
