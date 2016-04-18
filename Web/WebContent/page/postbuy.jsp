<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tips</title>
</head>
<body>
<form action="/Web/ReLogin" method="get">
<%=request.getAttribute("sum") %>
<input type="submit"  value="确定"> 
</form>
</body>
</html>