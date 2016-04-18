<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
<link href="css/skin.css" rel="stylesheet" type="text/css" media="all" />
 <script type="text/javascript" src="js/javascript100.min.js" ></script>
 <script type="text/javascript" src="js/jquery.colorbox.js"></script>
 <script type="text/javascript" src="js/login.js"></script>
<link href="css/colorbox.css" rel="stylesheet" type="text/css" media="all"/>
 <link href="css/login.css" rel="stylesheet" type="text/css"  media="all" /> 
 
<title>甜心屋</title>
</head>

<body  id="body">
<div id="top">
<div id="topcontent">
<span id="setFirst"  onmouseover="mouseover(this.id)"  onmouseout="mouseout(this.id)"> 设为首页</span>  |  
<span id="favor"   onmouseover="mouseover(this.id)"  onmouseout="mouseout(this.id)"> 加入收藏</span>
</div>
</div>
<div id="container">
<div id="headerTitle"></div>

</div>
<div id="content">
<div id="formblock">
<form action="../login" method="post"  id="info">
<strong id="userlab" class="lab">
用户：
</strong>
<input id="user" type="text" name="user" style="height:30px;width:200px;background:transparent;border:1px solid #ffffff;border-width:6; border-color:#CCCCCC;color:#000000;"   onmouseover="mouseoverinput(this.id,'userlab')"  onmouseout="mouseoutinput(this.id,'userlab')"  />
<br /><br />
<strong id="passlab" class="lab">
密码：
</strong>
<input  id="pass" type="password" name="password" style="height:30px;width:200px;background:transparent;border:1px solid #ffffff;border-width:6; border-color:#CCCCCC;color:#000000;" 
  onmouseover="mouseoverinput(this.id,'passlab')"  onmouseout="mouseoutinput(this.id,'passlab')" />
<p style="padding-left:5%;">
<span style="font-size:12px;color:#666666;">
身份
</span>
<select name="status"   style="color:#666666;">
<option value="user">user</option>
<option value="root"  selected="selected">root</option>
</select>
<input id="login" type="button"  style="color:#666666;background-color:rgb(45,230,189)" value="登陆" onclick="check()"  onmouseover="mouseover(this.id)"  onmouseout="mouseout(this.id)" />
<input id="reset" type="reset"  style="color:#666666;background-color:rgb(45,230,189)" value="重置"  onmouseover="mouseover(this.id)"  onmouseout="mouseout(this.id)" />
</p>
</form>
</div>


</div>


<div id="footer"><strong> 您的喜爱是我们最大的动力！谢谢您的支持！</strong></div>

</body>
</html>
