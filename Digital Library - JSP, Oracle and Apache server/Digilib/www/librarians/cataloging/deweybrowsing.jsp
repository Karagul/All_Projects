<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="digilib.web.Format" errorPage="/errorshandler.jsp" %>
<%
	response.setDateHeader("Expires", -1);
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>D I G I L I B &gt; Thang phân loại Dewey</title>
<script language="JavaScript" src="/digilib.js"></script>
<script language="JavaScript">
var stdColor = "#ffffff";
var actColor = "#ffff99";
var Select = -1;
function OnClick(index) {
	var totalData = 1;
	if (document.all("data").length != null) {
		totalData = document.all("data").length;
	}
	
	for (i = 0; i < totalData; i++) {
		if (i == index) {
			document.all("data", i).style.backgroundColor = actColor;
			document.all("data", i).style.fontWeight = "bold";			
		} else {
			document.all("data", i).style.backgroundColor = stdColor;
			document.all("data", i).style.fontWeight = "normal";			
		}
	}
	Select = index;
}

function OnDblClick() {
	doSelect();
}

function findByDDCID() {
	var oForm = document.forms("DeweyBrowsingForm");
	document.all("by").value = "DDCID";
	oForm.submit();
}

function findByName() {
	var oForm = document.forms("DeweyBrowsingForm");
	document.all("by").value = "NAME";
	oForm.submit();
}

function doSelect() {
	if (Select != -1) {
		document.all("DDCID").value=trim(document.all("Selected", Select).value);
	}
}

function doCancel() {
	window.close();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/digilib.css" rel="stylesheet" type="text/css" />
</head>

<body>


<form action="" method="get" name="DeweyBrowsingForm" id="DeweyBrowsingForm">
  <table width="500" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr> 
      <td width="10"><img src="/images/news_leftcurve.gif" width="10" height="20" /></td>
      <td width="150" align="center" bgcolor="#083908" class="headline">Mã Dewey</td>
      <td width="335" align="center" bgcolor="#083908" class="headline">Diễn giải</td>
      <td width="10"><img src="/images/news_rightcurve.gif" width="10" height="20" /></td>
    </tr>
    <tr> 
      <td colspan="4"> <%
	String sBy = "DDCID";
	String sDDCID = "";
	String sName = "";
	try {
		if (request.getParameter("by") != null) {
			sBy = request.getParameter("by");
		}
		if (request.getParameter("DDCID") != null) {
			sDDCID = request.getParameter("DDCID");
		}
		if (request.getParameter("Name") != null) {
			sName = request.getParameter("Name");
		}
	} catch (Exception e) {
		sBy = "DDCID";
	}
	String sCriteria;
	if (sBy.equals("NAME")) {
		sCriteria = "lower(NAME) like lower('%" + sName + "%')";
	} else {
		sCriteria = "lower(DDCID) like lower('" + sDDCID + "%')";
	}
%> <table width="500" border="0" cellpadding="5" cellspacing="0" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
          <tr> 
            <td width="120" style="border-right: #999999 1px solid;"> <input name="DDCID" type="text" class="textbox" id="DDCID" maxlength="20" value="<%=sDDCID%>" /></td>
            <td width="20" align="center" style="border-right: #999999 1px solid;"><img src="/images/finder.gif" width="15" height="15" class="picbutton" onclick="findByDDCID();" /></td>
            <td width="310"><input name="Name" type="text" class="textbox" id="Name" maxlength="100" value="<%= sName%>" /></td>
            <td width="20" align="center"><img src="/images/finder.gif" width="15" height="15" onclick="findByName();" /></td>
          </tr>
        </table>
        <jsp:useBean id="Dewey" scope="page" class="digilib.view.Classification" /> 
        <%
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
	Dewey.setPageSize(PageSize);
	Dewey.setPage(Page);
	Dewey.setCriteria(sCriteria);
	Dewey.open();
	int totalRecords = Dewey.getMaxRows();
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
	while (Dewey.next()) {	
%> <table width="500" border="0" cellpadding="5" cellspacing="0" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
          <tr id="data" style="cursor: hand;" onclick="OnClick(<%=i%>);" ondblclick="OnDblClick();"> 
            <td width="150" style="border-right: #999999 1px solid;"> <input name="Selected" type="hidden" id="Selected" value="<%= Dewey.getDDCID() %>" />
              <%= Dewey.getDDCID() %></td>
            <td width="335"> <%= Dewey.getName() %> </td>
          </tr>
        </table>
        <%
		i++;
	}
	Dewey.close();
%> </td>
    </tr>
    <tr> 
      <td colspan="4"><table width="500" border="0" align="center" cellpadding="0" cellspacing="5" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
          <tr> 
            <td width="150">Mẩu tin 
              <%= fromRecord %>
              - 
              <%= toRecord %>
              / 
              <%= totalRecords %>
              mẩu tin<br />
              Trang 
              <%= Page %>
              / 
              <%= totalPages %>
              trang</td>
            <td align="center"> <input name="page" type="hidden" id="page3" value="<%= Page %>" />
              Giới hạn 
              <select name="pagesize" class="listbox" id="select2" onchange="setPageSize();">
                <%
	for (int ps = 1; ps <= 50; ps++) {
%>
                <option value="<%= ps %>" <%= (ps == PageSize) ? "selected=\"selected\"" : "" %>> 
                <%= ps %>
                </option>
                <%
	}
%>
              </select>
              mẩu tin / trang</td>
            <td width="100" align="right"> <img src="/images/movefirst_up.gif" width="20" height="10" class="picbutton" onclick="<%= (Page > 1) ? "gotoPage(1);" : "" %>" /> 
              <img src="/images/moveprevious_up.gif" width="20" height="10" class="picbutton" onclick="<%= (Page > 1) ? "gotoPage(" + (Page-1) + ");" : "" %>" /> 
              <img src="/images/movenext_up.gif" width="20" height="10" class="picbutton" onclick="<%= (Page < totalPages) ? "gotoPage(" + (Page+1) + ");" : "" %>" /> 
              <img src="/images/movelast_up.gif" width="20" height="10" class="picbutton" onclick="<%= (Page < totalPages) ? "gotoPage(" + totalPages + ");" : "" %>" /></td>
          </tr>
        </table> </td>
    </tr>
    <tr>
      <td colspan="4"><table width="500" border="0" cellpadding="5" cellspacing="0" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
          <tr> 
            <td align="right"> <input name="by" type="hidden" id="by3" /> <input name="Select" type="button" class="button" id="Select3" value="Chọn" onclick="doSelect();" /> 
              <input name="Close" type="button" class="button" id="Close3" value="Đóng" onclick="doCancel();" /></td>
          </tr>
        </table></td>
    </tr>
  </table>
</form>
</body>
</html>
