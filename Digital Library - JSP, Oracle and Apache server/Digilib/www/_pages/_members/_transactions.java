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
import digilib.view.BookingDetail;
import digilib.view.ExpansionDetail;


public class _transactions extends oracle.jsp.runtime.HttpJsp {


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
    _transactions page = this;
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
            	} else {
      		response.sendRedirect("/members/?src=" + request.getRequestURI());
      	}
      
      out.print(__jsp_StaticText.text[6]);
      digilib.view.Booking curBooking;
      if ((curBooking = (digilib.view.Booking) pageContext.getAttribute( "curBooking", PageContext.PAGE_SCOPE)) == null) {
        curBooking = (digilib.view.Booking) new digilib.view.Booking();
        pageContext.setAttribute( "curBooking", curBooking, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[7]);
            	curBooking.setCriteria("MEMBERID = '" + curMember.getMemberID() + "' AND STATUS = 1");
      	curBooking.open();
      	if (curBooking.next()) {
      
      out.print(__jsp_StaticText.text[8]);
      out.print( curBooking.getDocumentNo() );
      out.print(__jsp_StaticText.text[9]);
      out.print( Format.formatShortDate(curBooking.getDocumentDate()) );
      out.print(__jsp_StaticText.text[10]);
      out.print(__jsp_StaticText.text[11]);
            	BookingDetail curDetails = curBooking.getDetails();
      	curDetails.open();
      	int i = 0;
      	while (curDetails.next()) {
      
      out.print(__jsp_StaticText.text[12]);
      out.print( (i%2==0) ? "#ffffff" : "#ffffcc" );
      out.print(__jsp_StaticText.text[13]);
      out.print( i+1 );
      out.print(__jsp_StaticText.text[14]);
      out.print( curDetails.getPrimaryTitle() );
      out.print(__jsp_StaticText.text[15]);
      out.print( Format.formatShortDate(curDetails.getDetailDate()) );
      out.print(__jsp_StaticText.text[16]);
            		i++;
      	}
      	curDetails.close();
      
      out.print(__jsp_StaticText.text[17]);
      out.print( curBooking.getDocumentNo() );
      out.print(__jsp_StaticText.text[18]);
            	}
      	curBooking.close();
      
      out.print(__jsp_StaticText.text[19]);
      digilib.view.Expansion curExpansion;
      if ((curExpansion = (digilib.view.Expansion) pageContext.getAttribute( "curExpansion", PageContext.PAGE_SCOPE)) == null) {
        curExpansion = (digilib.view.Expansion) new digilib.view.Expansion();
        pageContext.setAttribute( "curExpansion", curExpansion, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[20]);
            	curExpansion.setCriteria("MEMBERID = '" + curMember.getMemberID() + "' AND STATUS = 1");
      	curExpansion.open();
      	if (curExpansion.next()) {
      
      out.print(__jsp_StaticText.text[21]);
      out.print( curExpansion.getDocumentNo() );
      out.print(__jsp_StaticText.text[22]);
      out.print( Format.formatShortDate(curExpansion.getDocumentDate()) );
      out.print(__jsp_StaticText.text[23]);
      out.print(__jsp_StaticText.text[24]);
            	ExpansionDetail curEDetails = curExpansion.getDetails();
      	curEDetails.open();
      	int ie = 0;
      	while (curEDetails.next()) {
      
      out.print(__jsp_StaticText.text[25]);
      out.print( (ie%2==0) ? "#ffffff" : "#ffffcc" );
      out.print(__jsp_StaticText.text[26]);
      out.print( ie+1 );
      out.print(__jsp_StaticText.text[27]);
      out.print( curEDetails.getPrimaryTitle() );
      out.print(__jsp_StaticText.text[28]);
      out.print( Format.formatShortDate(curEDetails.getDetailDate()) );
      out.print(__jsp_StaticText.text[29]);
            		ie++;
      	}
      	curEDetails.close();
      
      out.print(__jsp_StaticText.text[30]);
      out.print( curExpansion.getDocumentNo() );
      out.print(__jsp_StaticText.text[31]);
            	}
      	curExpansion.close();
      
      out.print(__jsp_StaticText.text[32]);
      digilib.view.BookingList curBookingList;
      if ((curBookingList = (digilib.view.BookingList) pageContext.getAttribute( "curBookingList", PageContext.PAGE_SCOPE)) == null) {
        curBookingList = (digilib.view.BookingList) new digilib.view.BookingList();
        pageContext.setAttribute( "curBookingList", curBookingList, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[33]);
      digilib.view.WaitingList curWaitingList;
      if ((curWaitingList = (digilib.view.WaitingList) pageContext.getAttribute( "curWaitingList", PageContext.PAGE_SCOPE)) == null) {
        curWaitingList = (digilib.view.WaitingList) new digilib.view.WaitingList();
        pageContext.setAttribute( "curWaitingList", curWaitingList, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[34]);
            	curBookingList.setCriteria("MEMBERID = '" + curMember.getMemberID() + "'");
      	curBookingList.open();
      	int bi = 0;
      	while (curBookingList.next()) {
      
      out.print(__jsp_StaticText.text[35]);
      out.print( (bi%2==0) ? "ffffff" : "#ffffcc" );
      out.print(__jsp_StaticText.text[36]);
      out.print( curBookingList.getPrimaryTitle() );
      out.print(__jsp_StaticText.text[37]);
            		bi++;
      	}
      	curBookingList.close();
      	curWaitingList.setCriteria("MEMBERID = '" + curMember.getMemberID() + "'");
      	curWaitingList.open();
      	while (curWaitingList.next()) {
      
      out.print(__jsp_StaticText.text[38]);
      out.print( (bi%2==0) ? "ffffff" : "#ffffcc" );
      out.print(__jsp_StaticText.text[39]);
      out.print( curWaitingList.getPrimaryTitle() );
      out.print(__jsp_StaticText.text[40]);
            		bi++;
      	}
      	curWaitingList.close();
      
      out.print(__jsp_StaticText.text[41]);
      digilib.view.LoanList curLoanList;
      if ((curLoanList = (digilib.view.LoanList) pageContext.getAttribute( "curLoanList", PageContext.PAGE_SCOPE)) == null) {
        curLoanList = (digilib.view.LoanList) new digilib.view.LoanList();
        pageContext.setAttribute( "curLoanList", curLoanList, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[42]);
      digilib.view.LoanOverdueList curLoanOverdueList;
      if ((curLoanOverdueList = (digilib.view.LoanOverdueList) pageContext.getAttribute( "curLoanOverdueList", PageContext.PAGE_SCOPE)) == null) {
        curLoanOverdueList = (digilib.view.LoanOverdueList) new digilib.view.LoanOverdueList();
        pageContext.setAttribute( "curLoanOverdueList", curLoanOverdueList, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[43]);
            	curLoanList.setCriteria("MEMBERID = '" + curMember.getMemberID() + "'");
      	curLoanList.open();
      	int li = 0;
      	Date now = new Date();
      	while (curLoanList.next()) {
      
      out.print(__jsp_StaticText.text[44]);
      out.print( (li%2==0) ?"ffffff" : "#ffffcc" );
      out.print(__jsp_StaticText.text[45]);
      out.print( li+1 );
      out.print(__jsp_StaticText.text[46]);
      out.print( curLoanList.getPrimaryTitle() );
      out.print(__jsp_StaticText.text[47]);
      out.print( Format.formatShortDate(curLoanList.getTransactionDate()) );
      out.print(__jsp_StaticText.text[48]);
      out.print( Format.formatShortDate(curLoanList.getDueDate()) );
      out.print(__jsp_StaticText.text[49]);
            	if (curLoanList.getDueDate().compareTo(now) == 0) {
      
      out.print(__jsp_StaticText.text[50]);
      out.print( curLoanList.getTransactionNo() );
      out.print(__jsp_StaticText.text[51]);
            	} else {
      
      out.print(__jsp_StaticText.text[52]);
            	}
      
      out.print(__jsp_StaticText.text[53]);
            		li++;
      	}
      	curLoanList.close();
      	curLoanOverdueList.setCriteria("MEMBERID = '" + curMember.getMemberID() + "'");
      	curLoanOverdueList.open();
      	while (curLoanOverdueList.next()) {
      
      out.print(__jsp_StaticText.text[54]);
      out.print( (li%2==0) ?"ffffff" : "#ffffcc" );
      out.print(__jsp_StaticText.text[55]);
      out.print( li+1 );
      out.print(__jsp_StaticText.text[56]);
      out.print( curLoanOverdueList.getPrimaryTitle() );
      out.print(__jsp_StaticText.text[57]);
      out.print( Format.formatShortDate(curLoanOverdueList.getTransactionDate()) );
      out.print(__jsp_StaticText.text[58]);
      out.print( Format.formatShortDate(curLoanOverdueList.getDueDate()) );
      out.print(__jsp_StaticText.text[59]);
      out.print( curLoanOverdueList.getTransactionNo() );
      out.print(__jsp_StaticText.text[60]);
            		li++;
      	}
      	curLoanOverdueList.close();
      
      out.print(__jsp_StaticText.text[61]);

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
    private static final char text[][]=new char[62][];
    static {
      text[0] = 
      "﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n".toCharArray();
      text[1] = 
      "\r\n".toCharArray();
      text[2] = 
      "\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\"><!-- InstanceBegin template=\"/Templates/1 Cols Base.dwt.jsp\" codeOutsideHTMLIsLocked=\"false\" -->\r\n<head>\r\n<!-- InstanceBeginEditable name=\"doctitle\" -->\r\n<title>D I G I L I B &gt; Độc giả &gt; Chi tiết các nghiệp vụ</title>\r\n<script language=\"JavaScript\" src=\"transactions.js\"></script>\r\n<!-- InstanceEndEditable -->\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n\r\n<!-- InstanceBeginEditable name=\"head\" --><!-- InstanceEndEditable -->\r\n<link href=\"/digilib.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n</head>\r\n\r\n<body>\r\n<table width=\"760\" height=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr>\r\n    <td height=\"150\">\r\n      <table width=\"760\" height=\"150\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"150\" rowspan=\"3\" align=\"center\" valign=\"middle\"><img src=\"/images/logo.gif\" width=\"150\" height=\"150\" /></td>\r\n          <td height=\"75\" colspan=\"2\">\r\n            <table width=\"610\" height=\"75\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"middle\">\r\n                  <object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0\" width=\"500\" height=\"75\">\r\n                    <param name=\"movie\" value=\"/images/banner.swf\" />\r\n                     \r\n                    <param name=\"quality\" value=\"high\" /><param name=\"SCALE\" value=\"noborder\">\r\n                    <embed src=\"/images/banner.swf\" width=\"500\" height=\"75\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\" scale=\"noborder\"></embed></object>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td height=\"25\" colspan=\"2\">\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"4\" cellspacing=\"0\" class=\"navigator\">\r\n              <tr align=\"center\">\r\n                <td><a href=\"/\">digilib.com</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/search.jsp\">Thư mục</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/members/\">Độc giả</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/librarians/\">Thủ thư</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/feedback.jsp\">Góp ý</a></td>\r\n                <td>•</td>\r\n                <td><a href=\"/contactus.jsp\">Liên hệ</a></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td width=\"300\" height=\"50\">\r\n            <table width=\"300\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"HeaderImage\" --><img src=\"/images/header_membertransactions.gif\" width=\"300\" height=\"50\" /><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"310\">\r\n            <table width=\"310\" height=\"50\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr>\r\n                <td align=\"right\"><!-- InstanceBeginEditable name=\"Validation\" --><!-- #BeginLibraryItem \"/Library/Member's Validation.lbi\" -->\r\n                  ".toCharArray();
      text[3] = 
      "\r\n                  ".toCharArray();
      text[4] = 
      "\r\n                  \t\t\t\t  \r\n                  <form name=\"LogoutForm\" id=\"LogoutForm\" method=\"post\" action=\"/process/members.jsp?action=logout\">\r\n                    <table width=\"310\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td align=\"right\">Độc giả <strong>\r\n                          ".toCharArray();
      text[5] = 
      "\r\n                          </strong></td><td width=\"75\" align=\"center\">\r\n                          <input name=\"Logout\" type=\"submit\" class=\"button\" id=\"Logout\" value=\"Thoát\" />\r\n                        </td></tr>\r\n                    </table></form>".toCharArray();
      text[6] = 
      "\r\n                  \t\t\t\t  \r\n                                    <!-- #EndLibraryItem --><!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"100%\" valign=\"top\">\r\n      <table width=\"760\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr>\r\n          <td width=\"160\" height=\"100%\" valign=\"top\">\r\n            <table width=\"160\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\">\r\n              <tr>\r\n                <td align=\"center\" valign=\"top\">\r\n                  <!-- InstanceBeginEditable name=\"LeftMenu\" -->\r\n                  <table width=\"150\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\"><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Thư mục trưc tuyến</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/search.jsp?searchtype=quick\">Tra cứu nhanh</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/search.jsp?searchtype=advanced\">Tra cứu chi tiết</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Độc giả</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"profile.jsp\">Hồ sơ cá nhân</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"#\">Chi tiết các nghiệp vụ</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"histories.jsp\">Lịch sử các nghiệp vụ</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td><img src=\"/images/action_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                      <td colspan=\"2\" align=\"center\" bgcolor=\"#c2a366\" class=\"headline\">Phản hồi</td>\r\n                      <td valign=\"bottom\"><img src=\"/images/action_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/feedback.jsp\">Góp ý</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\"><a href=\"/contactus.jsp\">Liên hệ</a></td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\"><img src=\"/images/leftmenu_bullet.gif\" width=\"10\" height=\"10\" /></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td width=\"10\">&nbsp;</td>\r\n                      <td width=\"125\" align=\"right\">&nbsp;</td>\r\n                      <td width=\"5\">&nbsp;</td>\r\n                      <td width=\"10\" valign=\"bottom\">&nbsp;</td>\r\n                    </tr>\r\n                    \r\n                    \r\n                  </table>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n          </td>\r\n          <td width=\"600\" height=\"100%\" valign=\"top\">\r\n            <table width=\"600\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n              <tr>\r\n                <td><!-- InstanceBeginEditable name=\"MainContent\" -->\r\n                  ".toCharArray();
      text[7] = 
      "\r\n                  ".toCharArray();
      text[8] = 
      "\r\n                  <form name=\"BookingForm\" id=\"BookingForm\" method=\"post\" action=\"/process/bookings.jsp?action=post\">\r\n                    <table width=\"590\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td width=\"10\"><img src=\"/images/lefttop_curve.gif\" width=\"10\" height=\"20\" /></td>\r\n                        <td width=\"430\" bgcolor=\"#663300\" class=\"headline\">Chi tiết phiếu đăng ký số : ".toCharArray();
      text[9] = 
      " - Lập ngày :\r\n                          ".toCharArray();
      text[10] = 
      "\r\n                        </td>\r\n                        <td width=\"150\"><img src=\"/images/headline_trailer.gif\" width=\"150\" height=\"20\" /></td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td colspan=\"3\">\r\n                          <table width=\"590\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                            <tr>\r\n                              <td>\r\n                                <table width=\"580\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                  <tr>\r\n                                    <td width=\"10\"><img src=\"/images/news_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                    <td width=\"30\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">#</td>\r\n                                    <td width=\"450\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Tài liệu</td>\r\n                                    <td width=\"80\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Đăng ký ngày</td>\r\n                                    <td width=\"10\"><img src=\"/images/news_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                  </tr>\r\n                                  <tr>\r\n                                    <td colspan=\"5\">\r\n                                      ".toCharArray();
      text[11] = 
      "\r\n                                      ".toCharArray();
      text[12] = 
      "\r\n                                      \t\t\t\t\t\t\t  \r\n                                      <table width=\"580\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"".toCharArray();
      text[13] = 
      "\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr>\r\n                                          <td width=\"30\" align=\"right\" style=\"border-right: #999999 1px solid;\">".toCharArray();
      text[14] = 
      "</td>\r\n                                          <td width=\"450\" style=\"border-right: #999999 1px solid;\">".toCharArray();
      text[15] = 
      "</td>\r\n                                          <td width=\"80\">".toCharArray();
      text[16] = 
      "</td>\r\n                                        </tr>\r\n                                      </table>\r\n                                      ".toCharArray();
      text[17] = 
      "\r\n                                      \t\t\t\t\t\t\t\t\r\n                                    </td>\r\n                                  </tr>\r\n                                </table>\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td align=\"center\">\r\n                                <input name=\"accepted\" type=\"hidden\" id=\"accepted\" value=\"".toCharArray();
      text[18] = 
      "\" />\r\n                                <input name=\"Post\" type=\"submit\" class=\"button\" id=\"Post\" value=\"Chuyển cho Thủ thư\" />\r\n                              </td>\r\n                            </tr>\r\n                          </table>\r\n                        </td>\r\n                      </tr>\r\n                    </table>\r\n                  </form>\r\n                  ".toCharArray();
      text[19] = 
      "\r\n                  ".toCharArray();
      text[20] = 
      "\r\n                  ".toCharArray();
      text[21] = 
      "\r\n                  <form name=\"ExpansionForm\" id=\"ExpansionForm\" method=\"post\" action=\"/process/expansions.jsp?action=post\">\r\n                    <table width=\"590\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td width=\"10\"><img src=\"/images/lefttop_curve.gif\" width=\"10\" height=\"20\" /></td>\r\n                        <td width=\"430\" bgcolor=\"#663300\" class=\"headline\">Chi tiết phiếu gia hạn số : ".toCharArray();
      text[22] = 
      " - Lập ngày :\r\n                          ".toCharArray();
      text[23] = 
      "\r\n                        </td>\r\n                        <td width=\"150\"><img src=\"/images/headline_trailer.gif\" width=\"150\" height=\"20\" /></td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td colspan=\"3\">\r\n                          <table width=\"590\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                            <tr>\r\n                              <td>\r\n                                <table width=\"580\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                  <tr>\r\n                                    <td width=\"10\"><img src=\"/images/news_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                    <td width=\"30\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">#</td>\r\n                                    <td width=\"450\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Tài liệu</td>\r\n                                    <td width=\"80\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Gia hạn ngày</td>\r\n                                    <td width=\"10\"><img src=\"/images/news_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                  </tr>\r\n                                  <tr>\r\n                                    <td colspan=\"5\">\r\n                                      ".toCharArray();
      text[24] = 
      "\r\n                                      ".toCharArray();
      text[25] = 
      "\r\n                                      \t\t\t\t\t\t\t  \r\n                                      <table width=\"580\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"".toCharArray();
      text[26] = 
      "\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr>\r\n                                          <td width=\"30\" align=\"right\" style=\"border-right: #999999 1px solid;\">".toCharArray();
      text[27] = 
      "</td>\r\n                                          <td width=\"450\" style=\"border-right: #999999 1px solid;\">".toCharArray();
      text[28] = 
      "</td>\r\n                                          <td width=\"80\">".toCharArray();
      text[29] = 
      "</td>\r\n                                        </tr>\r\n                                      </table>\r\n                                      ".toCharArray();
      text[30] = 
      "\r\n                                      \t\t\t\t\t\t\t\t\r\n                                    </td>\r\n                                  </tr>\r\n                                </table>\r\n                              </td>\r\n                            </tr>\r\n                            <tr>\r\n                              <td align=\"center\">\r\n                                <input name=\"accepted\" type=\"hidden\" id=\"accepted\" value=\"".toCharArray();
      text[31] = 
      "\" />\r\n                                <input name=\"Post\" type=\"submit\" class=\"button\" id=\"Post\" value=\"Chuyển cho Thủ thư\" />\r\n                              </td>\r\n                            </tr>\r\n                          </table>\r\n                        </td>\r\n                      </tr>\r\n                    </table>\r\n                  </form>\r\n                  ".toCharArray();
      text[32] = 
      "\r\n                  <form name=\"BookingListForm\" id=\"BookingListForm\" method=\"post\" action=\"/process/bookinglist.jsp?action=remove\">\r\n                    <table width=\"590\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td width=\"10\"><img src=\"/images/lefttop_curve.gif\" width=\"10\" height=\"20\" /></td>\r\n                        <td width=\"430\" bgcolor=\"#663300\" class=\"headline\">Các yêu cầu đã gởi cho Thủ thư</td>\r\n                        <td width=\"150\"><img src=\"/images/headline_trailer.gif\" width=\"150\" height=\"20\" /></td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td colspan=\"3\">\r\n                          <table width=\"590\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                            <tr>\r\n                              <td>\r\n                                <table width=\"580\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                  <tr>\r\n                                    <td width=\"10\"><img src=\"/images/news_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                    <td width=\"30\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">#</td>\r\n                                    <td width=\"430\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Tài liệu</td>\r\n                                    <td width=\"100\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Trạng thái</td>\r\n                                    <td width=\"10\"><img src=\"/images/news_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                  </tr>\r\n                                  <tr>\r\n                                    <td colspan=\"5\">\r\n                                      ".toCharArray();
      text[33] = 
      "\r\n                                      ".toCharArray();
      text[34] = 
      "\r\n                                      ".toCharArray();
      text[35] = 
      "\r\n                                      <table width=\"580\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"".toCharArray();
      text[36] = 
      "\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr>\r\n                                          <td width=\"30\" align=\"center\" style=\"border-right: #999999 1px solid;\"><img src=\"/images/remove_up.gif\" width=\"10\" height=\"10\" class=\"picbutton\" /></td>\r\n                                          <td width=\"450\" style=\"border-right: #999999 1px solid;\">".toCharArray();
      text[37] = 
      "</td>\r\n                                          <td width=\"100\" align=\"center\">Đã chấp thuận</td>\r\n                                        </tr>\r\n                                      </table>\r\n                                      ".toCharArray();
      text[38] = 
      "\r\n                                      <table width=\"580\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"".toCharArray();
      text[39] = 
      "\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr>\r\n                                          <td width=\"30\" align=\"center\" style=\"border-right: #999999 1px solid;\"><img src=\"/images/remove_up.gif\" width=\"10\" height=\"10\" class=\"picbutton\" /></td>\r\n                                          <td width=\"450\" style=\"border-right: #999999 1px solid;\">\r\n                                            ".toCharArray();
      text[40] = 
      "\r\n                                          </td>\r\n                                          <td width=\"100\" align=\"center\">Đang chờ</td>\r\n                                        </tr>\r\n                                      </table>\r\n".toCharArray();
      text[41] = 
      "\t\t\t\t\t\t\t\t\t  \r\n                                                                          </td>\r\n                                  </tr>\r\n                                </table>\r\n                              </td>\r\n                            </tr>\r\n                          </table>\r\n                        </td>\r\n                      </tr>\r\n                    </table>\r\n                  </form>\r\n                  <form name=\"ExpansionForm\" id=\"ExpansionForm\" method=\"post\" action=\"/process/expansions.jsp?action=add\" onsubmit=\"return checkData();\">\r\n                    <table width=\"590\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td width=\"10\"><img src=\"/images/lefttop_curve.gif\" width=\"10\" height=\"20\" /></td>\r\n                        <td width=\"430\" bgcolor=\"#663300\" class=\"headline\">Tài liệu đang mượn</td>\r\n                        <td width=\"150\"><img src=\"/images/headline_trailer.gif\" width=\"150\" height=\"20\" /></td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td colspan=\"3\">\r\n                          <table width=\"590\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                            <tr>\r\n                              <td>\r\n                                <table width=\"580\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                  <tr>\r\n                                    <td width=\"10\"><img src=\"/images/news_leftcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                    <td width=\"30\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">#</td>\r\n                                    <td width=\"300\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Tài liệu</td>\r\n                                    <td width=\"100\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Ngày mượn</td>\r\n                                    <td width=\"100\" align=\"center\" bgcolor=\"#083908\" class=\"headline\">Hạn trả</td>\r\n                                    <td width=\"30\" align=\"right\" bgcolor=\"#083908\" class=\"headline\">\r\n                                      <input name=\"SelectAll\" type=\"checkbox\" id=\"SelectAll\" onclick=\"doSelectAll();\" />\r\n                                    </td>\r\n                                    <td width=\"10\"><img src=\"/images/news_rightcurve.gif\" width=\"10\" height=\"20\" /></td>\r\n                                  </tr>\r\n                                  <tr>\r\n                                    <td colspan=\"7\">\r\n                                      ".toCharArray();
      text[42] = 
      "\r\n                                      ".toCharArray();
      text[43] = 
      "\r\n                                      ".toCharArray();
      text[44] = 
      "\r\n                                    \t\t\t\t\t\t\t\t  \r\n                                      <table width=\"580\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"".toCharArray();
      text[45] = 
      "\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr>\r\n                                          <td width=\"30\" align=\"right\" style=\"border-right: #999999 1px solid;\">\r\n                                            ".toCharArray();
      text[46] = 
      "\r\n                                          </td>\r\n                                          <td width=\"320\" style=\"border-right: #999999 1px solid;\">\r\n                                            ".toCharArray();
      text[47] = 
      "\r\n                                          </td>\r\n                                          <td width=\"100\" align=\"center\" style=\"border-right: #999999 1px solid;\">\r\n                                            ".toCharArray();
      text[48] = 
      "\r\n                                          </td>\r\n                                          <td width=\"100\" align=\"center\" style=\"border-right: #999999 1px solid;\">\r\n                                            ".toCharArray();
      text[49] = 
      "\r\n                                            </font></td>\r\n                                          <td width=\"30\" align=\"center\">\r\n                                            ".toCharArray();
      text[50] = 
      "\r\n                                            \t\t\t\t\t\t\t\t\t\t  \r\n                                            <input name=\"accepted\" type=\"checkbox\" id=\"accepted\" value=\"".toCharArray();
      text[51] = 
      "\" />\r\n                                            ".toCharArray();
      text[52] = 
      "\r\n                                            \t<img src=\"/images/spacer.gif\" width=\"25\" height=\"1\" />\t\r\n                                            ".toCharArray();
      text[53] = 
      "\r\n                                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n                                          </td>\r\n                                        </tr>\r\n                                      </table>\r\n                                      ".toCharArray();
      text[54] = 
      "\r\n                                      <table width=\"580\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"".toCharArray();
      text[55] = 
      "\" style=\"border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;\">\r\n                                        <tr>\r\n                                          <td width=\"30\" align=\"right\" style=\"border-right: #999999 1px solid;\">\r\n                                            ".toCharArray();
      text[56] = 
      "\r\n                                          </td>\r\n                                          <td width=\"320\" style=\"border-right: #999999 1px solid;\">\r\n                                            ".toCharArray();
      text[57] = 
      "\r\n                                          </td>\r\n                                          <td width=\"100\" align=\"center\" style=\"border-right: #999999 1px solid;\">\r\n                                            ".toCharArray();
      text[58] = 
      "\r\n                                          </td>\r\n                                          <td width=\"100\" align=\"center\" style=\"border-right: #999999 1px solid;\"><font color=\"#ff0000\">\r\n                                            ".toCharArray();
      text[59] = 
      "\r\n                                            </font></td>\r\n                                          <td width=\"30\" align=\"center\">\r\n                                            <input name=\"accepted\" type=\"checkbox\" id=\"accepted\" value=\"".toCharArray();
      text[60] = 
      "\" />\r\n                                          </td>\r\n                                        </tr>\r\n                                      </table>\r\n                                      ".toCharArray();
      text[61] = 
      "\r\n                                                                                                                \t\t\t\t\t\t\t\t\t\r\n                                  </td>\r\n                                  </tr>\r\n                                  <tr>\r\n                                    <td colspan=\"7\">\r\n                                      <table width=\"580\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                                        <tr>\r\n                                          <td align=\"center\">\r\n                                            <input name=\"Post\" type=\"submit\" class=\"button\" id=\"Post\" value=\"Gia hạn\" />\r\n                                          </td>\r\n                                        </tr>\r\n                                      </table>\r\n                                    </td>\r\n                                  </tr>\r\n                                </table>\r\n                              </td>\r\n                            </tr>\r\n                          </table>\r\n                        </td>\r\n                      </tr>\r\n                    </table>\r\n                  </form>\r\n                  <!-- InstanceEndEditable --></td>\r\n              </tr>\r\n            </table>\r\n            </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"5\" class=\"copyright\">\r\n        <tr>\r\n          <td>&copy; 2002 - 2003 Ami Company Limited - - Vuong Phuc Dinh (0540377)</td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n</body>\r\n<!-- InstanceEnd --></html>\r\n".toCharArray();
    }
  }
}
