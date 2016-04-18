<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="<%=request.getContextPath()+"/page/js/usermainpage.js"%>"></script>
<link type="text/css" href="<%=request.getContextPath()+"/page/css/member.css"%>" media="all" rel="stylesheet" />

<title>甜心屋</title>
</head>
<body>
<div id="headerTitle"></div>
<div id="container">

<div id="nav">
<ul>
  <li class=" "><a href="<%=request.getContextPath()+"/page/login.jsp"%>">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li class=""><a href="<%=request.getContextPath()+"/page/memberpage.jsp"%>">糕点管理</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li class=""><a href="<%=request.getContextPath()+"/page/saler.jsp"%>">销售</a>&nbsp;&nbsp;&nbsp;&nbsp;</li> 
  <li class=""><a onclick="showPersonInfo()">查看个人信息</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
 </ul> 
 </div>
<div id="show">

<table>
<tr>
<td>
<div>
<img src="<%=request.getContextPath()+"/page/source/1.jpg"%>" />
<form  action="../Web/productmanager" method="post">
雪域天使&nbsp;<select name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select>
<br/>

可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type" value="1"/>
</form>
</div>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/2.jpg"%>" />
<form  action="../Web/productmanager" method="post">
慕斯蛋糕&nbsp;<select><option value="1"  name="day">周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="2"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/3.jpg"%>" />
<form  action="../Web/productmanager" method="post">
抹茶情深&nbsp;
<select  name="day"><option value="1" >周一</option>
<option value="1" >周二</option><option value="1" >周三</option>
<option value="1" >周四</option><option value="1" >周五</option>
<option value="1" >周六</option><option value="1" >周日</option>
</select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="3"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/4.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
月光倾城&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="4"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/5.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
神秘园&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="5"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/6.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
奇栗秋香&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="6"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/7.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
唇齿留香&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="7"/>
</form>
</td
></tr>

<tr>
<td>
<div>
<img src="<%=request.getContextPath()+"/page/source/8.jpg"%>" />
<form  action="../Web/productmanager" method="post">
唇齿留香&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="8"/>
</form>
</div>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/9.jpg"%>" />
<form  action="../Web/productmanager" method="post">
夜礼服假面&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="9"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/10.jpg"%>" />
<form  action="../Web/productmanager" method="post">
水果漩涡&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="10"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/11.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
梦幻花园&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="11"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/12.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
冬日漫步&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="12"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/13.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
延年益寿&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden"  name="type" value="13"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/14.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
田园风光&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="14"/>
</form>
</td
></tr>
<tr>
<td>
<div>
<img src="<%=request.getContextPath()+"/page/source/15.jpg"%>" />
<form  action="../Web/productmanager" method="post">
巧克力森林&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden"  name="type" value="15"/>
</form>
</div>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/16.jpg"%>" />
<form  action="../Web/productmanager" method="post">
巧克力浓情&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="16"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/17.jpg"%>" />
<form  action="../Web/productmanager" method="post">
幸福港湾&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="17"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/18.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
假面骑士&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="18"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/19.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
财源滚滚&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden"  name="type" value="19"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/20.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
绿野仙踪&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="20"/>
</form>
</td>
<td>
<img src="<%=request.getContextPath()+"/page/source/21.jpg"%>"/>
<form  action="../Web/productmanager" method="post">
浪漫之约&nbsp;<select  name="day"><option value="1" >周一</option><option value="1" >周二</option><option value="1" >周三</option><option value="1" >周四</option><option value="1" >周五</option><option value="1" >周六</option><option value="1" >周日</option></select><br/>
可售数量
<input type="text" name="number"  style="width:30px"/>
<br/>
价格&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="price"  style="width:30px"/>
<br/>
<input type="submit" value="确定"/>
<input type="hidden" name="type"  value="21"/>
</form>
</td
></tr>
</table>
</div>
</div>     
</body>
</html>
