package org.wahlzeit.model.location;

public class GPSLocation extends AbstractLocation {
	
	private double gpsLatitude = 0;
	private double gpsLongitude = 0;
	
	
	/***
    * @methodtype constructor
    */
    public GPSLocation(){
    }

	@Override
	public String getLocation() {
		
		return "(" + gpsLatitude + ", " + gpsLongitude + ")";
	}
	
	@Override
	public void setLocation(String mapcode) {
		//no implementation for mapcode in GPSLocation class
	}
	
	@Override
	public void setLocation(double latitude, double longitude) {
		this.gpsLatitude = latitude;
        this.gpsLongitude = longitude;
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
	protected void assertValidLongitude(double longitude){
//      if(!(longitude >= -180 && longitude <= 180)){
//			throw new IllegalArgumentException("Invalid longitude value: " + longitude);
//  }
		assert (!(longitude >= -180 && longitude <= 180)): "Invalid longitude value: " + longitude;

    }
	
	/**
	* get Gps Latitude
	* @methodtype getter
	*/
	public double getGpsLatitude() {
		return gpsLatitude;
	}

	/**
	* set Gps Latitude
	* @methodtype setter
	*/
	public void setGpsLatitude(double gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	/**
	* get Gps Longitude
	* @methodtype getter
	*/
	public double getGpsLongitude() {
		return gpsLongitude;
	}

	/**
	* set Gps Longitude
	* @methodtype setter
	*/
	public void setGpsLongitude(double gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}

}
