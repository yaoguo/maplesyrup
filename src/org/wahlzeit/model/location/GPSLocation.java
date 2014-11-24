package org.wahlzeit.model.location;

public class GPSLocation extends AbstractLocation {
	
	/***
    * @methodtype constructor
    */
    public GPSLocation(){
    	super();
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

}
