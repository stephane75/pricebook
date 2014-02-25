package models;

import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * User: stephane
 * Date: 17/02/14
 */
@Entity
public class Product extends Model {

    public String name;
    public String description;
    public String picture;

    @OneToMany(mappedBy="product", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Price> prices;

    @OneToOne
    @JoinColumn(name="category_fk", nullable=true)
    public Category category;

    public Product(String name, String description, String picture){
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.prices = new ArrayList<Price>();
    }

    public Product addPrice(float value, User user, Store store){
        Price price = new Price(value, user, store, this);
        this.prices.add(price);
        this.save();
        return this;
    }

    public Product categorize(String name){
        this.category = Category.findOrCreateByName(name);
        this.save();
        return this;
    }

    public static List<Product> findProductByName(String name){
        StringBuilder sb = new StringBuilder("%");
        sb.append(name.toLowerCase());
        sb.append("%");
        return Product.find("byNameLike", sb.toString()).fetch();
    }

    public static List<Product> findProductByCategory(String category) {
        return Product.find(
                "select distinct p from Product p join p.category as c where c.name = ?", category
        ).fetch();
    }
}
