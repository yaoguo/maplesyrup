package org.wahlzeit.model.domain;

public class Quality {

/**
  * 
  * @author Yao Guo
  */
	
	public enum Scales {
		POINT(0, "points"),
		LEVEL(1, "level");

		private int scaleAsInt;
		private String scaleAsString;

		Scales(int scaleAsInt, String scaleAsString) {
			this.scaleAsInt = scaleAsInt;
			this.scaleAsString = scaleAsString;
		}
		
		public static Scales getFromInt(int intValue) {
			Scales[] scales = values();
			for(int i = 0; i < scales.length; ++i) {
				if(scales[i].asInt() == intValue) {
					return scales[i];
				}
			}
			
			return POINT;
		}
		
		public static Scales getFromString(String scaleAsString) {
			Scales[] scales = values();
			for(int i = 0; i < scales.length; ++i) {
				if(scales[i].getScaleAsString().equals(scaleAsString)) {
					return scales[i];
				}
			}
			
			return LEVEL;
		}

		public String getScaleAsString() {
			return scaleAsString;
		}	
		
		public int asInt() {
			return scaleAsInt;
		}
	}

	///////////////////////////////////
	/// Fields
	///////////////////////////////////
	private final int value;
	private final Scales scale;

	/**
	 * @methodtype constructor
	 */
	protected Quality(int value, Scales scale) {
		this.value = value;
		this.scale  = scale;
	}

	/**
	 * Returns the unit of the value object
	 * 
	 * @return returns the unit of the value object
	 * @methodtype get
	 */
	public Scales getScale() {
		return scale;
	}

	/**
	 * Returns the value of the value object
	 * 
	 * @return returns the value of the value object
	 * @methodtype get
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns a string representation of the value object
	 * 
	 * @return returns a string representation of the value object
	 * @methodtype conversion
	 */
	public String asString() {
		return asString(value, scale);
	}

	public static String asString(int value, Scales scale) {
		return value + " " + scale.getScaleAsString();
	}
	
	
}
