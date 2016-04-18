<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/saler.css" rel="stylesheet" media="all"/>
<script type="text/javascript" src="js/saler.js"></script>
<title>甜心屋</title>
</head>

<body>
<div id="headerTitle"></div>
<div id="container">
<div id="input">
产品编号
<input type="text" id="product"/>
&nbsp;&nbsp;&nbsp;
产品数量
<input type="text" id="number"/>
&nbsp;&nbsp;&nbsp;
单价
<input type="text" id="price"/>
<input type="button" onclick="addProduct()"  value="确定"/>
</div>
<form id="order"  action="../buydealer"  method="post">
<div id="show">
<table id="prolist">
<tbody id="table">
<tr><th>产品编号</th><th>产品数量</th><th>产品单价</th></tr>
</tbody>
</table>
</div>
总额&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="sum" id="sum" readonly="readonly" />
(单位人民币)
<br/>
会员卡号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" id="card"  />
会员卡支付金额
<input type="text" id="money"/>
<br/>
现金支付金额
<input type="text" id="cash"/>
<br/>
找零&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" id="charge"/>
<br/>
<input type="hidden" id="bills" value=""/>
<input type="button"  value="清除"  onclick="clear()"/>
<input type="button" value="提交"  onclick="commit()"/>
</form>
</div>
</body>
</html>
