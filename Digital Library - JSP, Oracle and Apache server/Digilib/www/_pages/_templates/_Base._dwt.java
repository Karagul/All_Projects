package _templates;

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


public class _Base_2e_dwt extends oracle.jsp.runtime.HttpJsp {


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
    _Base_2e_dwt page = this;
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
    private static final char text[][]=new char[3][];
    static {
      text[0] = 
      "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n".toCharArray();
      text[1] = 
      "\r\n".toCharArray();
      text[2] = 
      "\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n<head>\r\n<!-- TemplateBeginEditable name=\"doctitle\" -->\r\n<title>Untitled Document</title>\r\n<!-- TemplateEndEditable -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n<!-- TemplateBeginEditable name=\"head\" -->\r\n<!-- TemplateEndEditable -->\r\n<link href=\"/digilib.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<style type=\"text/css\">\r\n<!--\r\n.style2 {color: #000099}\r\n-->\r\n</style>\r\n</head>\r\n\r\n<body>\r\n<table width=\"760\" height=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr>\r\n    <td height=\"150\">\r\n      <table width=\"760\" height=\"150\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"150\" rowspan=\"3\" align=\"center\" valign=\"middle\"><img src=\"/images/logo.gif\" width=\"150\" height=\"150\" /></td>\r\n          <td height=\"75\" colspan=\"2\">\r\n            <table width=\"610\" height=\"75\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"middle\">\r\n                  <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\" width=\"500\" height=\"75\">\r\n                    <param name=\"movie\" value=\"/images/banner.swf\" />\r\n                     \r\n                    <param name=\"quality\" value=\"high\" /><param name=\"SCALE\" value=\"noborder\">\r\n                    <embed src=\"/images/banner.swf\" width=\"500\" height=\"75\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" scale=\"noborder\"></embed></object>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td height=\"25\" colspan=\"2\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"4\" cellspacing=\"0\" class=\"navigator\">\r\n              <tr align=\"center\">\r\n                <td><a href=\"/\">digilib.com</a></td>\r\n                <td>•</td>\r\n                <td><span class=\"style2\">Search</span></td>\r\n                <td>•</td>\r\n                <td><span class=\"style2\">Member</span></td>\r\n                <td>•</td>\r\n                <td><a href=\"/librarians/\">Librarian</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/feedback.jsp\">Feedback</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/contactus.jsp\">Contact us</a></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"300\" height=\"50\">\r\n            <table width=\"300\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td><!-- TemplateBeginEditable name=\"HeaderImage\" --><!-- TemplateEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"310\">\r\n            <table width=\"310\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"right\"><!-- TemplateBeginEditable name=\"Validation\" --><!-- TemplateEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"100%\" valign=\"top\">\r\n      <table width=\"760\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"160\" height=\"100%\" valign=\"top\">\r\n            <table width=\"160\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"top\">\r\n                  <!-- TemplateBeginEditable name=\"LeftMenu\" -->\r\n                  <table width=\"150\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                  </table>\r\n                  <!-- TemplateEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"600\" height=\"100%\" valign=\"top\"><!-- TemplateBeginEditable name=\"Content\" --><!-- TemplateEndEditable --></td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"copyright\">\r\n        <tr>\r\n          <td>&copy;  Vuong Phuc Dinh (010300022102)</td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n</body>\r\n</html>\r\n".toCharArray();
    }
  }
}
