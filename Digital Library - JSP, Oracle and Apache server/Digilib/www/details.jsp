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
<title>D I G I L I B &gt; Details</title>
<!-- InstanceEndEditable -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
<!--
.style1 {font-size: 24px}
-->
</style>
<style type="text/css">
<!--
.style2 {font-family: Verdana, Arial, Helvetica, sans-serif}
-->
</style>
<style type="text/css">
<!--
.style3 {color: #083908}
-->
</style>
<style type="text/css">
<!--
.style4 {font-size: 28px}
-->
</style>
<style type="text/css">
<!--
.style5 {font-family: Arial, Helvetica, sans-serif}
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
                <td><!-- InstanceBeginEditable name="HeaderImage" --><span class="style3 style2 style1 style4"><em>Document Details </em></span><!-- InstanceEndEditable --></td>
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
                  <form name="LogoutForm" id="LogoutForm" method="post" action="/process/members.jsp?action=logout">
                    <table width="310" border="0" cellspacing="5" cellpadding="0">
                      <tr> 
                        <td align="right">Member<strong> 
                          <jsp:getProperty name="curMember" property="Name" />
                          </strong></td>
                        <td width="75" align="center"> <input name="Logout" type="submit" class="button" id="Logout" value="Logout" /> 
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
                      <td width="125" align="right"><a href="/search.jsp?searchtype=advanced">Advanced Search</a></td>
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
                      <td width="125" align="right"><span class="style2 style5"><a href="members/histories.jsp">History of Transaction</a></span></td>
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
                <td><!-- InstanceBeginEditable name="MainContent" --> 
                  <jsp:useBean id="curItem" scope="page" class="digilib.view.Item" />
                  <%
	String sItemNo = "";
	try {
		sItemNo = "ITEMNO = " + request.getParameter("itemno");
	} catch (Exception e) {
		sItemNo = "ITEMNO = 0";
	}

	curItem.setCriteria(sItemNo);
	curItem.open();
	if (curItem.next()) {
%>
                  <form name="ItemDetailForm" id="ItemDetailForm" method="post" action="/process/bookings.jsp?action=add">
                    <table width="490" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr> 
                        <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                        <td width="330" bgcolor="#663300" class="headline"> Document Details - 
                          <%= curItem.getItemNo() %>
                        </td>
                        <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                      </tr>
                      <tr> 
                        <td colspan="3"><table width="400" border="0" align="center" cellpadding="0" cellspacing="5">
                            <tr valign="top"> 
                              <td width="100"><strong>Mã xếp giá</strong></td>
                              <td width="385">
                                <%= Format.formatDisplayString(curItem.getDDCID()) %>
                                <%= Format.formatDisplayString(curItem.getEdition()) %>
                              </td>
                            </tr>
                            <tr valign="top"> 
                              <td><strong>Tiêu đề</strong></td>
                              <td>
                                <%= Format.formatDisplayString(curItem.getPrimaryTitle()) %>
                              </td>
                            </tr>
                            <tr valign="top"> 
                              <td><strong>Tiêu đề khác</strong></td>
                              <td> 
                                <%@ page import="digilib.view.OtherTitle" %>
                                <%
	OtherTitle otherTitles = curItem.getOtherTitles();
	otherTitles.open();
	int io = 0;
	while (otherTitles.next()) {
		if (io > 0) {
			out.print("<br />");
		}
		out.println(otherTitles.getOtherTitle());
		io++;
	}
	otherTitles.close();
%>
                              </td>
                            </tr>
                            <tr valign="top"> 
                              <td><strong>Tác giả</strong></td>
                              <td> 
                                <%@ page import="digilib.view.Name" %>
                                <%
	Name names = curItem.getNames();
	names.open();
	int ina = 0;
	while (names.next()) {
		if (ina > 0) {
			out.print("<br />");
		}
		out.println(names.getName());
		ina++;
	}
	names.close();
%>
                              </td>
                            </tr>
                            <tr valign="top"> 
                              <td><strong>Nhà xuất bản</strong></td>
                              <td>
                                <%= Format.formatDisplayString(curItem.getImprint()) %>
                              </td>
                            </tr>
                            <tr valign="top"> 
                              <td><strong>Ngôn ngữ</strong></td>
                              <td>
                                <%= Format.formatDisplayString(curItem.getLanguage()) %>
                              </td>
                            </tr>
                            <tr valign="top"> 
                              <td><strong>Mô tả</strong></td>
                              <td> 
                                <%@ page import="digilib.view.Note" %>
                                <%
	Note notes = curItem.getNotes();
	notes.open();
	int in = 0;
	while (notes.next()) {
		if (in > 0) {
			out.print("<br />");
		}
		out.println(Format.formatDisplayString(notes.getNote()));
		in++;
	}
	notes.close();
%>
                              </td>
                            </tr>
                            <tr valign="top"> 
                              <td><strong>Từ khoá</strong></td>
                              <td> 
                                <%@ page import="digilib.view.Keyword" %>
                                <%
	Keyword keywords = curItem.getKeywords();
	keywords.open();
	int ik = 0;
	while (keywords.next()) {
		if (ik > 0) {
			out.print(" | ");
		}
		out.println(Format.formatDisplayString(keywords.getKeyword()));
		ik++;
	}
	keywords.close();
%>
                              </td>
                            </tr>
                            <tr valign="top"> 
                              <td><strong>Định dạng</strong></td>
                              <td>
                                <%= Format.formatDisplayString(curItem.getFormat()) %>
                              </td>
                            </tr>
                            <tr valign="top"> 
                              <td><strong>Vật liệu</strong></td>
                              <td>
                                <%= Format.formatDisplayString(curItem.getPhysicalDescription()) %>
                              </td>
                            </tr>
                          </table></td>
                      </tr>
<%
	if (curMember.isValidated()) {
%>					  
                      <tr align="center"> 
                        <td colspan="3"><input name="accepted" type="hidden" id="accepted" value="<%= curItem.getItemNo() %>" />
                          <input name="Book" type="submit" class="button" id="Book" value="Booking" /></td>
                      </tr>
<%
	}
%>					  
                    </table>
                  </form>
                  <%	
	}
	curItem.close();
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
