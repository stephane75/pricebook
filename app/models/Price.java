package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * User: stephane
 * Date: 17/02/14
 */

@Entity
public class Price extends Model {

    public float value;
    public Date date;

    @ManyToOne
    public Product product;

    @OneToOne
    @JoinColumn(name="user_fk", nullable=true)
    public User user;

    @OneToOne
    @JoinColumn(name="store_fk", nullable=true)
    public Store store;

    public Price(float value, User user, Store store, Product product){
        this.value = value;
        this.user = user;
        this.store = store;
        this.product = product;
        this.date = new Date();
    }

    /*public Price addUser(User user){
        this.user = user;
        this.save();
        return this;
    }*/
}
