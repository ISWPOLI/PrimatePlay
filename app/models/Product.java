package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by alejo on 10/20/2016.
 */
@Entity
public class Product extends Model {
@Id
    public Long id;
    public String productname;
    public int quantity;
    public String description;
    public BigDecimal price;
    public String image;


    public static  Model.Finder<Long, Product> find = new Model.Finder(Long.class, Product.class);

}
