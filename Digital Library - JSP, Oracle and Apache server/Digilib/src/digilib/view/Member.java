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

public class Member extends View {
	/**Member Properties**/
	private static final String MemberID = "MEMBERID";
	private static final String Name = "NAME";
	private static final String GroupID = "GROUPID";
	private static final String GroupName = "GROUPNAME";
	private static final String Gender = "GENDER";
	private static final String Birthday = "BIRTHDAY";
	private static final String Address = "ADDRESS";
	private static final String Phone = "PHONE";
	private static final String Fax = "FAX";
	private static final String Email = "EMAIL";
	private static final String Password = "PASSWORD";
	private static final String PictureType = "PICTURETYPE";
	private static final String Picture = "PICTURE";
	private static final String IssuedDate = "ISSUEDDATE";
	private static final String ExpireDate = "EXPIREDATE";
	private static final String Priority = "PRIORITY";
	private static final String MaxBookings = "MAXBOOKINGS";
	private static final String MaxLoans = "MAXLOANS";
	private static final String MaxExpansions = "MAXEXPANSIONS";
	private static final String BookingDuration = "BOOKINGDURATION";
	private static final String LoanDuration = "LOANDURATION";
	private static final String ExpansionDuration = "EXPANSIONDURATION";
	private static final String MembershipDuration = "MEMBERSHIPDURATION";
	private static final String ChargeRate = "CHARGERATE";
	private static final String Status = "STATUS";
	private static final String AudUser = "AUDUSER";
	private static final String AudTime = "AUDTIME";

	public Member() {
		this.TableName = "MEMBERVIEW";
		this.OrderBy = "ORDER BY MEMBERID";
	}

	public static boolean add(Long newRegistrationNo,
							  String newGroupID,
							  String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call MEMBERS.ADD(?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setLong(2, newRegistrationNo.longValue());
		cstm.setString(3, newGroupID);
		cstm.setString(4, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean update(String newMemberID,
								 String newGroupID,
								 String newName,
								 Integer newGender,
								 Date newBirthday,
								 String newAddress,
								 String newPhone,
								 String newFax,
								 String newEmail,
								 String newPassword,
								 String newPictureType,
								 byte[] newPicture,
								 Date newExpireDate,
								 Integer newStatus,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call MEMBERS.MODIFY(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newMemberID);
		if (newGroupID != null) {
			cstm.setString(3, newGroupID);
		} else {
			cstm.setNull(3, Types.CHAR);
		}
		if (newName != null) {
			cstm.setString(4, newName);
		} else {
			cstm.setNull(4, Types.VARCHAR);
		}
		if (newGender != null) {
			cstm.setInt(5, newGender.intValue());
		} else {
			cstm.setNull(5, Types.NUMERIC);
		}
		if (newBirthday != null) {
			cstm.setDate(6, new java.sql.Date(newBirthday.getTime()));
		} else {
			cstm.setNull(6, Types.DATE);
		}
		if (newAddress != null) {
			cstm.setString(7, newAddress);
		} else {
			cstm.setNull(7, Types.VARCHAR);
		}
		if (newPhone != null) {
			cstm.setString(8, newPhone);
		} else {
			cstm.setNull(8, Types.VARCHAR);
		}
		if (newFax != null) {
			cstm.setString(9, newFax);
		} else {
			cstm.setNull(9, Types.VARCHAR);
		}
		if (newEmail != null) {
			cstm.setString(10, newEmail);
		} else {
			cstm.setNull(10, Types.VARCHAR);
		}
		if (newPassword != null) {
			cstm.setString(11, newPassword);
		} else {
			cstm.setNull(11, Types.VARCHAR);
		}
		if (newPictureType != null) {
			cstm.setString(12, newPictureType);
		} else {
			cstm.setNull(12, Types.VARCHAR);
		}
		if (newPicture != null) {
			ByteArrayInputStream bPicture = new ByteArrayInputStream(newPicture);
			cstm.setBinaryStream(13, bPicture, newPicture.length);
		} else {
			cstm.setNull(13, Types.VARBINARY);
		}
		if (newExpireDate != null) {
			cstm.setDate(14, new java.sql.Date(newExpireDate.getTime()));
		} else {
			cstm.setNull(14, Types.DATE);
		}
		if (newStatus != null) {
			cstm.setInt(15, newStatus.intValue());
		} else {
			cstm.setNull(15, Types.NUMERIC);
		}
		cstm.setString(16, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean remove(String newMemberID,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call MEMBERS.REMOVE(?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newMemberID);
		cstm.setString(3, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean validate(String newMemberID,
								   String newPassword) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call MEMBERS.VALIDATE(?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newMemberID);
		cstm.setString(3, newPassword);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public String getMemberID() throws SQLException {
		return this.getString(MemberID);
	}

	public String getGroupID() throws SQLException {
		return this.getString(GroupID);
	}

	public String getGroupName() throws SQLException {
		return this.getString(GroupName);
	}

	public String getName() throws SQLException {
		return this.getString(Name);
	}

	public Integer getGender() throws SQLException {
		return this.getInteger(Gender);
	}

	public Date getBirthday() throws SQLException {
		return this.getDate(Birthday);
	}

	public String getAddress() throws SQLException {
		return this.getString(Address);
	}

	public String getPhone() throws SQLException {
		return this.getString(Phone);
	}

	public String getFax() throws SQLException {
		return this.getString(Fax);
	}

	public String getEmail() throws SQLException {
		return this.getString(Email);
	}

	public String getPassword() throws SQLException {
		return this.getString(Password);
	}

	public String getPictureType() throws SQLException {
		return this.getString(PictureType);
	}

	public byte[] getPicture() throws SQLException {
		Blob blobPicture = this.getBlob(Picture);
		byte[] bPicture = new byte[(int)blobPicture.length()];
		bPicture = blobPicture.getBytes(1, (int)blobPicture.length());
		return bPicture;
	}

	public Date getIssuedDate() throws SQLException {
		return this.getDate(IssuedDate);
	}

	public Date getExpireDate() throws SQLException {
		return this.getDate(ExpireDate);
	}

	public Integer getPriority() throws SQLException {
		return this.getInteger(Priority);
	}

	public Integer getMaxBookings() throws SQLException {
		return this.getInteger(MaxBookings);
	}

	public Integer getMaxLoans() throws SQLException {
		return this.getInteger(MaxLoans);
	}

	public Integer getMaxExpansions() throws SQLException {
		return this.getInteger(MaxExpansions);
	}

	public Integer getBookingDuration() throws SQLException {
		return this.getInteger(BookingDuration);
	}

	public Integer getLoanDuration() throws SQLException {
		return this.getInteger(LoanDuration);
	}

	public Integer getExpansionDuration() throws SQLException {
		return this.getInteger(ExpansionDuration);
	}

	public Integer getMembershipDuration() throws SQLException {
		return this.getInteger(MembershipDuration);
	}

	public Integer getChargeRate() throws SQLException {
		return this.getInteger(ChargeRate);
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