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
import digilib.view.*;
import digilib.web.Format;


public class _export extends oracle.jsp.runtime.HttpJsp {


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
    _export page = this;
    ServletConfig config = pageContext.getServletConfig();

    try {
      // global beans
      // end global beans


      out.print(__jsp_StaticText.text[0]);
            	response.setDateHeader("Expires", -1);
      	response.setHeader("Cache-Control", "no-cache");
      	response.setHeader("Pragma", "no-cache");
      	response.setContentType("text/xml");
      
      out.print(__jsp_StaticText.text[1]);
      out.print(__jsp_StaticText.text[2]);
      out.print(__jsp_StaticText.text[3]);
      digilib.view.Item Items;
      if ((Items = (digilib.view.Item) pageContext.getAttribute( "Items", PageContext.PAGE_SCOPE)) == null) {
        Items = (digilib.view.Item) new digilib.view.Item();
        pageContext.setAttribute( "Items", Items, PageContext.PAGE_SCOPE);
      }
      out.print(__jsp_StaticText.text[4]);
            	String sFromItemNo = "0";
      	String sToItemNo = "999999999999";
      	try {
      		sFromItemNo = request.getParameter("FromItemNo");
      		sToItemNo = request.getParameter("ToItemNo");
      	} catch (Exception e) {}
      	String sCriteria = "ITEMNO >= " + sFromItemNo + " AND ITEMNO <= " + sToItemNo;
      	Items.setCriteria(sCriteria);
      	Items.open();
      	while (Items.next()) {
      
      out.print(__jsp_StaticText.text[5]);
      out.print(Format.formatXML(Items.getFormatID()));
      out.print(__jsp_StaticText.text[6]);
      out.print(Format.formatXML(Items.getItemNo().toString()));
      out.print(__jsp_StaticText.text[7]);
      out.print(Format.formatXML(Items.getDDCID()));
      out.print(__jsp_StaticText.text[8]);
      out.print(Format.formatXML(Items.getLanguageID()));
      out.print(__jsp_StaticText.text[9]);
            		Name PrimaryName = new Name();
      		PrimaryName.setCriteria("ITEMNO = '" + Items.getItemNo() + "' AND TAG='100a'");
      		PrimaryName.open();
      		while (PrimaryName.next()) {
      
      out.print(__jsp_StaticText.text[10]);
      out.print(Format.formatXML(PrimaryName.getName()));
      out.print(__jsp_StaticText.text[11]);
            		}
      		PrimaryName.close();
      
      out.print(__jsp_StaticText.text[12]);
            		Name otherNames = new Name();
      		otherNames.setCriteria("ITEMNO = '" + Items.getItemNo() + "' AND TAG<>'100a'");
      		otherNames.open();
      		while (otherNames.next()) {
      
      out.print(__jsp_StaticText.text[13]);
      out.print(Format.formatXML(otherNames.getName()));
      out.print(__jsp_StaticText.text[14]);
            		}
      		otherNames.close();
      
      out.print(__jsp_StaticText.text[15]);
      out.print(Format.formatXML(Items.getPrimaryTitle()));
      out.print(__jsp_StaticText.text[16]);
            		OtherTitle otherTitles = Items.getOtherTitles();
      		otherTitles.open();
      		while(otherTitles.next()) {
      
      out.print(__jsp_StaticText.text[17]);
      out.print( Format.formatXML(otherTitles.getOtherTitle()));
      out.print(__jsp_StaticText.text[18]);
            		}
      		otherTitles.close();
      
      out.print(__jsp_StaticText.text[19]);
      out.print(Format.formatXML(Items.getEdition()));
      out.print(__jsp_StaticText.text[20]);
      out.print(Format.formatXML(Items.getImprint()));
      out.print(__jsp_StaticText.text[21]);
      out.print(Format.formatXML(Items.getPhysicalDescription()));
      out.print(__jsp_StaticText.text[22]);
            		Note notes = Items.getNotes();
      		notes.open();
      		while (notes.next()) {
      
      out.print(__jsp_StaticText.text[23]);
      out.print(Format.formatXML(notes.getNote()));
      out.print(__jsp_StaticText.text[24]);
            		}
      		notes.close();
      
      out.print(__jsp_StaticText.text[25]);
            		Copy copies = Items.getCopies();
      		copies.open();
      		while (copies.next()) {
      
      out.print(__jsp_StaticText.text[26]);
      out.print(Format.formatXML(copies.getLocation()));
      out.print(__jsp_StaticText.text[27]);
            		}
      		copies.close();
      
      out.print(__jsp_StaticText.text[28]);
            	}
      	Items.close();
      
      out.print(__jsp_StaticText.text[29]);

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
    private static final char text[][]=new char[30][];
    static {
      text[0] = 
      "﻿".toCharArray();
      text[1] = 
      "\r\n".toCharArray();
      text[2] = 
      "\t\r\n".toCharArray();
      text[3] = 
      "\t\r\n<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\r\n<!DOCTYPE mrcbfile SYSTEM \"http://www.digilib.com/dtd/mrcbfile.dtd\">\r\n<mrcbfile>\r\n".toCharArray();
      text[4] = 
      "\r\n".toCharArray();
      text[5] = 
      "\r\n\t<mrcb format-type=\"".toCharArray();
      text[6] = 
      "\">\r\n\t\t<mrcb-numbers-and-codes>\r\n\t\t\t<mrcb010>\r\n\t\t\t\t<mrcb010-a>".toCharArray();
      text[7] = 
      "</mrcb010-a>\r\n\t\t\t</mrcb010>\r\n\t\t\t<mrcb024>\r\n\t\t\t\t<mrcb024-a>".toCharArray();
      text[8] = 
      "</mrcb024-a>\r\n\t\t\t</mrcb024>\r\n\t\t\t<mrcb041>\r\n\t\t\t\t<mrcb041-a>".toCharArray();
      text[9] = 
      "</mrcb041-a>\r\n\t\t\t</mrcb041>\r\n\t\t</mrcb-numbers-and-codes>\r\n\t\t<mrcb-main-entry>\r\n\t\t\t<mrcb100>\r\n".toCharArray();
      text[10] = 
      "\r\n\t\t\t\t<mrcb100-a>".toCharArray();
      text[11] = 
      "</mrcb100-a>\r\n\t\t\t</mrcb100>\r\n".toCharArray();
      text[12] = 
      "\r\n\t\t\t<mrcb130>\r\n".toCharArray();
      text[13] = 
      "\r\n\t\t\t\t<mrcb130-a>".toCharArray();
      text[14] = 
      "</mrcb130-a>\r\n".toCharArray();
      text[15] = 
      "\r\n\t\t\t</mrcb130>\r\n\t\t</mrcb-main-entry>\r\n\t\t<mrcb-title-and-title-related>\r\n\t\t\t<mrcb245>\r\n\t\t\t\t<mrcb245-a>".toCharArray();
      text[16] = 
      "</mrcb245-a>\r\n\t\t\t</mrcb245>\r\n\t\t\t<mrcb246>\r\n".toCharArray();
      text[17] = 
      "\r\n\t\t\t\t<mrcb246-a>".toCharArray();
      text[18] = 
      "</mrcb246-a>\r\n".toCharArray();
      text[19] = 
      "\r\n\t\t\t</mrcb246>\r\n\t\t</mrcb-title-and-title-related>\r\n\t\t<mrcb-edition-imprint-etc>\r\n\t\t\t<mrcb250>\r\n\t\t\t\t<mrcb250-a>".toCharArray();
      text[20] = 
      "</mrcb250-a>\r\n\t\t\t</mrcb250>\r\n\t\t\t<mrcb260>\r\n\t\t\t\t<mrcb260-a>".toCharArray();
      text[21] = 
      "</mrcb260-a>\r\n\t\t\t</mrcb260>\r\n\t\t</mrcb-edition-imprint-etc>\r\n\t\t<mrcb-physical-description>\r\n\t\t\t<mrcb300>\r\n\t\t\t\t<mrcb300-a>".toCharArray();
      text[22] = 
      "</mrcb300-a>\r\n\t\t\t</mrcb300>\r\n\t\t</mrcb-physical-description>\r\n\t\t<mrcb-notes>\r\n\t\t\t<mrcb500>\r\n".toCharArray();
      text[23] = 
      "\t\t\t\r\n\t\t\t\t<mrcb500-a>".toCharArray();
      text[24] = 
      "</mrcb500-a>\r\n".toCharArray();
      text[25] = 
      "\t\t\t\t\r\n\t\t\t</mrcb500>\r\n\t\t</mrcb-notes>\r\n\t\t<mrcb-location>\r\n\t\t\t<mrcb851>\r\n".toCharArray();
      text[26] = 
      "\r\n\t\t\t\t<mrcb851-a>".toCharArray();
      text[27] = 
      "</mrcb851-a>\t\t\t\r\n".toCharArray();
      text[28] = 
      "\r\n\t\t\t</mrcb851>\r\n\t\t</mrcb-location>\r\n\t</mrcb>\r\n".toCharArray();
      text[29] = 
      "\r\n</mrcbfile>".toCharArray();
    }
  }
}
