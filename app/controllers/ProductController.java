package controllers;

import akka.util.ByteString;
import com.avaje.ebean.Model;
import com.avaje.ebeaninternal.util.IOUtils;
import controllers.*;
import models.Product;
import models.User;
import play.api.Play;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
            File file = picture.getFile();
           boolean aux; //Si ya se guardo en el servidor
           final String imgPathToSave= "/public/images/"+ "default.jpg";
          //Guardar en el disco
            Path a = file.toPath();
            Path ab= Paths.get("/public/images/", ("copy_" + fileName));
           try( Files.copy(a, ab), StandardCopyOption.REPLACE_EXISTING);
            Files.deleteIfExists(file.toPath());
            )


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
