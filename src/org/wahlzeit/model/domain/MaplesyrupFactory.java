package org.wahlzeit.model.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.wahlzeit.model.domain.Quality.Scales;

public class MaplesyrupFactory {
/**
 * The MaplesyrupFactory class is responsible for creating instances of the Maplesyrup domain classes.
 * 
 * @collaboration Factory
 * @author Yao Guo
 *
 */

	private static MaplesyrupFactory instance;
	private static HashMap<String, Quality> qualityInstances = new HashMap<String, Quality>();

	private MaplesyrupFactory() {

	}

	/**
	 * Getter method of the singleton
	 * 
	 * @return the instance of the class
	 * @methodtype get
	 */
	public static MaplesyrupFactory getInstance() {
		if(instance == null) {
			instance = new MaplesyrupFactory();
		}
		return instance;
	}

	/**
	 * Returns a default maplesyrup object
	 * 
	 * @return default maplesyrup object
	 * @methodtype factory
	 */
	public Maplesyrup createMaplesyrupObject() {
		return new Maplesyrup();
	}

	/**
	 * Creates a new Maplesyrup object
	 * 
	 * @param regionCategory region category to be set
	 * @param syrupCategory syrup category to be set
	 * @param drawWeight draw weight to be set
	 * @return Returns the new maplesyrup object
	 * @methodtype factory
	 */
	public Maplesyrup createMaplesyrupObject(RegionCategory regionCategory, 
			SyrupCategory syrupCategory, Quality qualityScore, MaplesyrupType type) {
		//precondition
		assert regionCategory != null;
		assert syrupCategory != null;
		assert qualityScore != null;
		assert type != null;

		return new Maplesyrup(regionCategory, syrupCategory, qualityScore, type);
	}

	/**
	 * Returns a new RegionCategory object from a given id
	 * 
	 * @param categoryId Id of the requested object
	 * @return the respective category object
	 * @methodtype factory
	 */
	public RegionCategory createRegionCategory(int categoryId) {
		//precondition
		assert categoryId >= 0;

		return RegionCategory.getFromInt(categoryId);
	}

	/**
	 * Returns a new RegionCategory object from a given name
	 * 
	 * @param categoryName Name of the requested object
	 * @return the respective category object
	 * @methodtype factory
	 */
	public RegionCategory createRegionCategory(String categoryName) {
		//precondition
		assert categoryName != null && categoryName.length() >= 0;

		return RegionCategory.getFromString(categoryName);
	}

	/**
	 * Returns a new SyrupCategory object from a given id
	 * 
	 * @param categoryId Id of the requested object
	 * @return the respective category object
	 * @methodtype factory
	 */
	public SyrupCategory createSyrupCategory(int categoryId) {
		//precondition
		assert categoryId >= 0;

		return SyrupCategory.getFromInt(categoryId);
	}

	/**
	 * Returns a new SyrupCategory object from a given name
	 * 
	 * @param categoryName Name of the requested object
	 * @return the respective category object
	 * @methodtype factory
	 */
	public SyrupCategory createSyrupCategory(String categoryName) {
		//precondition
		assert categoryName != null && categoryName.length() >= 0;

		return SyrupCategory.getFromString(categoryName);
	}

	/**
	 * Creates a new Quality object
	 * 
	 * @param value The value of the new object 
	 * @param scale The scale of the new object
	 * @return the respective Quality object
	 * @methodtype factory
	 */
	public Quality createQuality(int value, Scales scale) {
		//precondition
		assert value >= 0;
		assert scale != null;

		return getQualityInstance(value, scale);
	}

	/**
	 * Returns an existings instance of the Quality object. If there isn't an existing one, it creates a new one.
	 * 
	 * @param value represents the integer value
	 * @param scale represents the scale
	 * @return return an instance of the Quality class
	 */
	private static Quality getQualityInstance(int value, Scales scale) {
		//postcondition
		assert scale != null;
		assert value >= 0;

		String key = Quality.asString(value, scale);

		Quality instance = null;
		if(qualityInstances.containsKey(key)) {
			instance = qualityInstances.get(key);
		} else {
			instance = new Quality(value, scale);
			qualityInstances.put(key, instance);
		}

		return instance;
	}
	
	public MaplesyrupType createMaplesyrupType(String name, String usage) {
			return new MaplesyrupType(name, usage);
	}
		
	public MaplesyrupType createMaplesyrupType(ResultSet rset) throws SQLException {
		return new MaplesyrupType(rset);
	}
	
	public Maplesyrup createMaplesyrup() {
		return new Maplesyrup();
	}
	
	public Maplesyrup createMaplesyrup(ResultSet rset) throws SQLException {
		return new Maplesyrup();
	}
}
