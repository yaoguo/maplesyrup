package org.wahlzeit.model.domain;

public abstract class AbstractCategory {
/**
 * 
 * @author YAO GUO
 *
 */
	
	protected String categoryName;
	
	/**
	 * @methodtype constructor
	 */
	public AbstractCategory() {
		this("");
	}
	
	/**
	 * @methodtype constructor
	 */
	public AbstractCategory(String categoryName) {
		initialize();
	}
	
	/**
	 * 
	 * @return the category name
	 * @methodtype getter
	 */
	public String getCategoryName() {
		//precondition
		assert categoryName != null;
		
		return categoryName;
	}

	/**
	 * 
	 * @param new category name
	 * @methodtype setter
	 */
	public void setCategoryName(String newCategoryName) {
		//precondition
		assert newCategoryName != null;
		
		this.categoryName = newCategoryName;
		
		//postcondition
		assert this.categoryName != null;
		assert this.categoryName == newCategoryName;
	}
	
	/**
	 * Initializes the fields with default values
	 * 
	 * @methodtype initialization
	 */
	private void initialize() {
		categoryName = "";
		
		setCategoryName(categoryName);
		
		//postcondition
		assert categoryName != null;
	}
	
	/**
	 * class invariants
	 */
	protected void assertInvariants() {
		assert categoryName != null;
	}
	
}
