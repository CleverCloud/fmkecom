/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.fmkecom;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Reference;
import java.util.Map;
import models.fmkcms.I18nShortValue;
import mongo.MongoEntity;

/**
 *
 * @author waxzce
 */
@Entity
public class ConfiguredProduct extends MongoEntity {

    @Reference
    public ProductRef productRef;
    
    @Reference
    public Map<ProductCarac, I18nShortValue> configuration;
}
