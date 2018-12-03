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

public class DayEnd extends View {
	/**BookingList Properties*/

	public DayEnd() {
	}

	public static boolean processBookingOverdue(String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call DAYEND.PROCESSBOOKINGOVERDUE(?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}

	public static boolean processLoanOverdue(String newAudUser) throws Exception {
		boolean result = false;
		Connection conn = DBConnectionManager.getInstance().getConnection();
		CallableStatement cstm = conn.prepareCall("{?=call DAYEND.PROCESSLOANOVERDUE(?)}");
		cstm.registerOutParameter(1, Types.NUMERIC);
		cstm.setString(2, newAudUser);
		cstm.execute();
		if (cstm.getInt(1) == 1) {
			result = true;
		}
		cstm.close();
		DBConnectionManager.getInstance().freeConnection(conn);
		return (result);
	}
}