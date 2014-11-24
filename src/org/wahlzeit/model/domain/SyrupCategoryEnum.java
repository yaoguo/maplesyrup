package org.wahlzeit.model.domain;

public enum SyrupCategoryEnum {

	Classic("classic"),
	Other("other");
	
	private String name;
	
	SyrupCategoryEnum(String name) {
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
