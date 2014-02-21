package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * User: stephane
 * Date: 17/02/14
 */

@Entity
public class Store extends Model {

    public String name;
    public String logo;
    public String address;

    public Store(String name, String logo, String address){
        this.name = name;
        this.logo = logo;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
