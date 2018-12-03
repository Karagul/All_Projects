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

public class OtherTitle extends View {
	/**Copy Properties**/
	private static final String ItemNo = "ITEMNO";
	private static final String OtherTitle = "OTHERTITLE";	
	private static final String AudUser = "AUDUSER";
	private static final String AudTime = "AUDTIME";

	public OtherTitle() {
		this.TableName = "OTHERTITLE";
	}

	public Long getItemNo() throws SQLException {
		return this.getLong(ItemNo);
	}

	public String getOtherTitle() throws SQLException {
		return this.getString(OtherTitle);
	}

	public String getAudUser() throws SQLException {
		return this.getString(AudUser);
	}

	public Date getAudTime() throws SQLException {
		return this.getDate(AudTime);
	}
}