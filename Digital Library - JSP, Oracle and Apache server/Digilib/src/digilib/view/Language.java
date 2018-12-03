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

public class Language extends View {
	/**Copy Properties**/
	private static final String LanguageID = "LANGUAGEID";
	private static final String Name = "NAME";	
	private static final String AudUser = "AUDUSER";
	private static final String AudTime = "AUDTIME";

	public Language() {
		this.TableName = "LANGUAGE";
	}

	public static boolean add(String newLanguageID,
							  String newName,
							  String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call LANGUAGES.ADD(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newLanguageID);
		cstm.setString(3, newName);
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean update(String newLanguageID,
								 String newName,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call LANGUAGES.MODIFY(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newLanguageID);
		if (newName != null) {
			cstm.setString(3, newName);
		} else {
			cstm.setNull(3, Types.VARCHAR);
		}
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean remove(String newLanguageID,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call LANGUAGES.REMOVE(?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newLanguageID);
		cstm.setString(3, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public String getLanguageID() throws SQLException {
		return this.getString(LanguageID);
	}

	public String getName() throws SQLException {
		return this.getString(Name);
	}

	public String getAudUser() throws SQLException {
		return this.getString(AudUser);
	}

	public Date getAudTime() throws SQLException {
		return this.getDate(AudTime);
	}
}