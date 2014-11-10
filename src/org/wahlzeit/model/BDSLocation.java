package org.wahlzeit.model;

import java.util.Vector;

public class BDSLocation extends AbstractLocation {
	
	String locateMethod;
	String locationName;
	float bdsLatitude;
	float bdsLongitude;
	Vector<Comparable> v = new Vector<Comparable>();
	
	BDSLocation(){
		//do nothing
	}
	
	BDSLocation(String myLocationName, float myBdsLatitude, float myBdsLongitude){
		//do nothing
		initialize(myLocationName, myBdsLatitude, myBdsLongitude);
	}
	
	void initialize(String myLocationName, float myBdsLatitude, float myBdsLongitude) {
		
		this.locationName = myLocationName;
		this.bdsLatitude = myBdsLatitude;
		this.bdsLongitude = myBdsLongitude;
	}

	@Override
	public Vector<Comparable> locate(String myLocateMethod) {
		if(GPS.equals(myLocateMethod)){
			return locateBDS();
		}
		return v;
	}

	@Override
	Vector<Comparable> locateBDS() {
		
		//add GPS info elements int the vector in order
		v.add(BDS);
		v.add(locationName);
		v.add(bdsLatitude);
		v.add(bdsLongitude);
		
		return v;
	}

	@Override
	Vector locateGPS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Vector locateGSNS() {
		// TODO Auto-generated method stub
		return null;
	}
}
