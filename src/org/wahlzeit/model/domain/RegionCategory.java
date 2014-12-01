package org.wahlzeit.model.domain;

public enum RegionCategory implements Category {
/**
 * 
 * @author YAO GUO
 *
 */
	Quebec	(1, "Quebec"),
	Vermont	(2, "Vermont"),
	Ontario	(3, "Ontario"),
	NewYork	(4, "New York"),
	Maine	(5, "Maine"),
	Other	(0, "Other");
	
	private final String name;
	private final int intValue;
	
	/**
	 * @methodtype constructor
	 */
	RegionCategory(int intValue, String name) {
		this.intValue = intValue;
		this.name = name;
	}
	
	/**
	 * @para intValue, retrieve region category by integer values
	 * @return enumeration value
	 */
	public static RegionCategory getFromInt(int intValue) {
		RegionCategory[] regionCategories = values();

		for(int i = 0; i < regionCategories.length; i++) {
			if(regionCategories[i].asInt() == intValue) {
				return regionCategories[i];
			}
		}
		
		return Other;
	}
	
	/**
	 * @para name, retrieve region category by String
	 * @return enumeration value
	 */
	public static RegionCategory getFromString(String name) {
		RegionCategory[] regionCategories = values();
		
		for(int i = 0; i < regionCategories.length; i++) {
			if(name!=null && regionCategories[i].getTypeName().equals(name.trim())) {
				return regionCategories[i];
			}
		}
		
		return Other;
	}

	@Override
	public String asString() {
		return "Region category: " + name;
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
