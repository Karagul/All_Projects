// JavaScript Document
function checkLibrarianID(index) {
  var LibrarianID = trim(document.all("LibrarianID", index).value);
  document.all("LibrarianID", index).value = LibrarianID.toUpperCase();
}

function checkName(index) {
  var Name = trim(document.all("Name", index).value);
  document.all("Name", index).value = Name;
}

function checkPassword(index) {
  var Password = trim(document.all("Password", index).value);
  document.all("Password", index).value = Password;
}

function checkConfirmPassword(index) {
  var Password = trim(document.all("ConfirmPassword", index).value);
  document.all("ConfirmPassword", index).value = Password;
}

function checkData(index) {
	var obj = document.forms(DataForm);
	if (trim(obj.item("LibrarianID", index).value) == "") {
		alert("Vui lòng điền mã thủ thư");
		obj.item("LibrarianID", index).focus();
		return false;
	} else if (trim(obj.item("Name", index).value) == "") {
		alert("Vui lòng điền tên thủ thư");
		obj.item("Name", index).focus();
		return false;
	} else if (trim(obj.item("Password", index).value) == "") {
		alert("Vui lòng điền mật khẩu");
		obj.item("Password", index).focus();
		return false;
	} else if (trim(obj.item("Password", index).value) != trim(obj.item("ConfirmPassword", index).value)) {
		alert("Xác nhận mật khẩu không đúng\r\n,Xin vui lòng chọn lại mật khẩu");
		obj.item("Password", index).focus();
		return false;
	}
	return true;
}