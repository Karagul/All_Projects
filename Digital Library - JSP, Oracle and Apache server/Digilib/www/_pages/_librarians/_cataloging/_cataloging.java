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


public class _cataloging extends oracle.jsp.runtime.HttpJsp {


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
    _cataloging page = this;
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
      digilib.view.Format Formats;
      if ((Formats = (digilib.view.Format) pageContext.getAttribute( "Formats", PageContext.PAGE_SCOPE)) == null) {
        Formats = (digilib.view.Format) new digilib.view.Format();
        pageContext.setAttribute( "Formats", Formats, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[7]);
      digilib.view.Language Languages;
      if ((Languages = (digilib.view.Language) pageContext.getAttribute( "Languages", PageContext.PAGE_SCOPE)) == null) {
        Languages = (digilib.view.Language) new digilib.view.Language();
        pageContext.setAttribute( "Languages", Languages, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[8]);
            	String[][] sFormats = null;
      	String[][] sLanguages = null;
      	int totalFormats, totalLanguages, i;
      	Formats.open();
      	totalFormats = Formats.getMaxRows();
      	sFormats = new String[totalFormats][2];
      	i = 0;
      	while (Formats.next()) {
      		sFormats[i][0] = Formats.getFormatID();
      		sFormats[i][1] = Formats.getName();
      		i++;
      	}
      	Formats.close();
      
      	Languages.open();
      	totalLanguages = Languages.getMaxRows();
      	sLanguages = new String[totalLanguages][2];
      	i = 0;
      	while (Languages.next()) {
      		sLanguages[i][0] = Languages.getLanguageID();
      		sLanguages[i][1] = Languages.getName();
      		i++;
      	}
      	Languages.close();
      
      out.print(__jsp_StaticText.text[9]);
            	for (i = 0; i < totalLanguages; i++) {
      
      out.print(__jsp_StaticText.text[10]);
      out.print( sLanguages[i][0]);
      out.print(__jsp_StaticText.text[11]);
      out.print( sLanguages[i][0]);
      out.print(__jsp_StaticText.text[12]);
      out.print( sLanguages[i][1]);
      out.print(__jsp_StaticText.text[13]);
            	}
      
      out.print(__jsp_StaticText.text[14]);
            	for (i = 0; i < totalFormats; i++) {
      
      out.print(__jsp_StaticText.text[15]);
      out.print( sFormats[i][0]);
      out.print(__jsp_StaticText.text[16]);
      out.print( sFormats[i][0]);
      out.print(__jsp_StaticText.text[17]);
      out.print( sFormats[i][1]);
      out.print(__jsp_StaticText.text[18]);
            	}
      
      out.print(__jsp_StaticText.text[19]);

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
    private static final char text[][]=new char[20][];
    static {
      text[0] = 
      "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n".toCharArray();
      text[1] = 
      "\r\n".toCharArray();
      text[2] = 
      "\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/1 Cols Base.dwt.jsp\" codeOutsideHTMLIsLocked=\"false\" -->\r\n<head>\r\n<!-- InstanceBeginEditable name=\"doctitle\" -->\r\n<title>D I G I L I B &gt; Thủ thư &gt; Biên mục tài liệu</title>\r\n<script language=\"JavaScript\" src=\"/digilib.js\"></script>\r\n<script language=\"JavaScript\" src=\"cataloging.js\"></script>\r\n<!-- InstanceEndEditable -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\r\n<!-- InstanceBeginEditable name=\"head\" --><!-- InstanceEndEditable -->\r\n<link href=\"/digilib.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n</head>\r\n\r\n<body>\r\n<table width=\"760\" height=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr>\r\n    <td height=\"150\">\r\n      <table width=\"760\" height=\"150\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"150\" rowspan=\"3\" align=\"center\" valign=\"middle\"><img src=\"/images/logo.gif\" width=\"150\" height=\"150\" /></td>\r\n          <td height=\"75\" colspan=\"2\">\r\n            <table width=\"610\" height=\"75\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"middle\">\r\n                  <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\" width=\"500\" height=\"75\">\r\n                    <param name=\"movie\" value=\"/images/banner.swf\" />\r\n                     \r\n                    <param name=\"quality\" value=\"high\" /><param name=\"SCALE\" value=\"noborder\">\r\n                    <embed src=\"/images/banner.swf\" width=\"500\" height=\"75\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" scale=\"noborder\"></embed></object>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td height=\"25\" colspan=\"2\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"4\" cellspacing=\"0\" class=\"navigator\">\r\n              <tr align=\"center\">\r\n                <td><a href=\"/\">digilib.com</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/search.jsp\">Thư mục</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/members/\">Độc giả</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/librarians/\">Thủ thư</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/feedback.jsp\">Góp ý</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/contactus.jsp\">Liên hệ</a></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"300\" height=\"50\">\r\n            <table width=\"300\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"HeaderImage\" --><img src=\"/images/header_cataloging.gif\" width=\"300\" height=\"50\" /><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"310\">\r\n            <table width=\"310\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"right\"><!-- InstanceBeginEditable name=\"Validation\" --><!-- #BeginLibraryItem \"/Library/Librarian's Validation.lbi\" -->\r\n                  ".toCharArray();
      text[3] = 
      "\r\n".toCharArray();
      text[4] = 
      "\t\t\t\t  \r\n                  <form name=\"LogoutForm\" id=\"LogoutForm\" method=\"post\" action=\"/process/librarians.jsp?action=logout\">\r\n                    <table width=\"310\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td align=\"right\">Thủ thư <strong>\r\n                          ".toCharArray();
      text[5] = 
      "\r\n                          </strong></td><td width=\"75\" align=\"center\">\r\n                          <input name=\"Logout\" type=\"submit\" class=\"button\" id=\"Logout\" value=\"Thoát\" />\r\n                        </td></tr>\r\n                    </table></form>".toCharArray();
      text[6] = 
      "\t\t\t\t  \r\n                                    <!-- #EndLibraryItem --><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"100%\" valign=\"top\">\r\n      <table width=\"760\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"160\" height=\"100%\" valign=\"top\">\r\n            <table width=\"160\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"top\">\r\n                  <!-- InstanceBeginEditable name=\"LeftMenu\" -->\r\n                  <table width=\"150\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Thủ \r\n                        thư</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/profile.jsp\">Hồ sơ \r\n                        cá nhân</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Quản \r\n                        lý thư viện</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/management/\">Quản \r\n                        lý thư viện</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Biên \r\n                        mục tài liệu</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/items.jsp\">Danh \r\n                        mục tài liệu</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"#\">Nhập tài liệu \r\n                        mới</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/languages.jsp\">Danh \r\n                        mục Ngôn ngữ</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/formats.jsp\">Danh \r\n                        mục Định dạng</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/classifications.jsp\">Thang \r\n                        phân loại Dewey</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/imexport.jsp\">Nhập \r\n                        / Xuất dữ liệu</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Báo \r\n                        cáo</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/reports/managements.jsp\">Các \r\n                        báo cáo quản lý</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/reports/labeling.jsp\">In \r\n                        nhãn tài liệu</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                  </table>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"600\" height=\"100%\" valign=\"top\">\r\n            <table width=\"600\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"MainContent\" --> \r\n                  <form name=\"CatalogingForm\" id=\"CatalogingForm\" method=\"post\" action=\"/process/cataloging.jsp?action=add\" onreset=\"resetForm();\" onsubmit=\"return submitForm();\">\r\n                    <table width=\"590\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n                      <tr> \r\n                        <td width=\"10\"><img src=\"/images/lefttop_curve.gif\" width=\"10\" height=\"20\" /></td>\r\n                        <td width=\"430\" bgcolor=\"#663300\" class=\"headline\">Biên \r\n                          mục tài liệu</td>\r\n                        <td width=\"150\"><img src=\"/images/headline_trailer.gif\" width=\"150\" height=\"20\" /></td>\r\n                      </tr>\r\n                      <tr> \r\n                        <td colspan=\"3\"><table width=\"490\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"5\">\r\n                            <tr> \r\n                              <td colspan=\"2\"><strong>Tựa đề chính</strong></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><input name=\"PrimaryTitle\" type=\"text\" class=\"textbox\" id=\"PrimaryTitle\" maxlength=\"200\" /></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><strong>Tựa đề khác</strong></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><input name=\"OtherTitle\" type=\"text\" class=\"textbox\" id=\"OtherTitle\" maxlength=\"200\" /> \r\n                              </td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td width=\"45\" align=\"center\"> <input name=\"AddTitle\" type=\"button\" class=\"button\" id=\"AddTitle\" value=\"&gt;&gt;\" onclick=\"addTitle();\" /> \r\n                                <br /> <br /> <input name=\"RemoveTitle\" type=\"button\" class=\"button\" id=\"RemoveTitle\" value=\"&lt;&lt;\" onclick=\"removeTitle();\" /> \r\n                              </td>\r\n                              <td width=\"430\"> <select name=\"OtherTitles\" size=\"5\" multiple=\"multiple\" class=\"textbox\" id=\"OtherTitles\">\r\n                                </select></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><strong>Mô tả</strong></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><textarea name=\"Note\" rows=\"5\" wrap=\"PHYSICAL\" class=\"textbox\" id=\"Note\"></textarea></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><strong>Tác giả chính</strong></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><input name=\"PrimaryAuthor\" type=\"text\" class=\"textbox\" id=\"PrimaryAuthor\" maxlength=\"200\" /></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><strong>Các tác giả khác</strong></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><input name=\"OtherAuthor\" type=\"text\" class=\"textbox\" id=\"OtherAuthor\" maxlength=\"200\" /></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td align=\"center\"> <input name=\"AddAuthor\" type=\"button\" class=\"button\" id=\"AddAuthor\" value=\"&gt;&gt;\" onclick=\"addAuthor();\" /> \r\n                                <br /> <br /> <input name=\"RemoveAuthor\" type=\"button\" class=\"button\" id=\"RemoveAuthor\" value=\"&lt;&lt;\" onclick=\"removeAuthor();\" /> \r\n                              </td>\r\n                              <td> <select name=\"OtherAuthors\" size=\"5\" multiple=\"multiple\" class=\"textbox\" id=\"OtherAuthors\">\r\n                                </select></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><strong>Nhà xuất bản</strong></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><input name=\"Imprint\" type=\"text\" class=\"textbox\" id=\"Imprint\" maxlength=\"200\" /></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><table width=\"480\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                  <tr> \r\n                                    <td width=\"200\"><strong>Phân loại</strong> \r\n                                      (theo thang phân loại Dewey)</td>\r\n                                    <td width=\"5\">&nbsp;</td>\r\n                                    <td width=\"100\"><strong>Phiên bản</strong></td>\r\n                                    <td width=\"5\">&nbsp;</td>\r\n                                    <td width=\"170\"><strong>Mã xếp giá</strong></td>\r\n                                  </tr>\r\n                                </table></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><table width=\"480\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                  <tr> \r\n                                    <td width=\"170\"> <input name=\"DDCID\" type=\"text\" class=\"textbox\" id=\"DDCID\" maxlength=\"20\" onblur=\"updateFullEdition();\" /> \r\n                                    </td>\r\n                                    <td width=\"30\" align=\"center\"><img src=\"/images/finder.gif\" width=\"15\" height=\"15\" class=\"picbutton\" onclick=\"browseDewey();\" /></td>\r\n                                    <td width=\"5\">&nbsp;</td>\r\n                                    <td width=\"100\"><input name=\"Edition\" type=\"text\" class=\"textbox\" id=\"Edition\" maxlength=\"50\" onblur=\"updateFullEdition();\" /></td>\r\n                                    <td width=\"5\">&nbsp;</td>\r\n                                    <td width=\"170\"> <input name=\"FullEdition\" type=\"text\" class=\"textbox\" id=\"FullEdition\" maxlength=\"100\" readonly=\"readonly\" /></td>\r\n                                  </tr>\r\n                                </table></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><strong>Ngôn ngữ</strong></td>\r\n                            </tr>\r\n".toCharArray();
      text[7] = 
      "\r\n".toCharArray();
      text[8] = 
      "\r\n".toCharArray();
      text[9] = 
      "\t\t\t\t\t\t\t\r\n                            <tr> \r\n                              <td colspan=\"2\"><select name=\"LanguageID\" class=\"textbox\" id=\"LanguageID\">\r\n                                  <option value=\"-1\">--Chọn ngôn ngữ--</option>\r\n".toCharArray();
      text[10] = 
      "\r\n                                  <option value=\"".toCharArray();
      text[11] = 
      "\">".toCharArray();
      text[12] = 
      " - ".toCharArray();
      text[13] = 
      "</option>\r\n".toCharArray();
      text[14] = 
      "\t\t\t\t\t\t\t\t  \r\n                                </select></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><strong>Định dạng</strong></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><select name=\"FormatID\" class=\"textbox\" id=\"FormatID\">\r\n                                  <option value=\"-1\">--Chọn định dạng--</option>\r\n".toCharArray();
      text[15] = 
      "\r\n                                  <option value=\"".toCharArray();
      text[16] = 
      "\">".toCharArray();
      text[17] = 
      " - ".toCharArray();
      text[18] = 
      "</option>\r\n".toCharArray();
      text[19] = 
      "\t\t\t\t\t\t\t\t  \r\n                                </select></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><strong>Mô tả vật lý</strong></td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td colspan=\"2\"><input name=\"PhysicalDescription\" type=\"text\" class=\"textbox\" id=\"PhysicalDescription\" maxlength=\"200\" /></td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td colspan=\"2\"><strong>Từ khoá</strong></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td colspan=\"2\"><input name=\"Keyword\" type=\"text\" class=\"textbox\" id=\"Keyword\" maxlength=\"100\" /></td>\r\n                            </tr>\r\n                            <tr> \r\n                              <td align=\"center\"> <input name=\"AddKeyword\" type=\"button\" class=\"button\" id=\"AddKeyword\" value=\"&gt;&gt;\" onclick=\"addKeyword();\" /> \r\n                                <br /> <br /> <input name=\"RemoveKeyword\" type=\"button\" class=\"button\" id=\"RemoveKeyword\" value=\"&lt;&lt;\" onclick=\"removeKeyword();\" /> \r\n                              </td>\r\n                              <td><select name=\"Keywords\" size=\"5\" multiple=\"multiple\" class=\"textbox\" id=\"select2\">\r\n                                </select></td>\r\n                            </tr>\r\n                            <tr align=\"center\"> \r\n                              <td colspan=\"2\"><input name=\"Submit\" type=\"submit\" class=\"button\" value=\"Cập nhật vào hệ thống\" /> \r\n                                <input name=\"Reset\" type=\"reset\" class=\"button\" id=\"Reset\" value=\"Nhập lại\" /></td>\r\n                            </tr>\r\n                          </table></td>\r\n                      </tr>\r\n                    </table>\r\n                  </form>\r\n                  <br />\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n            </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"copyright\">\r\n        <tr>\r\n          <td>&copy; 2002 - 2003 Ami Company Limited - - Vuong Phuc Dinh (0540377)</td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n</body>\r\n<!-- InstanceEnd --></html>\r\n".toCharArray();
    }
  }
}
