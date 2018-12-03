package digilib.view;

/**
 * Title:        D I G I L I B - Views Package
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author Trinh Vuong Bao Khanh (9800782) - Vo Thi Nhu Trang (9800741)
 * @version 1.0
 */

import java.io.*;
import java.sql.*;
import java.util.Date;
import digilib.util.DBConnectionManager;

public class Item extends View {
	/**Item Properties**/
	private static final String ItemNo = "ITEMNO";
	private static final String PrimaryTitle = "PRIMARYTITLE";
	private static final String Edition = "EDITION";
	private static final String Imprint = "IMPRINT";
	private static final String PhysicalDescription = "PHYSICALDESCRIPTION";
	private static final String LanguageID = "LANGUAGEID";
	private static final String Language = "LANGUAGE";
	private static final String FormatID = "FORMATID";
	private static final String Format = "FORMAT";
	private static final String DDCID = "DDCID";
	private static final String Classification = "CLASSIFICATION";
	private static final String NameID = "NAMEID";
	private static final String PrimaryAuthor = "PRIMARYAUTHOR";
	private static final String AudUser = "AUDUSER";
	private static final String AudTime = "AUDTIME";

	public Item() {
		this.TableName = "ITEMVIEW";
	}

	public static Long add(String newPrimaryTitle,
						   String newEdition,
						   String newImprint,
						   String newPhysicalDescription,
						   String newAudUser) throws Exception {
		Long result = null;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.ADD(?,?,?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newPrimaryTitle);
		cstm.setString(3, newEdition);
		cstm.setString(4, newImprint);
		cstm.setString(5, newPhysicalDescription);
		cstm.setString(6, newAudUser);
		cstm.execute();
		result = new Long(cstm.getLong(1));
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean update(Long newItemNo,
								 String newPrimaryTitle,
								 String newEdition,
								 String newImprint,
								 String newPhysicalDescription,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.MODIFY(?,?,?,?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		if (newPrimaryTitle != null) {
			cstm.setString(3, newPrimaryTitle);
		} else {
			cstm.setNull(3, Types.VARCHAR);
		}
		if (newEdition != null) {
			cstm.setString(4, newEdition);
		} else {
			cstm.setNull(4, Types.VARCHAR);
		}
		if (newImprint != null) {
			cstm.setString(5, newImprint);
		} else {
			cstm.setNull(5, Types.VARCHAR);
		}
		if (newPhysicalDescription != null) {
			cstm.setString(6, newPhysicalDescription);
		} else {
			cstm.setNull(6, Types.VARCHAR);
		}
		cstm.setString(7, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean remove(Long newItemNo,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.REMOVE(?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setString(3, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}
	
	public static boolean addOtherTitle(Long newItemNo,
										String newOtherTitle,
										String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.ADDOTHERTITLE(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setString(3, newOtherTitle);
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);		
	}

	public static boolean addNote(Long newItemNo,
								  String newNote,
								  String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.ADDNOTE(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setString(3, newNote);
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);		
	}

	public static boolean addKeyword(Long newItemNo,
									 String newKeyword,
									 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.ADDKEYWORD(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setString(3, newKeyword);
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);		
	}
	
	public static boolean setPrimaryAuthor(Long newItemNo,
										   String newAuthor,
										   String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.SETPRIMARYAUTHOR(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setString(3, newAuthor);
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);		
	}

	public static boolean setOtherAuthor(Long newItemNo,
										 String newAuthor,
										 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.SETOTHERAUTHOR(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setString(3, newAuthor);
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);		
	}

	public static boolean setFormat(Long newItemNo,
									String newFormatID,
									String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.SETFORMAT(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setString(3, newFormatID);
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);		
	}

	public static boolean setLanguage(Long newItemNo,
									  String newLanguageID,
									  String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.SETLANGUAGE(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setString(3, newLanguageID);
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);		
	}

	public static boolean setClassification(Long newItemNo,
											String newClassification,
											String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call ITEMS.SETCLASSIFICATION(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setString(3, newClassification);
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);		
	}

	public Long getItemNo() throws SQLException {
		return this.getLong(ItemNo);
	}

	public String getPrimaryTitle() throws SQLException {
		return this.getString(PrimaryTitle);
	}

	public String getEdition() throws SQLException {
		return this.getString(Edition);
	}

	public String getImprint() throws SQLException {
		return this.getString(Imprint);
	}

	public String getPhysicalDescription() throws SQLException {
		return this.getString(PhysicalDescription);
	}

	public String getLanguageID() throws SQLException {
		return this.getString(LanguageID);
	}

	public String getLanguage() throws SQLException {
		return this.getString(Language);
	}

	public String getFormatID() throws SQLException {
		return this.getString(FormatID);
	}

	public String getFormat() throws SQLException {
		return this.getString(Format);
	}

	public String getDDCID() throws SQLException {
		return this.getString(DDCID);
	}

	public String getClassification() throws SQLException {
		return this.getString(Classification);
	}

	public String getNameID() throws SQLException {
		return this.getString(NameID);
	}

	public String getPrimaryAuthor() throws SQLException {
		return this.getString(PrimaryAuthor);
	}

	public Copy getCopies() throws SQLException {
		Copy Copies = new Copy();
		Copies.setCriteria("ITEMNO = " + this.getItemNo());
		return Copies;
	}
	
	public OtherTitle getOtherTitles() throws SQLException {
		OtherTitle otherTitles = new OtherTitle();
		otherTitles.setCriteria("ITEMNO = " + this.getItemNo());
		return otherTitles;
	}
	
	public Note getNotes() throws SQLException {
		Note notes = new Note();
		notes.setCriteria("ITEMNO = " + this.getItemNo());
		return notes;
	}
	
	public Name getNames() throws SQLException {
		Name names = new Name();
		names.setCriteria("ITEMNO = " + this.getItemNo());
		return names;
	}
	
	public Keyword getKeywords() throws SQLException {
		Keyword keywords = new Keyword();
		keywords.setCriteria("ITEMNO = " + this.getItemNo());
		return keywords;
	}

	public String getAudUser() throws SQLException {
		return this.getString(AudUser);
	}

	public Date getAudTime() throws SQLException {
		return this.getDate(AudTime);
	}

}