<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="digilib.web.Format" errorPage="/errorshandler.jsp" %>
<%
	response.setDateHeader("Expires", -1);
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
%>
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/2 Cols Base.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
<head>
<!-- InstanceBeginEditable name="doctitle" -->
<title>D I G I L I B &gt; Độc giả &gt; Hồ sơ cá nhân</title>
<script language="JavaScript" src="/digilib.js"></script>
<script language="JavaScript" src="/data.js"></script>
<script language="JavaScript" src="members.js"></script>
<script language="JavaScript">
	DataForm = "ProfileForm";
	DataFormAction = "/process/members.jsp";
	DataSet = "Members";
</script>
<!-- InstanceEndEditable -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- InstanceBeginEditable name="head" --><!-- InstanceEndEditable -->
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
                <td><!-- InstanceBeginEditable name="HeaderImage" --><img src="/images/header_memberprofile.gif" width="300" height="50" /><!-- InstanceEndEditable --></td>
              </tr>
            </table>
          </td>
          <td width="310">
            <table width="310" height="50" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="right"><!-- InstanceBeginEditable name="Validation" --><!-- #BeginLibraryItem "/Library/Member's Validation.lbi" -->
                  <jsp:useBean id="curMember" scope="session" class="digilib.web.Member"/>
                  <%
	if (curMember.isValidated()) {
%>
                  				  
                  <form name="LogoutForm" id="LogoutForm" method="post" action="/process/members.jsp?action=logout">
                    <table width="310" border="0" cellspacing="5" cellpadding="0">
                      <tr>
                        <td align="right">Độc giả <strong>
                          <jsp:getProperty name="curMember" property="Name" />
                          </strong></td><td width="75" align="center">
                          <input name="Logout" type="submit" class="button" id="Logout" value="Thoát" />
                        </td></tr>
                    </table></form><%
	} else {
		response.sendRedirect("/members/?src=" + request.getRequestURI());
	}
%>
                  				  
                                    <!-- #EndLibraryItem --><!-- InstanceEndEditable --></td>
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
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Thư mục trưc tuyến</td>
                      <td width="10" valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/search.jsp?searchtype=quick">Tra cứu nhanh</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/search.jsp?searchtype=advanced">Tra cứu chi tiết</a></td>
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
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Độc giả</td>
                      <td valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="#">Hồ sơ cá nhân</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="transactions.jsp">Chi tiết các nghiệp vụ</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="histories.jsp">Lịch sử các nghiệp vụ</a></td>
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
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Phản hồi</td>
                      <td valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/feedback.jsp">Góp ý</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/contactus.jsp">Liên hệ</a></td>
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
            <table width="600" height="100%" border="0" cellpadding="0" cellspacing="5">
              <tr>
                <td width="400" valign="top"><!-- InstanceBeginEditable name="LeftContent" -->
                  <table width="400" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                      <td width="240" bgcolor="#663300" class="headline">Hồ sơ cá nhân độc giả : <strong><%= Format.formatMemberID(curMember.getMemberID()) %></strong></td>
                      <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                    </tr>
                    <tr>
                      <td colspan="3">
                        <form action="/process/members.jsp?action=update" method="post" enctype="multipart/form-data" name="ProfileForm" id="ProfileForm">
                          <table width="400" border="0" cellpadding="0" cellspacing="5" class="data" id="divDisplay" style="display: inline;">
                            <tr>
                              <td width="65" rowspan="12" align="center" valign="top"><img src="/images/currentmember.jsp" width="60" height="80" /></td>
                              <td width="100">Họ và tên</td>
                              <td width="215"><%= curMember.getName() %></td>
                            </tr>
                            <tr>
                              <td>Giới tính</td>
                              <td><%= (curMember.getGender() == 1) ? "Nam" : "Nữ" %></td>
                            </tr>
                            <tr>
                              <td>Ngày sinh</td>
                              <td><%= Format.formatShortDate(curMember.getBirthday()) %></td>
                            </tr>
                            <tr>
                              <td>Địa chỉ</td>
                              <td rowspan="3" valign="top"><%= Format.formatDisplayString(curMember.getAddress()) %></td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                              <td>Điện thoại</td>
                              <td><%= Format.formatDisplayString(curMember.getPhone()) %></td>
                            </tr>
                            <tr>
                              <td>Fax</td>
                              <td><%= Format.formatDisplayString(curMember.getFax()) %></td>
                            </tr>
                            <tr>
                              <td>Email</td>
                              <td><%= curMember.getEmail() %></td>
                            </tr>
                            <tr>
                              <td>Mật khẩu</td>
                              <td>********************</td>
                            </tr>
                            <tr>
                              <td>Xác nhận mật khẩu</td>
                              <td>********************</td>
                            </tr>
                            <tr>
                              <td><em>Cập nhật lần cuối</em></td>
                              <td><em><%= Format.formatTimeStamp(curMember.getAudTime()) %> - (<%= curMember.getAudUser() %>)</em></td>
                            </tr>
                            <tr>
                              <td rowspan="2">&nbsp;</td>
                              <td colspan="2" align="center">&nbsp;
                                
                              </td>
                            </tr>
                            <tr>
                              <td colspan="2" align="center">
                                <input name="Edit" type="button" class="button" id="Edit" onclick="doEdit(0);" value="Thay đổi thông tin" />
                              </td>
                            </tr>
                          </table>
                          <table width="400" border="0" cellpadding="0" cellspacing="5" class="data" id="divEdit" style="display: none;">
                            <tr>
                              <td width="65" rowspan="12" align="center" valign="top"><img src="/images/currentmember.jsp" width="60" height="80" id="PictureDisplay" />
                                
                              </td>
                              <td width="100">Họ và tên</td>
                              <td width="215">
                                <input name="Name" type="text" class="textbox" id="Name" value="<%= curMember.getName() %>" maxlength="100" />
                                                                
                              </td>
                            </tr>
                            <tr>
                              <td>Giới tính</td>
                              <td>
Nam
                                <input name="Gender" type="radio" value="1" <%= (1 == curMember.getGender()) ? "checked=\"checked\"" : "" %> />
                                &nbsp;Nữ 
                                <input type="radio" name="Gender" value="0" <%= (0 == curMember.getGender()) ? "checked=\"checked\"" : "" %> />
                              </td>
                            </tr>
                            <tr>
                              <td>Ngày sinh</td>
                              <td>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
%>
                                <select name="Day" class="listbox" id="Day">
<%
	for (int i = 1; i <= 31; i++) {
%>
									<option value="<%= i %>" <%= (i == curMember.getBirthday().getDate()) ? "selected=\"selected\"" : "" %>><%= i %></option>
<%
	}
%>
                                </select>
                                /
                                <select name="Month" class="listbox" id="Month">
<%
	for (int i = 0; i < 12; i++) {
%>
									<option value="<%= i %>" <%= (i == curMember.getBirthday().getMonth()) ? "selected=\"selected\"" : "" %>><%= i+1 %></option>
<%
	}
%>
                                </select>
                                /
                                <select name="Year" class="listbox" id="Year">
<%
	int curYear = Integer.parseInt(sdf.format(new Date()));
	for (int i = 1900; i <= curYear; i++) {
%>
									<option value="<%= i %>" <%= (i == Integer.parseInt(sdf.format(curMember.getBirthday())) ? "selected=\"selected\"" : "" ) %>><%= i %></option>
<%
	}
%>
                                </select>
                              </td>
                            </tr>
                            <tr>
                              <td>Địa chỉ</td>
                              <td rowspan="3" valign="top">
                                <textarea name="Address" rows="4" wrap="PHYSICAL" class="textbox" id="Address"><%= curMember.getAddress() %></textarea>
                                                                
                              </td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                              <td>Điện thoại</td>
                              <td>
                                <input name="Phone" type="text" class="textbox" id="Phone" value="<%= Format.formatDisplayString(curMember.getPhone()) %>" maxlength="50" />
                                                                
                              </td>
                            </tr>
                            <tr>
                              <td>Fax</td>
                              <td>
                                <input name="Fax" type="text" class="textbox" id="Fax" value="<%= Format.formatDisplayString(curMember.getFax()) %>" maxlength="50" />
                                                                
                              </td>
                            </tr>
                            <tr>
                              <td>Email</td>
                              <td>
                                <input name="Email" type="text" class="textbox" id="Email" value="<%= curMember.getEmail() %>" maxlength="100" />
                              </td>
                            </tr>
                            <tr>
                              <td>Mật khẩu</td>
                              <td>
                                <input name="Password" type="password" class="textbox" id="Password" value="<%= curMember.getPassword() %>" maxlength="50" />
                              </td>
                            </tr>
                            <tr>
                              <td>Xác nhận mật khẩu</td>
                              <td>
                                <input name="ConfirmPassword" type="password" class="textbox" id="ConfirmPassword" value="<%= curMember.getPassword() %>" maxlength="50" />
                              </td>
                            </tr>
                            <tr>
                              <td><em>Cập nhật lần cuối</em></td>
                              <td><em>
                                <%= Format.formatTimeStamp(new Date()) %> - (<%= curMember.getMemberID() %>)</em></td>
                            </tr>
                            <tr>
                              <td rowspan="2">&nbsp;</td>
                              <td>Cập nhật ảnh</td>
                              <td align="center">
                                <input name="Picture" type="file" class="textbox" id="Picture" onpropertychange="setPicture();" />
                              </td>
                            </tr>
                            <tr>
                              <td colspan="2" align="center">
                                <input name="MemberID" type="hidden" id="MemberID2" value="<%= curMember.getMemberID() %>" />
                                <input name="Apply" type="submit" class="button" id="Apply" value="Cập nhật thay đổi" />
                                <input name="Cancel" type="button" class="button" id="Cancel" onclick="doCancel(0);" value="Ngưng thay đổi" />
                                                                                              </td>
                            </tr>
                          </table>
                        </form>
                                                </td>
                    </tr>
                  </table>
                  <!-- InstanceEndEditable --></td>
                <td width="185" align="center" valign="top"><!-- InstanceBeginEditable name="RightContent" -->
                  <table width="185" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="10"><img src="/images/news_leftcurve.gif" width="10" height="20" /></td>
                      <td width="165" align="center" bgcolor="#083908" class="headline">Một số thông tin khác</td>
                      <td width="10"><img src="/images/news_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr bgcolor="#ffffcc">
                      <td colspan="3">
                        <table width="185" border="0" cellpadding="0" cellspacing="5" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                          <tr>
                            <td width="100">Ngày cấp thẻ</td>
                            <td width="70" align="right"><%= Format.formatShortDate(curMember.getIssuedDate()) %></td>
                          </tr>
                          <tr>
                            <td width="100">Ngày hết hạn</td>
                            <td width="70" align="right"><%= Format.formatShortDate(curMember.getExpireDate()) %></td>
                          </tr>
                          <tr>
                            <td width="100">Đăng ký tối đa</td>
                            <td width="70" align="right"><%= curMember.getMaxBookings() %></td>
                          </tr>
                          <tr>
                            <td width="100">Thời hạn đăng ký</td>
                            <td width="70" align="right"><%= curMember.getBookingDuration() %></td>
                          </tr>
                          <tr>
                            <td width="100">Mượn tối đa</td>
                            <td width="70" align="right"><%= curMember.getMaxLoans() %></td>
                          </tr>
                          <tr>
                            <td width="100">Thời hạn mượn</td>
                            <td width="70" align="right"><%= curMember.getLoanDuration() %></td>
                          </tr>
                          <tr>
                            <td width="100">Gia hạn tối đa</td>
                            <td width="70" align="right"><%= curMember.getMaxExpansions() %></td>
                          </tr>
                          <tr>
                            <td width="100">Thời hạn gia hạn</td>
                            <td width="70" align="right"><%= curMember.getExpansionDuration() %></td>
                          </tr>
                          <tr>
                            <td width="100">Phạt trễ hạn (/ngày)</td>
                            <td width="70" align="right"><%= curMember.getChargeRate() %></td>
                          </tr>
                          
                          
                          
                          
                        </table>
                      </td>
                    </tr>
                  </table>
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
          <td>&copy; 2002 - 2003 Ami Company Limited - - Vuong Phuc Dinh (0540377)</td>
        </tr>
      </table>
    </td>
  </tr>
</table>

</body>
<!-- InstanceEnd --></html>
