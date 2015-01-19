package org.wahlzeit.model.location;

import java.util.List;
import java.util.StringTokenizer;

import org.wahlzeit.exception.LocationException;

import com.mapcode.*;

public class MapcodeLocation extends AbstractLocation {
/**
 * 
 * @collaboration Location
 * @author YAO GUO
 *
 */

	private List <Mapcode> mapcodes;
	private final String MAPCODE_DELIMITER = ".";
	
	/***
     * @methodtype constructor
     */
	public MapcodeLocation() {
		
	}
	
	/***
     * @methodtype constructor
     */
	public MapcodeLocation(String mapcodeString) throws LocationException {
		this();
		parseMapcodeLocationString(mapcodeString);
	}
	
	/***
     * @methodtype command
     */
	private void parseMapcodeLocationString(String mapcodeString) throws LocationException {
			
		String location = "";
		
		assert mapcodeString != null;
		
		int pos = mapcodeString.indexOf(MAPCODE_DELIMITER);
		int len = mapcodeString.length();
		
		if(pos!=0 && pos+1<len){
			location = mapcodeString.substring(0, pos) + mapcodeString.substring(pos+1, len);
		}else {
			throw new LocationException("Could not parse the string into Mapcode string.");
		}
	}

	/***
	 * generate map code 
     * @methodtype command
     */
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

	@Override
	public String asString() {
		// TODO Auto-generated method stub
		return null;
	}
}
