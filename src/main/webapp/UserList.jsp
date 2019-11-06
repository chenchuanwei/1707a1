<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path=request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="<%=path%>/css/index_work.css"/> 
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
</head>
<body>
	<table>
		<tr>
			<th>用户id</th>
			<th>用户名</th>
			<th>密码</th>
			<th>昵称</th>
			<th>生日</th>
			<th>性别</th>
			<th>是否禁止</th>
			<th>创建时间</th>
			<th>修改时间</th>
			<th>头像</th>
		</tr>
	<c:forEach items="${list}" var="u">
		<tr>
			<td>${u.uid}</td>
			<td>${u.uname}</td>
			<td>${u.pwd}</td>
			<td>${u.nickname}</td>
			<td>${u.birthday}</td>
			<td>
				<c:if test="${u.gender==1}">
					男
				</c:if>
				<c:if test="${u.gender==0}">
					女
				</c:if>
			</td>
			<td>
				<c:if test="${u.locked==1}">
					否
				</c:if>
				<c:if test="${u.locked==0}">
					是
				</c:if>
			</td>
			<td>${u.created}</td>
			<td>${u.updated}</td>
			<td>${u.picture}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>