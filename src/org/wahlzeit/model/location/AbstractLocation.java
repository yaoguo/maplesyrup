package org.wahlzeit.model.location;

public abstract class AbstractLocation implements Location {
/**
 * 
 * @author YAO GUO
 *
 */

	public String location;
	public double latitude;
	public double longitude;
	
	/**
	* get the location
	* @methodtype get
	*/
	public abstract String getLocation();
	
	
	/***
	* set the location with mapcode
	* @param mapcode
	* @methodtype set
	*/
	public abstract void setLocation(String mapcode);
	
	/***
	* set the location with GPS coordinate
	* @param GPS coordinate
	* @methodtype set
	*/
	public abstract void setLocation(double latitude, double longitude);
	
}