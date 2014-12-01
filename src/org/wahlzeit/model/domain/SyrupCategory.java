package org.wahlzeit.model.domain;

public enum SyrupCategory implements Category {
/**
 * 
 * @author YAO GUO
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

	@Override
	public String asString() {
		return "Syrup category: " + name;
	}

	@Override
	public int asInt() {
		return intValue;
	}

	@Override
	public Category[] getAllValues() {
		return values();
	}

	@Override
	public String getTypeName() {
		return name;
	}
}
