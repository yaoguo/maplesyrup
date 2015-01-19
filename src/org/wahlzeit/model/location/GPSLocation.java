package org.wahlzeit.model.location;

import java.util.StringTokenizer;

import org.wahlzeit.exception.LocationException;

public class GPSLocation extends AbstractLocation {
/**
 * 
 * @collaboration Location
 * @author YAO GUO
 *
 */
	private final String GPS_DELIMITER = ",";
	
	/***
    * @methodtype constructor
    */
    public GPSLocation(){
    	super();
    }
    
	/***
     * @methodtype constructor
     */
    public GPSLocation(String gpsString) throws LocationException {
		this();
		parseGPSLocationString(gpsString);
     }

	/***
     * @methodtype command
     */
	private void parseGPSLocationString(String gpsString) throws LocationException {
		StringTokenizer strTokenizer = new StringTokenizer(gpsString, GPS_DELIMITER);
		
		if(strTokenizer.countTokens() == 2) {
			this.latitude = Double.parseDouble(strTokenizer.nextToken().trim());
			this.longitude = Double.parseDouble(strTokenizer.nextToken().trim());
		}else {
			throw new LocationException("Could not parse the string into GPS string.");
		}
	}

	@Override
	public String getLocation() {
		this.location = "(" + this.latitude + ", " +  this.longitude + ")";
		
		return this.location;
	}
	
	@Override
	public void setLocation(String mapcode) {
		//no implementation for mapcode in GPSLocation class
	}
	
	@Override
	public void setLocation(double gpslatitude, double gpslongitude) {
		this.latitude = gpslatitude;
        this.longitude = gpslongitude;
	}
	
	/**
	* 
	* @methodtype assertion
	*/
	protected void assertValidLatitude(double latitude){
//        if(!(latitude >= -90 && latitude <= 90)){
//            throw new IllegalArgumentException("Invalid latitude value: " + latitude);
//        }
        
        assert (!(latitude >= -90 && latitude <= 90)): "Invalid latitude value: " + latitude;
    }
	
	/**
	* 
	* @methodtype assertion
	*/
	protected void assertValidLongitude(double longitude) throws LocationException {
      if(!(longitude >= -180 && longitude <= 180)){
			throw new LocationException("Invalid longitude value: " + longitude);
  }
		//assert (!(longitude >= -180 && longitude <= 180)): "Invalid longitude value: " + longitude;

    }
	
	/**
	* get Gps Latitude
	* @methodtype getter
	*/
	public double getLatitude() {
		return this.latitude;
	}

	/**
	* set Gps Latitude
	* @methodtype setter
	*/
	public void setGpsLatitude(double gpsLatitude) {
		this.latitude = gpsLatitude;
	}

	/**
	* get Gps Longitude
	* @methodtype getter
	*/
	public double getLongitude() {
		return this.longitude;
	}

	/**
	* set Gps Longitude
	* @methodtype setter
	*/
	public void setLongitude(double gpsLongitude) {
		this.longitude = gpsLongitude;
	}

	@Override
	public String asString() {
		// TODO Auto-generated method stub
		return null;
	}

}
