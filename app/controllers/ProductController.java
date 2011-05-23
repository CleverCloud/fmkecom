/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import java.util.Locale;
import models.fmkecom.Product;
import models.fmkecom.ProductRef;
import play.data.validation.Validation;
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
      product.name = params.get("product.name");
      validation.valid(product);
      if (Validation.hasErrors()) {
         params.flash();
         validation.keep();
         editProduct(id);
      } else {
         product.save();
         lookAt(product.reference.id.toStringMongod());
      }

   }

   public static void editProduct(String id) {
      Product product = Product.getManager().getByMongodId(id);


      render(product);
   }

   public static void doTranslate(String id) {
      ProductRef productRef = ProductRef.getManager().getRefByMongodId(id);
      Product product = new Product();
      product.name = params.get("product.name");
      product.reference = productRef;
      product.language = params.get("product.language", Locale.class);
      validation.valid(product);
      if (Validation.hasErrors()) {
         params.flash();
         validation.keep();
         translate(id);
      } else {
         product.save();
         lookAt(productRef.id.toStringMongod());
      }
   }

   public static void doNewProduct() {
      ProductRef productRef = new ProductRef();
      Product product = new Product();
      productRef.product_reference = params.get("productRef.product_reference");
      product.name = params.get("product.name");
      product.reference = productRef;
      product.language = params.get("product.language", Locale.class);
      validation.valid(product);
      validation.valid(productRef);
      if (Validation.hasErrors()) {
         params.flash();
         validation.keep();
         newProduct();
      } else {

         productRef.save();
         product.save();
         ProductController.list(0);
      }
   }

   public static void list(Integer pageNumber) {
      List<ProductRef> products = ProductRef.getManager().getRefPage(pageNumber, 20);

      render(products, pageNumber);
   }

   public static void lookAt(String id) {
      ProductRef productRef = ProductRef.getManager().getRefByMongodId(id);

      render(productRef);
   }
}
