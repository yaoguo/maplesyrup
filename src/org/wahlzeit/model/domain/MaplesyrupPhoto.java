package org.wahlzeit.model.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.domain.Quality.Scales;

public class MaplesyrupPhoto extends Photo {
/**
 * 
 * @author YAO GUO
 *
 */
	public static final String SYRUP_CATEGORY = "syrupCategory";
	public static final String REGION_CATEGORY = "regionCategory";
	public static final String QUALITY = "quality";
	public static final String QUALITY_SCALE = "qualityScale";
	public static final String QUALITY_VALUE = "qualityValue";

	protected Maplesyrup maplesyrup;
	
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
	
	/**
	 * Getter method of the domain class
	 * 
	 * @return the domain class
	 * @methodtype get
	 */
	public Maplesyrup getMaplesyrup() {
		
		return maplesyrup;
	}
	
	/**
	 * Setter method for the bow category
	 * 
	 * @methodtype set
	 */
	public void setMaplesyrup(Maplesyrup maplesyrup) {
		//precondition
		assert maplesyrup != null;
		
		this.maplesyrup = maplesyrup;
		incWriteCount();
		
		//postcondition
		assert this.maplesyrup != null;
		assert this.maplesyrup == maplesyrup;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void readFrom(ResultSet rset) throws SQLException {
		super.readFrom(rset);
		
		SyrupCategory syrupCategory = MaplesyrupFactory.getInstance().createSyrupCategory(rset.getInt(SYRUP_CATEGORY));
		RegionCategory regionCategory = MaplesyrupFactory.getInstance().createRegionCategory(rset.getInt(REGION_CATEGORY));
		
		int qualityValue = rset.getInt(QUALITY_VALUE);
		int qualityScaleAsInt = rset.getInt(QUALITY_SCALE);
		
		Quality qualt = MaplesyrupFactory.getInstance().createQuality(qualityValue, Quality.Scales.getFromInt(qualityScaleAsInt));
		 
		maplesyrup = new Maplesyrup(regionCategory, syrupCategory, qualt);
	}
	
	/**
	 * @throws SQLException
	 */
	public void writeOn(ResultSet rset) throws SQLException {
		super.writeOn(rset);
		
		rset.updateInt(REGION_CATEGORY, maplesyrup.getRegionCategory().asInt());
		rset.updateInt(SYRUP_CATEGORY, maplesyrup.getSyrupCategory().asInt());
		rset.updateInt(QUALITY_VALUE, maplesyrup.getQuality().getValue());
		rset.updateInt(QUALITY_SCALE, maplesyrup.getQuality().getScale().asInt());
	}
	
	/**
	 * @methodtype initialization
	 */
	private void initialize() {
		
		maplesyrup = new Maplesyrup();
		
		assertInvariants();
		
		incWriteCount();
	}
	
	/**
	 * @methodtype class assertion
	 */
	private void assertInvariants() {
		assert maplesyrup != null;
	}
}
