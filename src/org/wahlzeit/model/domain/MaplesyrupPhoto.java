package org.wahlzeit.model.domain;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class MaplesyrupPhoto extends Photo {
/**
 * 
 * @author YAO GUO
 *
 */

	public static final String SYRUP_CATEGORY = "syrupCategory";
	public static final String ORIGIN_CATEGORY = "originCategory";
	
	protected SyrupCategory syrupCategory;
	protected OriginCategory originCategory;
	
	/**
	 * @methodtype constructor
	 */
	public MaplesyrupPhoto() {
		super();
		initialize();
	}
	
	/**
	 * @methodtype constructor
	 */
	public MaplesyrupPhoto(PhotoId fotoID) {
		super(fotoID);
		initialize();
	}

	/**
	 * @methodtype getter
	 */
	public SyrupCategory getSyrupCategory() {
		//precondition
		assert syrupCategory != null;
		return syrupCategory;
	}

	/**
	 * @methodtype setter
	 */
	public void setSyrupCategory(SyrupCategory syrupCategory) {
		//precondition
		assert syrupCategory != null;
		
		this.syrupCategory = syrupCategory;
		
		//postcondition
		assert this.syrupCategory != null;
		assert this.syrupCategory == syrupCategory;
	}

	/**
	 * @methodtype getter
	 */
	public OriginCategory getOriginCategory() {
		//precondition
		assert originCategory != null;
		return originCategory;
	}

	/**
	 * @methodtype setter
	 */
	public void setOriginCategory(OriginCategory originCategory) {
		//precondition
		assert originCategory != null;
				
		this.originCategory = originCategory;
		
		//postcondition
		assert this.originCategory != null;
		assert this.originCategory == originCategory;
	}
	
	/**
	 * @methodtype initialization
	 */
	private void initialize() {
		syrupCategory = new SyrupCategory();
		originCategory = new OriginCategory();
		
		assertInvariants();
	}
	
	/**
	 * @methodtype class assertion
	 */
	private void assertInvariants() {
		assert syrupCategory != null;
		assert originCategory != null;
	}

}
