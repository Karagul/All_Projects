// JavaScript Document
function checkMemberID() {
	if (!isNumberInt(document.all("MemberID", 0).value)) {
		alert("Mã số thẻ không hợp lệ");
		document.all("MemberID", 0).focus();
		return false;
	} else if (!isNumberInt(document.all("MemberID", 1).value)) {
		alert("Mã số thẻ không hợp lệ");
		document.all("MemberID", 1).focus();
		return false;
	} else if (!isNumberInt(document.all("MemberID", 0).value)) {
		alert("Mã số thẻ không hợp lệ");
		document.all("MemberID", 2).focus();
		return false;
	}
	return true;
}

function setPicture() {
	if (document.all("Picture").value != "") {
		document.all("PictureDisplay").src = document.all("Picture").value;
	} else {
		document.all("PictureDisplay").src = "/images/currentmember.jsp";
	}
}

function checkData(index) {
	if (trim(document.all("Name", index).value) == "") {
		alert("Vui lòng điền Họ tên vào bản đăng ký");
		document.all("Name", index).focus();
		return false;
	}
	if (document.all("Day", index).value == "-1") {
		alert("Vui lòng điền ngày tháng năm sinh của bạn vào bản đăng ký");
		document.all("Day", index).focus();
		return false;
	}
	if (document.all("Month", index).value == "-1") {
		alert("Vui lòng điền ngày tháng năm sinh của bạn vào bản đăng ký");
		document.all("Month", index).focus();
		return false;
	}
	if (document.all("Year", index).value == "-1") {
		alert("Vui lòng điền ngày tháng năm sinh của bạn vào bản đăng ký");
		document.all("Year", index).focus();
		return false;
	}
	if (trim(document.all("Address", index).value) == "") {
		alert("Vui lòng điền địa chỉ của bạn vào bản đăng ký");
		document.all("Address", index).focus();
		return false;
	}
	if (trim(document.all("Email", index).value) == "") {
		alert("Vui lòng điền địa chỉ Email của bạn vào bản đăng ký");
		document.all("Email", index).focus();
		return false;
	}
	if (trim(document.all("Password", index).value) == "") {
		alert("Vui lòng chọn mật khẩu của bạn");
		document.all("Password", index).focus();
		return false;
	}
	if (trim(document.all("Password", index).value) != trim(document.all("ConfirmPassword", index).value)) {
		alert("Xác nhận mật khẩu không đúng, vui lòng chọn lại mật khẩu");
		document.all("Password", index).focus();
		return false;
	}
	return true;
}