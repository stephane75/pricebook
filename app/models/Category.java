package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * User: stephane
 * Date: 17/02/14
 */

@Entity
public class Category extends Model implements Comparable<Category>{

    public String name;

    private Category(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Category otherCategory) {
        return name.compareTo(otherCategory.name);
    }

    public static Category findOrCreateByName(String name) {
        Category category = Category.find("byName", name).first();
        if(category == null) {
            category = new Category(name);
        }
        return category;
    }
}
