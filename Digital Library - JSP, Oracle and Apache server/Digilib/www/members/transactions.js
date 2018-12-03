// JavaScript Document
function doSelectAll() {
	if (document.all("accepted") != null) {
		var totalItems = document.all("accepted").length;
		if (isNaN(totalItems)) {
			totalItems = 1;
		}
	} else {
		var totalItems = 0;
	}
	var status = document.all("SelectAll", 0).checked;
	for (i = 0; i < totalItems; i++) {
		document.all("accepted", i).checked = status;
	}
}

function checkData() {
	if (document.all("accepted") != null) {
		var totalItems = document.all("accepted").length;
		if (isNaN(totalItems)) {
			totalItems = 1;
		}
	} else {
		var totalItems = 0;
	}
	for (i = 0; i < totalItems; i++) {
		if (document.all("accepted", i).checked) {
			return true;
		}
	}
	alert("Bạn phải chọn ít nhất một mục để lập phiếu");
	return false;
}