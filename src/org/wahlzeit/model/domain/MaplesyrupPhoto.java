package org.wahlzeit.model.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class MaplesyrupPhoto extends Photo {
/**
 * 
 * @author YAO GUO
 *
 */
	///////////////////
	/// fields
	///////////////////
	public static final String SYRUP_CATEGORY = "syrupCategory";
	public static final String REGION_CATEGORY = "regionCategory";
	
	protected SyrupCategory syrupCategory;
	protected RegionCategory regionCategory;
	
	
	///////////////////
	/// constructor
	///////////////////
	/**
	 * @methodtype constructor
	 */
	public MaplesyrupPhoto() {
		super();
		initialize();
	}
	
	/**
	 * @methodtype constructor
	 * @param PhotoId
	 */
	public MaplesyrupPhoto(PhotoId fotoID) {
		super(fotoID);
		initialize();
	}
	
	/**
	 * @throws SQLException 
	 * @methodtype constructor
	 */
	public MaplesyrupPhoto(ResultSet rset) throws SQLException {
		super(rset);
	}
	
	///////////////////
	/// methods
	///////////////////	
	/**
	 * Getter method for the syrup category
	 * 
	 * @return the syrup category
	 * @methodtype get
	 */
	public SyrupCategory getSyrupCategory() {
		//precondition
		assert syrupCategory != null;
		
		return syrupCategory;
	}
	
	/**
	 * Setter method for the bow category
	 * 
	 * @methodtype set
	 */
	public void setSyrupCategory(SyrupCategory syrupCategory) {
		//precondition
		assert syrupCategory != null;
		
		this.syrupCategory = syrupCategory;
		incWriteCount();
		
		//postcondition
		assert this.syrupCategory != null;
		assert this.syrupCategory == syrupCategory;
	}

	/**
	 * Getter method for the region category
	 * 
	 * @return the region category
	 * @methodtype get
	 */
	public RegionCategory getRegionCategory() {
		//precondition
		assert regionCategory != null;
		
		return regionCategory;
	}
	
	/**
	 * Setter method for the region category
	 * 
	 * @methodtype set
	 */
	public void setRegionCategory(RegionCategory regionCategory) {
		//precondition
		assert regionCategory != null;
		
		this.regionCategory = regionCategory;
		incWriteCount();
		
		//postcondition
		assert this.regionCategory != null;
		assert this.regionCategory == regionCategory;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void readFrom(ResultSet rset) throws SQLException {
		super.readFrom(rset);
		
		syrupCategory = SyrupCategory.getFromInt(rset.getInt(SYRUP_CATEGORY));
		regionCategory = RegionCategory.getFromInt(rset.getInt(REGION_CATEGORY));
	}
	
	/**
	 * @throws SQLException
	 */
	public void writeOn(ResultSet rset) throws SQLException {
		super.writeOn(rset);
		
		rset.updateInt(SYRUP_CATEGORY, syrupCategory.asInt());
		rset.updateInt(REGION_CATEGORY, regionCategory.asInt());
	}
	
	/**
	 * @methodtype initialization
	 */
	private void initialize() {
		
		syrupCategory = SyrupCategory.Other;
		regionCategory = RegionCategory.Other;
		
		assertInvariants();
		
		incWriteCount();
	}
	
	/**
	 * @methodtype class assertion
	 */
	private void assertInvariants() {
		assert syrupCategory != null;
		assert regionCategory != null;
	}

}
