package controllers;

import com.avaje.ebean.Model;
import controllers.*;
import models.Product;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.product;

import javax.inject.Inject;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * Created by alejo on 10/20/2016.
 */
public class ProductController extends Controller{
    @Inject FormFactory formFactory;
    public Result loadProduct(){
        return ok(product.render("Producto"));
    }

    public Result addProduct(){
        Product product = Form.form(Product.class).bindFromRequest().get();
        product.save();
        return redirect(controllers.routes.ProductController.loadProduct());

    }

    public Result getProducts(){
        List<Product> products = new Model.Finder(String.class, product.class).all();
        return ok(toJson(products));

    }
}
