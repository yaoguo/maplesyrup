package org.wahlzeit.model.location;

import java.util.List;

import com.mapcode.*;

public class MapcodeLocation extends AbstractLocation {
	private String mapcode;
	private final String MAPCODE_DELIMITER = ".";
	

	private List <Mapcode> mapcodes;
	
	public MapcodeLocation(String photoPath)
	{
		setLatAndLong(photoPath);
		this.mapcodes = MapcodeCodec.encode(this.latitude, this.longitude);
		this.coordinate = createNewCoordinate();
	}
	
	protected String createNewCoordinate() {
		// TODO Auto-generated method stub
		return this.mapcodes.get(this.mapcodes.size()-1).toString();
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
