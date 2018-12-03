package _librarians._management;

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


public class _registrations extends oracle.jsp.runtime.HttpJsp {


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
    _registrations page = this;
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
      digilib.view.Registration Registrations;
      if ((Registrations = (digilib.view.Registration) pageContext.getAttribute( "Registrations", PageContext.PAGE_SCOPE)) == null) {
        Registrations = (digilib.view.Registration) new digilib.view.Registration();
        pageContext.setAttribute( "Registrations", Registrations, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[7]);
      digilib.view.MemberGroup MemberGroups;
      if ((MemberGroups = (digilib.view.MemberGroup) pageContext.getAttribute( "MemberGroups", PageContext.PAGE_SCOPE)) == null) {
        MemberGroups = (digilib.view.MemberGroup) new digilib.view.MemberGroup();
        pageContext.setAttribute( "MemberGroups", MemberGroups, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[8]);
            	/**Get Groups Information*/
      	String[][] GroupsInfo = null;
      	MemberGroups.open();
      	int totalGroups = MemberGroups.getMaxRows();
      	GroupsInfo = new String[totalGroups][2];
      	int g = 0;
      	while (MemberGroups.next()) {
      		GroupsInfo[g][0] = MemberGroups.getGroupID();
      		GroupsInfo[g][1] = MemberGroups.getName();
      		g++;
      	}
      	MemberGroups.close();
      	
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
      	Registrations.setPageSize(PageSize);
      	Registrations.setPage(Page);
      	//Registrations.setCriteria(sCriteria);
      	Registrations.open();
      	int totalRecords = Registrations.getMaxRows();
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
      	while (Registrations.next()) {	
      
      out.print(__jsp_StaticText.text[9]);
      out.print( (i % 2 == 0) ? "#ffffff" : "#ffffcc" );
      out.print(__jsp_StaticText.text[10]);
      out.print( Registrations.getRegistrationNo() );
      out.print(__jsp_StaticText.text[11]);
      out.print( Registrations.getRegistrationNo() );
      out.print(__jsp_StaticText.text[12]);
      out.print( Registrations.getName());
      out.print(__jsp_StaticText.text[13]);
      out.print( (Registrations.getGender().intValue() == 1) ? "Nam" : "Nữ" );
      out.print(__jsp_StaticText.text[14]);
      out.print( Format.formatShortDate(Registrations.getBirthday()) );
      out.print(__jsp_StaticText.text[15]);
      out.print( Format.formatDisplayString(Registrations.getAddress()) );
      out.print(__jsp_StaticText.text[16]);
      out.print( Format.formatDisplayString(Registrations.getPhone()) );
      out.print(__jsp_StaticText.text[17]);
      out.print( Format.formatDisplayString(Registrations.getFax()) );
      out.print(__jsp_StaticText.text[18]);
      out.print( Registrations.getEmail() );
      out.print(__jsp_StaticText.text[19]);
            	for (int j = 0; j < totalGroups; j++) {
      
      out.print(__jsp_StaticText.text[20]);
      out.print( GroupsInfo[j][0] );
      out.print(__jsp_StaticText.text[21]);
      out.print( GroupsInfo[j][0] );
      out.print(__jsp_StaticText.text[22]);
      out.print( GroupsInfo[j][1] );
      out.print(__jsp_StaticText.text[23]);
            	}
      
      out.print(__jsp_StaticText.text[24]);
            		i++;
      	}
      	Registrations.close();
      
      out.print(__jsp_StaticText.text[25]);
      out.print( fromRecord );
      out.print(__jsp_StaticText.text[26]);
      out.print( toRecord );
      out.print(__jsp_StaticText.text[27]);
      out.print( totalRecords );
      out.print(__jsp_StaticText.text[28]);
      out.print( Page );
      out.print(__jsp_StaticText.text[29]);
      out.print( totalPages );
      out.print(__jsp_StaticText.text[30]);
      out.print( Page );
      out.print(__jsp_StaticText.text[31]);
            	for (int ps = 1; ps <= 50; ps++) {
      
      out.print(__jsp_StaticText.text[32]);
      out.print( ps );
      out.print(__jsp_StaticText.text[33]);
      out.print( (ps == PageSize) ? "selected=\"selected\"" : "" );
      out.print(__jsp_StaticText.text[34]);
      out.print( ps );
      out.print(__jsp_StaticText.text[35]);
            	}
      
      out.print(__jsp_StaticText.text[36]);
      out.print( (Page > 1) ? "gotoPage(1);" : "" );
      out.print(__jsp_StaticText.text[37]);
      out.print( (Page > 1) ? "gotoPage(" + (Page-1) + ");" : "" );
      out.print(__jsp_StaticText.text[38]);
      out.print( (Page < totalPages) ? "gotoPage(" + (Page+1) + ");" : "" );
      out.print(__jsp_StaticText.text[39]);
      out.print( (Page < totalPages) ? "gotoPage(" + totalPages + ");" : "" );
      out.print(__jsp_StaticText.text[40]);

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
    private static final char text[][]=new char[41][];
    static {
      text[0] = 
      "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n".toCharArray();
      text[1] = 
      "\r\n".toCharArray();
      text[2] = 
      "\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/1 Cols Base.dwt.jsp\" codeOutsideHTMLIsLocked=\"false\" -->\r\n<head>\r\n<!-- InstanceBeginEditable name=\"doctitle\" -->\r\n<title>D I G I L I B &gt; Thủ thư &gt; Quản lý Thư viện &gt; Cấp thẻ độc giả</title>\r\n<script language=\"JavaScript\" src=\"/digilib.js\"></script>\r\n<script language=\"JavaScript\" src=\"/data.js\"></script>\r\n<script language=\"JavaScript\" src=\"/members/members.js\"></script>\r\n<script language=\"JavaScript\">\r\n\tDataForm = \"RegistrationInfoForm\";\r\n\tDataFormAction = \"/process/registrations.jsp\";\r\n\tDataSet = \"Registrations\";\r\n</script>\r\n<!-- InstanceEndEditable -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\r\n<!-- InstanceBeginEditable name=\"head\" --><!-- InstanceEndEditable -->\r\n<link href=\"/digilib.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n</head>\r\n\r\n<body>\r\n<table width=\"760\" height=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr>\r\n    <td height=\"150\">\r\n      <table width=\"760\" height=\"150\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"150\" rowspan=\"3\" align=\"center\" valign=\"middle\"><img src=\"/images/logo.gif\" width=\"150\" height=\"150\" /></td>\r\n          <td height=\"75\" colspan=\"2\">\r\n            <table width=\"610\" height=\"75\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"middle\">\r\n                  <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\" width=\"500\" height=\"75\">\r\n                    <param name=\"movie\" value=\"/images/banner.swf\" />\r\n                     \r\n                    <param name=\"quality\" value=\"high\" /><param name=\"SCALE\" value=\"noborder\">\r\n                    <embed src=\"/images/banner.swf\" width=\"500\" height=\"75\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" scale=\"noborder\"></embed></object>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td height=\"25\" colspan=\"2\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"4\" cellspacing=\"0\" class=\"navigator\">\r\n              <tr align=\"center\">\r\n                <td><a href=\"/\">digilib.com</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/search.jsp\">Thư mục</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/members/\">Độc giả</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/librarians/\">Thủ thư</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/feedback.jsp\">Góp ý</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/contactus.jsp\">Liên hệ</a></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"300\" height=\"50\">\r\n            <table width=\"300\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"HeaderImage\" --><img src=\"/images/header_registrationlist.gif\" width=\"300\" height=\"50\" /><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"310\">\r\n            <table width=\"310\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"right\"><!-- InstanceBeginEditable name=\"Validation\" --><!-- #BeginLibraryItem \"/Library/Librarian's Validation.lbi\" -->\r\n                  ".toCharArray();
      text[3] = 
      "\r\n".toCharArray();
      text[4] = 
      "\t\t\t\t  \r\n                  <form name=\"LogoutForm\" id=\"LogoutForm\" method=\"post\" action=\"/process/librarians.jsp?action=logout\">\r\n                    <table width=\"310\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td align=\"right\">Thủ thư <strong>\r\n                          ".toCharArray();
      text[5] = 
      "\r\n                          </strong></td><td width=\"75\" align=\"center\">\r\n                          <input name=\"Logout\" type=\"submit\" class=\"button\" id=\"Logout\" value=\"Thoát\" />\r\n                        </td></tr>\r\n                    </table></form>".toCharArray();
      text[6] = 
      "\t\t\t\t  \r\n                                    <!-- #EndLibraryItem --><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"100%\" valign=\"top\">\r\n      <table width=\"760\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"160\" height=\"100%\" valign=\"top\">\r\n            <table width=\"160\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"top\">\r\n                  <!-- InstanceBeginEditable name=\"LeftMenu\" -->\r\n                  <table width=\"150\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Thủ \r\n                        thư</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/profile.jsp\">Hồ sơ \r\n                        cá nhân</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\"><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Quản \r\n                        lý thư viện</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"#\">Cấp thẻ độc giả</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/management/members.jsp\">Danh \r\n                        sách Độc giả</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/management/membergroups.jsp\">Danh \r\n                        sách Nhóm độc giả</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/management/librarians.jsp\">Danh \r\n                        sách Thủ thư</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/management/loans.jsp\">Cho \r\n                        mượn tài liệu</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/management/confirmloans.jsp\">Phiếu \r\n                        mượn đã lập</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/management/returns.jsp\">Thu \r\n                        hồi tài liệu</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\"><a href=\"/librarians/management/confirmreturns.jsp\">Phiếu \r\n                        trả đã lập</a></td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/management/dayend.jsp\">Xử \r\n                        lý cuối ngày</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\"><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Biên \r\n                        mục tài liệu</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/cataloging/\">Biên \r\n                        mục tài liệu</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\"><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Báo \r\n                        cáo</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/reports/managements.jsp\">Các \r\n                        báo cáo quản lý</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr> \r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/librarians/reports/labeling.jsp\">In \r\n                        nhãn tài liệu</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td align=\"right\">&nbsp;</td>\r\n                      <td>&nbsp;</td>\r\n                      <td valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                  </table>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"600\" height=\"100%\" valign=\"top\">\r\n            <table width=\"600\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"MainContent\" -->\r\n                  <table width=\"590\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr>\r\n                      <td width=\"10\"><img src=\"/images/lefttop_curve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td width=\"430\" bgcolor=\"#663300\" class=\"headline\">Danh sách đăng ký Thẻ độc giả</td>\r\n                      <td width=\"150\"><img src=\"/images/headline_trailer.gif\" width=\"150\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td colspan=\"3\">\r\n                        <table width=\"590\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                          <tr>\r\n                            <td>\r\n                              <form name=\"RegistrationsInfoForm\" id=\"RegistrationsInfoForm\" method=\"post\" action=\"/process/registrations.jsp\">\r\n                                <table width=\"580\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                  <tr>\r\n                                    <td width=\"10\"><img src=\"/images/news_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                    <td width=\"560\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Thông tin đăng ký</td>\r\n                                    <td width=\"10\"><img src=\"/images/news_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                  </tr>\r\n                                      \r\n                                  ".toCharArray();
      text[7] = 
      "\r\n\t\t\t\t\t\t\t\t  ".toCharArray();
      text[8] = 
      "\r\n                                  ".toCharArray();
      text[9] = 
      "\r\n                                                                        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \r\n                                  <tr>\r\n                                    <td colspan=\"3\">\r\n                                      <table width=\"580\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" bgcolor=\"".toCharArray();
      text[10] = 
      "\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr>\r\n                                          <td width=\"100\" rowspan=\"11\" align=\"center\" valign=\"top\"><img src=\"/images/registration.jsp?registrationno=".toCharArray();
      text[11] = 
      "\" width=\"90\" height=\"120\" />\r\n                                            <input name=\"RegistrationNo\" type=\"hidden\" id=\"RegistrationNo\" value=\"".toCharArray();
      text[12] = 
      "\" />\r\n                                          </td>\r\n                                          <td width=\"100\">Họ và tên</td>\r\n                                          <td>".toCharArray();
      text[13] = 
      "</td>\r\n                                          <td width=\"100\">&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>Giới tính</td>\r\n                                          <td>".toCharArray();
      text[14] = 
      "</td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>Ngày sinh</td>\r\n                                          <td>".toCharArray();
      text[15] = 
      "</td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>Địa chỉ</td>\r\n                                          <td rowspan=\"3\" valign=\"top\">".toCharArray();
      text[16] = 
      "</td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>&nbsp;</td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>&nbsp;</td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>Điện thoại</td>\r\n                                          <td>".toCharArray();
      text[17] = 
      "</td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>Fax</td>\r\n                                          <td>".toCharArray();
      text[18] = 
      "</td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>Email</td>\r\n                                          <td>".toCharArray();
      text[19] = 
      "</td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>Mật khẩu</td>\r\n                                          <td>*******************</td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>Xác nhận mật khẩu</td>\r\n                                          <td>*******************</td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        <tr>\r\n                                          <td>&nbsp;</td>\r\n                                          <td>Xử lý cấp thẻ</td>\r\n                                          <td>\r\n                                            <select name=\"GroupID\" class=\"textbox\" id=\"GroupID\">\r\n                                              <option value=\"_leave_\" selected=\"selected\">--Để lại--</option>\r\n                                              <option value=\"_delete_\">--Xoá--</option>\r\n".toCharArray();
      text[20] = 
      "\r\n<option value=\"".toCharArray();
      text[21] = 
      "\">".toCharArray();
      text[22] = 
      " | ".toCharArray();
      text[23] = 
      "</option>  \r\n".toCharArray();
      text[24] = 
      "\r\n                                            </select>\r\n                                          </td>\r\n                                          <td>&nbsp;</td>\r\n                                        </tr>\r\n                                        \r\n                                      </table>\r\n                                    </td>\r\n                                  </tr>\r\n                                  ".toCharArray();
      text[25] = 
      "\r\n                                  <tr>\r\n                                    <td colspan=\"3\">\r\n                                      <table width=\"580\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"5\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr>\r\n                                          <td width=\"175\">Mẩu tin \r\n                                            ".toCharArray();
      text[26] = 
      "\r\n                                             - \r\n                                            ".toCharArray();
      text[27] = 
      "\r\n                                             / \r\n                                            ".toCharArray();
      text[28] = 
      "\r\n                                             mẩu tin<br />\r\nTrang \r\n                                            ".toCharArray();
      text[29] = 
      "\r\n                                             / \r\n                                            ".toCharArray();
      text[30] = 
      "\r\n                                             trang</td>\r\n                                          <td align=\"center\">\r\n                                            <input name=\"page\" type=\"hidden\" id=\"page\" value=\"".toCharArray();
      text[31] = 
      "\" />\r\n                                            Giới hạn \r\n                                            <select name=\"pagesize\" class=\"listbox\" id=\"pagesize\" onchange=\"setPageSize();\">\r\n                                              ".toCharArray();
      text[32] = 
      "\r\n                                              \t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n                                              <option value=\"".toCharArray();
      text[33] = 
      "\" ".toCharArray();
      text[34] = 
      ">\r\n                                              ".toCharArray();
      text[35] = 
      "\r\n                                              </option>\r\n                                              ".toCharArray();
      text[36] = 
      "\r\n                                              \t\t\t\t\t\t\t\t\t\t\t\t\r\n                                            </select>\r\n                                             mẩu tin / trang</td>\r\n                                          <td width=\"175\" align=\"right\">\r\n\t\t\t\t\t\t\t\t\t\t  \t<img src=\"/images/movefirst_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[37] = 
      "\" /> \r\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"/images/moveprevious_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[38] = 
      "\" /> \r\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"/images/movenext_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[39] = 
      "\" /> \r\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"/images/movelast_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[40] = 
      "\" /></td>\r\n                                        </tr>\r\n                                      </table>  <table width=\"580\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                                        <tr>\r\n                                          <td align=\"center\">\r\n                                            <input name=\"Process\" type=\"submit\" class=\"button\" id=\"Process\" value=\"Xử lý\" />\r\n                                          </td>\r\n                                        </tr>\r\n                                      </table>\r\n                                    </td>\r\n                                  </tr>\r\n                                </table>\r\n                              </form>\r\n                            </td>\r\n                          </tr>\r\n                        </table>\r\n                      </td>\r\n                    </tr>\r\n                  </table>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n            </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"copyright\">\r\n        <tr>\r\n          <td>&copy; 2002 - 2003 Ami Company Limited - - Vuong Phuc Dinh (0540377)</td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n</body>\r\n<!-- InstanceEnd --></html>\r\n".toCharArray();
    }
  }
}
