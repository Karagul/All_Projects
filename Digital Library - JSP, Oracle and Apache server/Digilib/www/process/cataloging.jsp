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
<title>D I G I L I B &gt; Xử lý &gt; Biên mục tài liệu</title>
<%@ page import="digilib.view.Item" %>
<jsp:useBean id="curLibrarian" scope="session" class="digilib.web.Librarian" />
<%
	int delayTime = 3;
	int action = -1;
	String sAction = null;
	String sAnnouncement = "Don know what happens";
	try {
		sAction = request.getParameter("action");
	} catch (Exception e) {}
	if (sAction.equalsIgnoreCase("add")) {
		action = 10;
	} else if (sAction.equalsIgnoreCase("update")) {
		action = 11;
	} else if (sAction.equalsIgnoreCase("remove")) {
		action = 12;
	}
	
	Long lItemNo = null;
	String sPrimaryTitle = null;
	String sEdition = null;
	String sImprint = null;
	String sPhysicalDescription = null;
	String sLanguageID = null;
	String sFormatID = null;
	String sDDCID = null;
	String sPrimaryAuthor = null;
	String[] sOtherAuthors = null;
	String[] sOtherTitles = null;
	String[] sKeywords = null;
	String sNote = null;
	String src = null;
	if ((action != 0 && !curLibrarian.isValidated()) || !request.getMethod().equalsIgnoreCase("post")) {
		sAnnouncement = new String("Nguồn dữ liệu không hợp lệ !!!");
		src = "/librarians/";
	} else {
		switch (action) {
			case 10 : //add
				//try {
					sPrimaryTitle = request.getParameter("PrimaryTitle");
					sEdition = request.getParameter("Edition");
					sImprint = request.getParameter("Imprint");
					sPhysicalDescription = request.getParameter("PhysicalDescription");
					sLanguageID = request.getParameter("LanguageID");
					sFormatID = request.getParameter("FormatID");
					sDDCID = request.getParameter("DDCID");
					sPrimaryAuthor = request.getParameter("PrimaryAuthor");
					sOtherTitles = request.getParameterValues("OtherTitles");
					sOtherAuthors = request.getParameterValues("OtherAuthors");
					sKeywords = request.getParameterValues("Keywords");
					sNote = request.getParameter("Note");
					String sLibrarianID = curLibrarian.getLibrarianID();
					src = request.getHeader("Referer");
					try {
						lItemNo = Item.add(sPrimaryTitle, sEdition, sImprint, sPhysicalDescription, sLibrarianID);
						sAnnouncement = "Thêm tài liệu thành công!!!<br />";
					} catch (Exception e) {
						lItemNo = new Long(0);
					}
					if (lItemNo.longValue() > 0) {
						try {
							Item.setFormat(lItemNo, sFormatID, sLibrarianID);
							sAnnouncement += "Thiết lập định dạng cho tài liệu thành công!!!<br />";
						} catch (Exception e) {
							sAnnouncement += "Thiết lập định dạng cho tài liệu không thành công!!!<br />";
						}
						try {
							Item.setLanguage(lItemNo, sLanguageID, sLibrarianID);
							sAnnouncement += "Thiết lập ngôn ngữ cho tài liệu thành công!!!<br />";
						} catch (Exception e) {
							sAnnouncement += "Thiết lập ngôn ngữ cho tài liệu không thành công!!!<br />";
						}
						try {
							Item.setClassification(lItemNo, sDDCID, sLibrarianID);
							sAnnouncement += "Phân loại tài liệu thành công!!!<br />";
						} catch (Exception e) {
							sAnnouncement += "Phân loại tài liệu không thành công!!!<br />";
						}
						try {
							Item.setPrimaryAuthor(lItemNo, sPrimaryAuthor, sLibrarianID);
							sAnnouncement += "Thiết lập tác giả chính thành công!!!<br />";
						} catch (Exception e) {
							sAnnouncement += "Thiết lập tác giả chính không thành công!!!<br />";
						}
						try {
							Item.addNote(lItemNo, sNote, sLibrarianID);
							sAnnouncement += "Thiết lập mô tả thành công!!!<br />";
						} catch (Exception e) {
							sAnnouncement += "Thiết lập mô tả không thành công!!!<br />";
						}
						try {
							int totalOtherTitles = sOtherTitles.length;
							for (int i = 0; i < totalOtherTitles; i++) {
								Item.addOtherTitle(lItemNo, sOtherTitles[i], sLibrarianID);
							}
							sAnnouncement += "Thiết lập các tiêu đề khác thành công!!!<br />";
						} catch (Exception e) {
							sAnnouncement += "Thiết lập các tiêu đề khác không thành công!!!<br />";
						}
						try {
							int totalOtherAuthors = sOtherAuthors.length;
							for (int i = 0; i < totalOtherAuthors; i++) {
								Item.setOtherAuthor(lItemNo, sOtherAuthors[i], sLibrarianID);
							}
							sAnnouncement += "Thiết lập các tác giả khác thành công!!!<br />";
						} catch (Exception e) {
							sAnnouncement += "Thiết lập các tác giả khác không thành công!!!<br />";
						}
						try {
							int totalKeywords = sKeywords.length;
							for (int i = 0; i < totalKeywords; i++) {
								Item.addKeyword(lItemNo, sKeywords[i], sLibrarianID);
							}
							sAnnouncement += "Thiết lập các từ khoá thành công!!!<br />";
						} catch (Exception e) {
							sAnnouncement += "Thiết lập các từ khoá không thành công!!!<br />";
						}
					} else {
						sAnnouncement = "Biên mục tài liệu không thành công !!!";
					}
				//} catch (Exception e) {
					//sAnnouncement = "Hệ thống hiện tại không xử lý được<br />xin vui lòng thử lại sau";
				//}
				break;
			/*
			case 11 : //update
				try {
					sAffected = request.getParameter("affected");
					affected = Integer.parseInt(sAffected);
					sGroupID = request.getParameterValues("GroupID")[affected];
					sName = request.getParameterValues("Name")[affected];
					sPriority = request.getParameterValues("Priority")[affected];
					sMaxBookings = request.getParameterValues("MaxBookings")[affected];
					sMaxLoans = request.getParameterValues("MaxLoans")[affected];
					sMaxExpansions = request.getParameterValues("MaxExpansions")[affected];
					sBookingDuration = request.getParameterValues("BookingDuration")[affected];
					sLoanDuration = request.getParameterValues("LoanDuration")[affected];
					sExpansionDuration = request.getParameterValues("ExpansionDuration")[affected];
					sMembershipDuration = request.getParameterValues("MembershipDuration")[affected];
					sChargeRate = request.getParameterValues("ChargeRate")[affected];
					sStatus = request.getParameterValues("Status")[affected];
					src = request.getHeader("Referer");
					if (MemberGroup.update(sGroupID, sName, new Integer(sPriority), new Integer(sMaxBookings), new Integer(sMaxLoans), new Integer(sMaxExpansions), new Integer(sBookingDuration), new Integer(sLoanDuration), new Integer(sExpansionDuration), new Integer(sMembershipDuration), new Integer(sChargeRate), new Integer(sStatus), curLibrarian.getLibrarianID())) {
						sAnnouncement = "Cập nhật dữ liệu Nhóm độc giả thành công !!!";
					} else {
						sAnnouncement = "Cập nhật dữ liệu Nhóm độc giả không thành công !!!";
					}
				} catch (Exception e) {
					sAnnouncement = "Hệ thống hiện tại không xử lý được<br />xin vui lòng thử lại sau";
				}
				break;
			case 12 : //remove
				try {
					sAffected = request.getParameter("affected");
					affected = Integer.parseInt(sAffected);
					sGroupID = request.getParameterValues("GroupID")[affected];
					src = request.getHeader("Referer");
					if (MemberGroup.remove(sGroupID, curLibrarian.getLibrarianID())) {
						sAnnouncement = "Xoá Nhóm độc giả thành công !!!";
					} else {
						sAnnouncement = "Xoá Nhóm độc giả không thành công !!!";
					}
				} catch (Exception e) {
					sAnnouncement = "Hệ thống hiện tại không xử lý được<br />xin vui lòng thử lại sau";
				}
				break;
			*/
		}
	}
	response.setHeader("Refresh", delayTime + "; URL=" + src);
%>
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
                <td><!-- InstanceBeginEditable name="HeaderImage" --><img src="/images/header_announce.gif" width="300" height="50" /><!-- InstanceEndEditable --></td>
              </tr>
            </table>
          </td>
          <td width="310">
            <table width="310" height="50" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="right"><!-- InstanceBeginEditable name="Validation" --><!-- InstanceEndEditable --></td>
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
                  <table width="590" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                      <td width="430" bgcolor="#663300" class="headline">Thông báo</td>
                      <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                    </tr>
                    <tr>
                      <td colspan="3">
                        <table width="590" border="0" cellspacing="5" cellpadding="0">
                          <tr>
                            <td><h5><span id="Announcement"></span>
<script language="JavaScript">
	document.all("Announcement").innerHTML = "<%= sAnnouncement%>";
</script><br />
Bạn sẽ
được tự động chuyển về <%= src %> trong <span id="timer"></span>&nbsp;giây...<br />
Bạn có thể bấm vào <a href="<%= src %>"><%= src %></a> nếu không muốn chờ !!!<br />
                              www.digilib.com</h5>
<script language="JavaScript">
var timer = window.setTimeout(Counter, 900);
var timerCount = <%= delayTime %>;
function Counter() {
	if (timerCount >= 0) {
		document.all("timer").innerHTML = timerCount;
		timerCount--;
		timer = window.setTimeout(Counter, 900);
	}
}
</script>
							  </td>
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
