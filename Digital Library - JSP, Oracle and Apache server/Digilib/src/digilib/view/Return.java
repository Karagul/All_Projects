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

public class Return extends View {
	/**BookingList Properties*/
	private static final String DocumentNo = "DOCUMENTNO";
	private static final String DocumentDate = "DOCUMENTDATE";
	private static final String MemberID = "MEMBERID";
	private static final String Name = "NAME";
	private static final String Status = "STATUS";
	private static final String PostedDate = "POSTEDDATE";
	private static final String AudUser = "AUDUSER";
	private static final String AudTime = "AUDTIME";

	public Return() {
		this.TableName = "RETURNVIEW";
	}

	public static boolean post(Long newDocumentNo,
							   String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call RETURNS.POST(?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newDocumentNo.longValue());
		cstm.setString(3, newAudUser);
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

	public Date getDocumentDate() throws SQLException {
		return this.getDate(DocumentDate);
	}

	public String getMemberID() throws SQLException {
		return this.getString(MemberID);
	}

	public String getName() throws SQLException {
		return this.getString(Name);
	}

	public Integer getStatus() throws SQLException {
		return this.getInteger(Status);
	}

	public Date getPosted() throws SQLException {
		return this.getDate(PostedDate);
	}

	public String getAudUser() throws SQLException {
		return this.getString(AudUser);
	}

	public Date getAudTime() throws SQLException {
		return this.getDate(AudTime);
	}

	public ReturnDetail getDetails() throws SQLException {
		ReturnDetail returnDetails = new ReturnDetail();
		returnDetails.setCriteria("DOCUMENTNO = " + this.getDocumentNo().longValue());
		return returnDetails;
	}
}