// JavaScript Document
function checkGroupID(index) {
	var GroupID = trim(document.all("GroupID", index).value);
	document.all("GroupID", index).value = GroupID.toUpperCase();
}

function checkData(index) {
	var obj = document.forms(DataForm);
	if (trim(obj.item("GroupID", index).value) == "") {
		alert("Vui lòng điền mã Nhóm");
		obj.item("GroupID", index).focus();
		return false;
	} else if (trim(obj.item("Name", index).value) == "") {
		alert ("Vui lòng điền tên nhóm");
		obj.item("Name", index).focus();
		return false;		
	} else if (!isNumberInt(obj.item("MaxBookings", index).value)) {
		alert("Xin vui lòng nhập 1 số hợp lệ");
		obj.item("MaxBookings", index).focus();
		return false;
	} else if (!isNumberInt(obj.item("MaxLoans", index).value)) {
		alert("Xin vui lòng nhập 1 số hợp lệ");
		obj.item("MaxLoans", index).focus();
		return false;
	} else if (!isNumberInt(obj.item("MaxExpansions", index).value)) {
		alert("Xin vui lòng nhập 1 số hợp lệ");
		obj.item("MaxExpansions", index).focus();
		return false;
	} else if (!isNumberInt(obj.item("BookingDuration", index).value)) {
		alert("Xin vui lòng nhập 1 số hợp lệ");
		obj.item("BookingDuration", index).focus();
		return false;
	} else if (!isNumberInt(obj.item("LoanDuration", index).value)) {
		alert("Xin vui lòng nhập 1 số hợp lệ");
		obj.item("LoanDuration", index).focus();
		return false;
	} else if (!isNumberInt(obj.item("ExpansionDuration", index).value)) {
		alert("Xin vui lòng nhập 1 số hợp lệ");
		obj.item("ExpansionDuration", index).focus();
		return false;
	} else if (!isNumberInt(obj.item("ChargeRate", index).value)) {
		alert("Xin vui lòng nhập 1 số hợp lệ");
		obj.item("ChargeRate", index).focus();
		return false;
	} else if (!isNumberInt(obj.item("MembershipDuration", index).value)) {
		alert("Xin vui lòng nhập 1 số hợp lệ");
		obj.item("MembershipDuration", index).focus();
		return false;
	}
	return true;
}