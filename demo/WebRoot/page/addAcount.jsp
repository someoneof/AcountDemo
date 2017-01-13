<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加账户</title>
<script language="javascript">
function checkFm(form){
	var username=form.username.value;
	var password=form.password.value;
	var repassword=form.repassword.value;
	var typename=form.typename.value;
	if (username==null || username.trim()==""){
		alert("username不能为空！");
		username.focus();
		return false;
	}
	if(username.length<6) {
		alert("username的长度不能低于5位");
		return false;
	}
	if(password==null || password.trim()==""){
		alert("password不能为空!");
		return false;
	}
	if(password.length<6){
		alert("password的长度不能低于6位!");
		return false;
	}
	if(password!=repassword){
		alert("两次输入的密码不一致");
		return false;
	}
	if(typename==null ||typename.trimj()==""){
		alert("帐号类型不能为空!");
		return false;	
	}
	if(form.remark.value=="添加备注") remark=="";
	return true;
}

</script>
</head>
<body>
<form action="/demo/acount/add" method="post" enctype="multipart/form-data" onsubmit="return checkFm(this)">
  <table width="90%" border="0" cellspacing="2" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"><td colspan="2"  > <font color="#FFFFFF">添加用户：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">用户名称：</div></td>
      <td width="78%"> <input type="text" name="username" size="50" maxlength="40"/>
        <font color="#FF0000">*</font></td>
    </tr>
	<tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">输入密码：</div></td>
      <td width="78%"><input type="password" name="password" size="50" maxlength="40"/>
      </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%"><div align="right">请再次输入密码：</div></td>
      <td width="78%"><input type="password" name="repassword" size="50" maxlength="40"/>
      </td>
		<tr><td width="22%"></td>
		<td width="78%">
		<select name=typename >
		<c:forEach items="${requestScope.types}" var="type">
			<option value="${type.typename}">${type.typename}</option>
		</c:forEach>
		</select></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%"><div align="right">添加备注：</div></td>
      <td width="78%"><input type="text" name="remark" onblur="javascript:if(this.value=='')this.value='可以不填写备注';"  onfocus="javascript:if(this.value=='可以不填写备注')this.value='';" value="可以不填写备注"size="50" maxlength="40"/>
      </td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"> <input type="submit" name="SYS_SET" value=" 确 定 " class="frm_btn"></div></td>
    </tr>
  </table>
</form>
</body>
</html>