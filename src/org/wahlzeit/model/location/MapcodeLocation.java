package org.wahlzeit.model.location;

import com.mapcode.*;

public class MapcodeLocation extends AbstractLocation {
	private String mapcode;
	private final String MAPCODE_DELIMITER = ".";
	

	public MapcodeLocation() {
	}
	
	
	@Override
	public String getLocation() {
		
		return mapcode;
	}

	@Override
	public void setLocation(String mapcode) {
		
		
		
	}

	@Override
	public void setLocation(double latitude, double longitude) {
		//no implementation for GPS location in MapcodeLocation class
	}
	
	/**
	* get mapcode
	* @methodtype getter
	*/
	public String getMapcode() {
		return mapcode;
	}
	
	/**
	* set mapcode
	* @methodtype setter
	*/
	public void setMapcode(String mapcode) {
		this.mapcode = mapcode;
	}
}
