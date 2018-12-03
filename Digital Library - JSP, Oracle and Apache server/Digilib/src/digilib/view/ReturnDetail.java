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

public class ReturnDetail extends View {
	/**BookingList Properties*/
	private static final String DocumentNo = "DOCUMENTNO";
	private static final String ItemNo = "ITEMNO";
	private static final String CopyNo = "COPYNO";
	private static final String PrimaryTitle = "PRIMARYTITLE";
	private static final String CopyType = "COPYTYPE";
	private static final String Location = "LOCATION";
	private static final String Reference = "REFERENCE";
	private static final String DetailDate = "DETAILDATE";
	private static final String AudUser = "AUDUSER";
	private static final String AudTime = "AUDTIME";

	public ReturnDetail() {
		this.TableName = "RETURNDETAILVIEW";
	}

	public static boolean add(Long newReferenceNo,
							  String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call RETURNS.ADD(?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newReferenceNo.longValue());
		cstm.setString(3, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean remove(Long newDocumentNo,
								 Long newItemNo,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call RETURNS.REMOVE(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newDocumentNo.longValue());
		cstm.setLong(3, newItemNo.longValue());
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public Long getDocumentNo() throws SQLException {
		return this.getLong(DocumentNo);
	}

	public Date getDetailDate() throws SQLException {
		return this.getDate(DetailDate);
	}

	public Long getItemNo() throws SQLException {
		return this.getLong(ItemNo);
	}

	public Integer getCopyNo() throws SQLException {
		return this.getInteger(CopyNo);
	}

	public String getPrimaryTitle() throws SQLException {
		return this.getString(PrimaryTitle);
	}

	public Integer getCopyType() throws SQLException {
		return this.getInteger(CopyType);
	}

	public String getLocation() throws SQLException {
		return this.getString(Location);
	}

	public Long getReferenceNo() throws SQLException {
		return this.getLong(Reference);
	}

	public String getAudUser() throws SQLException {
		return this.getString(AudUser);
	}

	public Date getAudTime() throws SQLException {
		return this.getDate(AudTime);
	}
}