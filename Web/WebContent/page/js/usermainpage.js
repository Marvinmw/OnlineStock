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
	// �����������Ӧ�Ѿ����
	if (XMLHttpReq.readyState == 4) {
		// �ж϶���״̬�����������������������Ӧ
		if (XMLHttpReq.status == 200) {
			// ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
			// �������ı�����������ó�������Ϣ
			var text = XMLHttpReq.responseText;
			window.alert(text);
		} else {
			// ҳ�治����
			window.alert("���������ҳ�����쳣��");
		}
	}
}