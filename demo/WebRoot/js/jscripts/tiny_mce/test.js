window.onload=function(){
	$.ajax({
		url:"json/setSelect.do",
		datatype:"json",
		type:"post",
		cache:false,
		async:false,
		error:function(){
			alert("error!");
		},
		success:function(dataJson){
			var _optionList=dataJson;
			var_options=_optionList.split(" ");
			var sobj=document.getElementsById("myselect");
			for(var i=0;i<var_options.length;i++){
				var oObj=document.createElement("option");
				oObj.setAttribute("value", _options[i]);
				oObj.appendChild(document.createTextNode(_options[i]));
				sobj.appendChild(oObj);
			}
		}
	})
}