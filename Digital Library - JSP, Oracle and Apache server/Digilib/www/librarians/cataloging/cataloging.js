// JavaScript Document
function addTitle() {
	var oOtherTitle = document.all("OtherTitle");
	var tOtherTitle = trim(oOtherTitle.value);
	if (tOtherTitle == "") {
		alert("Vui lòng điền tiêu đề khác trước khi thêm");
		oOtherTitle.focus();
	} else {
		var oOtherTitles = document.all("OtherTitles");
		var oTitle = document.createElement("OPTION");
		oTitle.text = tOtherTitle;
		oTitle.value = tOtherTitle;
		oOtherTitles.add(oTitle);
		oOtherTitle.value = "";
	}
}

function removeTitle() {
	var oOtherTitles = document.all("OtherTitles");
	var totalNodes = oOtherTitles.length;
	var a = new Array();
	for (i = 0; i < totalNodes; i++) {
		if (oOtherTitles.children(i).selected) {
			a[i] = true;
		} else {
			a[i] = false;
		}
	}
	
	for (i = totalNodes-1; i >= 0; i--) {
		if (a[i]) {
			oOtherTitles.remove(i);
		}
	}
}

function removeAllTitles() {
	var oOtherTitles = document.all("OtherTitles");
	var totalNodes = oOtherTitles.length;
	for (i = totalNodes-1; i >= 0; i--) {
		oOtherTitles.remove(i);
	}
}

function selectAllTitles() {
	var oOtherTitles = document.all("OtherTitles");
	var totalNodes = oOtherTitles.length;
	for (i = totalNodes-1; i >= 0; i--) {
		oOtherTitles.children(i).selected = true;
	}
}

function addAuthor() {
	var oAuthor = document.all("OtherAuthor");
	var tAuthor = trim(oAuthor.value);
	if (tAuthor == "") {
		alert("Vui lòng điền tên Tác giả trước khi thêm");
		oAuthor.focus();
	} else {
		var oAuthors = document.all("OtherAuthors");
		var oAAuthor = document.createElement("OPTION");
		oAAuthor.text = tAuthor;
		oAAuthor.value = tAuthor;
		oAuthors.add(oAAuthor);
		oAuthor.value = "";
	}
}

function removeAuthor() {
	var oAuthors = document.all("OtherAuthors");
	var totalNodes = oAuthors.length;
	var a = new Array();
	for (i = 0; i < totalNodes; i++) {
		if (oAuthors.children(i).selected) {
			a[i] = true;
		} else {
			a[i] = false;
		}
	}
	
	for (i = totalNodes-1; i >= 0; i--) {
		if (a[i]) {
			oAuthors.remove(i);
		}
	}
}

function removeAllAuthors() {
	var oAuthors = document.all("OtherAuthors");
	var totalNodes = oAuthors.length;
	for (i = totalNodes-1; i >= 0; i--) {
		oAuthors.remove(i);
	}
}

function selectAllAuthors() {
	var oAuthors = document.all("OtherAuthors");
	var totalNodes = oAuthors.length;
	for (i = totalNodes-1; i >= 0; i--) {
		oAuthors.children(i).selected = true;
	}
}

function addKeyword() {
	var oKeyword = document.all("Keyword");
	var tKeyword = trim(oKeyword.value);
	if (tKeyword == "") {
		alert("Vui lòng điền Từ khóa trước khi thêm");
		oKeyword.focus();
	} else {
		var oKeywords = document.all("Keywords");
		var oAKeyword = document.createElement("OPTION");
		oAKeyword.text = tKeyword;
		oAKeyword.value = tKeyword;
		oKeywords.add(oAKeyword);
		oKeyword.value = "";
	}
}

function removeKeyword() {
	var oKeywords = document.all("Keywords");
	var totalNodes = oKeywords.length;
	var a = new Array();
	for (i = 0; i < totalNodes; i++) {
		if (oKeywords.children(i).selected) {
			a[i] = true;
		} else {
			a[i] = false;
		}
	}
	
	for (i = totalNodes-1; i >= 0; i--) {
		if (a[i]) {
			oKeywords.remove(i);
		}
	}
}

function removeAllKeywords() {
	var oKeywords = document.all("Keywords");
	var totalNodes = oKeywords.length;
	for (i = totalNodes-1; i >= 0; i--) {
		oKeywords.remove(i);
	}
}

function selectAllKeywords() {
	var oKeywords = document.all("Keywords");
	var totalNodes = oKeywords.length;
	for (i = totalNodes-1; i >= 0; i--) {
		oKeywords.children(i).selected = true;
	}
}

function checkDewey() {
	var oDewey = document.all("DDCID");
	var tDewey = oDewey.value;
	if (tDewey.length > 0) {
		if (isNaN(tDewey)) {
			alert("Mã Dewey không hợp lệ");
			oDewey.focus();		
			return false;
		} else if (!isFinite(tDewey)) {
			alert("Mã Dewey không hợp lệ");
			oDewey.focus();
			return false;
		} else if (tDewey.length < 3) {
			alert("Mã Dewey không hợp lệ");
			oDewey.focus();
			return false;
		} else if (tDewey.length > 3 && tDewey.substr(3,1) != ".") {
			alert("Mã Dewey không hợp lệ");
			oDewey.focus();
			return false;
		}
	}
	return true;
}

function updateFullEdition() {
	var oDewey = document.all("DDCID");
	if (checkDewey()) {
		document.all("FullEdition").value = document.all("DDCID").value + " " + document.all("Edition").value;
	} else {
		oDewey.focus();
	}
}

function resetForm() {
	removeAllTitles();
	removeAllAuthors();
	removeAllKeywords();
}

function submitForm() {
	selectAllTitles();
	selectAllAuthors();
	selectAllKeywords();
	
	return true;
}

function browseDewey() {
	window.open("deweybrowsing.jsp?pagesize=10", "", "height=300px; width=550px; location=no; menubar=no; resizable=no; scrollbars=yes; status=no; titlebar=yes; toolbar=no;");
}