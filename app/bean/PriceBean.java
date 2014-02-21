package bean;

import java.io.Serializable;

/**
 * User: stephane
 * Date: 20/02/14
 */
public class PriceBean implements Serializable{

    private float value;
    private long date;
    private String user;
    private String email;
    private String store;
    private long productId;

    public PriceBean(long productId, float value, long date, String user, String store){
        this.productId = productId;
        this.value = value;
        this.date = date;
        this.user = user;
        this.store = store;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
