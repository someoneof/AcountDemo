<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐号管理平台</title>
<script language="javascript">
	function topage(page){
		var form = document.forms[0];
		form.currpage.value=page;
		form.submit();
	}

	function allselect(allobj,items){
	    var state = allobj.checked;
	    if(items.length){
	    	for(var i=0;i<items.length;i++)
	    		if(!items[i].disabled) items[i].checked=state;
	    }else{
	    	if(!items.disabled) items.checked=state;
	    }
	}
	
	function actionEvent(methodname){
		var form = document.forms[0];
		if(validateIsSelect(form.all, form.acountids)){
			form.method.value=methodname;
			form.acountids.value=form.acountids;
			form.action="<c:url value='/acount/setState'/>";
			form.submit();
		}else{
			alert("请选择要操作的记录");
		}
	}
	
	function validateIsSelect(allobj,items){
	    var state = allobj.checked;
	    if(items.length){
	    	for(var i=0;i<items.length;i++){
	    		if(items[i].checked) return true;
	    	}
	    }else{
	    	if(items.checked) return true;
	    }
	    return false;
	}
	
$(function () {
	$("#btnGet").click(function () {
    	$.ajax({
        	url: "GetDatas.ashx",
            type: "Post",
            contentType: "application/json",
            dataType: "json",
            success: function (data) {
            var ddl = $("#ddlDatas");
            //删除节点
            RemoveOption();
            //方法1：添加默认节点 
            ddl.append("<option value='-1'>--请选择--</option>");
            //转成Json对象
            var result = eval(data);
            //循环遍历 下拉框绑定
            $(result).each(function (key) {
            //第一种方法
            var opt = $("<option></option>").text(result[key].ProName).val(result[key].ProID);
            ddl.append(opt);
});
	},
    		error: function (data) {
                   alert("Error");
            }
            });
            });
        });
        function RemoveOption() {
            $("#ddlDatas option").remove();
        }

        function AppendOption(value, text) {
            $("#ddlDatas").append("<option value='" + value + "'>"+ text + "</option>");
       }
</script>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">帐号管理</h1>
    </div>
</div>
<form action="/demo/acount/list" method="post" enctype="multipart/form-data">
<input type="hidden" name="currpage"/>
<input type="hidden" name="method"/>
<input type="hidden" name="acountids"/>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
                datatables   
            </div>
             <div class="panel-heading">
             	<input id="button1" type="button" value="显示所有账户信息" enctype="multipart/form-data" onclick="javascript:window.location.href='/demo/acount/list'">
            </div> 
            <table width="98%" border="0" cellspacing="1" cellpadding="2" align="center">
   <tr >
    <td colspan="4" bgcolor="6f8ac4" align="right"></td>
    <jsp:include page="/page/fenye.jsp" />
   </tr>
    <tr>
      <td width="30%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">ID</font></div></td>
      <td width="5%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">code</font></div></td>
      <td width="35%" bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">username</font></div></td>
	  <td width="30%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">password</font></div></td>
	  <td width="30%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">remark</font></div></td>
	  <td width="30%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">state</font></div></td>
	  <td width="30%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">isBan</font></div></td>
	  <td width="30%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">createdate</font></div></td>
	  <td width="30%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">lastlogin</font></div></td>
	  <td width="30%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">typename</font></div></td>
	  <td width="30%" nowrap bgcolor="6f8ac4"> <div align="center"><font color="#FFFFFF">修改</font></div></td>
    </tr>
<!---------------------------LOOP START------------------------------>
<c:forEach items="${pageView.record}" var="entry">
    <tr>
      <td bgcolor="f5f5f5"> <div align="center"><input type="checkbox" name="acountids" value="${entry.acountid} }">${entry.acountid}</div></td>
      <td bgcolor="f5f5f5"> <div align="center">${entry.code}</div></td>
      <td bgcolor="f5f5f5"> <div align="center">${entry.username}</div></td>
	  <td bgcolor="f5f5f5"> <div align="center">${entry.password}</div></td>
	  <td bgcolor="f5f5f5"> <div align="center">${entry.remark}</div></td>
	  <td bgcolor="f5f5f5"> <div align="center"><c:if test='${!entry.state}'>离线</c:if><c:if test="${entry.state}">在线</c:if></div></td>
	  <td bgcolor="f5f5f5"> <div align="center"><c:if test='${!entry.isBan}'>被封</c:if><c:if test='${entry.isBan }'>未封</c:if></div></td>
	  <td bgcolor="f5f5f5"> <div align="center">${entry.createdate}</div></td>
	  <td bgcolor="f5f5f5"> <div align="center">${entry.lastlogin}</div></td>
	  <td bgcolor="f5f5f5"> <div align="center">${entry.typename}</div></td>
	  <td bgcolor="f5f5f5"> <div align="center"><a href="<c:url value='/acount/editUI?acountid=${entry.acountid}&typename=${entry.typename}'/>">编辑</a></div></td>
	</tr>
</c:forEach>
    <!----------------------LOOP END------------------------------->
    <tr> 
      <td bgcolor="f5f5f5" colspan="4" align="center"><table width="100%" border="0" cellspacing="1" cellpadding="3">
          <tr> 
            <td width="5%"></td>
              <td width="85%">
              <input type="button" class="frm_btn" onClick="javascript:window.location.href='<c:url value="/type/list"/>'" value="添加帐号"> &nbsp;&nbsp;
			  <input type="button" value="添加帐号类型" onclick="javascript:window.location.href='/demo/page/addtype.jsp'">
			  <input name="disable" type="button" value="封存" onClick="javascript:actionEvent('disable')">
			  <input name="visible" type="button" value="启封" onclick="javascript:actionEvent('visible')">
			  <input name="query" type="button" class="frm_btn" id="query" onClick="javascript:window.location.href='/demo/page/query.jsp'" value="查 询 "> &nbsp;&nbsp;
			  <input name="all" type="checkbox" class="frm_btn" id="query" onClick="javascript:allselect(this, this.form.acountids)">全选 &nbsp;&nbsp;
            	
            </td>
          </tr>
        </table>
        </td>
    </tr>
  </table>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
							<div class="form-group">
							</div>
				</div>
			</div>
		</div>
</div>
</div>
</form> 
</body>
</html>