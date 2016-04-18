// JavaScript Document
var  XMLHttpReq;
function showPersonInfo(){
	createXmlHttpRequest();
	XMLHttpReq.open("POST", "../Web/memberInfo", true);
	XMLHttpReq.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = showa;
	XMLHttpReq.send();
}

function createXmlHttpRequest() {
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		XMLHttpReq = new XMLHttpRequest();
	} else {// code for IE6, IE5
		XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	}

}

function showa(){
	// 如果服务器响应已经完成
	if (XMLHttpReq.readyState == 4) {
		// 判断对象状态，如果服务器生成了正常响应
		if (XMLHttpReq.status == 200) {
			// 信息已经成功返回，开始处理信息
			// 将聊天文本域的内容设置成聊天信息
			var text = XMLHttpReq.responseText;
			window.alert(text);
		} else {
			// 页面不正常
			window.alert("您所请求的页面有异常。");
		}
	}
}