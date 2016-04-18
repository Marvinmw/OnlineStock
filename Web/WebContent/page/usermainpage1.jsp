<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="<%=request.getContextPath()+"/page/js/usermainpage.js"%>"></script>
<link type="text/css" href="<%=request.getContextPath()+"/page/css/usermanpage.css"%>" media="all" rel="stylesheet" />

<title>甜心屋</title>
</head>
<body>
<div id="headerTitle"></div>
<div id="container">

<div id="nav">
<ul>
  <li class=" "><a href="<%=request.getContextPath()+"/page/FirstPage.jsp"%>">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li class=""><a href="<%=request.getContextPath()+"/page/usermainpage.jsp"%>">糕点</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li class=""><a href="<%=request.getContextPath()+"/page/recharge.jsp"%>">会员卡管理</a>&nbsp;&nbsp;&nbsp;&nbsp;</li> 
 </ul> 
 </div>
<div id="show">
<table>
<tr>
<td>
<div>
<img src="<%=request.getContextPath()+"/page/source/1.jpg"%>" />
<form action="../Web/PreBuy"   method="post">
雪域天使&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type" value="1"/>
<input type="hidden" name="price" value="90"/>
</form>
</div>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/2.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
巧克力慕斯蛋糕&nbsp;￥90<br/>
数量
<input type="text" name="number"  style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type" value="2"/>
<input type="hidden" name="price" value="90"/></form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/3.jpg"%>" />
<form action="../Web/PreBuy"   method="post">
抹茶情深&nbsp;￥90<br/>
数量
<input type="text" name="number"  style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type" value="3"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/4.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
月光倾城&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="4"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/5.jpg"%>"/>
<input type="hidden" name="price" value="90"/>
<form action="../Web/PreBuy"   method="post">
神秘园&nbsp;￥90<br/>
数量
<input type="text"  name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="5"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/6.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
奇栗秋香&nbsp;￥90<br/>
数量
<input type="text" name="number"  style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="6"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/7.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
唇齿留香&nbsp;￥90<br/>
数量
<input type="text"  name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="7"/>
<input type="hidden" name="price" value="90"/>
</form>
</td
></tr>

<tr>
<td>
<div>
<img src="<%=request.getContextPath()+"/page/source/8.jpg"%>" />
<form action="../Web/PreBuy"   method="post">
留香&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="8"/>
<input type="hidden" name="price" value="90"/>
</form>
</div>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/15.jpg"%>" />
<form action="../Web/PreBuy"   method="post">
夜礼服假面&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="15"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/10.jpg"%>" />
<form action="../Web/PreBuy"   method="post">
水果漩涡&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="10"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/11.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
梦幻花园&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="11"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/12.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
冬日漫步&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="12"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/13.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
延年益寿&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="13"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/14.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
田园风光&nbsp;￥90<br/>
数量
<input type="text" name="number"  style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type"  value="14"/>
<input type="hidden" name="price" value="90"/>
</form>
</td
></tr>
<tr>
<td>
<div>
<img src="<%=request.getContextPath()+"/page/source/15.jpg"%>" />
<form action="../Web/PreBuy"   method="post">
巧克力森林&nbsp;￥90<br/>
数量
<input type="text" name="number"  style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type" value="16"/>
<input type="hidden" name="price" value="90"/>
</form>
</div>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/16.jpg"%>" />
<form action="../Web/PreBuy"   method="post">
巧克力浓情&nbsp;￥90<br/>
数量
<input type="text"  name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="price" value="90"/>
<input type="hidden" name="type" value="17"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/17.jpg"%>" />
<form action="../Web/PreBuy"   method="post">
幸福港湾&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type" value="18"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/18.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
假面骑士&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="price" value="90"/>
<input type="hidden" name="type" value="19"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/19.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
财源滚滚&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type" value="20"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/20.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
绿野仙踪&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type" value="21"/>
<input type="hidden" name="price" value="90"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/21.jpg"%>"/>
<form action="../Web/PreBuy"   method="post">
浪漫之约&nbsp;￥90<br/>
数量
<input type="text" name="number" style="width:30px"/>
<br/>
<input type="submit" value="购买"/>
<input type="hidden" name="type" value="22"/>
<input type="hidden" name="price" value="90"/>
</form>
</td
></tr>
</table>
</div>
</div>     
</body>
</html>
