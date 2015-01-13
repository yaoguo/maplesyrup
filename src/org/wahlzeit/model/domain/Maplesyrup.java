package org.wahlzeit.model.domain;

public class Maplesyrup {
/**
 * This class wraps all specific domain classes for the {@link MaplesyrupPhoto}.
 * 
 * @collaboration Maplesyrup, MaplesyrupPhoto/Maplesyrup, Value Object, Factory 
 * @author Yao Guo
 *
 */

	private RegionCategory regionCategory;
	private SyrupCategory syrupCategory;
	private Quality quality;
	protected MaplesyrupType type;
	protected int id;

	/**
	 * @methodtype constructor
	 */
	protected Maplesyrup() {
		this(RegionCategory.Other, 
			SyrupCategory.Other, 
			MaplesyrupFactory.getInstance().createQuality(0, Quality.Scales.POINT),
			null);
	}
	
	/**
	 * @methodtype constructor
	 */
	protected Maplesyrup(RegionCategory regionCategory, 
			SyrupCategory syrupCategory, 
			Quality quality,
			MaplesyrupType type) {
		this.regionCategory = regionCategory;
		this.syrupCategory = syrupCategory;
		this.quality = quality;
		this.type = type;
		
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

	public MaplesyrupType getType() {
		return type;
	}

	public void setType(MaplesyrupType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}