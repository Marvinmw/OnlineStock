<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="cn.nju.edu.dao.*,
    cn.nju.edu.EjbFactory.*,java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()+"/page/css/systemer.css" %>"   rel="stylesheet" type="text/css" media="all"></link>
<script type="text/javascript"  src="<%=request.getContextPath()+"/page/js/systemer.js" %>"></script>
<title>Insert title here</title>
<%
   DiscountDao cud=(DiscountDao)EJBFactory.getEJB("ejb:CakerSaledSystem/LogincalEJB/DiscountDaoImp!"+DiscountDao.class.getName());

%>
</head>
<body>
<div id="headerTitle"></div>
<div id="container">
<form id="form" action="../updatediscout" method="post">
会员等级一
<input type="text" id="1" name="level1" value="<%=cud.getCount("0") %>"></input>
<br/>
会员等级二
<input type="text" id="2" name="level2" value="<%=cud.getCount("1") %>"></input>
<br/>
会员等级三
<input type="text" id="3" name="level3" value="<%=cud.getCount("2") %>"></input>
<br/>
<input type="button" value="确定"   onclick="change()"></input>
</form>
</div>
</body>
</html>