// JavaScript Document
var n = 0;
var sum = 0;
var  XMLHttpReq;

function addProduct() {
	var record = "";
	var proid = document.getElementById("product").value;
	var pronu = document.getElementById("number").value;
	var proprice = document.getElementById("price").value;
	var bill = document.getElementById("bills");
	sum = pronu * proprice + sum;
	var item1 = document.createElement("input");
	var item2 = document.createElement("input");
	var item3 = document.createElement("input");
	n++;
	item1.id = n;
	n++;
	item2.id = n;
	n++;
	item3.id = n;
	item1.value = proid;
	item2.value = pronu;
	item3.value = proprice;

	record =record.concat(proid);
	record =record.concat(";");
	record =record.concat(pronu);
	record =record.concat(";");
	record =record.concat(proprice);
	record =record.concat("/");
	bill.value=bill.value.concat(record);

	item1.type = "text";
	item1.name = "item1";
	item1.style.background = "transparent";
	item1.style.textAlign = "center";
	item1.disabled = "disabled";
	item1.style.border = 0;
	item2.type = "text";
	item2.style.background = "transparent";
	item2.style.border = 0;
	item2.style.textAlign = "center";
	item2.name = "item2";
	item2.disabled = "disabled";
	item3.type = "text";
	item3.style.background = "transparent";
	item3.style.textAlign = "center";
	item3.style.border = 0;
	item3.name = "item3";
	item3.disabled = "disabled";
	item1.color = "#000000";
	item2.color = "#000000";
	item3.color = "#000000";

	var tr = document.createElement("tr");
	var td1 = document.createElement("td");
	var td2 = document.createElement("td");
	var td3 = document.createElement("td");

	td1.appendChild(item1); // standards compliant
	td2.appendChild(item2);
	td3.appendChild(item3);
	tr.appendChild(td1); // standards compliant
	tr.appendChild(td2);
	tr.appendChild(td3);
	document.getElementById("table").appendChild(tr);
	
	
	document.getElementById("sum").value = sum;
	
	document.getElementById("product").value="";
	document.getElementById("number").value="";
	 document.getElementById("price").value="";
}

function commit() {
	createXmlHttpRequest();
	var bill_ = document.getElementById("bills").value;
	var cash_ = document.getElementById("cash").value;
	var money_ = document.getElementById("money").value;
	var card_ = document.getElementById("card").value;
	var sum_=document.getElementById("sum").value;
	XMLHttpReq.open("POST", "../buydealer", true);
	XMLHttpReq.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");
	XMLHttpReq.onreadystatechange = show;
	var sendinfo="bill=" + bill_ + "&cash=" + cash_ + "&money=" + money_+ "&card=" + card_+"&sum="+sum_;
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
			var info = new Array();
			info = text.split(";");
			if (info[0] == 2) {
				window.alert("����ɹ�.\n");
				document.getElementById("charge").value = info[1];
			} else if(info[0] == 4)
			{
				window.alert("�˻�����,�����˻���δ���������ֽ�֧��");
			}
		} else {
			// ҳ�治����
			window.alert("���������ҳ�����쳣��");
		}
	}
}

function createXmlHttpRequest() {
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		XMLHttpReq = new XMLHttpRequest();
	} else {// code for IE6, IE5
		XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	}

}


function clear(){
	document.getElementById("bills").value="";
	document.getElementById("cash").value="";
	document.getElementById("money").value="";
	document.getElementById("card").value="";
	document.getElementById("sum").value="";
	document.getElementById("charge").value="";
	
  var body=document.getElementById("table");
  var table=document.getElementById("prolist");
  table.removeChild(body);

  
  var newbody=document.createElement("tbody");
  newbody.id="table";
  var newtr=document.createElement("tr");
  var th1=document.createElement("th");
  th1.innerHTML="��Ʒ���";
  var th2=document.createElement("th");
  th2.innerHTML="��Ʒ����";
  var th3=document.createElement("th");
  th3.innerHTML ="��Ʒ����";
 newtr.appendChild(th1);
 newtr.appendChild(th2);
 newtr.appendChild(th3);
 newbody.appendChild(newtr);
 table.appendChild(newbody);
  
}