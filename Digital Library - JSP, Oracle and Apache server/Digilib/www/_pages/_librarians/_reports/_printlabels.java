package _librarians._reports;

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
import digilib.view.OtherTitle;
import digilib.view.Note;
import digilib.view.Name;


public class _printlabels extends oracle.jsp.runtime.HttpJsp {


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
    PageContext pageContext = factory.getPageContext( this, request, response, null, true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    if (pageContext.getAttribute(OracleJspRuntime.JSP_REQUEST_REDIRECTED, PageContext.REQUEST_SCOPE) != null) {
      pageContext.setAttribute(OracleJspRuntime.JSP_PAGE_DONTNOTIFY, "true", PageContext.PAGE_SCOPE);
      factory.releasePageContext(pageContext);
      return;
}
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _printlabels page = this;
    ServletConfig config = pageContext.getServletConfig();

    try {
      // global beans
      // end global beans


      out.print(__jsp_StaticText.text[0]);
      out.print(__jsp_StaticText.text[1]);
      digilib.view.Item Items;
      if ((Items = (digilib.view.Item) pageContext.getAttribute( "Items", PageContext.PAGE_SCOPE)) == null) {
        Items = (digilib.view.Item) new digilib.view.Item();
        pageContext.setAttribute( "Items", Items, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[2]);
            	String sFromItemNo = "0";
      	String sToItemNo = "999999999999";
      	try {
      		sFromItemNo = request.getParameter("FromItemNo");
      		sToItemNo = request.getParameter("ToItemNo");
      	} catch (Exception e) {}
      	String sCriteria = "ITEMNO >= " + sFromItemNo + " AND ITEMNO <= " + sToItemNo;
      	Items.setCriteria(sCriteria);
      	Items.open();
      	while (Items.next()) {
      
      out.print(__jsp_StaticText.text[3]);
      out.print( Items.getPrimaryTitle());
      out.print(__jsp_StaticText.text[4]);
      out.print(__jsp_StaticText.text[5]);
            	OtherTitle otherTitles = Items.getOtherTitles();
      	otherTitles.open();
      	while (otherTitles.next()) {
      
      out.print(__jsp_StaticText.text[6]);
      out.print( Format.formatDisplayString(otherTitles.getOtherTitle()) );
      out.print(__jsp_StaticText.text[7]);
            	}
      	otherTitles.close();
      
      out.print(__jsp_StaticText.text[8]);
      out.print(__jsp_StaticText.text[9]);
            	Note notes = Items.getNotes();
      	notes.open();
      	int ins = 0;
      	while (notes.next()) {
      
      out.print(__jsp_StaticText.text[10]);
      out.print( (ins > 0) ? "<br />" : "");
      out.print( Format.formatDisplayString(notes.getNote()));
      out.print(__jsp_StaticText.text[11]);
            		ins++;
      	}
      	notes.close();
      
      out.print(__jsp_StaticText.text[12]);
      out.print(__jsp_StaticText.text[13]);
            	Name names = Items.getNames();
      	names.open();
      	int in = 0;
      	while (names.next()) {
      
      out.print(__jsp_StaticText.text[14]);
      out.print((in > 0) ? "<br />" : "");
      out.print( Format.formatDisplayString(names.getName()));
      out.print(__jsp_StaticText.text[15]);
            		in++;
      	}
      	names.close();
      
      out.print(__jsp_StaticText.text[16]);
      out.print( Format.formatDisplayString(Items.getImprint()));
      out.print(__jsp_StaticText.text[17]);
      out.print( Format.formatDisplayString(Items.getDDCID()) );
      out.print(__jsp_StaticText.text[18]);
      out.print( Format.formatDisplayString(Items.getEdition()) );
      out.print(__jsp_StaticText.text[19]);
            	}
      	Items.close();
      
      out.print(__jsp_StaticText.text[20]);

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
    private static final char text[][]=new char[21][];
    static {
      text[0] = 
      "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n".toCharArray();
      text[1] = 
      "\r\n<title>D I G I L I B &gt; Thủ thư &gt; In nhãn tài liệu</title>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n<link href=\"/digilib.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n</head>\r\n\r\n<body>\r\n\r\n".toCharArray();
      text[2] = 
      "\r\n".toCharArray();
      text[3] = 
      "\r\n<table width=\"500\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-top: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n  <tr> \r\n    <td style=\"border-bottom: #999999 1px solid;\">\r\n<table width=\"500\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n        <tr> \r\n          <td width=\"135\" valign=\"top\"><font size=\"3\"><strong>Tiêu đề</strong></font></td>\r\n          <td width=\"350\"><font size=\"3\">".toCharArray();
      text[4] = 
      " \r\n            ".toCharArray();
      text[5] = 
      "\r\n            ".toCharArray();
      text[6] = 
      "\r\n            ".toCharArray();
      text[7] = 
      "<br />\r\n            ".toCharArray();
      text[8] = 
      "\r\n            </font></td>\r\n        </tr>\r\n        <tr> \r\n          <td width=\"135\" valign=\"top\"><font size=\"3\"><strong>Mô tả</strong></font></td>\r\n          <td> <font size=\"3\"> \r\n            ".toCharArray();
      text[9] = 
      "\r\n            ".toCharArray();
      text[10] = 
      "\r\n            ".toCharArray();
      text[11] = 
      " \r\n            ".toCharArray();
      text[12] = 
      "\r\n            </font></td>\r\n        </tr>\r\n        <tr> \r\n          <td valign=\"top\"><font size=\"3\"><strong>Tác giả</strong></font></td>\r\n          <td> <font size=\"3\"> \r\n            ".toCharArray();
      text[13] = 
      "\r\n            ".toCharArray();
      text[14] = 
      "\r\n            ".toCharArray();
      text[15] = 
      " \r\n            ".toCharArray();
      text[16] = 
      "\r\n            </font></td>\r\n        </tr>\r\n        <tr> \r\n          <td valign=\"top\"><font size=\"3\"><strong>Nhà xuất bản</strong></font></td>\r\n          <td><font size=\"3\">".toCharArray();
      text[17] = 
      "</font></td>\r\n        </tr>\r\n      </table></td>\r\n  </tr>\r\n  <tr align=\"center\"> \r\n    <td> <table width=\"500\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n        <tr>\r\n          <td align=\"center\"> <font size=\"5\"><strong>".toCharArray();
      text[18] = 
      " ".toCharArray();
      text[19] = 
      "</strong></font></td>\r\n        </tr>\r\n      </table>\r\n      \r\n    </td>\r\n  </tr>\r\n</table>\r\n<br />\r\n".toCharArray();
      text[20] = 
      "\r\n</body>\r\n</html>\r\n".toCharArray();
    }
  }
}
