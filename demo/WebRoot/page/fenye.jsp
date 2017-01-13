<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<font color="#FFFFFF">
 	    当前页:第${pageView.currpage}页 | 总记录数:${pageView.totalRecord}条 | 每页显示:${pageView.maxresult}条 | 总页数:${pageView.totalPage}页</font>　
<c:forEach begin="${pageView.pageIndex.firstIndex}" end="${pageView.pageIndex.endIndex}" var="wp">
    <c:if test="${pageView.currpage==wp}"><b><font color="#FFFFFF">第${wp}页</font></font></b></c:if>
    <c:if test="${pageView.currpage!=wp}"><a href="javascript:topage('${wp}')" class="a03">第${wp}页</a></c:if>
</c:forEach>
<!-- productTypeAction_findAllType?currpage=${wp } -->