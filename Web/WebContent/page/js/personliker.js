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
	
	// �����������Ӧ�Ѿ����
	if (XMLHttpReq.readyState == 4) {
		// �ж϶���״̬�����������������������Ӧ
		if (XMLHttpReq.status == 200) {
			// ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
			// �������ı�����������ó�������Ϣ
			var text = XMLHttpReq.responseXML;
			//if(text=="failed")
			//	window.alert("���뿨�Ų����ڣ�");
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
			// ҳ�治����
			window.alert("���������ҳ�����쳣��");
		}
	}
}