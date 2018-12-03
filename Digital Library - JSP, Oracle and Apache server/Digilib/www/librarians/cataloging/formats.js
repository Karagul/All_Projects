// JavaScript Document
function checkFormatID(index) {
	document.all("FormatID", index).value = trim(document.all("FormatID", index).value).toUpperCase();
}

function checkData(index) {
	if (trim(document.all("FormatID", index).value) == "") {
		alert("Vui lòng điền Mã định dạng");
		document.all("FormatID", index).focus();
		return false;
	} else if (trim(document.all("Name", index).value) == "") {
		alert("Vui lòng điền tên định dạng");
		document.all("Name", index).focus();
		return false;
	}
	return true;
}