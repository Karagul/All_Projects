<%
  response.setDateHeader("Expires", -1);
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Pragma", "no-cache");
%>
<html>
<head>
<title>D I G I L I B - Confirm</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/digilib.css" type="text/css">
<script language="JavaScript" src="/digilib.js"></script>
<script language="JavaScript">
var Data = dialogArguments;
var DataSet = new String(Data.DataSet);
var Document = Data.document;
var index = Data.Index;
function onOK() {
  Data.ConfirmValue = true;
  window.close();
}

function onCancel() {
  Data.ConfirmValue = false;
  window.close();
}

function getData() {
  if (DataSet == "Librarians") {
    document.all("MessageHeader").innerHTML = "Xoa Thu thu";
    document.all("Message").innerHTML = "<b>Mã Thủ thư :</b> " + Document.all("LibrarianID", index).value + "<br>"
                                      + "<b>Tên Thủ thư :</b> " + Document.all("Name", index).value + "<br>"
                                      + "<b>Trạng thái :</b> " + ((Document.all("Status", index).value == "0") ? "Ngưng" : "Hoạt động");
  } else if (DataSet == "MemberGroups") {
    document.all("MessageHeader").innerHTML = "Xoa Nhóm độc giả";
    document.all("Message").innerHTML = "<b>Mã Nhóm :</b> " + Document.all("GroupID", index).value + "<br>"
                                      + "<b>Tên Nhóm :</b> " + Document.all("Name", index).value + "<br>"
                                      + "<b>Trạng thái :</b> " + ((Document.all("Status", index).value == "0") ? "Ngưng" : "Hoạt động");
  }
}
</script>
</head>
<body bgcolor="#FFFFFF" text="#000000" onLoad="getData();">
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="2" align="center">
  <tr>
    <td><img src="/images/header_announce.gif" width="300" height="50"></td>
  </tr>
  <tr>
    <th bgcolor="#083908" class="headline"><span id="MessageHeader"></span></th>
  </tr>
  <tr>
    <td height="100%" valign="top"><span id="Message"></span></td>
  </tr>
  <tr>
    <td align="center">
      <input type="button" name="OK" value="Submit" class="button" onClick="onOK();">
      <input type="submit" name="Cancel" value="Cancel" class="button" onClick="onCancel();">
    </td>
  </tr>
</table>
</body>
</html>
