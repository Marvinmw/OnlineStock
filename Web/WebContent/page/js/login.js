// JavaScript Document

js100(function(){
	Javascript100.setHomePage({url:"wwww.javascript100.com",id:"setFirst"});
	Javascript100.addFavorite({id:"favor",title:"javascript100官网",url:"www.javascript100.com"});
})

function mouseover(id){
	document.getElementById(id).style.color="#333333";
	}  
function mouseout(id){
	document.getElementById(id).style.color="#666666";
	}
	
	
	
function mouseoverinput(id, labid){
	document.getElementById(id).style.borderColor="#333333";
	document.getElementById(labid).style.color="#333333";
	}  
function mouseoutinput(id,labid){
	document.getElementById(id).style.borderColor="#666666";
	document.getElementById(labid).style.color="#666666";
	}


function check(){
	var username=document.getElementById("user").value;
	var password=document.getElementById("pass").value;
	if(username=="" | password==""){
		alert("Please fill the form");
		return;
	}
	else{
		document.getElementById("info").submit();
	}
	
	
}