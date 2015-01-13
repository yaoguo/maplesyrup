package org.wahlzeit.model.domain;

public interface Category {
	
/**
 * The {@link Category} interface contains common methods for categories.
 * 
 * @collaboration Maplesyrup, Category
 * @author Yao Guo
 *
 */
	
	public String asString();
	public int asInt();
	public Category[] getAllValues();
	public String getTypeName();
}