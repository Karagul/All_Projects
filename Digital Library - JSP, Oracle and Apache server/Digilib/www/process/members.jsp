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
<title>D I G I L I B &gt; Xử lý &gt; Độc giả</title>
<%@ page import="digilib.view.Member" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<jsp:useBean id="curMember" scope="session" class="digilib.web.Member" />
<%
	int delayTime = 3;
	int action = -1;
	String sAction = null;
	String sAnnouncement = "Don know what happens";
	try {
		sAction = request.getParameter("action");
	} catch (Exception e) {}
	if (sAction.equalsIgnoreCase("login")) {
		action = 0;
	} else if (sAction.equalsIgnoreCase("logout")) {
		action = 1;
	} else if (sAction.equalsIgnoreCase("update")) {
		action = 11;
	} else if (sAction.equalsIgnoreCase("remove")) {
		action = 12;
	}
	
	String sMemberID = null;
	String sGroupID = null;
	String sName = null;
	Integer Gender = null;
	Date Birthday = null;
	String sAddress = null;
	String sPhone = null;
	String sFax = null;
	String sEmail = null;
	String sPassword = null;
	String sPictureType = null;
	Integer Status = null;
	String src = null;
	String sAffected = null;
	byte[] Picture = null;
	Date ExpireDate = null;

	int affected = -1;
	if ((action != 0 && !curMember.isValidated()) || !request.getMethod().equalsIgnoreCase("post")) {
		sAnnouncement = new String("Nguồn dữ liệu không hợp lệ !!!");
		src = "/members/";
	} else {
		switch (action) {
			case 0 : //Login
				try {
					sMemberID = request.getParameterValues("MemberID")[0]
							  + request.getParameterValues("MemberID")[1]
							  + request.getParameterValues("MemberID")[2];
					sPassword = request.getParameter("Password");
					src = request.getParameter("src");
					if (curMember.validate(sMemberID, sPassword)) {
						sAnnouncement = "Xác nhận độc giả hợp lệ !!!";
					} else {
						sAnnouncement = "Xác nhận độc giả không hợp lệ !!!";
					}
				} catch (Exception e) {
					sAnnouncement = "Hệ thống hiện tại không xác nhận được<br />xin vui lòng thử lại sau";
				}
				if (src == null || src.trim().equals("") || src.equalsIgnoreCase("null")) {
					src = "/members/";
				}
				break;
			case 1 : //Logout
				curMember.invalidate();
				sAnnouncement = "Kết thúc phiên làm việc thành công !!!";
				src = "/members/";
				break;
			case 11 : //update
				MultipartRequest mRequest = new MultipartRequest(request, ".", 1024*1024);
				sMemberID = mRequest.getParameter("MemberID");
				Calendar cBirthday = Calendar.getInstance();
				String FileName = null;
				File fPicture = null;
				FileInputStream fiPicture = null;
				int lenPicture = 0;
				try {
					sName = mRequest.getParameter("Name");
					Gender = new Integer(mRequest.getParameter("Gender"));
					cBirthday.set(Integer.parseInt(mRequest.getParameter("Year")),
								  Integer.parseInt(mRequest.getParameter("Month")),
								  Integer.parseInt(mRequest.getParameter("Day")));
					Birthday = cBirthday.getTime();
					sAddress = mRequest.getParameter("Address");
					sPhone = mRequest.getParameter("Phone");
					sFax = mRequest.getParameter("Fax");
					sEmail = mRequest.getParameter("Email");
					sPassword = mRequest.getParameter("Password");
				} catch (Exception e) {}
				Enumeration files = mRequest.getFileNames();
				if (files.hasMoreElements()) {
					FileName = (String)files.nextElement();
					fPicture = mRequest.getFile(FileName);
					sPictureType = mRequest.getContentType(FileName);
					if (fPicture != null) {
						lenPicture = (int)fPicture.length();
						fiPicture = new FileInputStream(fPicture);
						Picture = new byte[lenPicture];
						fiPicture.read(Picture);
					}
				}
				try {
					sGroupID = mRequest.getParameter("GroupID");
					Status = new Integer(mRequest.getParameter("Status"));
					cBirthday.set(Integer.parseInt(mRequest.getParameter("eYear")),
								  Integer.parseInt(mRequest.getParameter("eMonth")),
								  Integer.parseInt(mRequest.getParameter("eDay")));
					ExpireDate = cBirthday.getTime();											   
				} catch (Exception e) {}
				if (Member.update(sMemberID, sGroupID, sName, Gender, Birthday, sAddress, sPhone, sFax, sEmail, sPassword, sPictureType, Picture, ExpireDate, Status, curMember.getMemberID())) {
					sAnnouncement = "Cập nhật thành công thông tin độc giả";
					if (sMemberID.equals(curMember.getMemberID())) {
						curMember.validate(sMemberID, sPassword);
					}
				}
				src = request.getHeader("Referer");
				break;
				/*
			case 12 : //remove
				try {
					sAffected = request.getParameter("affected");
					affected = Integer.parseInt(sAffected);
					sLibrarianID = request.getParameterValues("LibrarianID")[affected];
					src = request.getHeader("Referer");
					if (Librarian.remove(sLibrarianID, curLibrarian.getLibrarianID())) {
						sAnnouncement = "Xoá Thủ thư thành công !!!";
					} else {
						sAnnouncement = "Xoá Thủ thư không thành công !!!";
					}
				} catch (Exception e) {
					sAnnouncement = "Hệ thống hiện tại không xử lý được<br />xin vui lòng thử lại sau";
				}
				break;*/
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
