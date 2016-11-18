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
    public Long id;
    @Constraints.Required
    @Constraints.Email
    @Formats.NonEmpty
    public String email;
    @Constraints.Required
    @Formats.NonEmpty
    public String username;
    @Constraints.Required
    @Formats.NonEmpty
    @Constraints.MinLength(6)
    @Constraints.MaxLength(20)
    public String pass;
    @Constraints.Required
    @Formats.NonEmpty
    public String passconf;



//queries
    public static  Model.Finder<String, User> find = new Model.Finder(String.class, User.class);

//***Retrieve all the User **//


    public static User authenticate(String email, String clearPassword)  {

        // get the user with email only to keep the salt password
        User user = find.where().eq("email", email).findUnique();
        if (user != null) {
            // get the hash password from the salt + clear password
            return user;

        }
        return null;
    }

}
