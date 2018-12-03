<jsp:useBean id="curMember" scope="session" class="digilib.web.Member"/>
<%
  response.setHeader("Cache-control", "no-cache");
  response.setHeader("Pragma", "no-cache");
  response.setDateHeader("Expires", -1);
  try {
  	response.setContentType(curMember.getPictureType());
  	response.getOutputStream().write(curMember.getPicture());
  } catch (NullPointerException npe) {}
%>