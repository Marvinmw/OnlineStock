<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link type="text/css" href="<%=request.getContextPath()+"/page/css/saler.css"%>" media="all" rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()+"/page/js/personliker.js" %>"></script>
<title>Insert title here</title>
</head>
<body>
<div id="headerTitle"></div>
<div id="container">
<div  id="form">
<form action="../personliker"  method="post">
输入会员卡号
<input type="text" id="cardid" name="card"/>
<input type="submit" value="确定">
<!-- 
<input type="button" onclick="commit()" value="查询"/>
 -->
</form>
</div>
</body>
</html>