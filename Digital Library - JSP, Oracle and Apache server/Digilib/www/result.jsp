<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="digilib.web.Format" errorPage="/errorshandler.jsp" %>
<%
	response.setDateHeader("Expires", -1);
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
%>
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/1 Cols Base.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<!-- InstanceBeginEditable name="doctitle" -->
<title>D I G I L I B &gt; Search Results</title>
<script language="JavaScript" src="search.js"></script>
<!-- InstanceEndEditable -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
<!--
.style7 {font-size: 24px}
-->
</style>
<style type="text/css">
<!--
.style8 {font-family: Verdana, Arial, Helvetica, sans-serif}
-->
</style>
<style type="text/css">
<!--
.style9 {color: #083908}
-->
</style>
<style type="text/css">
<!--
.style10 {color: #0000FF}
-->
</style>
<!-- InstanceEndEditable -->
<link href="/digilib.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="760" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="150">
      <table width="760" height="150" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="150" rowspan="3" align="center" valign="middle"><img src="/images/logo.gif" width="150" height="150" /></td>
          <td height="75" colspan="2">
            <table width="610" height="75" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="center" valign="middle">
                  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0" width="500" height="75">
                    <param name="movie" value="/images/banner.swf" />
                     
                    <param name="quality" value="high" /><param name="SCALE" value="noborder">
                    <embed src="/images/banner.swf" width="500" height="75" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" scale="noborder"></embed></object>
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td height="25" colspan="2">
            <table width="100%" border="0" cellpadding="4" cellspacing="0" class="navigator">
              <tr align="center">
                <td><a href="/">digilib.com</a></td>
                <td>•</td>
                <td><a href="/search.jsp">Search</a></td>
                <td>•</td>
                <td><a href="/members/">Member</a></td>
                <td>•</td>
                <td><a href="/librarians/">Librarian</a></td>
                <td>•</td>
                <td><a href="/feedback.jsp">Feedback</a></td>
                <td>•</td>
                <td><a href="/contactus.jsp">Contact</a></td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td width="300" height="50">
            <table width="300" height="50" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><!-- InstanceBeginEditable name="HeaderImage" --><span class="style9 style8 style7"><em>Search Results</em></span><!-- InstanceEndEditable --></td>
              </tr>
            </table>
          </td>
          <td width="310">
            <table width="310" height="50" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="right"><!-- InstanceBeginEditable name="Validation" -->
                  <jsp:useBean id="curMember" scope="session" class="digilib.web.Member"/>
<%
	if (curMember.isValidated()) {
%>				  
                  <form name="form1" id="form1" method="post" action="">
                    <table width="310" border="0" cellspacing="5" cellpadding="0">
                      <tr>
                        <td align="right">Member<strong>
                          <jsp:getProperty name="curMember" property="Name" />
                          </strong>
                        </td>
                        <td width="75" align="center">
                          <input name="Logout" type="submit" class="button" id="Logout" value="Logout" />
                        </td>
                      </tr>
                    </table>
                  </form>
<%
	}
%>				  
                  <!-- InstanceEndEditable --></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td height="100%" valign="top">
      <table width="760" height="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="160" height="100%" valign="top">
            <table width="160" height="100%" border="0" cellpadding="0" cellspacing="5">
              <tr>
                <td align="center" valign="top">
                  <!-- InstanceBeginEditable name="LeftMenu" -->
                  <table width="150" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="10"><img src="/images/action_leftcurve.gif" width="10" height="20" /></td>
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Online Search </td>
                      <td width="10" valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/search.jsp?searchtype=quick">Quick Search</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/search.jsp?searchtype=advanced">Advanced Searcht</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td><img src="/images/action_leftcurve.gif" width="10" height="20" /></td>
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Are you member?</td>
                      <td valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="125" align="right"><span class="style2"><a href="members/registrationform.jsp">Register Now</a></span></td>
                      <td width="5">&nbsp;</td>
                      <td valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td><img src="/images/action_leftcurve.gif" width="10" height="20" /></td>
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Member</td>
                      <td valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="125" align="right"><a href="/members/profile.jsp">Profile</a></td>
                      <td width="5">&nbsp;</td>
                      <td valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="125" align="right"><a href="/members/transactions.jsp">Activities</a></td>
                      <td width="5">&nbsp;</td>
                      <td valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="125" align="right"><span class="style10"><a href="members/histories.jsp">History of Transaction</a></span></td>
                      <td width="5">&nbsp;</td>
                      <td valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td><img src="/images/action_leftcurve.gif" width="10" height="20" /></td>
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Feedback</td>
                      <td valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="125" align="right"><a href="/feedback.jsp">Feedback</a></td>
                      <td width="5">&nbsp;</td>
                      <td valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td width="125" align="right"><a href="/contactus.jsp">Contact us</a></td>
                      <td width="5">&nbsp;</td>
                      <td valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right">&nbsp;</td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom">&nbsp;</td>
                    </tr>
                  </table>
                  <!-- InstanceEndEditable --></td>
              </tr>
            </table>
          </td>
          <td width="600" height="100%" valign="top">
            <table width="600" border="0" cellspacing="5" cellpadding="0">
              <tr>
                <td><!-- InstanceBeginEditable name="MainContent" --> <span id="Result"> 
                  <table width="590" border="0" cellpadding="0" cellspacing="0" style="display: inline;">
                    <tr>
                      <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                      <td width="430" bgcolor="#663300" class="headline">Search Results </td>
                      <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                    </tr>
                    <tr>
                      <td colspan="3">
                        <table width="580" border="0" cellspacing="5" cellpadding="0">
                          <tr>
                            <td>
                              <form action="/process/bookings.jsp?action=add" method="post" name="SearchResultForm" id="SearchResultForm">
                                <table width="580" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td width="10"><img src="/images/news_leftcurve.gif" width="10" height="20" /></td>
                                    <td width="30" align="center" bgcolor="#083908" class="headline">#</td>
                                    <td width="440" align="center" bgcolor="#083908" class="headline">Resources</td>
                                    <td width="60" align="center" bgcolor="#083908" class="headline">on-stock</td>
                                    <td width="30" align="right" bgcolor="#083908" class="headline">
                                      <input name="SelectAll" type="checkbox" id="SelectAll" onclick="doSelectAll();" />
                                    </td>
                                    <td width="10"><img src="/images/news_rightcurve.gif" width="10" height="20" /></td>
                                  </tr>
                                  <tr>
                                    <td colspan="6">
                                      <table width="580" border="0" cellpadding="5" cellspacing="0" style="border-left: #999999 1px solid; border-right: #999999 1px solid;">
                                        <jsp:useBean id="curResults" scope="page" class="digilib.view.Item" />
<%@ page import="digilib.view.Copy" %>
<%@ page import="digilib.view.Search" %>
<%
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
%>									
                                        <tr bgcolor="<%= (i%2==0) ? "ffffff" : "#ffffcc" %>">
                                          <td width="30" align="right" style="border-right: #999999 1px solid; border-bottom: #999999 1px solid;"><%= i+1 %></td>
                                          <td width="445" style="border-right: #999999 1px solid; border-bottom: #999999 1px solid;"><a href="details.jsp?itemno=<%= curResults.getItemNo() %>"><%= curResults.getPrimaryTitle() %> </a></td>
<%
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
%>										  
                                          <td width="50" align="right" style="border-right: #999999 1px solid; border-bottom: #999999 1px solid;"><%= availableCopies %> / <%= totalCopies %></td>
                                          <td width="30" align="center" style="border-bottom: #999999 1px solid;"> 
                                            <%
	if (curMember.isValidated()) {
%>										  
                                            <input name="accepted" type="checkbox" id="accepted" value="<%= curResults.getItemNo() %>" />
                                            <%
	}
%>&nbsp;
                                          </td>
                                        </tr>
<%
		i++;
	}
	curResults.close();
%>									  
                                      </table>
                                    </td>
                                  </tr>
                                  <tr>
                                    <td colspan="6">
                                      <table width="580" border="0" align="center" cellpadding="0" cellspacing="5" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                                        <tr>
                                          <td width="175">Mẩu tin 
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
                                          <td align="center">
                                            <input name="filter" type="hidden" id="filter" value="<%= Format.formatDisplayString(sCriteria) %>" />
                                                                                        <input name="page" type="hidden" id="page" value="<%= Page %>" />
                                            Giới hạn 
                                            <select name="pagesize" class="listbox" id="pagesize" onchange="setPageSize();">
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
                                          <td width="175" align="right">
										  	<img src="/images/movefirst_up.gif" width="20" height="10" class="picbutton" onclick="<%= (Page > 1) ? "gotoPage(1);" : "" %>" /> 
											<img src="/images/moveprevious_up.gif" width="20" height="10" class="picbutton" onclick="<%= (Page > 1) ? "gotoPage(" + (Page-1) + ");" : "" %>" /> 
											<img src="/images/movenext_up.gif" width="20" height="10" class="picbutton" onclick="<%= (Page < totalPages) ? "gotoPage(" + (Page+1) + ");" : "" %>" /> 
											<img src="/images/movelast_up.gif" width="20" height="10" class="picbutton" onclick="<%= (Page < totalPages) ? "gotoPage(" + totalPages + ");" : "" %>" /></td>
                                        </tr>
                                      </table>
                                    </td>
                                  </tr>
<%
	if (curMember.isValidated()) {
%>											
                                  <tr>
                                    <td colspan="6">
                                      <table width="580" border="0" cellpadding="0" cellspacing="5" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                                        <tr>
                                          <td align="center">                                            
                                            <input name="Book" type="submit" class="button" id="Book" value="Booking" />
                                          </td>
                                        </tr>
                                      </table>
                                    </td>
                                  </tr>
<%
	}
%>											
                                </table>
                                                                </form>                              
                              <script language="JavaScript" type="text/javascript">
showResult();
</script>
							</td>
                          </tr>
                        </table>
                        </td>
                    </tr>
                  </table>
				</span>
<!-- InstanceEndEditable --></td>
              </tr>
            </table>
            </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td height="25">
      <table width="100%" border="0" cellpadding="0" cellspacing="5" class="copyright">
        <tr>
          <td>&copy; 2004 - 2005  Vuong Phuc Dinh (010300022102)</td>
        </tr>
      </table>
    </td>
  </tr>
</table>

</body>
<!-- InstanceEnd --></html>
