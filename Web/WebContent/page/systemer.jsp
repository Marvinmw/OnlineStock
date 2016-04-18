<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()+"/page/css/systemer.css" %>"   rel="stylesheet" type="text/css" media="all"></link>
<script type="text/javascript"  src="<%=request.getContextPath()+"/page/js/systemer.js" %>"></script>
<script type="text/javascript" src="<%=request.getContextPath()+"/page/js/usermainpage.js"%>"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="headerTitle"></div>
	<div id="nav">
	<ul>
  <li class="fuck"><a href="<%=request.getContextPath()+"/page/login.jsp"%>">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li class="fuck"><a href="<%=request.getContextPath()+"/page/systemer.jsp"%>">店面管理</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li class="fuck"><a href="<%=request.getContextPath()+"/page/level.jsp"%>">优惠管理</a>&nbsp;&nbsp;&nbsp;&nbsp;</li> 
  <li class="fuck"><a onclick="showPersonInfo()">查看个人信息</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
 </ul> 
	</div>
	<div id="container">
	<div>
   <form id="form" action="">
	输入店面代号
	<input type="text" name="storeid"  id="storeid"></input>
	<input type="button" value="确定" onclick="commit()"></input>
	<input type="button" value="修改"  onclick="modify()"></input>
	<input type="button"  value="添加"  onclick="add()"></input>
	<input type="button"  value="删除"  onclick="deletemember()"></input>

	
	
	
	<div id="show">
	<ul id="list">
	
	</ul>
	</div>
	
	</form>
	</div>
	</div>
</body>
</html>