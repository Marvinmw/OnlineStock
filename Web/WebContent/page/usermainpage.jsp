<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  session="false"%>
 
<%@page import="cn.nju.edu.tool.ProductShow" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=request.getContextPath()+"/page/js/usermainpage.js"%>"></script>
<link type="text/css" href="<%=request.getContextPath()+"/page/css/usermanpage.css"%>" media="all" rel="stylesheet" />
 <script type="text/javascript" src="<%=request.getContextPath()+"/page/js/jquery.colorbox.js" %>"></script>
 <script type="text/javascript" src="<%=request.getContextPath()+"/page/js/jquery-1.4.2.min.js" %>"></script>
<script type="text/javascript" src="<%=request.getContextPath()+"/page/js/jquery.jcarousel.min.js" %>"></script>
<link href="<%=request.getContextPath()+"/page/css/skin2.css" %>" rel="stylesheet" type="text/css" media="all" />
<%
  ProductShow  ps=new ProductShow();
  Iterator<String> itr=ps.getItr();
  int n=1;
%>
<title>甜心屋</title>

 <script type="text/javascript">


function mycarousel_initCallback(carousel)
{
    // Disable autoscrolling if the user clicks the prev or next button.
    carousel.buttonNext.bind('click', function() {
        carousel.startAuto(0);
    });

    carousel.buttonPrev.bind('click', function() {
        carousel.startAuto(0);
    });

    // Pause autoscrolling if the user moves with the cursor over the clip.
    carousel.clip.hover(function() {
        carousel.stopAuto();
    }, function() {
        carousel.startAuto();
    });
};

jQuery(document).ready(function() {
    jQuery('#mycarousel').jcarousel({
        auto: 5,
        wrap: 'last',
		visible:5,
		wrap:"both",
        initCallback: mycarousel_initCallback
    });
});



</script> 
</head>
<body>
<div id="headerTitle"></div>
<div id="container">

<div id="nav">
<ul>
  <li class=" "><a href="<%=request.getContextPath()+"/page/login.jsp"%>">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li class=""><a href="<%=request.getContextPath()+"/page/usermainpage.jsp"%>">糕点</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li class=""><a href="<%=request.getContextPath()+"/page/recharge.jsp"%>">会员卡管理</a>&nbsp;&nbsp;&nbsp;&nbsp;</li> 
  <li class=""><a href="<%=request.getContextPath()+"/page/salerlog.jsp"%>">销售记录</a>&nbsp;&nbsp;&nbsp;&nbsp;</li> 
  <li class=""><a href="<%=request.getContextPath()+"/page/modifyPersonInfo.jsp"%>">修改个人信息</a>&nbsp;&nbsp;&nbsp;&nbsp;</li> 
 </ul> 
 </div>
<div id="show">

<ul id="mycarousel" class=" jcarousel-skin-tango" style="width:90px;height:90px;">
<script>
  document.getElementById("mycarousel").style.height="500px";
</script>
  <%while(itr.hasNext()){
	String key=itr.next();
	%>
   <li>
   <div>
   <img src="<%=request.getContextPath()+"/page/source/"+n+".jpg"%>" />
   <form action="../Web/PreBuy"   method="post">
    <%=key %>&nbsp;￥<%=ps.getPrice(key) %><br/>
           数量
    <input type="text" name="number" style="width:30px"/>
   <br/>
    <input type="submit" value="购买"/>
    <input type="hidden" name="type" value="<%=n %>"/>
    <input type="hidden" name="price" value="<%=ps.getPrice(key) %>"/>
   </form>
   </div>
   </li>
   <%
   n++;
   } %>

 
</ul>


</div>
</div>     
</body>
</html>
