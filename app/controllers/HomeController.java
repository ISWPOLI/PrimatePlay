package controllers;


import com.avaje.ebean.Model;
import models.Person;
import models.User;
import models.Login;
import play.data.*;
import play.mvc.*;
import views.html.*;


import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    @Inject
    FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>
     */


    public Result index() {
        Form<Login> aux = formFactory.form(Login.class);

        return ok(index.render("Hello world!", aux));
    }

    public Result home() { return ok(home.render("Home"));
    }
    public Result catalog() { return ok(catalog.render("catalog"));
    }

    public Result addPerson(){
        Person person = Form.form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.HomeController.index());

    }

    public Result getPersons(){
        List<Person> persons = new Model.Finder(String.class, Person.class).all();
        return ok(toJson(persons));

    }



}
