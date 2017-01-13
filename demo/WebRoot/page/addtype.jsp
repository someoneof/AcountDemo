<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript">
function checkFm(form){
	var typename=form.typename.value;
	if (typename==null || typename.trim()==""){
		alert("typename不能为空！");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<form action="/demo/type/add" method="post" enctype="multipart/form-data" onsubmit="return checkFm(this)">
  <table width="90%" border="0" cellspacing="2" cellpadding="3" align="center">
    <tr bgcolor="6f8ac4"><td colspan="2"  ><font color="#FFFFFF">添加帐号类型：</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td width="22%" > <div align="right">类型名称：</div></td>
      <td width="78%"> <input type="text" name="typename" size="50" maxlength="40"/>
        <font color="#FF0000">*</font></td>
    </tr>
    <tr bgcolor="f5f5f5"> 
      <td colspan="2"> <div align="center"> <input type="submit" name="SYS_SET" value="确 定 " class="frm_btn"></div></td>
    </tr>
  </table>
</form>
</body>
</html>