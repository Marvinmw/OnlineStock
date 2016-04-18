var XMLHttpReq;
function createXmlHttpRequest() {
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		XMLHttpReq = new XMLHttpRequest();
	} else {// code for IE6, IE5
		XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	}

}

function commit() {
	var dl = document.getElementById("show");
	var ul = document.createElement("ul");
	ul.id = "list";
	dl.replaceChild(ul, document.getElementById("list"));
	var storeid = document.getElementById("storeid").value;
	if(storeid==""){
		window.alert("����Ϊ�գ�");
    	return;
	}
	
	createXmlHttpRequest();
	XMLHttpReq.open("POST", "../manageman", true);
	XMLHttpReq.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = show;
	var sendinfo = "storeid=" + storeid;
	XMLHttpReq.send(sendinfo);

}

function show() {
	// �����������Ӧ�Ѿ����
	if (XMLHttpReq.readyState == 4) {
		// �ж϶���״̬�����������������������Ӧ
		if (XMLHttpReq.status == 200) {
			// ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
			// �������ı�����������ó�������Ϣ
			var text = XMLHttpReq.responseText;
			var item;
			var items = new Array();
			items = text.split("/");
			var ul = document.getElementById("list");
			for (item in items) {
				var li = document.createElement("li");
				if (items[item] == "")
					continue;
				li.innerHTML = items[item];
				ul.appendChild(li);
			}

		} else {
			// ҳ�治����
			window.alert("���������ҳ�����쳣��");
		}
	}

}

function change() {
	var level1 = document.getElementById("1").value;
	var level2 = document.getElementById("2").value;
	var level3 = document.getElementById("3").value;
	createXmlHttpRequest();
	XMLHttpReq.open("POST", "../updatediscout", true);
	XMLHttpReq.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = result;
	var sendinfo = "level1=" + level1 + "&level2=" + level2 + "&level3="
			+ level3;
	XMLHttpReq.send(sendinfo);

}

function result() {
	if (XMLHttpReq.readyState == 4) {
		// �ж϶���״̬�����������������������Ӧ
		if (XMLHttpReq.status == 200) {
			// ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
			// �������ı�����������ó�������Ϣ
			var text = XMLHttpReq.responseText;
			window.alert("���ĳɹ�����");

		} else {
			// ҳ�治����
			window.alert("���������ҳ�����쳣��");
		}
	}
}

function modify() {
	window
			.open(
					'../page/modify.html',
					'newwindow',
					'height=250,width=280,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
function add() {
	window
			.open(
					'../page/addmember.html',
					'newwindow',
					'height=250,width=280,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
}
function deletemember() {
	var nameid = prompt("Please enter id", "")
    if(nameid=="")
    	{
    	window.alert("����Ϊ�գ�");
    	return;
    	};
	createXmlHttpRequest();
	XMLHttpReq.open("POST", "../deletemember", true);
	XMLHttpReq.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = deletememberRs;
	var sendinfo = "id=" + nameid;
	XMLHttpReq.send(sendinfo);

}

function deletememberRs(){
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