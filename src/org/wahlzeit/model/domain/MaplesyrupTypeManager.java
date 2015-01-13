package org.wahlzeit.model.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.wahlzeit.main.ServiceMain;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;
import org.wahlzeit.services.SysLog;

public class MaplesyrupTypeManager extends ObjectManager {
/**
 * MaplesyrupTypeManager manages {@link MaplesyrupType} instances.
 * 
 * @collaboration MaplesyrupType, Manager
 * @author Yao Guo
 *
 */
	
	private final String SELECT_STATEMENT_MAPLESYRUP_TYPE_ID = "SELECT * FROM maplesyrupTypes WHERE id = ?";
	private final String INSERT_STATEMENT_MAPLESYRUP = "INSERT INTO maplesyrupTypes(id) VALUES(?)";
	
	private static MaplesyrupTypeManager instance;
	private static HashMap<Integer, MaplesyrupType> maplesyrupTypeCache = new HashMap<Integer, MaplesyrupType>();

	/**
	 * Constructor
	 */
	private MaplesyrupTypeManager() {

	}

	/**
	 * Getter method of the singleton
	 * 
	 * @return the instance of the class
	 * @methodtype get
	 */
	public static MaplesyrupTypeManager getInstance() {
		if(instance == null) {
			instance = new MaplesyrupTypeManager();
		}
		return instance;
	}
	
	/**
	 * Returns 
	 * 
	 * @param 
	 * @return 
	 */
	public MaplesyrupType getMaplesyrupTypeFromId(int id) {
		MaplesyrupType result = maplesyrupTypeCache.get(new Integer(id));

		if(result == null) {
			try {
				PreparedStatement stmt = getReadingStatement(SELECT_STATEMENT_MAPLESYRUP_TYPE_ID);
				result = (MaplesyrupType) readObject(stmt, id);
			} catch (SQLException e) {
				SysLog.logThrowable(e);
			}
			if (result != null) {
				doAddMaplesyrupType(id, result);
			}
		}

		return result;
	}
	
	/**
	 * 
	 */
	public int getNextId() {
			int id = 0;
			
			try {
				PreparedStatement stmt = getReadingStatement("SELECT * FROM maplesyrupTypes");
				ResultSet rset = stmt.executeQuery();
				//TODO Use max()
				while(rset.next()) {
					int currId = rset.getInt("id");
					if(currId > id) {
						id = currId;
					}
				}
			} catch (SQLException e) {
				SysLog.logThrowable(e);
			}
			
			return id+1;
		}

	/**
	 * 
	 */
	public void addMaplesyrupType(MaplesyrupType maplesyrupType) {
		doAddMaplesyrupType(maplesyrupType.getId(), maplesyrupType);

		try {
			PreparedStatement stmt = getReadingStatement(INSERT_STATEMENT_MAPLESYRUP);
			createObject(maplesyrupType, stmt, maplesyrupType.getId());
			ServiceMain.getInstance().saveGlobals();
		} catch (SQLException e) {
			SysLog.logThrowable(e);
		}
	}
	
	/**
	 * 
	 */
	public void saveMaplesyrupType(MaplesyrupType maplesyrupType) {
		try {
			PreparedStatement stmt = getUpdatingStatement(SELECT_STATEMENT_MAPLESYRUP_TYPE_ID);
			updateObject(maplesyrupType, stmt);
		} catch (SQLException e) {
			SysLog.logThrowable(e);
		}
	}

	/**
	 * 
	 */
	public void saveMaplesyrupTypes() {
		try {
			PreparedStatement stmt = getUpdatingStatement(SELECT_STATEMENT_MAPLESYRUP_TYPE_ID);
			updateObjects(maplesyrupTypeCache.values(), stmt);
		} catch (SQLException e) {
			SysLog.logThrowable(e);
		}
	}
	
	/**
	 * 
	 */
	private void doAddMaplesyrupType(int id , MaplesyrupType maplesyrupType) {
		maplesyrupTypeCache.put(new Integer(id), maplesyrupType);
	}

	@Override
	protected Persistent createObject(ResultSet rset) throws SQLException {
		return MaplesyrupFactory.getInstance().createMaplesyrupType(rset);
	}
}
