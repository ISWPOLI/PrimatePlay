package controllers;

import com.avaje.ebean.Model;
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


