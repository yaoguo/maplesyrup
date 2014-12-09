package org.wahlzeit.model.domain;

public class Maplesyrup {
/**
  * 
  * @author Yao Guo
  */

	protected final RegionCategory regionCategory;
	protected final SyrupCategory syrupCategory;
	protected final Quality quality;

	/**
	 * @methodtype constructor
	 */
	protected Maplesyrup() {
		this(RegionCategory.Other, SyrupCategory.Other, MaplesyrupFactory.getInstance().createQuality(0, Quality.Scales.POINT));
	}
	
	/**
	 * @methodtype constructor
	 */
	protected Maplesyrup(RegionCategory regionCategory, SyrupCategory syrupCategory, Quality quality) {
		this.regionCategory = regionCategory;
		this.syrupCategory = syrupCategory;
		this.quality = quality;
		
		assertInvariants();
	}

	/**
	 * Getter method of the region category
	 * 
	 * @return the region category
	 * @methodtype get
	 */
	public RegionCategory getRegionCategory() {
		return regionCategory;
	}

	/**
	 * Getter method of the syrup category
	 * 
	 * @return the syrup category
	 * @methodtype get
	 */
	public SyrupCategory getSyrupCategory() {
		return syrupCategory;
	}

	/**
	 * Getter method of the draw weight
	 * 
	 * @return the draw weight
	 * @methodtype get
	 */
	public Quality getQuality() {
		return quality;
	}
	
	/**
	 * Method that checks the class invariants
	 */
	private void assertInvariants() {
		if(regionCategory == null || syrupCategory == null || quality == null) {
			throw new IllegalStateException("Illegal state of the class 'Maplesyrup'");
		}
	}

}