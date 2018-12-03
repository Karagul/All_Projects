<jsp:useBean id="RList" scope="page" class="digilib.view.Registration"/>
<%
  response.setHeader("Cache-control", "no-cache");
  response.setHeader("Pragma", "no-cache");
  response.setDateHeader("Expires", -1);
  long RegistrationNo = 0;
  String sRegistrationNo = "";
  try {
    sRegistrationNo = request.getParameter("registrationno").trim();
    RegistrationNo = Long.parseLong(sRegistrationNo);
  }
  catch (Exception e) {}
  RList.setCriteria("REGISTRATIONNO = " + RegistrationNo);
  RList.open();
  try {
    if (RList.next()) {
      response.setContentType(RList.getPictureType());
      response.getOutputStream().write(RList.getPicture());
    }
  }
  catch (Exception e) { }
  RList.close();
%>