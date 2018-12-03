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

public class Keyword extends View {
	/**Copy Properties**/
	private static final String ItemNo = "ITEMNO";
	private static final String KeywordID = "KEYWORDID";
	private static final String Keyword = "KEYWORD";	
	private static final String AudUser = "AUDUSER";
	private static final String AudTime = "AUDTIME";

	public Keyword() {
		this.TableName = "ITEMKEYWORD";
	}

	public Long getItemNo() throws SQLException {
		return this.getLong(ItemNo);
	}
	
	public Long getKeywordID() throws SQLException {
		return this.getLong(KeywordID);
	}
	
	public String getKeyword() throws SQLException {
		return this.getString(Keyword);
	}

	public String getAudUser() throws SQLException {
		return this.getString(AudUser);
	}

	public Date getAudTime() throws SQLException {
		return this.getDate(AudTime);
	}
}