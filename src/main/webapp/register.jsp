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
		用户名:<input type="text" name="uname" onblur="checkuname()"><br><br>
		昵称:<input type="text" name="nickname"><br><br>
		密&nbsp;&nbsp;&nbsp;码:<input type="password" name="pwd"><br><br>
		确认密码:<input type="password" name="pwd1" onblur="checkpwd()"><br><br>
		性别:<input type="radio" name="gender" value="1">男
		<input type="radio" name="gender" value="0">女<br><br>
		生日:<input type="date" name="birthday"><br><br>
		是否禁止:<input type="radio" name="locked" value="1">否
		<input type="radio" name="locked" value="0">是<br><br>
		<input type="button" value="注册" onclick="register()">
		<input type="button" value="已注册,登录" onclick="login()">	
	</form>
</body>
<script type="text/javascript">
	
	function checkpwd(){
		var pwd=$("[name='pwd']").val();
		var pwd1=$("[name='pwd1']").val();
		if(pwd==pwd1){
			$("[value='注册']").attr("disabled",false);
		}else{
			alert("密码不一致");
			$("[value='注册']").attr("disabled",true);
		}
	}
	
	function checkuname(){
		
		var uname=$("[name='uname']").val();
		
		$.post(
			"<%=path%>checkuname",
			{"uname":uname},
			function(u){
				if(u!=null){
					alert("该用户已存在");
					$("[value='注册']").attr("disabled",true);
				}else{
					$("[value='注册']").attr("disabled",false);
				}
			},
			"json"
		);
	}
	
	function login(){
		location="<%=path%>/login.jsp";
	}

</script>
</html>