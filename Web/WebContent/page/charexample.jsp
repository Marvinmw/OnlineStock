<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.nju.edu.tool.StatisticsTool
    ,java.io.*"%>
<%
	String filename = (new StatisticsTool()).getSexStatisticsPie(
			session, new PrintWriter(out));
	String graphURL = request.getContextPath()
			+ "/servlet/DisplayChart?filename=" + filename;

	String filename1 = (new StatisticsTool()).getCardInfo(session,
			new PrintWriter(out));
	String graphURL1 = request.getContextPath()
			+ "/servlet/DisplayChart?filename=" + filename1;
	String filename2 = (new StatisticsTool()).getProductRate(session,
			new PrintWriter(out));
	String graphURL2 = request.getContextPath()
			+ "/servlet/DisplayChart?filename=" + filename2;
	String filename3 = (new StatisticsTool()).getStore(session,
			new PrintWriter(out));
	String graphURL3 = request.getContextPath()
			+ "/servlet/DisplayChart?filename=" + filename3;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=request.getContextPath()+"/page/js/usermainpage.js"%>"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() + "/page/js/jquery-1.4.2.min.js"%>"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()
					+ "/page/js/jquery.jcarousel.min.js"%>"></script>
<link href="<%=request.getContextPath() + "/page/css/skin1.css"%>"
	rel="stylesheet" type="text/css" media="all" />
<link type="text/css"
	href="<%=request.getContextPath() + "/page/css/manager.css"%>"
	media="all" rel="stylesheet" />
<title>My JSP 'index.jsp' starting page</title>

<script type="text/javascript">
	function mycarousel_initCallback(carousel) {
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
			auto : 0,
			wrap : 'circular',
			visible : 1,
			scroll:1,
			initCallback : mycarousel_initCallback
		});
	});
</script>
</head>
<body>
	<div id="headerTitle"></div>
	<div id="nav">
	<ul>
  <li class=" "><a href="<%=request.getContextPath()+"/page/login.jsp"%>">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li class=""><a href="<%=request.getContextPath()+"/page/charexample.jsp"%>">总体统计</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
  <li class=""><a href="<%=request.getContextPath()+"/page/usermamnerlike.jsp"%>">会员个人分析</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
   <li class=""><a onclick="showPersonInfo()">查看个人信息</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
   
 </ul> 
	</div>
	<div id="container">
	<div id="png">
		<ul id="mycarousel" class=" jcarousel-skin-tango"
			style="width: 550px; height: 350px;">
			<script>
				document.getElementById("mycarousel").style.height = "350px";
			</script>
			<li><a href="<%=graphURL%>"
				rel="1"><img src="<%=graphURL%>" /></a></li>
			<li><a href="<%=graphURL1%>"
				rel="1"><img src="<%=graphURL1%>" /></a></li>
			<li><a href="<%=graphURL2%>"
				rel="1"><img src="<%=graphURL2%>" /></a></li>
			<li><a href="<%=graphURL3%>"
				rel="1"><img src="<%=graphURL3%>" /></a></li>
		</ul>
</div>
	</div>
</body>
</html>


