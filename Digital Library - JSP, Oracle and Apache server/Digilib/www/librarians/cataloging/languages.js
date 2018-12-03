// JavaScript Document
function checkLanguageID(index) {
	document.all("LanguageID", index).value = trim(document.all("LanguageID", index).value).toUpperCase();
}

function checkData(index) {
	if (trim(document.all("LanguageID", index).value) == "") {
		alert("Vui lòng điền Mã ngôn ngữ");
		document.all("LanguageID", index).focus();
		return false;
	} else if (trim(document.all("Name", index).value) == "") {
		alert("Vui lòng điền tên ngôn ngữ");
		document.all("Name", index).focus();
		return false;
	}
	return true;
}