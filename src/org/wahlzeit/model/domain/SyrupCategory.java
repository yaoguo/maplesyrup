package org.wahlzeit.model.domain;

public class SyrupCategory extends AbstractCategory {
/**
 * 
 * @author YAO GUO
 *
 */
	
	SyrupCategoryEnum syrupCategory;
	
	/**
	 * @methodtype constructor
	 */
	public SyrupCategory() {
		this(SyrupCategoryEnum.Classic);
	}

	/**
	 * @methodtype constructor
	 */
	public SyrupCategory(SyrupCategoryEnum syrupCategory) {
		initialize();
		this.syrupCategory = syrupCategory;
		
		assertInvariants();
	}
	
	/**
	 * 
	 * @return syrupCategory
	 * @methodtype getter
	 */
	public SyrupCategoryEnum getSyrupCategory() {
		//precondition
		assert syrupCategory != null;
		
		return syrupCategory;
	}
	
	/**
	 * 
	 * @param 
	 * @methodtype setter
	 */
	public void setSyrupCategory(SyrupCategoryEnum syrupCategory) {
		//precondition
		assert syrupCategory != null;
		
		this.syrupCategory = syrupCategory;
		
		//postcondition
		assert this.syrupCategory != null;
		assert this.syrupCategory == syrupCategory;
	}
	
	/**
	 * 
	 * @methodtype initialization
	 */
	private void initialize() {
		syrupCategory = SyrupCategoryEnum.Classic;
		
		//postcondition
		assert syrupCategory != null;
	}
	
	/**
	 * 
	 * @methodtype assertion
	 */
	protected void assertInvariants() {
		
		assert syrupCategory != null;
	}
	

}
