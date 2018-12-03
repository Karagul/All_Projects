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
<title>D I G I L I B &gt; Độc giả &gt; Chi tiết các nghiệp vụ</title>
<script language="JavaScript" src="transactions.js"></script>
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
                <td><!-- InstanceBeginEditable name="HeaderImage" --><img src="/images/header_membertransactions.gif" width="300" height="50" /><!-- InstanceEndEditable --></td>
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
                      <td width="125" align="right"><a href="profile.jsp">Hồ sơ cá nhân</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="#">Chi tiết các nghiệp vụ</a></td>
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
            <table width="600" border="0" cellspacing="5" cellpadding="0">
              <tr>
                <td><!-- InstanceBeginEditable name="MainContent" -->
                  <jsp:useBean id="curBooking" scope="page" class="digilib.view.Booking" />
                  <%
	curBooking.setCriteria("MEMBERID = '" + curMember.getMemberID() + "' AND STATUS = 1");
	curBooking.open();
	if (curBooking.next()) {
%>
                  <form name="BookingForm" id="BookingForm" method="post" action="/process/bookings.jsp?action=post">
                    <table width="590" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                        <td width="430" bgcolor="#663300" class="headline">Chi tiết phiếu đăng ký số : <%= curBooking.getDocumentNo() %> - Lập ngày :
                          <%= Format.formatShortDate(curBooking.getDocumentDate()) %>
                        </td>
                        <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                      </tr>
                      <tr>
                        <td colspan="3">
                          <table width="590" border="0" cellspacing="5" cellpadding="0">
                            <tr>
                              <td>
                                <table width="580" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td width="10"><img src="/images/news_leftcurve.gif" width="10" height="20" /></td>
                                    <td width="30" align="center" bgcolor="#083908" class="headline">#</td>
                                    <td width="450" align="center" bgcolor="#083908" class="headline">Tài liệu</td>
                                    <td width="80" align="center" bgcolor="#083908" class="headline">Đăng ký ngày</td>
                                    <td width="10"><img src="/images/news_rightcurve.gif" width="10" height="20" /></td>
                                  </tr>
                                  <tr>
                                    <td colspan="5">
                                      <%@ page import="digilib.view.BookingDetail" %>
                                      <%
	BookingDetail curDetails = curBooking.getDetails();
	curDetails.open();
	int i = 0;
	while (curDetails.next()) {
%>
                                      							  
                                      <table width="580" border="0" cellpadding="5" cellspacing="0" bgcolor="<%= (i%2==0) ? "#ffffff" : "#ffffcc" %>" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                                        <tr>
                                          <td width="30" align="right" style="border-right: #999999 1px solid;"><%= i+1 %></td>
                                          <td width="450" style="border-right: #999999 1px solid;"><%= curDetails.getPrimaryTitle() %></td>
                                          <td width="80"><%= Format.formatShortDate(curDetails.getDetailDate()) %></td>
                                        </tr>
                                      </table>
                                      <%
		i++;
	}
	curDetails.close();
%>
                                      								
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                            <tr>
                              <td align="center">
                                <input name="accepted" type="hidden" id="accepted" value="<%= curBooking.getDocumentNo() %>" />
                                <input name="Post" type="submit" class="button" id="Post" value="Chuyển cho Thủ thư" />
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                    </table>
                  </form>
                  <%
	}
	curBooking.close();
%>
                  <jsp:useBean id="curExpansion" scope="page" class="digilib.view.Expansion" />
                  <%
	curExpansion.setCriteria("MEMBERID = '" + curMember.getMemberID() + "' AND STATUS = 1");
	curExpansion.open();
	if (curExpansion.next()) {
%>
                  <form name="ExpansionForm" id="ExpansionForm" method="post" action="/process/expansions.jsp?action=post">
                    <table width="590" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                        <td width="430" bgcolor="#663300" class="headline">Chi tiết phiếu gia hạn số : <%= curExpansion.getDocumentNo() %> - Lập ngày :
                          <%= Format.formatShortDate(curExpansion.getDocumentDate()) %>
                        </td>
                        <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                      </tr>
                      <tr>
                        <td colspan="3">
                          <table width="590" border="0" cellspacing="5" cellpadding="0">
                            <tr>
                              <td>
                                <table width="580" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td width="10"><img src="/images/news_leftcurve.gif" width="10" height="20" /></td>
                                    <td width="30" align="center" bgcolor="#083908" class="headline">#</td>
                                    <td width="450" align="center" bgcolor="#083908" class="headline">Tài liệu</td>
                                    <td width="80" align="center" bgcolor="#083908" class="headline">Gia hạn ngày</td>
                                    <td width="10"><img src="/images/news_rightcurve.gif" width="10" height="20" /></td>
                                  </tr>
                                  <tr>
                                    <td colspan="5">
                                      <%@ page import="digilib.view.ExpansionDetail" %>
                                      <%
	ExpansionDetail curEDetails = curExpansion.getDetails();
	curEDetails.open();
	int ie = 0;
	while (curEDetails.next()) {
%>
                                      							  
                                      <table width="580" border="0" cellpadding="5" cellspacing="0" bgcolor="<%= (ie%2==0) ? "#ffffff" : "#ffffcc" %>" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                                        <tr>
                                          <td width="30" align="right" style="border-right: #999999 1px solid;"><%= ie+1 %></td>
                                          <td width="450" style="border-right: #999999 1px solid;"><%= curEDetails.getPrimaryTitle() %></td>
                                          <td width="80"><%= Format.formatShortDate(curEDetails.getDetailDate()) %></td>
                                        </tr>
                                      </table>
                                      <%
		ie++;
	}
	curEDetails.close();
%>
                                      								
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                            <tr>
                              <td align="center">
                                <input name="accepted" type="hidden" id="accepted" value="<%= curExpansion.getDocumentNo() %>" />
                                <input name="Post" type="submit" class="button" id="Post" value="Chuyển cho Thủ thư" />
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                    </table>
                  </form>
                  <%
	}
	curExpansion.close();
%>
                  <form name="BookingListForm" id="BookingListForm" method="post" action="/process/bookinglist.jsp?action=remove">
                    <table width="590" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                        <td width="430" bgcolor="#663300" class="headline">Các yêu cầu đã gởi cho Thủ thư</td>
                        <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                      </tr>
                      <tr>
                        <td colspan="3">
                          <table width="590" border="0" cellspacing="5" cellpadding="0">
                            <tr>
                              <td>
                                <table width="580" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td width="10"><img src="/images/news_leftcurve.gif" width="10" height="20" /></td>
                                    <td width="30" align="center" bgcolor="#083908" class="headline">#</td>
                                    <td width="430" align="center" bgcolor="#083908" class="headline">Tài liệu</td>
                                    <td width="100" align="center" bgcolor="#083908" class="headline">Trạng thái</td>
                                    <td width="10"><img src="/images/news_rightcurve.gif" width="10" height="20" /></td>
                                  </tr>
                                  <tr>
                                    <td colspan="5">
                                      <jsp:useBean id="curBookingList" scope="page" class="digilib.view.BookingList" />
                                      <jsp:useBean id="curWaitingList" scope="page" class="digilib.view.WaitingList" />
                                      <%
	curBookingList.setCriteria("MEMBERID = '" + curMember.getMemberID() + "'");
	curBookingList.open();
	int bi = 0;
	while (curBookingList.next()) {
%>
                                      <table width="580" border="0" cellpadding="5" cellspacing="0" bgcolor="<%= (bi%2==0) ? "ffffff" : "#ffffcc" %>" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                                        <tr>
                                          <td width="30" align="center" style="border-right: #999999 1px solid;"><img src="/images/remove_up.gif" width="10" height="10" class="picbutton" /></td>
                                          <td width="450" style="border-right: #999999 1px solid;"><%= curBookingList.getPrimaryTitle() %></td>
                                          <td width="100" align="center">Đã chấp thuận</td>
                                        </tr>
                                      </table>
                                      <%
		bi++;
	}
	curBookingList.close();
	curWaitingList.setCriteria("MEMBERID = '" + curMember.getMemberID() + "'");
	curWaitingList.open();
	while (curWaitingList.next()) {
%>
                                      <table width="580" border="0" cellpadding="5" cellspacing="0" bgcolor="<%= (bi%2==0) ? "ffffff" : "#ffffcc" %>" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                                        <tr>
                                          <td width="30" align="center" style="border-right: #999999 1px solid;"><img src="/images/remove_up.gif" width="10" height="10" class="picbutton" /></td>
                                          <td width="450" style="border-right: #999999 1px solid;">
                                            <%= curWaitingList.getPrimaryTitle() %>
                                          </td>
                                          <td width="100" align="center">Đang chờ</td>
                                        </tr>
                                      </table>
<%
		bi++;
	}
	curWaitingList.close();
%>									  
                                                                          </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                    </table>
                  </form>
                  <form name="ExpansionForm" id="ExpansionForm" method="post" action="/process/expansions.jsp?action=add" onsubmit="return checkData();">
                    <table width="590" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                        <td width="430" bgcolor="#663300" class="headline">Tài liệu đang mượn</td>
                        <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                      </tr>
                      <tr>
                        <td colspan="3">
                          <table width="590" border="0" cellspacing="5" cellpadding="0">
                            <tr>
                              <td>
                                <table width="580" border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td width="10"><img src="/images/news_leftcurve.gif" width="10" height="20" /></td>
                                    <td width="30" align="center" bgcolor="#083908" class="headline">#</td>
                                    <td width="300" align="center" bgcolor="#083908" class="headline">Tài liệu</td>
                                    <td width="100" align="center" bgcolor="#083908" class="headline">Ngày mượn</td>
                                    <td width="100" align="center" bgcolor="#083908" class="headline">Hạn trả</td>
                                    <td width="30" align="right" bgcolor="#083908" class="headline">
                                      <input name="SelectAll" type="checkbox" id="SelectAll" onclick="doSelectAll();" />
                                    </td>
                                    <td width="10"><img src="/images/news_rightcurve.gif" width="10" height="20" /></td>
                                  </tr>
                                  <tr>
                                    <td colspan="7">
                                      <jsp:useBean id="curLoanList" scope="page" class="digilib.view.LoanList" />
                                      <jsp:useBean id="curLoanOverdueList" scope="page" class="digilib.view.LoanOverdueList" />
                                      <%
	curLoanList.setCriteria("MEMBERID = '" + curMember.getMemberID() + "'");
	curLoanList.open();
	int li = 0;
	Date now = new Date();
	while (curLoanList.next()) {
%>
                                    								  
                                      <table width="580" border="0" cellpadding="5" cellspacing="0" bgcolor="<%= (li%2==0) ?"ffffff" : "#ffffcc" %>" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                                        <tr>
                                          <td width="30" align="right" style="border-right: #999999 1px solid;">
                                            <%= li+1 %>
                                          </td>
                                          <td width="320" style="border-right: #999999 1px solid;">
                                            <%= curLoanList.getPrimaryTitle() %>
                                          </td>
                                          <td width="100" align="center" style="border-right: #999999 1px solid;">
                                            <%= Format.formatShortDate(curLoanList.getTransactionDate()) %>
                                          </td>
                                          <td width="100" align="center" style="border-right: #999999 1px solid;">
                                            <%= Format.formatShortDate(curLoanList.getDueDate()) %>
                                            </font></td>
                                          <td width="30" align="center">
                                            <%
	if (curLoanList.getDueDate().compareTo(now) == 0) {
%>
                                            										  
                                            <input name="accepted" type="checkbox" id="accepted" value="<%= curLoanList.getTransactionNo() %>" />
                                            <%
	} else {
%>
                                            	<img src="/images/spacer.gif" width="25" height="1" />	
                                            <%
	}
%>
                                            																					
                                          </td>
                                        </tr>
                                      </table>
                                      <%
		li++;
	}
	curLoanList.close();
	curLoanOverdueList.setCriteria("MEMBERID = '" + curMember.getMemberID() + "'");
	curLoanOverdueList.open();
	while (curLoanOverdueList.next()) {
%>
                                      <table width="580" border="0" cellpadding="5" cellspacing="0" bgcolor="<%= (li%2==0) ?"ffffff" : "#ffffcc" %>" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                                        <tr>
                                          <td width="30" align="right" style="border-right: #999999 1px solid;">
                                            <%= li+1 %>
                                          </td>
                                          <td width="320" style="border-right: #999999 1px solid;">
                                            <%= curLoanOverdueList.getPrimaryTitle() %>
                                          </td>
                                          <td width="100" align="center" style="border-right: #999999 1px solid;">
                                            <%= Format.formatShortDate(curLoanOverdueList.getTransactionDate()) %>
                                          </td>
                                          <td width="100" align="center" style="border-right: #999999 1px solid;"><font color="#ff0000">
                                            <%= Format.formatShortDate(curLoanOverdueList.getDueDate()) %>
                                            </font></td>
                                          <td width="30" align="center">
                                            <input name="accepted" type="checkbox" id="accepted" value="<%= curLoanOverdueList.getTransactionNo() %>" />
                                          </td>
                                        </tr>
                                      </table>
                                      <%
		li++;
	}
	curLoanOverdueList.close();
%>
                                                                                                                									
                                  </td>
                                  </tr>
                                  <tr>
                                    <td colspan="7">
                                      <table width="580" border="0" cellspacing="5" cellpadding="0">
                                        <tr>
                                          <td align="center">
                                            <input name="Post" type="submit" class="button" id="Post" value="Gia hạn" />
                                          </td>
                                        </tr>
                                      </table>
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                    </table>
                  </form>
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
