package _images;

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


public class _member extends oracle.jsp.runtime.HttpJsp {


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
    _member page = this;
    ServletConfig config = pageContext.getServletConfig();

    try {
      // global beans
      // end global beans


      out.print(__jsp_StaticText.text[0]);
      digilib.view.Member MList;
      if ((MList = (digilib.view.Member) pageContext.getAttribute( "MList", PageContext.PAGE_SCOPE)) == null) {
        MList = (digilib.view.Member) new digilib.view.Member();
        pageContext.setAttribute( "MList", MList, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[1]);
              response.setHeader("Cache-control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);
        String sMemberID = "";
        try {
          sMemberID = request.getParameter("memberid").trim();
        }
        catch (Exception e) {}
        MList.setCriteria("MEMBERID = '" + sMemberID + "'");
        MList.open();
        try {
          if (MList.next()) {
            response.setContentType(MList.getPictureType());
            response.getOutputStream().write(MList.getPicture());
          }
        }
        catch (Exception e) { }
        MList.close();
      

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
    private static final char text[][]=new char[2][];
    static {
      text[0] = 
      "﻿".toCharArray();
      text[1] = 
      "\r\n".toCharArray();
    }
  }
}
