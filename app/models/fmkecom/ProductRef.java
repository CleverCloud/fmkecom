/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.fmkecom;

import com.google.code.morphia.annotations.Entity;
import java.util.Map;
import java.util.Set;
import models.fmkcms.I18nShortValue;
import models.i18n.*;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import org.bson.types.ObjectId;

/**
 *
 * @author waxzce
 */
@Entity
public class ProductRef extends TranslatableRef<Product, ProductRef> {

   @NotNull
   @NotEmpty
   public String product_reference;
   public Set<ProductCarac> carac;

   public static TranslatableManager<Product, ProductRef> getManager() {
      return new TranslatableManager<Product, ProductRef>(Product.class, ProductRef.class);
   }
}
