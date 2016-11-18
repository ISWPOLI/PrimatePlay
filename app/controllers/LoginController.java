package controllers;

import models.User;
import models.Login;
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
        Form<Login> formulario = formFactory.form(Login.class);
        /*if(formulario.hasErrors()){
            return badRequest(views.html.index.render("error",formulario));
        }else {*/

            User aux = (formulario.bindFromRequest().get()).authenticate((formulario.bindFromRequest().get()).loginemail, (formulario.bindFromRequest().get()).loginpass);
            if (aux != null) {
                return ok(
                        main.render("login", Html.apply("Ingresaste Exitosamente")));
            } else {


                return redirect(routes.UserController.load());

            }
        }
    //}

    public Result load(){
        return redirect("/");
    }

}
