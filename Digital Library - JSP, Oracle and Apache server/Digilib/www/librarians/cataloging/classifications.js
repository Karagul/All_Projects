// JavaScript Document
function checkDDCID(index) {
	var oDewey = document.all("DDCID",index);
	var tDewey = trim(oDewey.value);
	if (tDewey.length > 0) {
		if (isNaN(tDewey)) {
			alert("Mã Dewey không hợp lệ 1");
			oDewey.focus();		
			return false;
		} else if (!isFinite(tDewey)) {
			alert("Mã Dewey không hợp lệ 2");
			oDewey.focus();
			return false;
		} else if (tDewey.length < 3) {
			alert("Mã Dewey không hợp lệ 3");
			oDewey.focus();
			return false;
		} else if (tDewey.length > 3 && tDewey.substr(3,1) != ".") {
			alert("Mã Dewey không hợp lệ 4");
			alert(tDewey.length);
			oDewey.focus();
			return false;
		}
	}
	return true;
}

function checkData(index) {
	if (checkDDCID(index)) {
		if (trim(document.all("Name", index).value) != "") {
			return true;
		}
		alert("Vui lòng điền tên phân loại");
		document.all("Name", index).focus();
	}
	return false;
}