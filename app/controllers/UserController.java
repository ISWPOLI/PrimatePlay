package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.Transaction;
import controllers.*;
import controllers.routes;
import models.User;
import org.jetbrains.annotations.NotNull;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.FormFactory;
import play.data.Form;
import views.html.*;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.List;

import static play.data.Form.form;
import static play.libs.Json.toJson;

/**
 * Created by alejo on 10/17/2016.
 */
public class UserController extends Controller{
    @Inject FormFactory formFactory;

    public Result load(){
        return ok(user.render("DIOOS"));
    }

    public Result addUser(){
        User user = form(User.class).bindFromRequest().get();
        user.save();
        return redirect(controllers.routes.UserController.load());

    }

    public Result getUsers(){
        List<User> users = new Model.Finder(String.class, user.class).all();
        return ok(toJson(users));

    }

    public Result edit(Long id) {
        Form<User> formulario = formFactory.form(User.class).fill(User.find.byId(id));
        return ok(
                views.html.gestionarUser.render(formulario)
        );
    }

    public Result updateUser(Long id) throws PersistenceException {
        Form<User> formulario = formFactory.form(User.class).bindFromRequest();
        if(formulario.hasErrors()){
            return badRequest(views.html.user.render("erroneo"));
        }

        Transaction txn = Ebean.beginTransaction();

        try{
            User savedUser = User.find.byId(id);
            if (savedUser != null) {
                User newUser = formulario.get();
                savedUser.email = newUser.email;
                savedUser.pass = newUser.pass;
                savedUser.username = newUser.username;

                savedUser.update();
                flash("success", "Usuario" + formulario.get().username + "has been update" );
                txn.commit();

            }


        }finally {
            txn.end();
        }
        return redirect("/");
    }




    }

    /*
    public Result registerUser() {
        if (request().method() == "POST") {


            User filled_user = Form.form(User.class).bindFromRequest().get();
            //Evaluate confirmation data
            if (!filled_user.getPass().isEmpty()){
                if(filled_user.getPass().equals(filled_user.getPass())){

                }
            }


        }

    }
    */


