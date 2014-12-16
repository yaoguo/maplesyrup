package org.wahlzeit.model.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.wahlzeit.main.ServiceMain;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;
import org.wahlzeit.services.SysLog;

public class MaplesyrupManager extends ObjectManager {

	private final String SELECT_STATEMENT_MAPLESYRUP_ID = "SELECT * FROM maplesyrups WHERE id = ?";
	private final String INSERT_STATEMENT_MAPLESYRUP = "INSERT INTO maplesyrups(id) VALUES(?)";

	private Map<Integer, Maplesyrup> maplesyrupCache = new HashMap<Integer, Maplesyrup>();

	private static MaplesyrupManager instance;

	/**
	 * Constructor
	 */
	private MaplesyrupManager() {}

	/**
	 * Getter method of the singleton
	 * 
	 * @return the instance of the class
	 * @methodtype get
	 */
	public static MaplesyrupManager getInstance() {
		if(instance == null) {
			instance = new MaplesyrupManager();
		}
		return instance;
	}

	/**
	 * 
	 */
	public Maplesyrup getMaplesyrupFromId(int id) {
		Maplesyrup result = maplesyrupCache.get(new Integer(id));

		if(result == null) {
			try {
				PreparedStatement stmt = getReadingStatement(SELECT_STATEMENT_MAPLESYRUP_ID);
				result = (Maplesyrup) readObject(stmt, id);
			} catch (SQLException ex) {
				SysLog.logThrowable(ex);
			}
			if (result != null) {
				doAddMaplesyrup(id, result);
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
			PreparedStatement stmt = getReadingStatement("SELECT * FROM maplesyrups");
			ResultSet rset = stmt.executeQuery();
			//TODO Use max()
			while(rset.next()) {
				int currId = rset.getInt("id");
				if(currId > id) {
					id = currId;
				}
			}
		} catch (SQLException ex) {
			SysLog.logThrowable(ex);
		}
		
		return id+1;
	}

	/**
	 * 
	 */
	public void addMaplesyrup(Maplesyrup maplesyrup) {
		doAddMaplesyrup(maplesyrup.getId(), maplesyrup);

		try {
			PreparedStatement stmt = getReadingStatement(INSERT_STATEMENT_MAPLESYRUP);
			createObject((Persistent) maplesyrup, stmt, maplesyrup.getId());
			ServiceMain.getInstance().saveGlobals();
		} catch (SQLException ex) {
			SysLog.logThrowable(ex);
		}
	}

	/**
	 * 
	 */
	public void saveMaplesyrup(Maplesyrup maplesyrup) {
		try {
			PreparedStatement stmt = getUpdatingStatement(SELECT_STATEMENT_MAPLESYRUP_ID);
			updateObject((Persistent) maplesyrup, stmt);
		} catch (SQLException ex) {
			SysLog.logThrowable(ex);
		}
	}

	/**
	 * 
	 */
	public void saveMaplesyrups() {
		try {
			PreparedStatement stmt = getUpdatingStatement(SELECT_STATEMENT_MAPLESYRUP_ID);
			updateObjects(maplesyrupCache.values(), stmt);
		} catch (SQLException ex) {
			SysLog.logThrowable(ex);
		}
	}
	
	/**
	 * 
	 */
	@Override
	protected Persistent createObject(ResultSet rset) throws SQLException {
		return (Persistent) MaplesyrupFactory.getInstance().createMaplesyrup(rset);
	}

	/**
	 * 
	 */
	private void doAddMaplesyrup(int id, Maplesyrup maplesyrup) {
		maplesyrupCache.put(new Integer(id), maplesyrup);
	}
}
