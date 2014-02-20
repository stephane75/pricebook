package models;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * User: stephane
 * Date: 17/02/14
 */

@Entity
public class User extends Model {

    @Email
    @Required
    @Column(unique=true)
    public String email;

    @Column(unique=true)
    public String login;

    public String password;
    public Date creationDate;

    public User(String email, String login, String password) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.creationDate = new Date();
    }

    public static User findByEmail(String email){
        return User.find("byEmail", email).first();
    }
}
