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
import digilib.view.Copy;


public class _items extends oracle.jsp.runtime.HttpJsp {


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
    _items page = this;
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
      digilib.view.Item Items;
      if ((Items = (digilib.view.Item) pageContext.getAttribute( "Items", PageContext.PAGE_SCOPE)) == null) {
        Items = (digilib.view.Item) new digilib.view.Item();
        pageContext.setAttribute( "Items", Items, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[7]);
            	Date now = new Date();
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
      	Items.setPageSize(PageSize);
      	Items.setPage(Page);
      	//Items.setCriteria(sCriteria);
      	Items.open();
      	int totalRecords = Items.getMaxRows();
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
      	while (Items.next()) {	
      
      out.print(__jsp_StaticText.text[8]);
      out.print((i%2==0)?"#ffffff":"#ffffcc");
      out.print(__jsp_StaticText.text[9]);
      out.print(i+1);
      out.print(__jsp_StaticText.text[10]);
      out.print( Items.getItemNo());
      out.print(__jsp_StaticText.text[11]);
      out.print( Items.getPrimaryTitle().trim());
      out.print(__jsp_StaticText.text[12]);
      out.print( Format.formatTimeStamp(Items.getAudTime()));
      out.print(__jsp_StaticText.text[13]);
      out.print( Items.getAudUser().trim());
      out.print(__jsp_StaticText.text[14]);
      out.print((i%2==0)?"#ffffff":"#ffffcc");
      out.print(__jsp_StaticText.text[15]);
      out.print(i);
      out.print(__jsp_StaticText.text[16]);
      out.print(__jsp_StaticText.text[17]);
            	Copy copies = Items.getCopies();
      	copies.open();
      	int totalCopies = copies.getMaxRows();
      	int availableCopies = 0;
      	while (copies.next()) {
      		if (copies.getStatus().intValue() == 1) {
      			availableCopies++;
      		}
      	}
      	copies.close();
      
      out.print(__jsp_StaticText.text[18]);
      out.print(availableCopies);
      out.print(__jsp_StaticText.text[19]);
      out.print(totalCopies);
      out.print(__jsp_StaticText.text[20]);
            		i++;
      	}
      	Items.close();
      
      out.print(__jsp_StaticText.text[21]);
      out.print( fromRecord );
      out.print(__jsp_StaticText.text[22]);
      out.print( toRecord );
      out.print(__jsp_StaticText.text[23]);
      out.print( totalRecords );
      out.print(__jsp_StaticText.text[24]);
      out.print( Page );
      out.print(__jsp_StaticText.text[25]);
      out.print( totalPages );
      out.print(__jsp_StaticText.text[26]);
      out.print( Page );
      out.print(__jsp_StaticText.text[27]);
            	for (int ps = 1; ps <= 50; ps++) {
      
      out.print(__jsp_StaticText.text[28]);
      out.print( ps );
      out.print(__jsp_StaticText.text[29]);
      out.print( (ps == PageSize) ? "selected=\"selected\"" : "" );
      out.print(__jsp_StaticText.text[30]);
      out.print( ps );
      out.print(__jsp_StaticText.text[31]);
            	}
      
      out.print(__jsp_StaticText.text[32]);
      out.print( (Page > 1) ? "gotoPage(1);" : "" );
      out.print(__jsp_StaticText.text[33]);
      out.print( (Page > 1) ? "gotoPage(" + (Page-1) + ");" : "" );
      out.print(__jsp_StaticText.text[34]);
      out.print( (Page < totalPages) ? "gotoPage(" + (Page+1) + ");" : "" );
      out.print(__jsp_StaticText.text[35]);
      out.print( (Page < totalPages) ? "gotoPage(" + totalPages + ");" : "" );
      out.print(__jsp_StaticText.text[36]);

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
    private static final char text[][]=new char[37][];
    static {
      text[0] = 
      "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n".toCharArray();
      text[1] = 
      "\r\n".toCharArray();
      text[2] = 
      "\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/1 Cols Base.dwt.jsp\" codeOutsideHTMLIsLocked=\"false\" -->\r\n<head>\r\n<!-- InstanceBeginEditable name=\"doctitle\" -->\r\n<title>D I G I L I B &gt; Thủ thư &gt; Biên mục tài liệu &gt; Danh mục tài liệu</title>\r\n<script language=\"JavaScript\" src=\"/digilib.js\"></script>\r\n<script language=\"JavaScript\">\r\n\tDataForm = \"ItemInfoForm\";\r\n\tDataFormAction = \"/process/copies.jsp\";\r\nfunction doApply(index, check) {\r\n\tdocument.all(DataForm).action = DataFormAction + \"?action=add&affected=\" + index;\r\n\tdocument.all(DataForm).submit();\r\n}\r\n</script>\r\n<!-- InstanceEndEditable -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\r\n<!-- InstanceBeginEditable name=\"head\" --><!-- InstanceEndEditable -->\r\n<link href=\"/digilib.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n</head>\r\n\r\n<body>\r\n<table width=\"760\" height=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr>\r\n    <td height=\"150\">\r\n      <table width=\"760\" height=\"150\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"150\" rowspan=\"3\" align=\"center\" valign=\"middle\"><img src=\"/images/logo.gif\" width=\"150\" height=\"150\" /></td>\r\n          <td height=\"75\" colspan=\"2\">\r\n            <table width=\"610\" height=\"75\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"middle\">\r\n                  <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\" width=\"500\" height=\"75\">\r\n                    <param name=\"movie\" value=\"/images/banner.swf\" />\r\n                     \r\n                    <param name=\"quality\" value=\"high\" /><param name=\"SCALE\" value=\"noborder\">\r\n                    <embed src=\"/images/banner.swf\" width=\"500\" height=\"75\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" scale=\"noborder\"></embed></object>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td height=\"25\" colspan=\"2\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"4\" cellspacing=\"0\" class=\"navigator\">\r\n              <tr align=\"center\">\r\n                <td><a href=\"/\">digilib.com</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/search.jsp\">Thư mục</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/members/\">Độc giả</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/librarians/\">Thủ thư</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/feedback.jsp\">Góp ý</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/contactus.jsp\">Liên hệ</a></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"300\" height=\"50\">\r\n            <table width=\"300\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"HeaderImage\" --><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"310\">\r\n            <table width=\"310\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"right\"><!-- InstanceBeginEditable name=\"Validation\" --><!-- #BeginLibraryItem \"/Library/Librarian's Validation.lbi\" -->\r\n                  ".toCharArray();
      text[3] = 
      "\r\n".toCharArray();
      text[4] = 
      "\t\t\t\t  \r\n                  <form name=\"LogoutForm\" id=\"LogoutForm\" method=\"post\" action=\"/process/librarians.jsp?action=logout\">\r\n                    <table width=\"310\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td align=\"right\">Thủ thư <strong>\r\n                          ".toCharArray();
      text[5] = 
      "\r\n                          </strong></td><td width=\"75\" align=\"center\">\r\n                          <input name=\"Logout\" type=\"submit\" class=\"button\" id=\"Logout\" value=\"Thoát\" />\r\n                        </td></tr>\r\n                    </table></form>".toCharArray();
      text[6] = 
      "\t\t\t\t  \r\n                                    <!-- #EndLibraryItem --><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"100%\" valign=\"top\">\r\n      <table width=\"760\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"160\" height=\"100%\" valign=\"top\">\r\n            <table width=\"160\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"top\">\r\n                  <!-- InstanceBeginEditable name=\"LeftMenu\" --> \r\n                  <table width=\"150\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Thủ \r\n                        thư</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/profile.jsp\">Hồ sơ \r\n                        cá nhân</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Quản \r\n                        lý thư viện</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/management/\">Quản \r\n                        lý thư viện</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Biên \r\n                        mục tài liệu</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"#\">Danh mục tài liệu</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/cataloging.jsp\">Nhập \r\n                        tài liệu mới</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/languages.jsp\">Danh \r\n                        mục Ngôn ngữ</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/formats.jsp\">Danh \r\n                        mục Định dạng</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/classifications.jsp\">Thang \r\n                        phân loại Dewey</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/imexport.jsp\">Nhập \r\n                        / Xuất dữ liệu</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Báo \r\n                        cáo</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/reports/managements.jsp\">Các \r\n                        báo cáo quản lý</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/reports/labeling.jsp\">In \r\n                        nhãn tài liệu</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                  </table>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"600\" height=\"100%\" valign=\"top\">\r\n            <table width=\"600\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"MainContent\" --> \r\n                  <form name=\"ItemInfoForm\" id=\"ItemInfoForm\" method=\"post\" action=\"/process/copies.jsp?action=add\">\r\n                    <table width=\"590\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                      <tr> \r\n                        <td width=\"10\"><img src=\"/images/lefttop_curve.gif\" width=\"10\" height=\"20\" /></td>\r\n                        <td width=\"430\" bgcolor=\"#663300\" class=\"headline\">Danh \r\n                          mục tài liệu</td>\r\n                        <td width=\"150\"><img src=\"/images/headline_trailer.gif\" width=\"150\" height=\"20\" /></td>\r\n                      </tr>\r\n                      <tr> \r\n                        <td colspan=\"3\"><table width=\"590\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                            <tr> \r\n                              <td><table width=\"580\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                  <tr> \r\n                                    <td width=\"10\"><img src=\"/images/news_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                    <td width=\"560\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Thông \r\n                                      tin tài liệu / Phiên bản</td>\r\n                                    <td width=\"10\"><img src=\"/images/news_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                  </tr>\r\n                                  <tr> \r\n                                    <td colspan=\"3\">\r\n                                      <table width=\"580\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" class=\"data\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; \">\r\n                                        ".toCharArray();
      text[7] = 
      "\r\n                                        ".toCharArray();
      text[8] = 
      "\r\n                                        <tr bgcolor=\"".toCharArray();
      text[9] = 
      "\"> \r\n                                          <td width=\"30\" rowspan=\"2\" align=\"right\" valign=\"top\" style=\"border-right: #999999 1px solid; border-bottom: #999999 1px solid;\"> \r\n                                            ".toCharArray();
      text[10] = 
      " </td>\r\n                                          <td width=\"330\" colspan=\"3\" style=\"border-right: #999999 1px solid; border-bottom: #999999 1px solid;\"> \r\n                                            <input name=\"ItemNo\" type=\"hidden\" id=\"ItemNo\" value=\"".toCharArray();
      text[11] = 
      "\" /> \r\n                                            ".toCharArray();
      text[12] = 
      "</td>\r\n                                          <td width=\"200\" colspan=\"2\" valign=\"top\" style=\"border-bottom: #999999 1px solid;\"><em>".toCharArray();
      text[13] = 
      " - (".toCharArray();
      text[14] = 
      ")</em></td>\r\n                                        </tr>\r\n                                        <tr bgcolor=\"".toCharArray();
      text[15] = 
      "\"> \r\n                                          <td width=\"20\" align=\"center\" style=\"border-right: #999999 1px solid; border-bottom: #999999 1px solid;\"><img src=\"/images/add_up.gif\" width=\"10\" height=\"10\" class=\"picbutton\" onclick=\"doApply(".toCharArray();
      text[16] = 
      ", false);\" /></td>\r\n                                          <td width=\"100\" style=\"border-right: #999999 1px solid; border-bottom: #999999 1px solid;\"> \r\n                                            <select name=\"CopyType\" class=\"listbox\" id=\"CopyType\">\r\n                                              <option value=\"0\" selected=\"selected\">Binh \r\n                                              thuong</option>\r\n                                              <option value=\"1\">So hoa</option>\r\n                                            </select> </td>\r\n                                          <td width=\"200\" style=\"border-right: #999999 1px solid; border-bottom: #999999 1px solid;\"> \r\n                                            <input name=\"Location\" type=\"text\" class=\"textbox\" id=\"Location\" maxlength=\"200\" /></td>\r\n                                          <td width=\"145\" valign=\"top\" style=\"border-bottom: #999999 1px solid;\">Các \r\n                                            phiên bản : </td>\r\n                                          <td width=\"45\" align=\"right\" valign=\"top\" style=\"border-bottom: #999999 1px solid;\"> \r\n                                            ".toCharArray();
      text[17] = 
      "\r\n".toCharArray();
      text[18] = 
      "\r\n                                            ".toCharArray();
      text[19] = 
      "/".toCharArray();
      text[20] = 
      " </td>\r\n                                        </tr>\r\n                                        ".toCharArray();
      text[21] = 
      "\r\n                                      </table>\r\n                                    </td>\r\n                                  </tr>\r\n                                  <tr> \r\n                                    <td colspan=\"3\"><table width=\"580\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"5\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr> \r\n                                          <td width=\"175\">Mẩu tin \r\n                                            ".toCharArray();
      text[22] = 
      "\r\n                                            - \r\n                                            ".toCharArray();
      text[23] = 
      "\r\n                                            / \r\n                                            ".toCharArray();
      text[24] = 
      "\r\n                                            mẩu tin<br />\r\n                                            Trang \r\n                                            ".toCharArray();
      text[25] = 
      "\r\n                                            / \r\n                                            ".toCharArray();
      text[26] = 
      "\r\n                                            trang</td>\r\n                                          <td align=\"center\"> <input name=\"page\" type=\"hidden\" id=\"page\" value=\"".toCharArray();
      text[27] = 
      "\" />\r\n                                            Giới hạn \r\n                                            <select name=\"pagesize\" class=\"listbox\" id=\"pagesize\" onchange=\"setPageSize();\">\r\n                                              ".toCharArray();
      text[28] = 
      "\r\n                                              <option value=\"".toCharArray();
      text[29] = 
      "\" ".toCharArray();
      text[30] = 
      "> \r\n                                              ".toCharArray();
      text[31] = 
      "\r\n                                              </option>\r\n                                              ".toCharArray();
      text[32] = 
      "\r\n                                            </select>\r\n                                            mẩu tin / trang</td>\r\n                                          <td width=\"175\" align=\"right\"> <img src=\"/images/movefirst_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[33] = 
      "\" /> \r\n                                            <img src=\"/images/moveprevious_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[34] = 
      "\" /> \r\n                                            <img src=\"/images/movenext_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[35] = 
      "\" /> \r\n                                            <img src=\"/images/movelast_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[36] = 
      "\" /></td>\r\n                                        </tr>\r\n                                      </table></td>\r\n                                  </tr>\r\n                                </table></td>\r\n                            </tr>\r\n                          </table></td>\r\n                      </tr>\r\n                    </table>\r\n                  </form>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n            </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"copyright\">\r\n        <tr>\r\n          <td>&copy; 2002 - 2003 Ami Company Limited - - Vuong Phuc Dinh (0540377)</td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n</body>\r\n<!-- InstanceEnd --></html>\r\n".toCharArray();
    }
  }
}
