package _librarians;

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


public class _profile extends oracle.jsp.runtime.HttpJsp {


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
    _profile page = this;
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
      digilib.web.Librarian curLibrarian;
      if ((curLibrarian = (digilib.web.Librarian) pageContext.getAttribute( "curLibrarian", PageContext.SESSION_SCOPE)) == null) {
        curLibrarian = (digilib.web.Librarian) new digilib.web.Librarian();
        pageContext.setAttribute( "curLibrarian", curLibrarian, PageContext.SESSION_SCOPE);
      }
      out.print(__jsp_StaticText.text[3]);
            	if (curLibrarian.isValidated()) {
      
      out.print(__jsp_StaticText.text[4]);
      out.print( curLibrarian.getName());
      out.print(__jsp_StaticText.text[5]);
            	} else {
      		response.sendRedirect("/librarians/?src=" + request.getRequestURI());
      	}
      
      out.print(__jsp_StaticText.text[6]);
      out.print( curLibrarian.getName());
      out.print(__jsp_StaticText.text[7]);
      out.print( Format.formatTimeStamp(curLibrarian.getAudTime()) );
      out.print(__jsp_StaticText.text[8]);
      out.print( curLibrarian.getAudUser() );
      out.print(__jsp_StaticText.text[9]);
      out.print( curLibrarian.getName() );
      out.print(__jsp_StaticText.text[10]);
      out.print( curLibrarian.getPassword() );
      out.print(__jsp_StaticText.text[11]);
      out.print( curLibrarian.getPassword() );
      out.print(__jsp_StaticText.text[12]);
      out.print( Format.formatTimeStamp(new Date()) );
      out.print(__jsp_StaticText.text[13]);
      out.print( curLibrarian.getLibrarianID());
      out.print(__jsp_StaticText.text[14]);
      out.print( curLibrarian.getLibrarianID() );
      out.print(__jsp_StaticText.text[15]);

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
    private static final char text[][]=new char[16][];
    static {
      text[0] = 
      "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n".toCharArray();
      text[1] = 
      "\r\n".toCharArray();
      text[2] = 
      "\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/2 Cols Base.dwt.jsp\" codeOutsideHTMLIsLocked=\"false\" -->\r\n<head>\r\n<!-- InstanceBeginEditable name=\"doctitle\" -->\r\n<title>D I G I L I B &gt; Thủ thư &gt; Hồ sơ cá nhân</title>\r\n<script language=\"JavaScript\" src=\"/digilib.js\"></script>\r\n<script language=\"JavaScript\" src=\"/data.js\"></script>\r\n<script language=\"JavaScript\" src=\"librarians.js\"></script>\r\n<script language=\"JavaScript\">\r\nDataForm = \"ProfileForm\";\r\nDataFormAction = \"/process/librarians.jsp\";\r\nDataSet = \"Librarians\";\r\n</script>\r\n<!-- InstanceEndEditable -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\r\n<!-- InstanceBeginEditable name=\"head\" --><!-- InstanceEndEditable -->\r\n<link href=\"/digilib.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n</head>\r\n\r\n<body>\r\n<table width=\"760\" height=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr>\r\n    <td height=\"150\">\r\n      <table width=\"760\" height=\"150\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"150\" rowspan=\"3\" align=\"center\" valign=\"middle\"><img src=\"/images/logo.gif\" width=\"150\" height=\"150\" /></td>\r\n          <td height=\"75\" colspan=\"2\">\r\n            <table width=\"610\" height=\"75\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"middle\">\r\n                  <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\" width=\"500\" height=\"75\">\r\n                    <param name=\"movie\" value=\"/images/banner.swf\" />\r\n                     \r\n                    <param name=\"quality\" value=\"high\" /><param name=\"SCALE\" value=\"noborder\">\r\n                    <embed src=\"/images/banner.swf\" width=\"500\" height=\"75\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" scale=\"noborder\"></embed></object>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td height=\"25\" colspan=\"2\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"4\" cellspacing=\"0\" class=\"navigator\">\r\n              <tr align=\"center\">\r\n                <td><a href=\"/\">digilib.com</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/search.jsp\">Search</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/members/\">Member</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/librarians/\">Librarian</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/feedback.jsp\">Feedback</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/contactus.jsp\">Contact</a></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"300\" height=\"50\">\r\n            <table width=\"300\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"HeaderImage\" --><img src=\"/images/header_librarianprofile.gif\" width=\"300\" height=\"50\" /><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"310\">\r\n            <table width=\"310\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"right\"><!-- InstanceBeginEditable name=\"Validation\" --><!-- #BeginLibraryItem \"/Library/Librarian's Validation.lbi\" -->\r\n                  ".toCharArray();
      text[3] = 
      "\r\n".toCharArray();
      text[4] = 
      "\t\t\t\t  \r\n                  <form name=\"LogoutForm\" id=\"LogoutForm\" method=\"post\" action=\"/process/librarians.jsp?action=logout\">\r\n                    <table width=\"310\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td align=\"right\">Thủ thư <strong>\r\n                          ".toCharArray();
      text[5] = 
      "\r\n                          </strong></td>\r\n                        <td width=\"75\" align=\"center\">\r\n                          <input name=\"Logout\" type=\"submit\" class=\"button\" id=\"Logout\" value=\"Thoát\" />\r\n                        </td>\r\n                      </tr>\r\n                    </table>\r\n                  </form>\r\n".toCharArray();
      text[6] = 
      "\t\t\t\t  \r\n                                    <!-- #EndLibraryItem --><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"100%\" valign=\"top\">\r\n      <table width=\"760\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"160\" height=\"100%\" valign=\"top\">\r\n            <table width=\"160\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"top\">\r\n                  <!-- InstanceBeginEditable name=\"LeftMenu\" -->\r\n                  <table width=\"150\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Thủ \r\n                        thư</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"#\">Hồ sơ cá nhân</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\"><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Quản \r\n                        lý thư viện</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/management/\">Quản \r\n                        lý thư viện</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\"><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Biên \r\n                        mục tài liệu</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/\">Biên \r\n                        mục tài liệu</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\"><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Báo \r\n                        cáo</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/reports/managements.jsp\">Các \r\n                        báo cáo quản lý</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/reports/labeling.jsp\">In \r\n                        nhãn tài liệu</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                  </table>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"600\" height=\"100%\" valign=\"top\">\r\n            <table width=\"600\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n              <tr>\r\n                <td width=\"400\" valign=\"top\"><!-- InstanceBeginEditable name=\"LeftContent\" -->\r\n                  <table width=\"400\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr>\r\n                      <td width=\"10\"><img src=\"/images/lefttop_curve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td width=\"240\" bgcolor=\"#663300\" class=\"headline\">Hồ sơ cá nhân thủ thư</td>\r\n                      <td width=\"150\"><img src=\"/images/headline_trailer.gif\" width=\"150\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td colspan=\"3\">\r\n                        <form name=\"ProfileForm\" id=\"ProfileForm\" method=\"post\" action=\"/process/librarians.jsp?action=update\" onsubmit=\"return checkData(0);\">\r\n                          <table width=\"400\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"data\" id=\"divDisplay\" style=\"display: inline;\">\r\n                            <tr>\r\n                              <td width=\"100\">Họ và tên</td>\r\n                              <td width=\"300\">".toCharArray();
      text[7] = 
      "\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\">Mật khẩu</td>\r\n                              <td width=\"300\">********************</td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\">Xác nhận mật khẩu</td>\r\n                              <td width=\"300\">********************</td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\"><em>Cập nhật lần cuối</em></td>\r\n                              <td width=\"300\"><em>".toCharArray();
      text[8] = 
      " - (".toCharArray();
      text[9] = 
      ")</em></td>\r\n                            </tr>\r\n                            <tr align=\"center\">\r\n                              <td colspan=\"2\">\r\n                                \r\n                                <input name=\"Edit\" type=\"button\" class=\"button\" id=\"Edit\" value=\"Thay đổi thông tin\" onclick=\"doEdit(0);\" />\r\n                              </td>\r\n                            </tr>\r\n                          </table>\r\n                          <table width=\"400\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"data\" id=\"divEdit\" style=\"display: none;\">\r\n                            <tr>\r\n                              <td width=\"100\">Họ và tên</td>\r\n                              <td width=\"300\">\r\n                                <input name=\"Name\" type=\"text\" class=\"textbox\" id=\"Name\" value=\"".toCharArray();
      text[10] = 
      "\" maxlength=\"100\" />\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\">Mật khẩu</td>\r\n                              <td width=\"300\">\r\n                                <input name=\"Password\" type=\"password\" class=\"textbox\" id=\"Password\" value=\"".toCharArray();
      text[11] = 
      "\" maxlength=\"50\" />\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\">Xác nhận mật khẩu</td>\r\n                              <td width=\"300\">\r\n                                <input name=\"ConfirmPassword\" type=\"password\" class=\"textbox\" id=\"ConfirmPassword\" value=\"".toCharArray();
      text[12] = 
      "\" maxlength=\"50\" />\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\"><em>Cập nhật lần cuối</em></td>\r\n                              <td width=\"300\"><em>\r\n                                ".toCharArray();
      text[13] = 
      "\r\n                                 - (".toCharArray();
      text[14] = 
      ")</em></td>\r\n                            </tr>\r\n                            <tr align=\"center\">\r\n                              <td colspan=\"2\">\r\n                                <input name=\"LibrarianID\" type=\"hidden\" id=\"LibrarianID\" value=\"".toCharArray();
      text[15] = 
      "\" />\r\n                                <input name=\"Status\" type=\"hidden\" id=\"Status\" value=\"1\" />\r\n                                <input name=\"Apply\" type=\"submit\" class=\"button\" id=\"Apply\" value=\"Cập nhật thay đổi\" />\r\n                                <input name=\"Cancel\" type=\"reset\" class=\"button\" id=\"Cancel\" value=\"Ngưng thay đổi thông tin\" onclick=\"doCancel(0);\" />\r\n                              </td>\r\n                            </tr>\r\n                          </table>\r\n                        </form>\r\n                      </td>\r\n                    </tr>\r\n                  </table>\r\n                  <!-- InstanceEndEditable --></td>\r\n                <td width=\"185\" align=\"center\" valign=\"top\"><!-- InstanceBeginEditable name=\"RightContent\" --><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n            </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"copyright\">\r\n        <tr>\r\n          <td>&copy; 2004 - 2005  Vuong Phuc Dinh (010300022102)</td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n</body>\r\n<!-- InstanceEnd --></html>\r\n".toCharArray();
    }
  }
}
