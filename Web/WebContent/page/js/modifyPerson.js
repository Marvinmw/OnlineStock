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