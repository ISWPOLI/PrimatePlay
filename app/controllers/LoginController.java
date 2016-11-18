package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.*;

import javax.inject.Inject;

/**
 * Created by alejo on 10/28/2016.
 */
public class LoginController extends Controller {
    @Inject
    FormFactory formFactory;



    public Result validate() {
        Form<User> formulario = formFactory.form(User.class);
        User aux = (formulario.bindFromRequest().get()).authenticate((formulario.bindFromRequest().get()).email, (formulario.bindFromRequest().get()).pass);
        if (aux != null) {
            flash("success", "Computer has been deleted");
            return ok(
                    main.render("login", Html.apply("Ingresaste Exitosamente")));
        } else {


            return redirect(routes.UserController.load());

        }

    }

    public Result load(){
        return redirect("/");
    }

}
