package org.wahlzeit.model.domain;

public class OriginCategory extends AbstractCategory {
/**
 * 
 * @author YAO GUO
 *
 */
	
	OriginCategoryEnum originCategory;
	
	/**
	 * @methodtype constructor
	 */
	public OriginCategory() {
		this(OriginCategoryEnum.Origin);
	}

	/**
	 * @methodtype constructor
	 */
	public OriginCategory(OriginCategoryEnum originCategory) {
		initialize();
		this.originCategory = originCategory;
		
		assertInvariants();
	}
	
	/**
	 * 
	 * @return syrupCategory
	 * @methodtype getter
	 */
	public OriginCategoryEnum getOriginCategory() {
		//precondition
		assert originCategory != null;
		
		return originCategory;
	}
	
	/**
	 * 
	 * @param 
	 * @methodtype setter
	 */
	public void setOriginCategory(OriginCategoryEnum originCategory) {
		//precondition
		assert originCategory != null;
		
		this.originCategory = originCategory;
		
		//postcondition
		assert this.originCategory != null;
		assert this.originCategory == originCategory;
	}
	
	/**
	 * 
	 * @methodtype initialization
	 */
	private void initialize() {
		originCategory = OriginCategoryEnum.Origin;
		
		//postcondition
		assert originCategory != null;
	}
	
	/**
	 * 
	 * @methodtype assertion
	 */
	protected void assertInvariants() {
		
		assert originCategory != null;
	}
	

}
