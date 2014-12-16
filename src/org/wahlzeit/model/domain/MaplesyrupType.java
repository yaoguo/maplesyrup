package org.wahlzeit.model.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.wahlzeit.services.DataObject;

public class MaplesyrupType extends DataObject {

	private final String TYPE_NAME = "name";
	private final String TYPE_USAGE = "usage";
	
	private int id;
	private String name;
	private String usage;
	
	/**
	 *
	 * @methodtype constructor
	 */
	public MaplesyrupType(String name, String usage) {
		this.id = MaplesyrupTypeManager.getInstance().getNextId();
		this.name = name;
		this.usage = usage;
		
		incWriteCount();
	}
	
	/**
	 *
	 * @methodtype constructor
	 */
	public MaplesyrupType(ResultSet rset) throws SQLException {
		readFrom(rset);
	}

	/**
	 *
	 * @methodtype get method
	 */
	public String getName() {
		return name;
	}
	
	/**
	 *
	 * @methodtype set method
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *
	 * @methodtype get method
	 */
	public String getUsage() {
		return usage;
	}
	
	/**
	 *
	 * @methodtype set method
	 */
	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	public String asString() {
		return "Type ID: "+ id + "; Type name: " + name + "; Usage for this type: " + usage;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String getIdAsString() {
		 return String.valueOf(id);
	}

	@Override
	public void readFrom(ResultSet rset) throws SQLException {
		name = rset.getString(TYPE_NAME);
		usage = rset.getString(TYPE_USAGE);
	}

	@Override
	public void writeOn(ResultSet rset) throws SQLException {
		rset.updateString(TYPE_NAME, name);
		rset.updateString(TYPE_USAGE, usage);
	}

	@Override
	public void writeId(PreparedStatement stmt, int pos) throws SQLException {
		stmt.setInt(pos, id);
	}
}
