/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.fmkecom.ProductRef;
import play.mvc.Controller;

/**
 *
 * @author waxzce
 */
public class ProductViewer extends Controller {
    public static void list(){
        List<ProductRef> products = ProductRef.getDs().find(ProductRef.class).asList();
        render(products);
    }
}
