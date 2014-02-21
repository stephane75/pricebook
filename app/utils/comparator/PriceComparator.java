package utils.comparator;

import bean.PriceBean;

import java.util.Comparator;

/**
 * User: stephane
 * Date: 21/02/14
 */
public class PriceComparator implements Comparator<PriceBean> {
    @Override
    public int compare(PriceBean priceBean, PriceBean priceBean2) {
        if(priceBean.getDate() > priceBean2.getDate()){
            return 0;
        }else{
            return 1;
        }
    }
}
