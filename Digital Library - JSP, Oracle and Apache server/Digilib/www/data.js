var DataForm = "";
var DataFormAction = "";
var DataSet = "";

function doEdit(index) {
  var totalForms = document.forms.length;
  for (i = 0; i < totalForms; i++) {
    document.forms(i).reset();
  }

  var totalRecords = 1;
  if (document.all("divDisplay").length != null) {
    totalRecords = document.all("divDisplay").length;
  }
  for (i = 0; i < totalRecords; i++) {
    if (i != index) {
      document.all("divDisplay", i).style.display = "inline";
      document.all("divEdit", i).style.display = "none";
    }
    else {
      document.all("divDisplay", i).style.display = "none";
      document.all("divEdit", i).style.display = "inline";
    }
  }

  var obj = document.forms(DataForm);
  obj.method = "POST";
  obj.action = DataFormAction + "?action=update&affected=" + index;
}

function doCancel(index) {
  document.all("divDisplay", index).style.display = "inline";
  document.all("divEdit", index).style.display = "none";
}

function doAdd(index) {
  doEdit(index);
  var obj = document.forms(DataForm);
  obj.method = "POST";
  obj.action = DataFormAction + "?action=add&affected=" + index;
}

function doApply(index, confirm) {
  if (confirm) {
    if (checkData(index)) {
      document.forms(DataForm).submit();
    }
    else {
      return false;
    }
  } else {
  	document.forms(DataForm).submit();
  }
  return false;
}

function doRemove(index) {
  if (confirm(index)) {
    var obj = document.forms(DataForm);
    obj.action = DataFormAction + "?action=remove&affected=" + index;
    obj.method = "POST";
    obj.submit();
  }
}

function gotoPage(page) {
  if (page > 0) {
    var pagesize = document.all.item("pagesize").value;
	var sHref = "?page="+page+"&pagesize="+pagesize;
	  var filter = document.all("filter");
	  if (filter != null && filter.value != null) {
  		sHref = sHref + "&filter=" + trim(filter.value);		
	  }
    document.location.href = sHref;
  }
}

function setPageSize() {
  var page = document.all("page").value;
  var pagesize = document.all("pagesize").value;
  var sHref = "?page="+page+"&pagesize="+pagesize;
  var filter = document.all("filter");
  if (filter != null && filter.value != null) {
  	sHref = sHref + "&filter=" + trim(filter.value);		
  }
  document.location.href = sHref;
}