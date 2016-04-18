
var n = 0;
var sum = 0;
var  XMLHttpReq;
function createXmlHttpRequest() {
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		XMLHttpReq = new XMLHttpRequest();
	} else {// code for IE6, IE5
		XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	}

}


function refresh(){
	createXmlHttpRequest();
	XMLHttpReq.open("POST", "../buylog", true);
	XMLHttpReq.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = addLog;

	XMLHttpReq.send();
	
	
}

function addLog(){

	// 如果服务器响应已经完成
	if (XMLHttpReq.readyState == 4) {
		// 判断对象状态，如果服务器生成了正常响应
		if (XMLHttpReq.status == 200) {
			// 信息已经成功返回，开始处理信息
			// 将聊天文本域的内容设置成聊天信息
			var text = XMLHttpReq.responseText;
			var info = text.split(";");
			var ul = document.getElementById("list");
			var ne=new Array;
			var i=0;
			for(i=0;i<info.length;i++){
			 ne[i] = document.createElement("li");
			 ne[i].innerHTML=info[i];
			 if(info[i]=="")
				 continue;
				ul.appendChild( ne[i]);
			}
			
		} else {
			// 页面不正常
			window.alert("您所请求的页面有异常。");
		}
	}
}

function back(){
	window.history.back(-1);
}

