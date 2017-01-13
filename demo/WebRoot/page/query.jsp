<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询账户信息</title>
<script language="javascript">
	function checkfm(form){
		var code=form.code.value;
		var username=form.username.value;
		var createtime1=form.createtime1.value;
		var createtime2=form.createtime2.value;
		var typeid=form.typeid.value;
		if(!Empty(code) && !Empty(username) && !Empty(createtime1) 
			&& !Empty(createtime2) && !Empty(typeid)){
			alert("不允许全部数值为空!");
			return false;
		}
		if(Empty(code) && Empty(username)){
			alert("编码号和用户名只允许输入一个");
			return false;
		}
		if(Empty(code) && Empty(typeid)){
			alert("编码号和账户名称只允许输入一个!");
			return false;
		}
		if(Empty(code) && (Empty(createtime1)||Empty(createtime2))){
			alert("编码号和注册时间只允许输入一个!");
			return false;
		}
		if(Empty(username) && (Empty(createtime1) || Empty(createtime2))){
			alert("用户名和注册时间只允许输入一个!");
			return false;
		}
		if(Empty(typeid) && (Empty(createtime1)||Empty(createtime2))){
			alert("账户类型和注册时间只允许输入一个!");
			return false;
		}
		if(Empty(username) && Empty(typeid)){
			alert("用户名和账户类型只允许输入一个!");
			return false;
		}
		if(username.length>7){
			alert("username的长度不能高于7位!");
			return false;
		}
		return true;
	}
function Empty(name){
	if(name!=null && name.trim()!="") return true;
	return false;
}
</script>
</head>
<body>
<form action="/demo/acount/query" method="post" onsubmit="return checkfm(this)">
  <table width="90%" border="0" cellspacing="2" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"><td colspan="2"> <font color="#FFFFFF">查询账户：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">编码号：</div></td>
      <td width="78%"> <input type="text" name="code" size="50" maxlength="40"/>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">用户名称：</div></td>
      <td width="78%"> <input type="text" name="username" size="50" maxlength="40"/>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">注册时段:(YYYY-MM-DD hh:mm:ss)</div></td>
      <td width="78%"> <input type="date" name="createtime1" size="50" maxlength="40"/>
      <input type="date" name="createtime2" size="50" maxlength="40"/></td>
    </tr>
      <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">帐号类型：</div></td>
      <td width="39%"><select name="typeid">
      	<c:forEach items="${types}" var="type">
      		<option value="${type.typeid}">${type.typename }</option>
      	</c:forEach>
      </select> 
      <a href="<c:url value='/type/list_queryAcount' />">添加帐号类型</a></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"><div align="center"> 
          <input type="submit" name="SYS_SET" value=" 确 定 " class="frm_btn">
        </div></td>
    </tr>
  </table>
<form>
</body>
</html>