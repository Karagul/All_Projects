package _librarians._cataloging;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;
import java.beans.*;
import java.util.*;
import digilib.util.DBConnectionManager;
import digilib.util.Properties;
import digilib.web.Format;


public class _deweybrowsing extends oracle.jsp.runtime.HttpJsp {


  // Begin global declarations

  public final String _globalsClassName = "Globals";
  public final boolean _has_session_OnStart = true;
  public final boolean _has_session_OnEnd = true;
  public final boolean _has_application_OnStart = true;
  public final boolean _has_application_OnEnd = true;
  // End global declarations


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    /* set up the intrinsic variables using the pageContext goober:
    ** session = HttpSession
    ** application = ServletContext
    ** out = JspWriter
    ** page = this
    ** config = ServletConfig
    ** all session/app beans declared in globals.jsa
    */
    JspFactory factory = JspFactory.getDefaultFactory();
    PageContext pageContext = factory.getPageContext( this, request, response, "/errorshandler.jsp", true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) {
      pageContext.setAttribute(OracleJspRuntime.JSP_PAGE_DONTNOTIFY, "true", PageContext.PAGE_SCOPE);
      factory.releasePageContext(pageContext);
      return;
}
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _deweybrowsing page = this;
    ServletConfig config = pageContext.getServletConfig();

    try {
      // global beans
      // end global beans


      out.print(__jsp_StaticText.text[0]);
      out.print(__jsp_StaticText.text[1]);
            	response.setDateHeader("Expires", -1);
      	response.setHeader("Cache-Control", "no-cache");
      	response.setHeader("Pragma", "no-cache");
      
      out.print(__jsp_StaticText.text[2]);
            	String sBy = "DDCID";
      	String sDDCID = "";
      	String sName = "";
      	try {
      		if (request.getParameter("by") != null) {
      			sBy = request.getParameter("by");
      		}
      		if (request.getParameter("DDCID") != null) {
      			sDDCID = request.getParameter("DDCID");
      		}
      		if (request.getParameter("Name") != null) {
      			sName = request.getParameter("Name");
      		}
      	} catch (Exception e) {
      		sBy = "DDCID";
      	}
      	String sCriteria;
      	if (sBy.equals("NAME")) {
      		sCriteria = "lower(NAME) like lower('%" + sName + "%')";
      	} else {
      		sCriteria = "lower(DDCID) like lower('" + sDDCID + "%')";
      	}
      
      out.print(__jsp_StaticText.text[3]);
      out.print(sDDCID);
      out.print(__jsp_StaticText.text[4]);
      out.print( sName);
      out.print(__jsp_StaticText.text[5]);
      digilib.view.Classification Dewey;
      if ((Dewey = (digilib.view.Classification) pageContext.getAttribute( "Dewey", PageContext.PAGE_SCOPE)) == null) {
        Dewey = (digilib.view.Classification) new digilib.view.Classification();
        pageContext.setAttribute( "Dewey", Dewey, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[6]);
            	int Page = 1;
      	int PageSize = 20;
      	String sPage = null;
      	String sPageSize = null;
      	try {
      		sPage = request.getParameter("page");
      		Page = Integer.parseInt(sPage);
      	} catch (Exception e) {}
      	try {
      		sPageSize = request.getParameter("pagesize");
      		PageSize = Integer.parseInt(sPageSize);
      	} catch (Exception e) {}
      	Page = (Page <= 0) ? 1 : Page;
      	PageSize = (PageSize <= 0) ? 1 : PageSize;
      	Dewey.setPageSize(PageSize);
      	Dewey.setPage(Page);
      	Dewey.setCriteria(sCriteria);
      	Dewey.open();
      	int totalRecords = Dewey.getMaxRows();
      	int totalPages, fromRecord, toRecord;
      	if (totalRecords <= 0) {
      		fromRecord = toRecord = Page = totalPages = 0;
      	} else {
      		totalPages = (totalRecords / PageSize) + ((totalRecords % PageSize != 0) ? 1 : 0);
      		Page = (Page > totalPages) ? totalPages : Page;
      		fromRecord = (Page-1) * PageSize + 1;
      		fromRecord = (fromRecord < 0) ? 1 : fromRecord;
      		toRecord = Page * PageSize;
      		toRecord = (toRecord > totalRecords) ? totalRecords : toRecord;
      	}
      	int i = 0;
      	while (Dewey.next()) {	
      
      out.print(__jsp_StaticText.text[7]);
      out.print(i);
      out.print(__jsp_StaticText.text[8]);
      out.print( Dewey.getDDCID() );
      out.print(__jsp_StaticText.text[9]);
      out.print( Dewey.getDDCID() );
      out.print(__jsp_StaticText.text[10]);
      out.print( Dewey.getName() );
      out.print(__jsp_StaticText.text[11]);
            		i++;
      	}
      	Dewey.close();
      
      out.print(__jsp_StaticText.text[12]);
      out.print( fromRecord );
      out.print(__jsp_StaticText.text[13]);
      out.print( toRecord );
      out.print(__jsp_StaticText.text[14]);
      out.print( totalRecords );
      out.print(__jsp_StaticText.text[15]);
      out.print( Page );
      out.print(__jsp_StaticText.text[16]);
      out.print( totalPages );
      out.print(__jsp_StaticText.text[17]);
      out.print( Page );
      out.print(__jsp_StaticText.text[18]);
            	for (int ps = 1; ps <= 50; ps++) {
      
      out.print(__jsp_StaticText.text[19]);
      out.print( ps );
      out.print(__jsp_StaticText.text[20]);
      out.print( (ps == PageSize) ? "selected=\"selected\"" : "" );
      out.print(__jsp_StaticText.text[21]);
      out.print( ps );
      out.print(__jsp_StaticText.text[22]);
            	}
      
      out.print(__jsp_StaticText.text[23]);
      out.print( (Page > 1) ? "gotoPage(1);" : "" );
      out.print(__jsp_StaticText.text[24]);
      out.print( (Page > 1) ? "gotoPage(" + (Page-1) + ");" : "" );
      out.print(__jsp_StaticText.text[25]);
      out.print( (Page < totalPages) ? "gotoPage(" + (Page+1) + ");" : "" );
      out.print(__jsp_StaticText.text[26]);
      out.print( (Page < totalPages) ? "gotoPage(" + totalPages + ");" : "" );
      out.print(__jsp_StaticText.text[27]);

      out.flush();

    }
    catch( Exception e) {
      try {
        if (out != null) out.clear();
      }
      catch( Exception clearException) {
      }
      pageContext.handlePageException( e);
    }
    finally {
      if (out != null) out.close();
      factory.releasePageContext(pageContext);
    }

  }
  private static class __jsp_StaticText {
    private static final char text[][]=new char[28][];
    static {
      text[0] = 
      "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n".toCharArray();
      text[1] = 
      "\r\n".toCharArray();
      text[2] = 
      "\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n<title>D I G I L I B &gt; Thang phân loại Dewey</title>\r\n<script language=\"JavaScript\" src=\"/digilib.js\"></script>\r\n<script language=\"JavaScript\">\r\nvar stdColor = \"#ffffff\";\r\nvar actColor = \"#ffff99\";\r\nvar Select = -1;\r\nfunction OnClick(index) {\r\n\tvar totalData = 1;\r\n\tif (document.all(\"data\").length != null) {\r\n\t\ttotalData = document.all(\"data\").length;\r\n\t}\r\n\t\r\n\tfor (i = 0; i < totalData; i++) {\r\n\t\tif (i == index) {\r\n\t\t\tdocument.all(\"data\", i).style.backgroundColor = actColor;\r\n\t\t\tdocument.all(\"data\", i).style.fontWeight = \"bold\";\t\t\t\r\n\t\t} else {\r\n\t\t\tdocument.all(\"data\", i).style.backgroundColor = stdColor;\r\n\t\t\tdocument.all(\"data\", i).style.fontWeight = \"normal\";\t\t\t\r\n\t\t}\r\n\t}\r\n\tSelect = index;\r\n}\r\n\r\nfunction OnDblClick() {\r\n\tdoSelect();\r\n}\r\n\r\nfunction findByDDCID() {\r\n\tvar oForm = document.forms(\"DeweyBrowsingForm\");\r\n\tdocument.all(\"by\").value = \"DDCID\";\r\n\toForm.submit();\r\n}\r\n\r\nfunction findByName() {\r\n\tvar oForm = document.forms(\"DeweyBrowsingForm\");\r\n\tdocument.all(\"by\").value = \"NAME\";\r\n\toForm.submit();\r\n}\r\n\r\nfunction doSelect() {\r\n\tif (Select != -1) {\r\n\t\tdocument.all(\"DDCID\").value=trim(document.all(\"Selected\", Select).value);\r\n\t}\r\n}\r\n\r\nfunction doCancel() {\r\n\twindow.close();\r\n}\r\n</script>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n<link href=\"/digilib.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n</head>\r\n\r\n<body>\r\n\r\n\r\n<form action=\"\" method=\"get\" name=\"DeweyBrowsingForm\" id=\"DeweyBrowsingForm\">\r\n  <table width=\"500\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n    <tr> \r\n      <td width=\"10\"><img src=\"/images/news_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n      <td width=\"150\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Mã Dewey</td>\r\n      <td width=\"335\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Diễn giải</td>\r\n      <td width=\"10\"><img src=\"/images/news_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n    </tr>\r\n    <tr> \r\n      <td colspan=\"4\"> ".toCharArray();
      text[3] = 
      " <table width=\"500\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n          <tr> \r\n            <td width=\"120\" style=\"border-right: #999999 1px solid;\"> <input name=\"DDCID\" type=\"text\" class=\"textbox\" id=\"DDCID\" maxlength=\"20\" value=\"".toCharArray();
      text[4] = 
      "\" /></td>\r\n            <td width=\"20\" align=\"center\" style=\"border-right: #999999 1px solid;\"><img src=\"/images/finder.gif\" width=\"15\" height=\"15\" class=\"picbutton\" onclick=\"findByDDCID();\" /></td>\r\n            <td width=\"310\"><input name=\"Name\" type=\"text\" class=\"textbox\" id=\"Name\" maxlength=\"100\" value=\"".toCharArray();
      text[5] = 
      "\" /></td>\r\n            <td width=\"20\" align=\"center\"><img src=\"/images/finder.gif\" width=\"15\" height=\"15\" onclick=\"findByName();\" /></td>\r\n          </tr>\r\n        </table>\r\n        ".toCharArray();
      text[6] = 
      " \r\n        ".toCharArray();
      text[7] = 
      " <table width=\"500\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n          <tr id=\"data\" style=\"cursor: hand;\" onclick=\"OnClick(".toCharArray();
      text[8] = 
      ");\" ondblclick=\"OnDblClick();\"> \r\n            <td width=\"150\" style=\"border-right: #999999 1px solid;\"> <input name=\"Selected\" type=\"hidden\" id=\"Selected\" value=\"".toCharArray();
      text[9] = 
      "\" />\r\n              ".toCharArray();
      text[10] = 
      "</td>\r\n            <td width=\"335\"> ".toCharArray();
      text[11] = 
      " </td>\r\n          </tr>\r\n        </table>\r\n        ".toCharArray();
      text[12] = 
      " </td>\r\n    </tr>\r\n    <tr> \r\n      <td colspan=\"4\"><table width=\"500\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"5\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n          <tr> \r\n            <td width=\"150\">Mẩu tin \r\n              ".toCharArray();
      text[13] = 
      "\r\n              - \r\n              ".toCharArray();
      text[14] = 
      "\r\n              / \r\n              ".toCharArray();
      text[15] = 
      "\r\n              mẩu tin<br />\r\n              Trang \r\n              ".toCharArray();
      text[16] = 
      "\r\n              / \r\n              ".toCharArray();
      text[17] = 
      "\r\n              trang</td>\r\n            <td align=\"center\"> <input name=\"page\" type=\"hidden\" id=\"page3\" value=\"".toCharArray();
      text[18] = 
      "\" />\r\n              Giới hạn \r\n              <select name=\"pagesize\" class=\"listbox\" id=\"select2\" onchange=\"setPageSize();\">\r\n                ".toCharArray();
      text[19] = 
      "\r\n                <option value=\"".toCharArray();
      text[20] = 
      "\" ".toCharArray();
      text[21] = 
      "> \r\n                ".toCharArray();
      text[22] = 
      "\r\n                </option>\r\n                ".toCharArray();
      text[23] = 
      "\r\n              </select>\r\n              mẩu tin / trang</td>\r\n            <td width=\"100\" align=\"right\"> <img src=\"/images/movefirst_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[24] = 
      "\" /> \r\n              <img src=\"/images/moveprevious_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[25] = 
      "\" /> \r\n              <img src=\"/images/movenext_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[26] = 
      "\" /> \r\n              <img src=\"/images/movelast_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[27] = 
      "\" /></td>\r\n          </tr>\r\n        </table> </td>\r\n    </tr>\r\n    <tr>\r\n      <td colspan=\"4\"><table width=\"500\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n          <tr> \r\n            <td align=\"right\"> <input name=\"by\" type=\"hidden\" id=\"by3\" /> <input name=\"Select\" type=\"button\" class=\"button\" id=\"Select3\" value=\"Chọn\" onclick=\"doSelect();\" /> \r\n              <input name=\"Close\" type=\"button\" class=\"button\" id=\"Close3\" value=\"Đóng\" onclick=\"doCancel();\" /></td>\r\n          </tr>\r\n        </table></td>\r\n    </tr>\r\n  </table>\r\n</form>\r\n</body>\r\n</html>\r\n".toCharArray();
    }
  }
}
