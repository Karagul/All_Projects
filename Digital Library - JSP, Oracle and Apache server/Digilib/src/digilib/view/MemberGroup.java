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

public class MemberGroup extends View {
	/**MemberGroup Properties**/
	private static final String GroupID = "GROUPID";
	private static final String Name = "NAME";
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

	public MemberGroup() {
		this.TableName = "MEMBERGROUP";
	}

	public static boolean add(String newGroupID,
							  String newName,
							  Integer newPriority,
							  Integer newMaxBookings,
							  Integer newMaxLoans,
							  Integer newMaxExpansions,
							  Integer newBookingDuration,
							  Integer newLoanDuration,
							  Integer newExpansionDuration,
							  Integer newMembershipDuration,
							  Integer newChargeRate,
							  Integer newStatus,
							  String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call MEMBERGROUPS.ADD(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newGroupID);
		cstm.setString(3, newName);
		cstm.setInt( 4, newPriority.intValue());
		cstm.setInt( 5, newMaxBookings.intValue());
		cstm.setInt( 6, newMaxLoans.intValue());
		cstm.setInt( 7, newMaxExpansions.intValue());
		cstm.setInt( 8, newBookingDuration.intValue());
		cstm.setInt( 9, newLoanDuration.intValue());
		cstm.setInt(10, newExpansionDuration.intValue());
		cstm.setInt(11, newMembershipDuration.intValue());
		cstm.setInt(12, newChargeRate.intValue());
		cstm.setInt(13, newStatus.intValue());
		cstm.setString(14, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean update(String newGroupID,
								 String newName,
								 Integer newPriority,
								 Integer newMaxBookings,
								 Integer newMaxLoans,
								 Integer newMaxExpansions,
								 Integer newBookingDuration,
								 Integer newLoanDuration,
								 Integer newExpansionDuration,
								 Integer newMembershipDuration,
								 Integer newChargeRate,
								 Integer newStatus,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call MEMBERGROUPS.MODIFY(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newGroupID);
		if (newName != null) {
			cstm.setString(3, newName);
		} else {
			cstm.setNull(3, Types.VARCHAR);
		}
		if (newPriority != null) {
			cstm.setInt( 4, newPriority.intValue());
		} else {
			cstm.setNull( 4, Types.NUMERIC);
		}
		if (newMaxBookings != null) {
			cstm.setInt( 5, newMaxBookings.intValue());
		} else {
			cstm.setNull(5, Types.NUMERIC);
		}
		if (newMaxLoans != null) {
			cstm.setInt( 6, newMaxLoans.intValue());
		} else {
			cstm.setNull(6, Types.NUMERIC);
		}
		if (newMaxExpansions != null) {
			cstm.setInt( 7, newMaxExpansions.intValue());
		} else {
			cstm.setNull(7, Types.NUMERIC);
		}
		if (newBookingDuration != null) {
			cstm.setInt( 8, newBookingDuration.intValue());
		} else {
			cstm.setNull(8, Types.NUMERIC);
		}
		if (newLoanDuration != null) {
			cstm.setInt( 9, newLoanDuration.intValue());
		} else {
			cstm.setNull(9, Types.NUMERIC);
		}
		if (newExpansionDuration != null) {
			cstm.setInt(10, newExpansionDuration.intValue());
		} else {
			cstm.setNull(10, Types.NUMERIC);
		}
		if (newMembershipDuration != null) {
			cstm.setInt(11, newMembershipDuration.intValue());
		} else {
			cstm.setNull(11, Types.NUMERIC);
		}
		if (newChargeRate != null) {
			cstm.setInt(12, newChargeRate.intValue());
		} else {
			cstm.setNull(12, Types.NUMERIC);
		}
		if (newStatus != null) {
			cstm.setInt(13, newStatus.intValue());
		} else {
			cstm.setNull(13, Types.NUMERIC);
		}
		if (newAudUser != null) {
			cstm.setString(14, newAudUser);
		} else {
			cstm.setNull(14, Types.CHAR);
		}
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean remove(String newGroupID,
								 String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call MEMBERGROUPS.REMOVE(?,?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newGroupID);
		cstm.setString(3, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public String getGroupID() throws SQLException {
		return this.getString(GroupID);
	}

	public String getName() throws SQLException {
		return this.getString(Name);
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