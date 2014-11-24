package org.wahlzeit.model.location;

import java.util.List;

import com.mapcode.*;

public class MapcodeLocation extends AbstractLocation {
/**
 * 
 * @author YAO GUO
 *
 */

	private List <Mapcode> mapcodes;
	
	public MapcodeLocation()
	{

	}
	
	protected String createMapcodeLocation() {
		//assertion the list is not empty
		
		
		return mapcodes.get(mapcodes.size()-1).toString();
	}
	
	
	@Override
	public String getLocation() {
		
		return location;
	}

	@Override
	public void setLocation(String mapcode) {
		//assert mapcode is valid
		
		
		
		location = mapcode;
	}

	@Override
	public void setLocation(double gpslatitude, double gpslongitude) {
		//mapcode can be set with gps coordinate
		mapcodes = MapcodeCodec.encode(gpslatitude, gpslongitude);
		location = createMapcodeLocation();
	}
}
