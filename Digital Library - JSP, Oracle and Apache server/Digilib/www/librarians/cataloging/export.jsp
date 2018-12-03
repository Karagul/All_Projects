<%
	response.setDateHeader("Expires", -1);
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setContentType("text/xml");
%>
<%@ page import="digilib.view.*"%>	
<%@ page import="digilib.web.Format"%>	
<?xml version="1.0" encoding="utf-8" standalone="no"?>
<!DOCTYPE mrcbfile SYSTEM "http://www.digilib.com/dtd/mrcbfile.dtd">
<mrcbfile>
<jsp:useBean id="Items" scope="page" class="digilib.view.Item" />
<%
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
%>
	<mrcb format-type="<%=Format.formatXML(Items.getFormatID())%>">
		<mrcb-numbers-and-codes>
			<mrcb010>
				<mrcb010-a><%=Format.formatXML(Items.getItemNo().toString())%></mrcb010-a>
			</mrcb010>
			<mrcb024>
				<mrcb024-a><%=Format.formatXML(Items.getDDCID())%></mrcb024-a>
			</mrcb024>
			<mrcb041>
				<mrcb041-a><%=Format.formatXML(Items.getLanguageID())%></mrcb041-a>
			</mrcb041>
		</mrcb-numbers-and-codes>
		<mrcb-main-entry>
			<mrcb100>
<%
		Name PrimaryName = new Name();
		PrimaryName.setCriteria("ITEMNO = '" + Items.getItemNo() + "' AND TAG='100a'");
		PrimaryName.open();
		while (PrimaryName.next()) {
%>
				<mrcb100-a><%=Format.formatXML(PrimaryName.getName())%></mrcb100-a>
			</mrcb100>
<%
		}
		PrimaryName.close();
%>
			<mrcb130>
<%
		Name otherNames = new Name();
		otherNames.setCriteria("ITEMNO = '" + Items.getItemNo() + "' AND TAG<>'100a'");
		otherNames.open();
		while (otherNames.next()) {
%>
				<mrcb130-a><%=Format.formatXML(otherNames.getName())%></mrcb130-a>
<%
		}
		otherNames.close();
%>
			</mrcb130>
		</mrcb-main-entry>
		<mrcb-title-and-title-related>
			<mrcb245>
				<mrcb245-a><%=Format.formatXML(Items.getPrimaryTitle())%></mrcb245-a>
			</mrcb245>
			<mrcb246>
<%
		OtherTitle otherTitles = Items.getOtherTitles();
		otherTitles.open();
		while(otherTitles.next()) {
%>
				<mrcb246-a><%= Format.formatXML(otherTitles.getOtherTitle())%></mrcb246-a>
<%
		}
		otherTitles.close();
%>
			</mrcb246>
		</mrcb-title-and-title-related>
		<mrcb-edition-imprint-etc>
			<mrcb250>
				<mrcb250-a><%=Format.formatXML(Items.getEdition())%></mrcb250-a>
			</mrcb250>
			<mrcb260>
				<mrcb260-a><%=Format.formatXML(Items.getImprint())%></mrcb260-a>
			</mrcb260>
		</mrcb-edition-imprint-etc>
		<mrcb-physical-description>
			<mrcb300>
				<mrcb300-a><%=Format.formatXML(Items.getPhysicalDescription())%></mrcb300-a>
			</mrcb300>
		</mrcb-physical-description>
		<mrcb-notes>
			<mrcb500>
<%
		Note notes = Items.getNotes();
		notes.open();
		while (notes.next()) {
%>			
				<mrcb500-a><%=Format.formatXML(notes.getNote())%></mrcb500-a>
<%
		}
		notes.close();
%>				
			</mrcb500>
		</mrcb-notes>
		<mrcb-location>
			<mrcb851>
<%
		Copy copies = Items.getCopies();
		copies.open();
		while (copies.next()) {
%>
				<mrcb851-a><%=Format.formatXML(copies.getLocation())%></mrcb851-a>			
<%
		}
		copies.close();
%>
			</mrcb851>
		</mrcb-location>
	</mrcb>
<%
	}
	Items.close();
%>
</mrcbfile>