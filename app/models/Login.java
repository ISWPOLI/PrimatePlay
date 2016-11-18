package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejo on 11/17/2016.
 */
public class Login extends Model{

    @Constraints.Required (message = "Please enter username")
    @Constraints.Email
    @Formats.NonEmpty
    public String loginemail;
    @Constraints.Required (message = "Please enter password ")
    @Constraints.MinLength(6)
    @Constraints.MaxLength(20)
    public String loginpassword;


    public static  Model.Finder<String, User> find = new Model.Finder(String.class, User.class);

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
