<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=request.getContextPath()+"/page/js/jquery-1.4.2.min.js" %>"></script>
<script type="text/javascript" src="<%=request.getContextPath()+"/page/js/jquery.jcarousel.min.js" %>"></script>
<link href="<%=request.getContextPath()+"/page/css/skin.css" %>" rel="stylesheet" type="text/css" media="all" />
 <script type="text/javascript" src="<%=request.getContextPath()+"/page/js/javascript100.min.js" %>" ></script>
 <script type="text/javascript" src="<%=request.getContextPath()+"/page/js/fitstpage.js" %>"></script>
 <script type="text/javascript" src="<%=request.getContextPath()+"/page/js/jquery.colorbox.js" %>"></script>
<link href="<%=request.getContextPath()+"/page/css/colorbox.css" %>" rel="stylesheet" type="text/css" media="all"/>
 <link href="<%=request.getContextPath()+"/page/css/fitstpage.css" %>" rel="stylesheet" type="text/css"  media="all" /> 
 

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

<title>甜心屋</title>
</head>

<body>
<div id="top">
<div id="topcontent">
<span id="setFirst"  onmouseover="mouseover(this.id)"  onmouseout="mouseout(this.id)"> 设为首页</span>  |  
<span id="favor"   onmouseover="mouseover(this.id)"  onmouseout="mouseout(this.id)"> 加入收藏</span>
</div>
</div>
<div id="container">
<div id="headerTitle"></div>
<div id="leftniv">
 <ul>
        <li><a href="<%=request.getContextPath()+"/page/login.jsp" %>">登陆</a></li>
        <li><a href="<%=request.getContextPath()+"/page/register.jsp" %>">注册</a></li>
        <li><a href="#">联系</a></li>
    </ul>
</div>
<div id="content">
<div><h2>产品展示</h2></div>
<div id="show">
<ul id="mycarousel" class=" jcarousel-skin-tango" style="width:90px;height:90px;">
<script>
  document.getElementById("mycarousel").style.height="250px";
</script>
  <li><a href="<%=request.getContextPath()+"/page/source/1.jpg"%>" rel="1" class="cake" title="雪域天使"> <img border="0" src="<%=request.getContextPath()+"/page/source/1.jpg"%>" /></a>雪域天使</li>
   <li> <a  href="<%=request.getContextPath()+"/page/source/2.jpg"%>" rel="1"  class="cake" title="巧克力慕斯蛋糕"><img border="0" src="<%=request.getContextPath()+"/page/source/2.jpg"%>"  /></a>巧克力慕斯蛋糕</li>
    <li> <a  href="<%=request.getContextPath()+"/page/source/3.jpg"%>" rel="1" class="cake" title="抹茶情深"><img border="0" src="<%=request.getContextPath()+"/page/source/3.jpg"%>" /></a>抹茶情深</li>
	 <li> <a  href="<%=request.getContextPath()+"/page/source/4.jpg"%>"rel="1"  class="cake" title="月光倾城"><img border="0" src="<%=request.getContextPath()+"/page/source/4.jpg"%>" /></a>月光倾城</li>
	  <li><a  href="<%=request.getContextPath()+"/page/source/5.jpg"%>"  rel="1" class="cake" title="神秘园"> <img border="0" src="<%=request.getContextPath()+"/page/source/5.jpg"%>" /></a>神秘园</li>
	   <li><a  href="<%=request.getContextPath()+"/page/source/6.jpg"%>" rel="1"  class="cake" title="奇栗秋香"> <img border="0" src="<%=request.getContextPath()+"/page/source/6.jpg"%>"  /></a>奇栗秋香</li>
        <li> <a   href="<%=request.getContextPath()+"/page/source/7.jpg"%>" rel="1"  class="cake" title="唇齿留香"><img border="0" src="<%=request.getContextPath()+"/page/source/7.jpg"%>" /></a>唇齿留香</li>
	
</ul>

</div>
 

</div>


</div>


<div id="footer"><strong> 您的喜爱是我们最大的动力！谢谢您的支持！</strong></div>

</body>
</html>
