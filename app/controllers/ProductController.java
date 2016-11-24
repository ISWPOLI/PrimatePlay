package controllers;


import com.avaje.ebean.Model;

import models.Product;

import org.apache.commons.io.FileUtils;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import javax.inject.Inject;
import java.io.File;

import java.io.IOException;

import java.util.List;



import static play.libs.Json.toJson;

/**
 * Created by alejo on 10/20/2016.
 */
public class ProductController extends Controller{
    @Inject FormFactory formFactory;
    @Inject play.Environment Enviroment;
    public Result loadProduct(){
        return ok(product.render("Producto"));
    }

    public Result addProduct(){
        MultipartFormData<File> body = request().body().asMultipartFormData();
        FilePart<File> picture = body.getFile("picture");
        String fileName = picture.getFilename();
        if(picture != null) {
            try{
                File file = picture.getFile();
                File destination = new File("/WorkSpace/PrimatePlayPoli/public/images", fileName+"");
                FileUtils.moveFile(file, destination);
            }catch (IOException ex){

            }


            Product product = Form.form(Product.class).bindFromRequest().get();
            product.image = fileName;
            product.save();

            String contentType = picture.getContentType();

            return redirect(controllers.routes.ProductController.loadProduct());

        } else {
            flash("error", "Se necesita un image para el producto");
            return badRequest();
        }







    }

    public Result getProducts(){
        List<Product> products = new Model.Finder(String.class, Product.class).all();
        return ok(toJson(products));

    }
}
