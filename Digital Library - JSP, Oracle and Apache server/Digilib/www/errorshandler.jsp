<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=utf-8" isErrorPage="true" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>D I G I L I B &gt; Error Handler</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
Errors occurred in processing<br /> 
Errors
<%= exception%> at <br />
<pre><% exception.printStackTrace(new PrintWriter(out)); %></pre>
</body>
</html>
