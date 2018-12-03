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

public class Librarian extends View {
	/**Librarian Properties**/
	private static final String LibrarianID = "LIBRARIANID";
	private static final String Name = "NAME";
	private static final String Password = "PASSWORD";
	private static final String Status = "STATUS";
	private static final String AudUser = "AUDUSER";
	private static final String AudTime = "AUDTIME";

	public Librarian() {
		this.TableName = "LIBRARIAN";
	}

	public static boolean add(String newLibrarianID,
							  String newName,
							  String newPassword,
							  Integer newStatus,
							  String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call LIBRARIANS.ADD(?,?,?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newLibrarianID);
		cstm.setString(3, newName);
		cstm.setString(4, newPassword);
		cstm.setInt(5, newStatus.intValue());
		cstm.setString(6, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean update(String newLibrarianID,
								 String newName,
								 String newPassword,
								 Integer newStatus,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call LIBRARIANS.MODIFY(?,?,?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newLibrarianID);
		if (newName != null) {
			cstm.setString(3, newName);
		} else {
			cstm.setNull(3, Types.VARCHAR);
		}
		if (newPassword != null) {
			cstm.setString(4, newPassword);
		} else {
			cstm.setNull(4, Types.VARCHAR);
		}
		if (newStatus != null) {
			cstm.setInt(5, newStatus.intValue());
		} else {
			cstm.setNull(5, Types.NUMERIC);
		}
		cstm.setString(6, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean remove(String newLibrarianID,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call LIBRARIANS.REMOVE(?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newLibrarianID);
		cstm.setString(3, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean validate(String newLibrarianID,
								   String newPassword) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call LIBRARIANS.VALIDATE(?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newLibrarianID);
		cstm.setString(3, newPassword);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public String getLibrarianID() throws SQLException {
		return this.getString(LibrarianID);
	}

	public String getName() throws SQLException {
		return this.getString(Name);
	}

	public String getPassword() throws SQLException {
		return this.getString(Password);
	}

	public Integer getStatus() throws SQLException {
		return this.getInteger(Status);
	}

	public String getAudUser() throws SQLException {
		return this.getString(AudUser);
	}

	public Date getAudTime() throws SQLException {
		return this.getDate(AudTime);
	}

}