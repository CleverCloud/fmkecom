/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import java.util.Locale;
import models.fmkecom.Product;
import models.fmkecom.ProductRef;
import play.mvc.Controller;

/**
 *
 * @author waxzce
 */
public class ProductController extends Controller {

   public static void newProduct() {
      render();
   }

   public static void translate(String id) {
      ProductRef productRef = ProductRef.getManager().getRefByMongodId(id);

      render(productRef);
   }
   
   
   public static void doEditProduct(String id) {
      Product product = Product.getManager().getByMongodId(id);

      
   }

   public static void editProduct(String id) {
      Product product = Product.getManager().getByMongodId(id);

      render(product);
   }

   public static void doTranslate(String id) {
      ProductRef productRef = ProductRef.getManager().getRefByMongodId(id);
      Product p = new Product();
      p.name = params.get("product.name");
      p.reference = productRef;
      p.language = params.get("product.language", Locale.class);
      p.save();
      lookAt(productRef.id.toStringMongod());
   }

   public static void doNewProduct() {
      ProductRef pr = new ProductRef();
      Product p = new Product();
      p.name = params.get("product.name");
      p.reference = pr;
      p.language = params.get("product.language", Locale.class);
      pr.save();
      p.save();
      ProductController.list();
   }

   public static void list() {
      List<ProductRef> products = ProductRef.getDs().find(ProductRef.class).asList();
      
      render(products);
   }

   public static void lookAt(String id) {
      ProductRef productRef = ProductRef.getManager().getRefByMongodId(id);

      render(productRef);
   }
}
