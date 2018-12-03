<jsp:useBean id="MList" scope="page" class="digilib.view.Member"/>
<%
  response.setHeader("Cache-control", "no-cache");
  response.setHeader("Pragma", "no-cache");
  response.setDateHeader("Expires", -1);
  String sMemberID = "";
  try {
    sMemberID = request.getParameter("memberid").trim();
  }
  catch (Exception e) {}
  MList.setCriteria("MEMBERID = '" + sMemberID + "'");
  MList.open();
  try {
    if (MList.next()) {
      response.setContentType(MList.getPictureType());
      response.getOutputStream().write(MList.getPicture());
    }
  }
  catch (Exception e) { }
  MList.close();
%>