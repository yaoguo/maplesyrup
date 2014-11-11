package org.wahlzeit.location;

import java.util.Vector;

public abstract class AbstractLocation implements Location {
	
	//Global Positioning System
	public static final String GPS = "GPS";
	//BeiDou Navigation Satellite System
	public static final String BDS = "BDS";
	//Galileo satellite navigation system
	public static final String GSNS = "GSNS";
	
	public Vector locate(String locateMethod){

		switch(locateMethod){
			case BDS:
				return locateBDS();
			case GSNS:
				return locateGSNS();
			default:
				//GPS
				return locateGPS();
		}	
	}

	abstract Vector locateGPS();
	abstract Vector locateBDS();
	abstract Vector locateGSNS();
	
}
