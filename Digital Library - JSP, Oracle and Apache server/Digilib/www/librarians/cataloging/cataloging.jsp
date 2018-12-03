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
<title>D I G I L I B &gt; Thủ thư &gt; Biên mục tài liệu</title>
<script language="JavaScript" src="/digilib.js"></script>
<script language="JavaScript" src="cataloging.js"></script>
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
                <td><!-- InstanceBeginEditable name="HeaderImage" --><img src="/images/header_cataloging.gif" width="300" height="50" /><!-- InstanceEndEditable --></td>
              </tr>
            </table>
          </td>
          <td width="310">
            <table width="310" height="50" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="right"><!-- InstanceBeginEditable name="Validation" --><!-- #BeginLibraryItem "/Library/Librarian's Validation.lbi" -->
                  <jsp:useBean id="curLibrarian" scope="session" class="digilib.web.Librarian"/>
<%
	if (curLibrarian.isValidated()) {
%>				  
                  <form name="LogoutForm" id="LogoutForm" method="post" action="/process/librarians.jsp?action=logout">
                    <table width="310" border="0" cellspacing="5" cellpadding="0">
                      <tr>
                        <td align="right">Thủ thư <strong>
                          <jsp:getProperty name="curLibrarian" property="Name" />
                          </strong></td><td width="75" align="center">
                          <input name="Logout" type="submit" class="button" id="Logout" value="Thoát" />
                        </td></tr>
                    </table></form><%
	} else {
		response.sendRedirect("/librarians/?src=" + request.getRequestURI());
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
                      <td><img src="/images/action_leftcurve.gif" width="10" height="20" /></td>
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Thủ 
                        thư</td>
                      <td valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr> 
                      <td>&nbsp;</td>
                      <td align="right"><a href="/librarians/profile.jsp">Hồ sơ 
                        cá nhân</a></td>
                      <td>&nbsp;</td>
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
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Quản 
                        lý thư viện</td>
                      <td valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr> 
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/librarians/management/">Quản 
                        lý thư viện</a></td>
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
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Biên 
                        mục tài liệu</td>
                      <td valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr> 
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/librarians/cataloging/items.jsp">Danh 
                        mục tài liệu</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr> 
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="#">Nhập tài liệu 
                        mới</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr> 
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/librarians/cataloging/languages.jsp">Danh 
                        mục Ngôn ngữ</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr> 
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/librarians/cataloging/formats.jsp">Danh 
                        mục Định dạng</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr> 
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/librarians/cataloging/classifications.jsp">Thang 
                        phân loại Dewey</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr> 
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/librarians/cataloging/imexport.jsp">Nhập 
                        / Xuất dữ liệu</a></td>
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
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Báo 
                        cáo</td>
                      <td valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr> 
                      <td>&nbsp;</td>
                      <td align="right"><a href="/librarians/reports/managements.jsp">Các 
                        báo cáo quản lý</a></td>
                      <td>&nbsp;</td>
                      <td valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr> 
                      <td>&nbsp;</td>
                      <td align="right"><a href="/librarians/reports/labeling.jsp">In 
                        nhãn tài liệu</a></td>
                      <td>&nbsp;</td>
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
                  </table>
                  <!-- InstanceEndEditable --></td>
              </tr>
            </table>
          </td>
          <td width="600" height="100%" valign="top">
            <table width="600" border="0" cellspacing="5" cellpadding="0">
              <tr>
                <td><!-- InstanceBeginEditable name="MainContent" --> 
                  <form name="CatalogingForm" id="CatalogingForm" method="post" action="/process/cataloging.jsp?action=add" onreset="resetForm();" onsubmit="return submitForm();">
                    <table width="590" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr> 
                        <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                        <td width="430" bgcolor="#663300" class="headline">Biên 
                          mục tài liệu</td>
                        <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                      </tr>
                      <tr> 
                        <td colspan="3"><table width="490" border="0" align="center" cellpadding="0" cellspacing="5">
                            <tr> 
                              <td colspan="2"><strong>Tựa đề chính</strong></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><input name="PrimaryTitle" type="text" class="textbox" id="PrimaryTitle" maxlength="200" /></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><strong>Tựa đề khác</strong></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><input name="OtherTitle" type="text" class="textbox" id="OtherTitle" maxlength="200" /> 
                              </td>
                            </tr>
                            <tr> 
                              <td width="45" align="center"> <input name="AddTitle" type="button" class="button" id="AddTitle" value="&gt;&gt;" onclick="addTitle();" /> 
                                <br /> <br /> <input name="RemoveTitle" type="button" class="button" id="RemoveTitle" value="&lt;&lt;" onclick="removeTitle();" /> 
                              </td>
                              <td width="430"> <select name="OtherTitles" size="5" multiple="multiple" class="textbox" id="OtherTitles">
                                </select></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><strong>Mô tả</strong></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><textarea name="Note" rows="5" wrap="PHYSICAL" class="textbox" id="Note"></textarea></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><strong>Tác giả chính</strong></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><input name="PrimaryAuthor" type="text" class="textbox" id="PrimaryAuthor" maxlength="200" /></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><strong>Các tác giả khác</strong></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><input name="OtherAuthor" type="text" class="textbox" id="OtherAuthor" maxlength="200" /></td>
                            </tr>
                            <tr> 
                              <td align="center"> <input name="AddAuthor" type="button" class="button" id="AddAuthor" value="&gt;&gt;" onclick="addAuthor();" /> 
                                <br /> <br /> <input name="RemoveAuthor" type="button" class="button" id="RemoveAuthor" value="&lt;&lt;" onclick="removeAuthor();" /> 
                              </td>
                              <td> <select name="OtherAuthors" size="5" multiple="multiple" class="textbox" id="OtherAuthors">
                                </select></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><strong>Nhà xuất bản</strong></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><input name="Imprint" type="text" class="textbox" id="Imprint" maxlength="200" /></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><table width="480" border="0" cellspacing="0" cellpadding="0">
                                  <tr> 
                                    <td width="200"><strong>Phân loại</strong> 
                                      (theo thang phân loại Dewey)</td>
                                    <td width="5">&nbsp;</td>
                                    <td width="100"><strong>Phiên bản</strong></td>
                                    <td width="5">&nbsp;</td>
                                    <td width="170"><strong>Mã xếp giá</strong></td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><table width="480" border="0" cellspacing="0" cellpadding="0">
                                  <tr> 
                                    <td width="170"> <input name="DDCID" type="text" class="textbox" id="DDCID" maxlength="20" onblur="updateFullEdition();" /> 
                                    </td>
                                    <td width="30" align="center"><img src="/images/finder.gif" width="15" height="15" class="picbutton" onclick="browseDewey();" /></td>
                                    <td width="5">&nbsp;</td>
                                    <td width="100"><input name="Edition" type="text" class="textbox" id="Edition" maxlength="50" onblur="updateFullEdition();" /></td>
                                    <td width="5">&nbsp;</td>
                                    <td width="170"> <input name="FullEdition" type="text" class="textbox" id="FullEdition" maxlength="100" readonly="readonly" /></td>
                                  </tr>
                                </table></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><strong>Ngôn ngữ</strong></td>
                            </tr>
<jsp:useBean id="Formats" scope="page" class="digilib.view.Format" />
<jsp:useBean id="Languages" scope="page" class="digilib.view.Language" />
<%
	String[][] sFormats = null;
	String[][] sLanguages = null;
	int totalFormats, totalLanguages, i;
	Formats.open();
	totalFormats = Formats.getMaxRows();
	sFormats = new String[totalFormats][2];
	i = 0;
	while (Formats.next()) {
		sFormats[i][0] = Formats.getFormatID();
		sFormats[i][1] = Formats.getName();
		i++;
	}
	Formats.close();

	Languages.open();
	totalLanguages = Languages.getMaxRows();
	sLanguages = new String[totalLanguages][2];
	i = 0;
	while (Languages.next()) {
		sLanguages[i][0] = Languages.getLanguageID();
		sLanguages[i][1] = Languages.getName();
		i++;
	}
	Languages.close();
%>							
                            <tr> 
                              <td colspan="2"><select name="LanguageID" class="textbox" id="LanguageID">
                                  <option value="-1">--Chọn ngôn ngữ--</option>
<%
	for (i = 0; i < totalLanguages; i++) {
%>
                                  <option value="<%= sLanguages[i][0]%>"><%= sLanguages[i][0]%> - <%= sLanguages[i][1]%></option>
<%
	}
%>								  
                                </select></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><strong>Định dạng</strong></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><select name="FormatID" class="textbox" id="FormatID">
                                  <option value="-1">--Chọn định dạng--</option>
<%
	for (i = 0; i < totalFormats; i++) {
%>
                                  <option value="<%= sFormats[i][0]%>"><%= sFormats[i][0]%> - <%= sFormats[i][1]%></option>
<%
	}
%>								  
                                </select></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><strong>Mô tả vật lý</strong></td>
                            </tr>
                            <tr>
                              <td colspan="2"><input name="PhysicalDescription" type="text" class="textbox" id="PhysicalDescription" maxlength="200" /></td>
                            </tr>
                            <tr>
                              <td colspan="2"><strong>Từ khoá</strong></td>
                            </tr>
                            <tr> 
                              <td colspan="2"><input name="Keyword" type="text" class="textbox" id="Keyword" maxlength="100" /></td>
                            </tr>
                            <tr> 
                              <td align="center"> <input name="AddKeyword" type="button" class="button" id="AddKeyword" value="&gt;&gt;" onclick="addKeyword();" /> 
                                <br /> <br /> <input name="RemoveKeyword" type="button" class="button" id="RemoveKeyword" value="&lt;&lt;" onclick="removeKeyword();" /> 
                              </td>
                              <td><select name="Keywords" size="5" multiple="multiple" class="textbox" id="select2">
                                </select></td>
                            </tr>
                            <tr align="center"> 
                              <td colspan="2"><input name="Submit" type="submit" class="button" value="Cập nhật vào hệ thống" /> 
                                <input name="Reset" type="reset" class="button" id="Reset" value="Nhập lại" /></td>
                            </tr>
                          </table></td>
                      </tr>
                    </table>
                  </form>
                  <br />
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
