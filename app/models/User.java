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

}
