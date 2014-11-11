package org.wahlzeit.location;

import java.util.Vector;

public class GPSLocation extends AbstractLocation {
	
	String locateMethod;
	String locationName;
	float gpsLatitude;
	float gpsLongitude;
	Vector<Comparable> v = new Vector<Comparable>();
	
	GPSLocation(){
		//do nothing
	}
	
	GPSLocation(String myLocationName, float myGpsLatitude, float myGpsLongitude){
		//do nothing
		initialize(myLocationName, myGpsLatitude, myGpsLongitude);
	}
	
	void initialize(String myLocationName, float myGpsLatitude, float myGpsLongitude) {
		
		this.locationName = myLocationName;
		this.gpsLatitude = myGpsLatitude;
		this.gpsLongitude = myGpsLongitude;
	}

	@Override
	public Vector<Comparable> locate(String myLocateMethod) {
		if(GPS.equals(myLocateMethod)){
			return locateGPS();
		}
		return v;
	}

	@Override
	Vector<Comparable> locateGPS() {
		
		//add GPS info elements int the vector in order
		v.add(GPS);
		v.add(locationName);
		v.add(gpsLatitude);
		v.add(gpsLongitude);
		
		return v;
	}

	@Override
	Vector locateBDS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Vector locateGSNS() {
		// TODO Auto-generated method stub
		return null;
	}
}
