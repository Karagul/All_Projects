// JavaScript Document
function doQuickSearch() {
	document.all("divQuickSearch").style.display = "inline";
	document.all("divAdvancedSearch").style.display = "none";
}

function doAdvancedSearch() {
	document.all("divQuickSearch").style.display = "none";
	document.all("divAdvancedSearch").style.display = "inline";
}

function doSearch() {
	document.all("ResultDisplay").innerHTML = "<h5>Please,wait while system is searching....</h5>";
	return true;
}

function changeDestination() {
	document.forms("QuickSearchForm").target = "";
	document.forms("AdvancedSearchForm").target = "";
}

function showResult() {
	var obj = window.parent.document.all("ResultDisplay");
	if (obj != null) {		
		obj.innerHTML = document.all("Result").innerHTML;
	}
}

function gotoPage(page) {
  if (page > 0) {
  	var obj = document.forms("SearchResultForm");
	if (window.parent.document.all("ResultDisplay") == null) {
  		var page = document.all("page").value;
  		var pagesize = document.all("pagesize").value;
  		document.location.href = "?page="+page+"&pagesize="+pagesize;
	} else {
		obj.item("page").value = page;
		obj.action = "result.jsp";
		obj.target = "Result";
		obj.method = "GET";
		obj.submit();
	}
  }
}

function setPageSize() {
	var obj = document.forms("SearchResultForm");
	if (window.parent.document.all("ResultDisplay") == null) {
  		var page = document.all("page").value;
  		var pagesize = document.all("pagesize").value;
  		document.location.href = "?page="+page+"&pagesize="+pagesize;
	} else {
		obj.action = "result.jsp";
		obj.target = "Result";
		obj.method = "GET";
		obj.submit();
	}
}

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
	alert("Please,choose at least one");
	return false;
}