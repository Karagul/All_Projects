package _members;

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
import java.text.SimpleDateFormat;


public class _registrationform extends oracle.jsp.runtime.HttpJsp {


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
    _registrationform page = this;
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
            	for (int i = 1; i <= 31; i++) {
      
      out.print(__jsp_StaticText.text[3]);
      out.print( i );
      out.print(__jsp_StaticText.text[4]);
      out.print( i );
      out.print(__jsp_StaticText.text[5]);
            	}
      
      out.print(__jsp_StaticText.text[6]);
            	for (int i = 0; i < 12; i++) {
      
      out.print(__jsp_StaticText.text[7]);
      out.print( i );
      out.print(__jsp_StaticText.text[8]);
      out.print( i+1 );
      out.print(__jsp_StaticText.text[9]);
            	}
      
      out.print(__jsp_StaticText.text[10]);
      out.print(__jsp_StaticText.text[11]);
            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
      	int now = Integer.parseInt(sdf.format(new Date()));
      	for (int i = 1900; i <= now; i++) {
      
      out.print(__jsp_StaticText.text[12]);
      out.print( i );
      out.print(__jsp_StaticText.text[13]);
      out.print( i );
      out.print(__jsp_StaticText.text[14]);
            	}
      
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
      "\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/1 Cols Base.dwt.jsp\" codeOutsideHTMLIsLocked=\"false\" -->\r\n<head>\r\n<!-- InstanceBeginEditable name=\"doctitle\" -->\r\n<title>D I G I L I B &gt; Đăng ký Thẻ độc giả</title>\r\n<script language=\"JavaScript\" src=\"/digilib.js\"></script>\r\n<script language=\"JavaScript\" src=\"members.js\"></script>\r\n<!-- InstanceEndEditable -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\r\n<!-- InstanceBeginEditable name=\"head\" --><!-- InstanceEndEditable -->\r\n<link href=\"/digilib.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n</head>\r\n\r\n<body>\r\n<table width=\"760\" height=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr>\r\n    <td height=\"150\">\r\n      <table width=\"760\" height=\"150\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"150\" rowspan=\"3\" align=\"center\" valign=\"middle\"><img src=\"/images/logo.gif\" width=\"150\" height=\"150\" /></td>\r\n          <td height=\"75\" colspan=\"2\">\r\n            <table width=\"610\" height=\"75\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"middle\">\r\n                  <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\" width=\"500\" height=\"75\">\r\n                    <param name=\"movie\" value=\"/images/banner.swf\" />\r\n                     \r\n                    <param name=\"quality\" value=\"high\" /><param name=\"SCALE\" value=\"noborder\">\r\n                    <embed src=\"/images/banner.swf\" width=\"500\" height=\"75\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" scale=\"noborder\"></embed></object>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td height=\"25\" colspan=\"2\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"4\" cellspacing=\"0\" class=\"navigator\">\r\n              <tr align=\"center\">\r\n                <td><a href=\"/\">digilib.com</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/search.jsp\">Search</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/members/\">Member</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/librarians/\">Librarian</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/feedback.jsp\">Feedback</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/contactus.jsp\">Contact</a></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"300\" height=\"50\">\r\n            <table width=\"300\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"HeaderImage\" --><img src=\"/images/header_registration.gif\" width=\"300\" height=\"50\" /><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"310\">\r\n            <table width=\"310\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"right\"><!-- InstanceBeginEditable name=\"Validation\" --><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"100%\" valign=\"top\">\r\n      <table width=\"760\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"160\" height=\"100%\" valign=\"top\">\r\n            <table width=\"160\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"top\">\r\n                  <!-- InstanceBeginEditable name=\"LeftMenu\" -->\r\n                  <table width=\"150\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                  </table>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"600\" height=\"100%\" valign=\"top\">\r\n            <table width=\"600\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"MainContent\" -->\r\n                  <form action=\"/process/guess.jsp?action=register\" method=\"post\" enctype=\"multipart/form-data\" name=\"RegistrationForm\" id=\"RegistrationForm\" onsubmit=\"return checkData(0);\">\r\n                    <table width=\"590\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td width=\"10\"><img src=\"/images/lefttop_curve.gif\" width=\"10\" height=\"20\" /></td>\r\n                        <td width=\"430\" bgcolor=\"#663300\" class=\"headline\">Thông tin đăng ký</td>\r\n                        <td width=\"150\"><img src=\"/images/headline_trailer.gif\" width=\"150\" height=\"20\" /></td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td colspan=\"3\">\r\n                          <table width=\"590\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"data\">\r\n                            <tr>\r\n                              <td width=\"100\" rowspan=\"5\" align=\"center\" valign=\"top\"><img src=\"/images/#\" width=\"90\" height=\"120\" id=\"PictureDisplay\" />\r\n                                \r\n                              </td>\r\n                              <td width=\"140\">Họ và tên</td>\r\n                              <td width=\"300\">\r\n                                <input name=\"Name\" type=\"text\" class=\"textbox\" id=\"Name\" maxlength=\"100\" />\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"140\">Giới tính</td>\r\n                              <td width=\"300\">Nam \r\n                                <input name=\"Gender\" type=\"radio\" value=\"1\" checked=\"checked\" />\r\n                                Nữ  \r\n                                <input type=\"radio\" name=\"Gender\" value=\"0\" />\r\n                                                           </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"140\">Ngày sinh</td>\r\n                              <td width=\"300\">\r\n                                <select name=\"Day\" class=\"listbox\" id=\"Day\">\r\n\t\t\t\t\t\t\t\t\t\r\n                                  <option value=\"-1\" selected=\"selected\">--Ngày--</option>\r\n                                  ".toCharArray();
      text[3] = 
      "\r\n                                  \t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\r\n                                  <option value=\"".toCharArray();
      text[4] = 
      "\">".toCharArray();
      text[5] = 
      "</option>\r\n                                  ".toCharArray();
      text[6] = 
      "\r\n                                  \t\t\t\t\t\t\t\t\t\r\n                                </select>\r\n/ \r\n                                <select name=\"Month\" class=\"listbox\" id=\"Month\">\r\n\t\t\t\t\t\t\t\t\t\r\n                                  <option value=\"-1\" selected=\"selected\">--Tháng--</option>\r\n                                  ".toCharArray();
      text[7] = 
      "\r\n                                  \t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\r\n                                  <option value=\"".toCharArray();
      text[8] = 
      "\">".toCharArray();
      text[9] = 
      "</option>\r\n                                  ".toCharArray();
      text[10] = 
      "\r\n                                  \t\t\t\t\t\t\t\t\t\r\n                                </select>\r\n/ \r\n                                <select name=\"Year\" class=\"listbox\" id=\"Year\">\r\n\t\t\t\t\t\t\t\t\t\r\n                                  <option value=\"-1\" selected=\"selected\">--Năm--</option>\r\n                                  ".toCharArray();
      text[11] = 
      "\r\n                                  ".toCharArray();
      text[12] = 
      "\r\n                                  \t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\r\n                                  <option value=\"".toCharArray();
      text[13] = 
      "\">".toCharArray();
      text[14] = 
      "</option>\r\n                                  ".toCharArray();
      text[15] = 
      "\r\n                                  \t\t\t\t\t\t\t\t\t\r\n                                </select>\r\n                                                                                               \r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"140\">Địa chỉ</td>\r\n                              <td width=\"300\" rowspan=\"3\" valign=\"top\">\r\n                                <textarea name=\"Address\" rows=\"4\" wrap=\"PHYSICAL\" class=\"textbox\" id=\"Address\"></textarea>\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"140\">&nbsp;</td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\" align=\"center\" valign=\"top\">\r\n                                <input name=\"Picture\" type=\"file\" class=\"textbox\" id=\"Picture\" onpropertychange=\"setPicture();\" />\r\n                              </td>\r\n                              <td width=\"140\">&nbsp;</td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\">&nbsp;\r\n                                \r\n                              </td>\r\n                              <td width=\"140\">Điện thoại</td>\r\n                              <td width=\"300\">\r\n                                <input name=\"Phone\" type=\"text\" class=\"textbox\" id=\"Phone\" maxlength=\"50\" />\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\">&nbsp;</td>\r\n                              <td width=\"140\">Fax</td>\r\n                              <td width=\"300\">\r\n                                <input name=\"Fax\" type=\"text\" class=\"textbox\" id=\"Fax\" maxlength=\"50\" />\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\">&nbsp;</td>\r\n                              <td width=\"140\">Email</td>\r\n                              <td width=\"300\">\r\n                                <input name=\"Email\" type=\"text\" class=\"textbox\" id=\"Email\" maxlength=\"100\" />\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\">&nbsp;</td>\r\n                              <td width=\"140\">Chọn mật khẩu</td>\r\n                              <td width=\"300\">\r\n                                <input name=\"Password\" type=\"password\" class=\"textbox\" id=\"Password\" maxlength=\"50\" />\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td width=\"100\">&nbsp;</td>\r\n                              <td width=\"140\">Xác nhận mật khẩu</td>\r\n                              <td width=\"300\">\r\n                                <input name=\"ConfirmPassword\" type=\"password\" class=\"textbox\" id=\"ConfirmPassword\" maxlength=\"50\" />\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td>&nbsp;</td>\r\n                              <td colspan=\"2\" align=\"center\">\r\n                                <input name=\"Register\" type=\"submit\" class=\"button\" id=\"Register\" value=\"Đăng ký\" />\r\n                                <input name=\"Reset\" type=\"reset\" class=\"button\" value=\"Nhập lại\" />\r\n                              </td>\r\n                            </tr>\r\n                            \r\n                            \r\n                          </table>\r\n                        </td>\r\n                      </tr>\r\n                    </table>\r\n                  </form>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n            </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"copyright\">\r\n        <tr>\r\n          <td>&copy; 2002 - 2003 Ami Company Limited - - Vuong Phuc Dinh (0540377)</td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n</body>\r\n<!-- InstanceEnd --></html>\r\n".toCharArray();
    }
  }
}
