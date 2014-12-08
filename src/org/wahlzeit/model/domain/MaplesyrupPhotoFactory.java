package org.wahlzeit.model.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.SysLog;

public class MaplesyrupPhotoFactory extends PhotoFactory {
	
	/**
	 * the singleton instance is initialized from the outside.
	 */
	private static MaplesyrupPhotoFactory instance = null;

	/**
	 * Public singleton access method.
	 */
	public static synchronized MaplesyrupPhotoFactory getInstance() {
		if (instance == null) {
			SysLog.logSysInfo("setting spcified MaplesyrupPhotoFactory");
			setInstance(new MaplesyrupPhotoFactory());
		}
		
		return instance;
	}

	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto() {
		return new MaplesyrupPhoto();
	}
	
	/**
	 * 
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto(PhotoId id) {
		return new MaplesyrupPhoto(id);
	}
	
	/**
	 * 
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto(ResultSet rs) throws SQLException {
		return new MaplesyrupPhoto(rs);
	}

}
