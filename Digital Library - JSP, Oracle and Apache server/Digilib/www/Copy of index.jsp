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
<title>D I G I L I B - Digital Library - Version 1.0</title>
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
                <td><!-- InstanceBeginEditable name="HeaderImage" --><img src="/images/header_news.gif" width="300" height="50" /><!-- InstanceEndEditable --></td>
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
                      <td width="10"><img src="/images/action_leftcurve.gif" width="10" height="20" /></td>
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Thư mục trực tuyến</td>
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
                      <td width="10"><img src="/images/action_leftcurve.gif" width="10" height="20" /></td>
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Chưa phải Độc giả?</td>
                      <td width="10" valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/members/registrationform.jsp">Đăng ký thẻ Độc giả</a></td>
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
                      <td width="10"><img src="/images/action_leftcurve.gif" width="10" height="20" /></td>
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Độc giả</td>
                      <td width="10" valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/members/profile.jsp">Hồ sơ cá nhân</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/members/transactions.jsp">Chi tiết các nghiệp vụ</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/members/histories.jsp">Lịch sử các nghiệp vụ</a></td>
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
                      <td width="10"><img src="/images/action_leftcurve.gif" width="10" height="20" /></td>
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Thủ thư</td>
                      <td width="10" valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/librarians/profile.jsp">Hồ sơ cá nhân</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/librarians/management/">Quản lý thư viện</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/librarians/cataloging/">Biên mục tài liệu</a></td>
                      <td width="5">&nbsp;</td>
                      <td width="10" valign="bottom"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                    </tr>
                    <tr>
                      <td width="10">&nbsp;</td>
                      <td width="125" align="right"><a href="/librarians/reports/">Các báo cáo</a></td>
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
                      <td width="10"><img src="/images/action_leftcurve.gif" width="10" height="20" /></td>
                      <td colspan="2" align="center" bgcolor="#c2a366" class="headline">Phản hồi</td>
                      <td width="10" valign="bottom"><img src="/images/action_rightcurve.gif" width="10" height="20" /></td>
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
                      <td colspan="2"><img src="/images/news_top_r1_c1.jpg" width="400" height="75" /></td>
                    </tr>
                    <tr>
                      <td width="200"><img src="/images/news_top_r2_c1.jpg" width="180" height="60" /></td>
                      <td width="200">&nbsp;</td>
                    </tr>
                  </table>
                  <br />
                  <table width="400" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                      <td width="240" bgcolor="#663300" class="headline">Vài 
                        nét về <strong>D I G I L I B</strong> <em>phiên bản 2.0</em></td>
                      <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                    </tr>
                    <tr>
                      <td colspan="3">
                        <table width="400" border="0" cellspacing="5" cellpadding="0">
                          <tr> 
                            <td width="50" align="center" valign="baseline"><img src="/images/marc_logo.gif" width="50" height="50" /></td>
                            <td valign="top"><strong>Tương thích MARC21</strong> 
                              : MARC21 là phiên bản hiện tại và phổ biến nhất 
                              của <a href="http://www.loc.gov/marc">MARC (Machine 
                              Readable Cataloging - Biên mục bằng máy tính)</a>. 
                              <strong>D I G I L I B</strong> <em>v2.0</em> đã 
                              đưa MARC21 vào hệ thống, giúp cho việc quản lý các 
                              thông tin của tài liệu đầy đủ, cũng như có thể dễ 
                              dàng trao đổi với các hệ thống khác có hỗ trợ MARC21</td>
                          </tr>
                          <tr> 
                            <td width="50" align="center" valign="baseline"><img src="/images/subjectheading_logo.gif" width="50" height="50" /></td>
                            <td valign="top"><strong>Tiêu đề đề mục</strong> : 
                              Nhằm nâng cao khả năng phân loại và sắp xếp tài 
                              liệu, <strong>D I G I L I B</strong> <em>v2.0</em> 
                              sử dụng <a href="http://www.loc.gov/subject_heading">hệ 
                              thống phân loại tiêu đề đề mục (Subject Heading) 
                              của <strong>Thư viện Quốc hội Hoa Kỳ</strong></a>.</td>
                          </tr>
                          <tr> 
                            <td width="50" align="center" valign="baseline"><img src="/images/unicode_logo.gif" width="34" height="33" /></td>
                            <td valign="top"><strong>Tương thích UNICODE</strong> 
                              : Nhằm mục đích hỗ trợ việc lưu trữ và xử lý các 
                              tài liệu có nguồn gốc từ nhiều nước khác nhau trên 
                              thế giới cũng như những bản dịch, <strong>D I G 
                              I L I B</strong> <em>v2.0</em> đã sử dụng <a href="http://www.unicode.org"><strong>UNICODE</strong></a> 
                              làm tiêu chuẩn việc lưu trữ và xử lý cho ngôn ngữ 
                              trong hệ thống.</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  <br />
                  <table width="400" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                      <td width="240" bgcolor="#663300" class="headline">Vì sao 
                        chọn <strong>D I G I L I B</strong></td>
                      <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                    </tr>
                    <tr>
                      <td colspan="3">
                        <table width="400" border="0" cellspacing="5" cellpadding="0">
                          <tr> 
                            <td width="5" valign="baseline"><img src="/images/arrow_right.gif" width="7" height="7" /></td>
                            <td><strong>Đăng ký đơn giản, miễn phí</strong> : 
                              Bạn chỉ cần điền đầy đủ thông tin vào phiếu đăng 
                              ký, chuyển cho Thủ thư. Khi đã được chấp thuận, 
                              bạn sẽ được gửi thông báo đến địa chỉ Email đã đăng 
                              ký với chúng tôi. Như vậy là bạn đã trở thành Độc 
                              giả chính thức và có thể sử dụng mọi dịch vụ do 
                              chúng tôi cung cấp</td>
                          </tr>
                          <tr> 
                            <td width="5" valign="baseline"><img src="/images/arrow_right.gif" width="7" height="7" /></td>
                            <td><strong>Dễ sử dụng</strong> : Hệ thống được thiết 
                              kế theo mô hình Thin-Client, Web-based Application, 
                              nên bạn chỉ cần 1 máy tính được nối mạng và 1 trình 
                              duyệt Internet (VD: Internet Explorer, Nescape Navigator...) 
                              là có thể sử dụng hệ thống</td>
                          </tr>
                          <tr> 
                            <td width="5" valign="baseline"><img src="/images/arrow_right.gif" width="7" height="7" /></td>
                            <td><strong>Tài liệu phong phú</strong> : Bạn sẽ tìm 
                              được nhiều tài liệu phong phú và hữu ích cho mục 
                              đích nghiên cứu của mình trong kho tài liệu của 
                              chúng tôi. Chỉ việc đăng ký và đến nhận khi có thông 
                              báo, hoặc tải trực tiếp xuống máy bạn - nếu là Tài 
                              liệu điện tử (E-books, hình ảnh v.v...)</td>
                          </tr>
                        </table>
                                                </td>
                    </tr>
                  </table>
                  <!-- InstanceEndEditable --></td>
                <td width="185" align="center" valign="top"><!-- InstanceBeginEditable name="RightContent" -->
                  <table width="185" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="10"><img src="/images/news_leftcurve.gif" width="10" height="20" /></td>
                      <td width="165" align="center" bgcolor="#083908" class="headline">Tin tức</td>
                      <td width="10"><img src="/images/news_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td colspan="3" bgcolor="#ffffcc" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                        <table width="180" border="0" align="center" cellpadding="0" cellspacing="5">
                          <tr>
                            <td width="5" valign="baseline"><img src="/images/arrow_right.gif" width="7" height="7" /></td>
                            <td>&nbsp;</td>
                          </tr>
                          <tr>
                            <td width="5" valign="baseline"><img src="/images/arrow_right.gif" width="7" height="7" /></td>
                            <td>&nbsp;</td>
                          </tr>
                          <tr>
                            <td width="5" valign="baseline"><img src="/images/arrow_right.gif" width="7" height="7" /></td>
                            <td>&nbsp;</td>
                          </tr>
                          <tr>
                            <td width="5" valign="baseline"><img src="/images/arrow_right.gif" width="7" height="7" /></td>
                            <td>&nbsp;</td>
                          </tr>
                          <tr>
                            <td width="5" valign="baseline"><img src="/images/arrow_right.gif" width="7" height="7" /></td>
                            <td>&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  <br />
                  <table width="185" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="10"><img src="/images/news_leftcurve.gif" width="10" height="20" /></td>
                      <td width="165" align="center" bgcolor="#083908" class="headline">Tài liệu mới</td>
                      <td width="10"><img src="/images/news_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td colspan="3" bgcolor="#ffffcc" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                        <table width="180" border="0" align="center" cellpadding="0" cellspacing="5">
<jsp:useBean id="newItems" scope="page" class="digilib.view.Item" />
<%
	newItems.setCriteria("ROWNUM <= 5 ORDER BY ITEMNO DESC");
	newItems.open();
	int i = 0;
	while (newItems.next()) {
%>						
                          <tr>
                            <td width="5" align="right" valign="baseline"><%= i+1 %>•</td>
                            <td><a href="/details.jsp?itemno=<jsp:getProperty name="newItems" property="ItemNo" />">
                              <jsp:getProperty name="newItems" property="PrimaryTitle" />
                              </a></td>
<%
		i++;
	}
	newItems.close();
%>							
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  <br />
                  <table width="185" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="10"><img src="/images/news_leftcurve.gif" width="10" height="20" /></td>
                      <td width="165" align="center" bgcolor="#083908" class="headline">Một số tài nguyên hữu ích</td>
                      <td width="10"><img src="/images/news_rightcurve.gif" width="10" height="20" /></td>
                    </tr>
                    <tr>
                      <td colspan="3" bgcolor="#ffffcc" style="border-left: #999999 1px solid; border-right: #999999 1px solid; border-bottom: #999999 1px solid;">
                        <table width="180" border="0" align="center" cellpadding="0" cellspacing="5">
                          <tr>
                            <td width="5" valign="baseline"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                            <td><a href="http://www.gov.loc">Thư viện Quốc 
                                    hội Hoa Kỳ</a></td>
                          </tr>
                          <tr>
                            <td width="5" valign="baseline"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                            <td><a href="http://www.loc.gov/marc">Tiêu chuẩn 
                                    MARC</a></td>
                          </tr>
                          <tr>
                            <td width="5" valign="baseline"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                            <td><a href="http://www.loc.gov/subject_heading"> 
                                    Hệ thống Subject Heading</a></td>
                          </tr>
                          <tr>
                            <td width="5" valign="baseline"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                            <td><a href="http://www.dewey.org">Thang phân 
                                    loại Dewey</a></td>
                          </tr>
                          <tr>
                            <td width="5" valign="baseline"><img src="/images/leftmenu_bullet.gif" width="10" height="10" /></td>
                            <td><a href="http://www.columbia.edu/projects/digitallibrary">Đề 
                                    án &quot;Thư viện Kỹ thuật số&quot; - Đại 
                                    học Columbia - Hoa Kỳ</a></td>
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
          <td>&copy; 2004 - 2005  Vuong Phuc Dinh (010300022102)</td>
        </tr>
      </table>
    </td>
  </tr>
</table>

</body>
<!-- InstanceEnd --></html>
