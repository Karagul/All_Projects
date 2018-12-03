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
<title>D I G I L I B &gt; Online Search</title>
<script language="JavaScript" src="search.js"></script>
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
<style type="text/css">
<!--
.style6 {color: #0000FF}
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
                <td><!-- InstanceBeginEditable name="HeaderImage" --><span class="style2 style1 style3 style4"><em>Online Search </em></span><!-- InstanceEndEditable --></td>
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
                      <td width="125" align="right"><span class="style2 style5 style6"><a href="members/histories.jsp">History of Transaction</a></span></td>
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
                  <table width="590" border="0" cellpadding="0" cellspacing="0" id="divQuickSearch" style="display: inline;">
                    <tr>
                      <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                      <td width="430" bgcolor="#663300" class="headline">Quick Search </td>
                      <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                    </tr>
                    <tr>
                      <td colspan="3">
                        <form action="/result.jsp" method="post" name="QuickSearchForm" target="Result" id="QuickSearchForm" onsubmit="return doSearch();">
                          <table width="590" border="0" cellspacing="5" cellpadding="0">
                            <tr>
                              <td width="75">&nbsp;</td>
                              <td width="50">&nbsp;</td>
                              <td width="50">&nbsp;</td>
                              <td width="50">&nbsp;</td>
                              <td width="240">&nbsp;</td>
                              <td width="50">&nbsp;</td>
                              <td width="75">&nbsp;</td>
                            </tr>
                            <tr>
                              <td width="75">&nbsp;</td>
                              <td width="50" align="center">Find</td>
                              <td width="50">
                                <select name="SearchCondition" class="listbox" id="SearchCondition">
                                  <option value="0" selected="selected">On</option>
                                  <option value="1">Included</option>
                                </select>
                              </td>
                              <td width="50">
                                <select name="SearchType" class="listbox" id="SearchType">
                                  <option value="0" selected="selected">Word</option>
                                  <option value="1">Words</option>
                                </select>
                              </td>
                              <td width="240">
                                <input name="SearchContent" type="text" class="textbox" id="SearchContent" />
                              </td>
                              <td width="50" align="center">
                                <input name="Search" type="submit" class="button" id="Search" value="Search" />
                              </td>
                              <td width="75">&nbsp;</td>
                            </tr>
                          </table>
                        </form>
                      </td>
                    </tr>
                  </table>
                  <table width="590" border="0" cellpadding="0" cellspacing="0" id="divAdvancedSearch" style="display: none;">
                    <tr>
                      <td width="10"><img src="/images/lefttop_curve.gif" width="10" height="20" /></td>
                      <td width="430" bgcolor="#663300" class="headline">Tra cứu chi tiết</td>
                      <td width="150"><img src="/images/headline_trailer.gif" width="150" height="20" /></td>
                    </tr>
                    <tr>
                      <td colspan="3">
                        <form action="/result.jsp" method="post" name="AdvancedSearchForm" target="Result" id="AdvancedSearchForm" onsubmit="return doSearch();">
                          <table width="590" border="0" cellspacing="5" cellpadding="0">
                            <tr>
                              <td width="50">&nbsp;</td>
                              <td width="100">&nbsp;</td>
                              <td width="50">&nbsp;</td>
                              <td width="50">&nbsp;</td>
                              <td width="50">&nbsp;</td>
                              <td width="240">&nbsp;</td>
                              <td width="50">&nbsp;</td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                              <td align="center">Tìm</td>
                              <td>
                                <select name="Field" class="listbox" id="Field">
                                  <option value="PRIMARYTITLE" selected="selected">Tiêu 
                                  đề</option>
                                  <option value="PRIMARYAUTHOR">Tác giả</option>
                                </select>
                                
                              </td>
                              <td>
                                <select name="SearchCondition" class="listbox" id="SearchCondition">
                                  <option value="0" selected="selected">Bằng</option>
                                  <option value="1">Chứa</option>
                                </select>
                                
                              </td>
                              <td>
                                <select name="SearchType" class="listbox" id="SearchType">
                                  <option value="0" selected="selected">Từ</option>
                                  <option value="1">Chuỗi</option>
                                </select>
                                
                              </td>
                              <td align="center">
                                <input name="SearchContent" type="text" class="textbox" id="SearchContent" />
                                
                              </td>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                              <td align="center">
                                <select name="Additional" class="listbox" id="Additional">
                                  <option value="AND" selected="selected">Và</option>
                                  <option value="OR">Hoặc</option>
                                  <option value="NOT">Ngoại trừ</option>
                                </select>
                              </td>
                              <td>
                                <select name="Field" class="listbox" id="Field">
                                  <option value="PRIMARYTITLE" selected="selected">Tiêu 
                                  đề</option>
                                  <option value="PRIMARYAUTHOR">Tác giả</option>
                                </select>
                                
                              </td>
                              <td>
                                <select name="SearchCondition" class="listbox" id="SearchCondition">
                                  <option value="0" selected="selected">Bằng</option>
                                  <option value="1">Chứa</option>
                                </select>
                                
                              </td>
                              <td>
                                <select name="SearchType" class="listbox" id="SearchType">
                                  <option value="0" selected="selected">Từ</option>
                                  <option value="1">Chuỗi</option>
                                </select>
                                
                              </td>
                              <td align="center">
                                <input name="SearchContent" type="text" class="textbox" id="SearchContent" />
                                
                              </td>
                              <td>&nbsp;</td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                              <td colspan="5" align="center">
                                <input name="Search" type="submit" class="button" id="Search" value="Tìm" />
                              </td>
                              <td>&nbsp;</td>
                            </tr>
                          </table>
                        </form>
                      </td>
                    </tr>
                  </table>
                  <br />
<span id="ResultDisplay"></span>
<iframe src="" name="Result" width="0" height="0" scrolling="no" frameborder="0">
<script language="JavaScript">
changeDestination();
</script>
</iframe>
<%
	String sSearchType = "quick";
	try {
		sSearchType = request.getParameter("searchtype");
		sSearchType = sSearchType.trim().toLowerCase();
	} catch (Exception e) {}
%>
<script language="JavaScript">
<%= (sSearchType.equalsIgnoreCase("advanced")) ? "doAdvancedSearch();" : "doQuickSearch();" %>
</script>
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
