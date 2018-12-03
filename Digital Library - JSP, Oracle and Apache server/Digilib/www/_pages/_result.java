
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
import digilib.view.Search;


public class _result extends oracle.jsp.runtime.HttpJsp {


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
    _result page = this;
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
      digilib.web.Member curMember;
      if ((curMember = (digilib.web.Member) pageContext.getAttribute( "curMember", PageContext.SESSION_SCOPE)) == null) {
        curMember = (digilib.web.Member) new digilib.web.Member();
        pageContext.setAttribute( "curMember", curMember, PageContext.SESSION_SCOPE);
      }
      out.print(__jsp_StaticText.text[3]);
            	if (curMember.isValidated()) {
      
      out.print(__jsp_StaticText.text[4]);
      out.print( curMember.getName());
      out.print(__jsp_StaticText.text[5]);
            	}
      
      out.print(__jsp_StaticText.text[6]);
      digilib.view.Item curResults;
      if ((curResults = (digilib.view.Item) pageContext.getAttribute( "curResults", PageContext.PAGE_SCOPE)) == null) {
        curResults = (digilib.view.Item) new digilib.view.Item();
        pageContext.setAttribute( "curResults", curResults, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[7]);
      out.print(__jsp_StaticText.text[8]);
      out.print(__jsp_StaticText.text[9]);
            	String sCriteria = "";
      	try {
      		String sSearchCondition = request.getParameter("SearchCondition");
      		String sSearchType = request.getParameter("SearchType");
      		String sSearchContent = request.getParameter("SearchContent");
      		sCriteria = "ITEMNO in ( " + Search.doQuickSearch(sSearchCondition, sSearchType, sSearchContent) + " ) ";
      	} catch (Exception e) {
      		sCriteria = "";
      	}
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
      	curResults.setPageSize(PageSize);
      	curResults.setPage(Page);
      	//out.print(sCriteria);
      	curResults.setCriteria(sCriteria);
      	curResults.open();
      	int totalRecords = curResults.getMaxRows();
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
      	while (curResults.next()) {	
      
      out.print(__jsp_StaticText.text[10]);
      out.print( (i%2==0) ? "ffffff" : "#ffffcc" );
      out.print(__jsp_StaticText.text[11]);
      out.print( i+1 );
      out.print(__jsp_StaticText.text[12]);
      out.print( curResults.getItemNo() );
      out.print(__jsp_StaticText.text[13]);
      out.print( curResults.getPrimaryTitle() );
      out.print(__jsp_StaticText.text[14]);
            	Copy curCopies = curResults.getCopies();
      	curCopies.open();
      	int totalCopies = curCopies.getMaxRows();
      	int availableCopies = 0;
      	while (curCopies.next()) {
      		if (curCopies.getStatus().intValue() == 1) {
      			availableCopies++;
      		}
      	}
      	curCopies.close();
      
      out.print(__jsp_StaticText.text[15]);
      out.print( availableCopies );
      out.print(__jsp_StaticText.text[16]);
      out.print( totalCopies );
      out.print(__jsp_StaticText.text[17]);
            	if (curMember.isValidated()) {
      
      out.print(__jsp_StaticText.text[18]);
      out.print( curResults.getItemNo() );
      out.print(__jsp_StaticText.text[19]);
            	}
      
      out.print(__jsp_StaticText.text[20]);
            		i++;
      	}
      	curResults.close();
      
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
      out.print( Format.formatDisplayString(sCriteria) );
      out.print(__jsp_StaticText.text[27]);
      out.print( Page );
      out.print(__jsp_StaticText.text[28]);
            	for (int ps = 1; ps <= 50; ps++) {
      
      out.print(__jsp_StaticText.text[29]);
      out.print( ps );
      out.print(__jsp_StaticText.text[30]);
      out.print( (ps == PageSize) ? "selected=\"selected\"" : "" );
      out.print(__jsp_StaticText.text[31]);
      out.print( ps );
      out.print(__jsp_StaticText.text[32]);
            	}
      
      out.print(__jsp_StaticText.text[33]);
      out.print( (Page > 1) ? "gotoPage(1);" : "" );
      out.print(__jsp_StaticText.text[34]);
      out.print( (Page > 1) ? "gotoPage(" + (Page-1) + ");" : "" );
      out.print(__jsp_StaticText.text[35]);
      out.print( (Page < totalPages) ? "gotoPage(" + (Page+1) + ");" : "" );
      out.print(__jsp_StaticText.text[36]);
      out.print( (Page < totalPages) ? "gotoPage(" + totalPages + ");" : "" );
      out.print(__jsp_StaticText.text[37]);
            	if (curMember.isValidated()) {
      
      out.print(__jsp_StaticText.text[38]);
            	}
      
      out.print(__jsp_StaticText.text[39]);

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
    private static final char text[][]=new char[40][];
    static {
      text[0] = 
      "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n".toCharArray();
      text[1] = 
      "\r\n".toCharArray();
      text[2] = 
      "\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/1 Cols Base.dwt.jsp\" codeOutsideHTMLIsLocked=\"false\" -->\r\n<head>\r\n<!-- InstanceBeginEditable name=\"doctitle\" -->\r\n<title>D I G I L I B &gt; Search Results</title>\r\n<script language=\"JavaScript\" src=\"search.js\"></script>\r\n<!-- InstanceEndEditable -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\r\n<!-- InstanceBeginEditable name=\"head\" -->\r\n<style type=\"text/css\">\r\n<!--\r\n.style7 {font-size: 24px}\r\n-->\r\n</style>\r\n<style type=\"text/css\">\r\n<!--\r\n.style8 {font-family: Verdana, Arial, Helvetica, sans-serif}\r\n-->\r\n</style>\r\n<style type=\"text/css\">\r\n<!--\r\n.style9 {color: #083908}\r\n-->\r\n</style>\r\n<style type=\"text/css\">\r\n<!--\r\n.style10 {color: #0000FF}\r\n-->\r\n</style>\r\n<!-- InstanceEndEditable -->\r\n<link href=\"/digilib.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n</head>\r\n\r\n<body>\r\n<table width=\"760\" height=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr>\r\n    <td height=\"150\">\r\n      <table width=\"760\" height=\"150\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"150\" rowspan=\"3\" align=\"center\" valign=\"middle\"><img src=\"/images/logo.gif\" width=\"150\" height=\"150\" /></td>\r\n          <td height=\"75\" colspan=\"2\">\r\n            <table width=\"610\" height=\"75\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"middle\">\r\n                  <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\" width=\"500\" height=\"75\">\r\n                    <param name=\"movie\" value=\"/images/banner.swf\" />\r\n                     \r\n                    <param name=\"quality\" value=\"high\" /><param name=\"SCALE\" value=\"noborder\">\r\n                    <embed src=\"/images/banner.swf\" width=\"500\" height=\"75\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" scale=\"noborder\"></embed></object>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td height=\"25\" colspan=\"2\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"4\" cellspacing=\"0\" class=\"navigator\">\r\n              <tr align=\"center\">\r\n                <td><a href=\"/\">digilib.com</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/search.jsp\">Search</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/members/\">Member</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/librarians/\">Librarian</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/feedback.jsp\">Feedback</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/contactus.jsp\">Contact</a></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"300\" height=\"50\">\r\n            <table width=\"300\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"HeaderImage\" --><span class=\"style9 style8 style7\"><em>Search Results</em></span><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"310\">\r\n            <table width=\"310\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"right\"><!-- InstanceBeginEditable name=\"Validation\" -->\r\n                  ".toCharArray();
      text[3] = 
      "\r\n".toCharArray();
      text[4] = 
      "\t\t\t\t  \r\n                  <form name=\"form1\" id=\"form1\" method=\"post\" action=\"\">\r\n                    <table width=\"310\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td align=\"right\">Member<strong>\r\n                          ".toCharArray();
      text[5] = 
      "\r\n                          </strong>\r\n                        </td>\r\n                        <td width=\"75\" align=\"center\">\r\n                          <input name=\"Logout\" type=\"submit\" class=\"button\" id=\"Logout\" value=\"Logout\" />\r\n                        </td>\r\n                      </tr>\r\n                    </table>\r\n                  </form>\r\n".toCharArray();
      text[6] = 
      "\t\t\t\t  \r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"100%\" valign=\"top\">\r\n      <table width=\"760\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"160\" height=\"100%\" valign=\"top\">\r\n            <table width=\"160\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"top\">\r\n                  <!-- InstanceBeginEditable name=\"LeftMenu\" -->\r\n                  <table width=\"150\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\"><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Online Search </td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/search.jsp?searchtype=quick\">Quick Search</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/search.jsp?searchtype=advanced\">Advanced Searcht</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Are you member?</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><span class=\"style2\"><a href=\"members/registrationform.jsp\">Register Now</a></span></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Member</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/members/profile.jsp\">Profile</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/members/transactions.jsp\">Chi tiết các nghiệp vụ</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><span class=\"style10\"><a href=\"members/histories.jsp\">History of Transaction</a></span></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Feedback</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/feedback.jsp\">Feedback</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td>&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/contactus.jsp\">Contact us</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                  </table>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"600\" height=\"100%\" valign=\"top\">\r\n            <table width=\"600\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"MainContent\" --> <span id=\"Result\"> \r\n                  <table width=\"590\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"display: inline;\">\r\n                    <tr>\r\n                      <td width=\"10\"><img src=\"/images/lefttop_curve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td width=\"430\" bgcolor=\"#663300\" class=\"headline\">Search Results </td>\r\n                      <td width=\"150\"><img src=\"/images/headline_trailer.gif\" width=\"150\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td colspan=\"3\">\r\n                        <table width=\"580\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                          <tr>\r\n                            <td>\r\n                              <form action=\"/process/bookings.jsp?action=add\" method=\"post\" name=\"SearchResultForm\" id=\"SearchResultForm\">\r\n                                <table width=\"580\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                  <tr>\r\n                                    <td width=\"10\"><img src=\"/images/news_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                    <td width=\"30\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">#</td>\r\n                                    <td width=\"440\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Resources</td>\r\n                                    <td width=\"60\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">on-stock</td>\r\n                                    <td width=\"30\" align=\"right\" bgcolor=\"#083908\" class=\"headline\">\r\n                                      <input name=\"SelectAll\" type=\"checkbox\" id=\"SelectAll\" onclick=\"doSelectAll();\" />\r\n                                    </td>\r\n                                    <td width=\"10\"><img src=\"/images/news_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                  </tr>\r\n                                  <tr>\r\n                                    <td colspan=\"6\">\r\n                                      <table width=\"580\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid;\">\r\n                                        ".toCharArray();
      text[7] = 
      "\r\n".toCharArray();
      text[8] = 
      "\r\n".toCharArray();
      text[9] = 
      "\r\n".toCharArray();
      text[10] = 
      "\t\t\t\t\t\t\t\t\t\r\n                                        <tr bgcolor=\"".toCharArray();
      text[11] = 
      "\">\r\n                                          <td width=\"30\" align=\"right\" style=\"border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">".toCharArray();
      text[12] = 
      "</td>\r\n                                          <td width=\"445\" style=\"border-right: #999999 1px solid; border-bottom: #999999 1px solid;\"><a href=\"details.jsp?itemno=".toCharArray();
      text[13] = 
      "\">".toCharArray();
      text[14] = 
      " </a></td>\r\n".toCharArray();
      text[15] = 
      "\t\t\t\t\t\t\t\t\t\t  \r\n                                          <td width=\"50\" align=\"right\" style=\"border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">".toCharArray();
      text[16] = 
      " / ".toCharArray();
      text[17] = 
      "</td>\r\n                                          <td width=\"30\" align=\"center\" style=\"border-bottom: #999999 1px solid;\"> \r\n                                            ".toCharArray();
      text[18] = 
      "\t\t\t\t\t\t\t\t\t\t  \r\n                                            <input name=\"accepted\" type=\"checkbox\" id=\"accepted\" value=\"".toCharArray();
      text[19] = 
      "\" />\r\n                                            ".toCharArray();
      text[20] = 
      "&nbsp;\r\n                                          </td>\r\n                                        </tr>\r\n".toCharArray();
      text[21] = 
      "\t\t\t\t\t\t\t\t\t  \r\n                                      </table>\r\n                                    </td>\r\n                                  </tr>\r\n                                  <tr>\r\n                                    <td colspan=\"6\">\r\n                                      <table width=\"580\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"5\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr>\r\n                                          <td width=\"175\">Mẩu tin \r\n                                            ".toCharArray();
      text[22] = 
      "\r\n                                             - \r\n                                            ".toCharArray();
      text[23] = 
      "\r\n                                             / \r\n                                            ".toCharArray();
      text[24] = 
      "\r\n                                             mẩu tin<br />\r\nTrang \r\n                                            ".toCharArray();
      text[25] = 
      "\r\n                                             / \r\n                                            ".toCharArray();
      text[26] = 
      "\r\n                                             trang</td>\r\n                                          <td align=\"center\">\r\n                                            <input name=\"filter\" type=\"hidden\" id=\"filter\" value=\"".toCharArray();
      text[27] = 
      "\" />\r\n                                                                                        <input name=\"page\" type=\"hidden\" id=\"page\" value=\"".toCharArray();
      text[28] = 
      "\" />\r\n                                            Giới hạn \r\n                                            <select name=\"pagesize\" class=\"listbox\" id=\"pagesize\" onchange=\"setPageSize();\">\r\n                                              ".toCharArray();
      text[29] = 
      "\r\n                                              \t\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t\t\t\r\n                                              <option value=\"".toCharArray();
      text[30] = 
      "\" ".toCharArray();
      text[31] = 
      ">\r\n                                              ".toCharArray();
      text[32] = 
      "\r\n                                              </option>\r\n                                              ".toCharArray();
      text[33] = 
      "\r\n                                              \t\t\t\t\t\t\t\t\t\t\t\t\r\n                                            </select>\r\n                                             mẩu tin / trang</td>\r\n                                          <td width=\"175\" align=\"right\">\r\n\t\t\t\t\t\t\t\t\t\t  \t<img src=\"/images/movefirst_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[34] = 
      "\" /> \r\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"/images/moveprevious_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[35] = 
      "\" /> \r\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"/images/movenext_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[36] = 
      "\" /> \r\n\t\t\t\t\t\t\t\t\t\t\t<img src=\"/images/movelast_up.gif\" width=\"20\" height=\"10\" class=\"picbutton\" onclick=\"".toCharArray();
      text[37] = 
      "\" /></td>\r\n                                        </tr>\r\n                                      </table>\r\n                                    </td>\r\n                                  </tr>\r\n".toCharArray();
      text[38] = 
      "\t\t\t\t\t\t\t\t\t\t\t\r\n                                  <tr>\r\n                                    <td colspan=\"6\">\r\n                                      <table width=\"580\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr>\r\n                                          <td align=\"center\">                                            \r\n                                            <input name=\"Book\" type=\"submit\" class=\"button\" id=\"Book\" value=\"Booking\" />\r\n                                          </td>\r\n                                        </tr>\r\n                                      </table>\r\n                                    </td>\r\n                                  </tr>\r\n".toCharArray();
      text[39] = 
      "\t\t\t\t\t\t\t\t\t\t\t\r\n                                </table>\r\n                                                                </form>                              \r\n                              <script language=\"JavaScript\" type=\"text/javascript\">\r\nshowResult();\r\n</script>\r\n\t\t\t\t\t\t\t</td>\r\n                          </tr>\r\n                        </table>\r\n                        </td>\r\n                    </tr>\r\n                  </table>\r\n\t\t\t\t</span>\r\n<!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n            </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"copyright\">\r\n        <tr>\r\n          <td>&copy; 2004 - 2005  Vuong Phuc Dinh (010300022102)</td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n</body>\r\n<!-- InstanceEnd --></html>\r\n".toCharArray();
    }
  }
}
