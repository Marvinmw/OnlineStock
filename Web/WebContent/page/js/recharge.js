var  XMLHttpReq;
function createXmlHttpRequest() {
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		XMLHttpReq = new XMLHttpRequest();
	} else {// code for IE6, IE5
		XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	}

}


function lookHis(){
window
.open(
		'../page/chargehis.jsp',
		'newwindow',
		'height=250,width=280,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}



function refresh(){
	createXmlHttpRequest();
	XMLHttpReq.open("POST", "../rechargeLog", true);
	XMLHttpReq.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = addLog;

	XMLHttpReq.send();
	
	
}

function addLog(){

	// �����������Ӧ�Ѿ����
	if (XMLHttpReq.readyState == 4) {
		// �ж϶���״̬�����������������������Ӧ
		if (XMLHttpReq.status == 200) {
			// ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
			// �������ı�����������ó�������Ϣ
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
			// ҳ�治����
			window.alert("���������ҳ�����쳣��");
		}
	}
}

function back(){
	window.history.back(-1);
}