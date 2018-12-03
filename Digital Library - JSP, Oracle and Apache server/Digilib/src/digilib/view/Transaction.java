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

public class Transaction extends View {
	/**Transaction Properties*/
	private static final String TransactionNo = "TRANSACTIONNO";
	private static final String TransactionType = "TRANSACTIONTYPE";
	private static final String TransactionDate = "TRANSACTIONDATE";
	private static final String DueDate = "DUEDATE";
	private static final String MemberID = "MEMBERID";
	private static final String Name = "NAME";
	private static final String GroupID = "GROUPID";
	private static final String GroupName = "GROUPNAME";	
	private static final String DocumentNo = "DOCUMENTNO";
	private static final String ReferenceNo = "REFERENCENO";
	private static final String ItemNo = "ITEMNO";
	private static final String PrimaryTitle = "PRIMARYTITLE";
	private static final String CopyNo = "COPYNO";
	private static final String CopyType = "COPYTYPE";
	private static final String Location = "LOCATION";
	private static final String Status = "STATUS";
	private static final String AudUser = "AUDUSER";
	private static final String AudTime = "AUDTIME";

	public Transaction() {
		this.TableName = "TRANSACTIONVIEW";
	}

	public Long getTransactionNo() throws SQLException {
		return this.getLong(TransactionNo);
	}

	public Integer getTransactionType() throws SQLException {
		return this.getInteger(TransactionType);
	}

	public Date getTransactionDate() throws SQLException {
		return this.getDate(TransactionDate);
	}

	public Date getDueDate() throws SQLException {
		return this.getDate(DueDate);
	}

	public String getMemberID() throws SQLException {
		return this.getString(MemberID);
	}

	public String getName() throws SQLException {
		return this.getString(Name);
	}

	public String getGroupID() throws SQLException {
		return this.getString(GroupID);
	}

	public String getGroupName() throws SQLException {
		return this.getString(GroupName);
	}

	public Long getDocumentNo() throws SQLException {
		return this.getLong(DocumentNo);
	}

	public Long getReferenceNo() throws SQLException {
		return this.getLong(ReferenceNo);
	}

	public Long getItemNo() throws SQLException {
		return this.getLong(ItemNo);
	}

	public String getPrimaryTitle() throws SQLException {
		return this.getString(PrimaryTitle);
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