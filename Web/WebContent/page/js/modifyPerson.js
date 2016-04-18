var  XMLHttpReq;

function createXmlHttpRequest() {
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		XMLHttpReq = new XMLHttpRequest();
	} else {// code for IE6, IE5
		XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	}

}


function commitmodify(){
	var user=document.getElementById("user").value;
	var password=document.getElementById("pass").value;
	var newpassword=document.getElementById("repass").value;
	
	var radio=document.getElementsByName("sex");
	var sex;
	for(var i=0;i<radio.length;i++){
		 if(radio[i].checked){
			 sex = radio[i].value;
             break;
         }
	}
	
	var birthadyDate=document.getElementById("birthadyDate").value;
	var address=document.getElementById("address").value;
	
	
	createXmlHttpRequest();
	XMLHttpReq.open("POST", "../modifyPersonInfo", true);
	XMLHttpReq.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = showresult;
	var sendinfo="user=" + user + "&password=" + password + "&newpassword=" + newpassword+ "&sex=" + sex+"&birthadyDate="+birthadyDate+"&address="+address;
	XMLHttpReq.send(sendinfo);
	
}

function showresult(){

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