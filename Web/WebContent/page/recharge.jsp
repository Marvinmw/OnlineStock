<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" href="css/recharge.css"  rel="stylesheet" media="all" />
 <script type="text/javascript" src="js/recharge.js"></script>
<title>甜心屋</title>
</head>

<body>
<div id="headerTitle"></div>
<div id="container">
<div id="content">
<form action="../ChargeServlet"  method="get">
银行卡号
<input type="text" name="card" style=" margin-bottom:10px" />
<select>
<option value="gonghang">工商银行</option>
<option value="nonghang">农业银行</option>
<option  value="youzhen">邮政</option>
<option value="jiaotong">交通银行</option>
</select>
<br/>
充值金额
<input type="text" name="money"  style="margin-bottom:10px"/>
<br/>
会员卡号
<input type="text" name="member_card" />
<br/>
<input type="submit" value="提交"/>
<input type="button" value="查看历史记录" onclick="lookHis()"></input>
<input type="reset"  value="重置"/>
</form>
<form  action="../StopCard"  method="get">
<p>
<strong >
停止使用会员卡,请在下面输入会员卡
</strong>
</p>
输入会员卡号
<br/>
<input type="text" name="card" />
<input type="submit" value="提交"/>
</form>
</div>
</div>
</body>
</html>
