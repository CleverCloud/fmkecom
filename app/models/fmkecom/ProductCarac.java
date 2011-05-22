/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.fmkecom;

import com.google.code.morphia.annotations.Entity;
import java.util.Set;
import models.fmkcms.I18nShortValue;

/**
 *
 * @author waxzce
 */
@Entity
public class ProductCarac extends I18nShortValue{
    
    public Set<I18nShortValue> values;
    
}
