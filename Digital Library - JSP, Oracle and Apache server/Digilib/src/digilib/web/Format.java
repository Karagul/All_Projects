package digilib.web;

/**
 * Title:        D I G I L I B - Web Package
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author Trinh Vuong Bao Khanh (9800782) - Vo Thi Nhu Trang (9800741)
 * @version 1.0
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class Format {
  private static SimpleDateFormat timeStamp = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
  private static SimpleDateFormat shortDate = new SimpleDateFormat("dd/MM/yyyy");

  public static String formatShortDate(Date newDate) {
    return shortDate.format(newDate);
  }

  public static String formatTimeStamp(Date newDate) {
    return timeStamp.format(newDate);
  }

  public static String replace(String orgString, String fndString, String rplString) {
    String result = "";
    int stPos = 0;
    int endPos = 0;
    if (orgString != null && fndString != null) {
      if (rplString == null) {
        rplString = "";
      }
      String temp = orgString;
      int len = fndString.length();
      stPos = temp.indexOf(fndString);
      if (stPos != -1) {
        do {
          int lenTemp = temp.length();
          result = result.concat(temp.substring(0, stPos));
          result = result.concat(rplString);
          temp = temp.substring(stPos+1, lenTemp);
          stPos = temp.indexOf(fndString);
        } while (stPos != -1);
      }
      result = result.concat(temp);
    }
    return result;
  }

  public static String formatDisplayString(String newString) {
    String result = "";
    if (newString != null) {
      result = replace(newString, "\r\n", "<br />");
    }
    return result;
  }

  public static String formatMemberID(String orgMemberID) {
  	String result = "";
  	if (orgMemberID != null) {
  		result = orgMemberID.substring(0,4) + "-"
  			   + orgMemberID.substring(4,8) + "-"
  			   + orgMemberID.substring(8,12);
  	}

  	return result;
  }
  
  public static String formatXML(String orgString) {
  	String result = "";
  	result = replace(replace(replace(replace(replace(orgString, "<","&lt;"), ">", "&gt;"), "&", "&amp;"), "\"", "&quot;"), "'", "&apos;");
  	return result;
  }

}