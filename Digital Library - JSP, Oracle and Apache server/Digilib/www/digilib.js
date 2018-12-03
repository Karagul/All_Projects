function trim(st) {
  var temp = new String(st);
  var startpos = 0;
  var endpos = 0;
  for (i = 0; i < temp.length; i++) {
    if (temp.charAt(i) != " ") {
      startpos = i;
      break;
    }
  }
  for (i = temp.length-1; i > -1; i--) {
    if (temp.charAt(i) != " ") {
      endpos = i+1;
      break;
    }
  }
  return temp.substring(startpos, endpos);
}

function compareString(st1, st2) {
  if (st1.length == st2.length && st1.indexOf(st2) != -1) {
    return true;
  }
  else {
    return false;
  }
}

function isNumberInt(inputString)
{
  return (!isNaN(parseInt(inputString))) ? true : false;
}

function announce(referer) {
  showModalDialog("/announces.jsp", window, "dialogHeight: 220px; dialogWidth: 320px; scroll: no; status: no;");
  document.location.href = referer;
}

var ConfirmValue = false;
var Index = 0;
function confirm(index) {
  Index = index;
  showModalDialog("/confirms.jsp", window, "dialogHeight: 220px; dialogWidth: 420px; scroll: no; status: no;");
  return ConfirmValue;
}