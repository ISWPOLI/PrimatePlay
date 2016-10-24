package models;



import com.avaje.ebean.Model;
import play.data.Form;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


/**
 * Created by alejo on 10/16/2016.
 */
@Entity
public class User extends Model{
    @Id
    private Long id;
    @Constraints.Required
    @Constraints.Email
    @Formats.NonEmpty
    private String email;
    @Constraints.Required
    @Formats.NonEmpty
    private String username;
    @Constraints.Required
    @Formats.NonEmpty
    @Constraints.MinLength(6)
    @Constraints.MaxLength(20)
    private String pass;
    @Constraints.Required
    @Formats.NonEmpty
    private String passconf;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassconf() {
        return passconf;
    }

    public void setPassconf(String passconf) {
        this.passconf = passconf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//queries
    public static  Model.Finder<String, User> find = new Model.Finder(String.class, User.class);

//***Retrieve all the User **//

}
