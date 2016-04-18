var  XMLHttpReq;
function createXmlHttpRequest() {
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		XMLHttpReq = new XMLHttpRequest();
	} else {// code for IE6, IE5
		XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	}

}
function commit(){
//	var old=document.getElementById("impage");
	//old.parentNode.removeChild(old);
	createXmlHttpRequest();
	var cardid=document.getElementById("cardid").value;
	XMLHttpReq.open("POST", "../personliker", true);
	XMLHttpReq.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = show;
	var sendinfo="card=" + cardid;
	XMLHttpReq.send(sendinfo);
}

function show(){
	
	// 如果服务器响应已经完成
	if (XMLHttpReq.readyState == 4) {
		// 判断对象状态，如果服务器生成了正常响应
		if (XMLHttpReq.status == 200) {
			// 信息已经成功返回，开始处理信息
			// 将聊天文本域的内容设置成聊天信息
			var text = XMLHttpReq.responseXML;
			//if(text=="failed")
			//	window.alert("输入卡号不存在！");
			//else{
			var p=window.createPopup();
			p.innerHTML=text;
			p.show(0,0, 800, 800, document.body);
//            var newimg=document.createElement("img");
//            newimg.src=text;
//            newimg.id="impage";
//            document.getElementById("show").appendChild(newimg);
			//}
		} else {
			// 页面不正常
			window.alert("您所请求的页面有异常。");
		}
	}
}