/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.fmkecom;

import com.google.code.morphia.annotations.Entity;
import java.util.Set;
import models.i18n.*;
import play.data.validation.Required;

/**
 *
 * @author waxzce
 */
@Entity
public class ProductRef extends TranslatableRef<Product, ProductRef> {

   @Required
   public String product_reference;
   public Set<ProductCarac> carac;

   public static TranslatableManager<Product, ProductRef> getManager() {
      return new TranslatableManager<Product, ProductRef>(Product.class, ProductRef.class);
   }
}
