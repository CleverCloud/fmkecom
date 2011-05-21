/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.fmkecom;

import com.google.code.morphia.annotations.Entity;
import elasticsearch.Searchable;
import models.i18n.*;
import org.bson.types.ObjectId;


/**
 *
 * @author waxzce
 */
@Entity
public class Product extends Translatable<Product, ProductRef> implements Searchable {
    
    public String name;
    

    public String getPrintTitle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getPrintDesc() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getPrintURL() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ObjectId getEntityId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float getScore() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setScore(float score) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
