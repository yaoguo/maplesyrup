package org.wahlzeit.model.domain;

import org.wahlzeit.utils.EnumValue;

public enum SyrupCategory implements EnumValue {
/**
  * SyrupCategory contains all information of the category of a Syrup.
  * 
  * @collaboration Maplesyrup, Factory, Value Object, Category
  * @author Yao Guo
  *
  */
	ExtraLight	(1, "Extra Light"),
	Light		(2, "Light"),
	Medium		(3, "Medium"),
	Amber		(4, "Amber"),
	Dark		(5, "Dark"),
	Other		(0, "Other");
	
	private final String name;
	private final int intValue;
	
	/**
	 * @methodtype constructor
	 */
	SyrupCategory(int intValue, String name) {
		this.intValue = intValue;
		this.name = name;
	}
	
	/**
	 * @para intValue, retrieve syrup category by integer values
	 * @return enumeration value
	 */
	public static SyrupCategory getFromInt(int intValue) {
		
		assertIsValidSyrupCategoryAsInt(intValue);
		
		SyrupCategory[] syrupCategories = values();

		for(int i = 0; i < syrupCategories.length; i++) {
			if(syrupCategories[i].asInt() == intValue) {
				return syrupCategories[i];
			}
		}
		
		return Other;
	}
	
	/**
	 * @para name, retrieve syrup category by String
	 * @return enumeration value
	 */
	public static SyrupCategory getFromString(String name) {
		SyrupCategory[] syrupCategories = values();
		
		for(int i = 0; i < syrupCategories.length; i++) {
			if(name!=null && syrupCategories[i].getTypeName().equals(name.trim())) {
				return syrupCategories[i];
			}
		}
		
		return Other;
	}
	
	/**
     * asserts that int representation is valid, must be between 0 and 5
     *
     * @param myValue int representation of SyrupCategory
     * @throws IllegalArgumentException
     */
    protected static void assertIsValidSyrupCategoryAsInt(int myValue) throws IllegalArgumentException {
        if ((myValue < 0) || (myValue > 5)) {
            throw new IllegalArgumentException("invalid SyrupCategory int: " + myValue);
        }
    }

	@Override
	public int asInt() {
		return intValue;
	}

	@Override
	public String asString() {
		return "Syrup category: " + name;
	}

	@Override
	public EnumValue[] getAllValues() {
		SyrupCategory[] syrupCategories = values();
		return syrupCategories;
	}

	@Override
	public String getTypeName() {
		return name;
	}

}
