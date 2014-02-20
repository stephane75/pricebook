package bean;

import java.io.Serializable;
import java.util.Date;

/**
 * User: stephane
 * Date: 20/02/14
 */
public class PriceBean implements Serializable{

    private float value;
    private long date;
    private String user;
    private String store;

    public PriceBean(float value, long date, String user, String store){
        this.value = value;
        this.date = date;
        this.user = user;
        this.store = store;
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
}
