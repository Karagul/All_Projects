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

public class Copy extends View {
	/**Copy Properties**/
	private static final String ItemNo = "ITEMNO";
	private static final String CopyNo = "COPYNO";
	private static final String CopyType = "COPYTYPE";
	private static final String Location = "LOCATION";
	private static final String Status = "STATUS";
	private static final String AudUser = "AUDUSER";
	private static final String AudTime = "AUDTIME";

	public Copy() {
		this.TableName = "COPY";
	}

	public static boolean add(Long newItemNo,
							  Integer newCopyType,
							  String newLocation,
							  Integer newStatus,
							  String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call COPIES.ADD(?,?,?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setInt(3, newCopyType.intValue());
		cstm.setString(4, newLocation);
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

	public static boolean update(Long newItemNo,
								 Integer newCopyNo,
								 Integer newCopyType,
								 String newLocation,
								 Integer newStatus,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call COPIES.UPDATE(?,?,?,?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setInt(3, newCopyNo.intValue());
		if (newCopyType != null) {
			cstm.setInt(4, newCopyType.intValue());
		} else {
			cstm.setNull(4, Types.NUMERIC);
		}
		if (newLocation != null) {
			cstm.setString(5, newLocation);
		} else {
			cstm.setNull(5, Types.VARCHAR);
		}
		if (newStatus != null) {
			cstm.setInt(6, newStatus.intValue());
		} else {
			cstm.setNull(6, Types.NUMERIC);
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
								 Integer newCopyNo,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call COPIES.REMOVE(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newItemNo.longValue());
		cstm.setInt(3, newCopyNo.intValue());
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

	public Integer getCopyNo() throws SQLException {
		return this.getInteger(CopyNo);
	}

	public Integer getCopyType() throws SQLException {
		return this.getInteger(CopyType);
	}

	public String getLocation() throws SQLException {
		return this.getString(Location);
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