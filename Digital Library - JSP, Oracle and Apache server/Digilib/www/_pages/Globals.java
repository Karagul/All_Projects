
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


import oracle.jsp.event.*;
import oracle.jsp.runtime.OraclePageContext;


public class Globals implements oracle.jsp.event.SessionListener, oracle.jsp.event.ApplicationListener {




  // ** Begin Declarations


  // ** End Declarations



  public void sessionOnStart( SessionEvent e) {
    PageContext pageContext = null;
    JspWriter out = null;
    try {
      ServletContext application = e.getApplication();
      HttpSession session = e.getSession();
      HttpServletRequest request = (HttpServletRequest)e.getRequest();
      HttpServletResponse response = (HttpServletResponse)e.getResponse();
      String page = e.getPage();
      pageContext = (PageContext) request.getAttribute( PageContext.PAGECONTEXT);
      out = pageContext.getOut();

      // globally declared session beans

      // session_OnStart body
            /*
        System.gc();
      */
      
    }
    catch( Throwable t) {
      ServletContext application = e.getApplication();
      if (application != null) application.log("sessionOnStart: Exception " + t.toString());
    }
  }


  public void sessionOnEnd( SessionEvent e) {
    PageContext pageContext = null;
    JspWriter out = null;
    try {
      ServletContext application = e.getApplication();
      HttpSession session = e.getSession();
      pageContext = new OraclePageContext( application, null, null, session);
      out = pageContext.getOut();
      // session_OnEnd body
              System.gc();
      
    }
    catch( Throwable t) {
      ServletContext application = e.getApplication();
      if (application != null) application.log( "event session_OnEnd: Exception " + t.toString());
    }
    try {
      if (out != null) out.clear();
      if (pageContext != null) pageContext.release();
    }
    catch( Exception theException) {
      ServletContext application = e.getApplication();
      if (application != null) application.log( "event session_OnEnd: Exception " + theException.toString());
    }
  }


  public void applicationOnStart( ApplicationEvent e) {
    PageContext pageContext = null;
    JspWriter out = null;
    try {
      ServletContext application = e.getApplication();
      pageContext = new OraclePageContext( application, null, null, null);
      out = pageContext.getOut();

      // globally declared application beans

      // application_OnStart body
              Properties pr = new Properties(application.getRealPath("/conf/conf.xml"));
        Hashtable dbdriver = pr.getCategory("db-driver");
        Hashtable dbconnection = pr.getCategory("db-connection");
        DBConnectionManager.setParameters((String)dbdriver.get("driver"),
                                          (String)dbconnection.get("uri"),
                                          (String)dbconnection.get("username"),
                                          (String)dbconnection.get("password"),
                                          4,
                                          10,
                                          false);
      
    }
    catch( Throwable t) {
      ServletContext application = e.getApplication();
      if (application != null) application.log( "event application_OnStart: Exception " + t.toString());
    }
    try {
      if (out != null) out.clear();
      if (pageContext != null) pageContext.release();
    }
    catch( Exception theException) {
      ServletContext application = e.getApplication();
      if (application != null) application.log( "event application_OnStart: Exception " + theException.toString());
    }
  }


  public void applicationOnEnd( ApplicationEvent e) {
    PageContext pageContext = null;
    JspWriter out = null;
    try {
      ServletContext application = e.getApplication();
      pageContext = new OraclePageContext( application, null, null, null);
      out = pageContext.getOut();

      // application_OnEnd body
            /*
        DBConnectionManager.getInstance().closeAllConnections();
      */
        System.gc();
        System.runFinalization();
      
    }
    catch( Throwable t) {
      ServletContext application = e.getApplication();
      if (application != null) application.log( "event application_OnEnd: Exception " + t.toString());
    }
    try {
      if (out != null) out.clear();
      if (pageContext != null) pageContext.release();
    }
    catch( Exception theException) {
      ServletContext application = e.getApplication();
      if (application != null) application.log( "event application_OnEnd: Exception " + theException.toString());
    }
  }


}
