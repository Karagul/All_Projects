<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page import="digilib.web.Format" %>
<title>D I G I L I B &gt; Thủ thư &gt; In nhãn tài liệu</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/digilib.css" rel="stylesheet" type="text/css" />
</head>

<body>

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
<table width="500" border="0" align="center" cellpadding="0" cellspacing="0" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-top: #999999 1px solid; border-bottom: #999999 1px solid;">
  <tr> 
    <td style="border-bottom: #999999 1px solid;">
<table width="500" border="0" cellspacing="5" cellpadding="0">
        <tr> 
          <td width="135" valign="top"><font size="3"><strong>Tiêu đề</strong></font></td>
          <td width="350"><font size="3"><%= Items.getPrimaryTitle()%> 
            <%@ page import="digilib.view.OtherTitle" %>
            <%
	OtherTitle otherTitles = Items.getOtherTitles();
	otherTitles.open();
	while (otherTitles.next()) {
%>
            <%= Format.formatDisplayString(otherTitles.getOtherTitle()) %><br />
            <%	
	}
	otherTitles.close();
%>
            </font></td>
        </tr>
        <tr> 
          <td width="135" valign="top"><font size="3"><strong>Mô tả</strong></font></td>
          <td> <font size="3"> 
            <%@ page import="digilib.view.Note" %>
            <%
	Note notes = Items.getNotes();
	notes.open();
	int ins = 0;
	while (notes.next()) {
%>
            <%= (ins > 0) ? "<br />" : ""%><%= Format.formatDisplayString(notes.getNote())%> 
            <%
		ins++;
	}
	notes.close();
%>
            </font></td>
        </tr>
        <tr> 
          <td valign="top"><font size="3"><strong>Tác giả</strong></font></td>
          <td> <font size="3"> 
            <%@ page import="digilib.view.Name" %>
            <%
	Name names = Items.getNames();
	names.open();
	int in = 0;
	while (names.next()) {
%>
            <%=(in > 0) ? "<br />" : ""%><%= Format.formatDisplayString(names.getName())%> 
            <%
		in++;
	}
	names.close();
%>
            </font></td>
        </tr>
        <tr> 
          <td valign="top"><font size="3"><strong>Nhà xuất bản</strong></font></td>
          <td><font size="3"><%= Format.formatDisplayString(Items.getImprint())%></font></td>
        </tr>
      </table></td>
  </tr>
  <tr align="center"> 
    <td> <table width="500" border="0" cellspacing="5" cellpadding="0">
        <tr>
          <td align="center"> <font size="5"><strong><%= Format.formatDisplayString(Items.getDDCID()) %> <%= Format.formatDisplayString(Items.getEdition()) %></strong></font></td>
        </tr>
      </table>
      
    </td>
  </tr>
</table>
<br />
<%
	}
	Items.close();
%>
</body>
</html>
