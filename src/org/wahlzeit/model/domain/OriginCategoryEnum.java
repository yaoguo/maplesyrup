package org.wahlzeit.model.domain;

public enum OriginCategoryEnum {

	Origin("Origin"),
	Other("Other");
	
	private String name;
	
	OriginCategoryEnum(String name) {
		this.name = name;
		assertInvariants();
	}
	
	String getName() {
		return name;
	}
	
	private void assertInvariants() {
		assert name != null;
	}
	
}
