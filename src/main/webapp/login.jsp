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
	<form action="">
		用户名:<input type="text" name="uname" onblur="look()"><br><br>
		密&nbsp;&nbsp;&nbsp;码:<input type="password" name="pwd"><br><br>
		<input type="button" value="登录" onclick="login()">
		<input type="button" value="注册" onclick="register()">
	</form>
</body>
<script type="text/javascript">
	
	function look(){
		var uname=$("[name='uname']").val();
		$.post(
			"<%=path%>/look",
			{"uname":uname},
			function(u){
				
				if(u!=null){
					str="<img alt='xxx' width='100px;' height='50px;'><br><br>"
					$("form").before(str);
					$("[alt='xxx']").attr("src","<%=path%>/lockPicture?path="+u.picture);
				}
			},
			"json"
		);
	}
	
	function register(){
		location="<%=path%>/register.jsp";
	}

	function login(){
		$.post(
			"<%=path%>/login",
			$("form").serialize(),
			function(u){
				if(u!=null){
					if(u.locked==1){
						alert("登录成功");
						location="<%=path%>/getUserList";
					}else{
						alert("该用户已被禁用");
					}
				}else{
					alert("账号或密码错误");
				}
			},
			"json"
		);
	}

</script>
</html>