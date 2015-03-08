<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = this.getServletContext().getContextPath();
%>
<script type="text/javascript" src="<%= this.getServletContext().getContextPath() %>/js/jquery-easyui-1.4.1/jquery.min.js"></script>
<html>
	<head>
		<style type="text/css">
			body{
				text-align:center;
				background-color: #ccc;
			}
			h1{
				font-size: 50px;
				margin-top: 10%;
				font-family: sans-serif;
				color: #ff00ff;
			}
			div{
				padding:10px;
			}
			.div{
				background-color: #fff;
				text-align:center;
				width:400px;
				height:225px;
				position:absolute;
				left: 50%;
				top: 50%;
				margin-left: -200px;
				margin-top:-100px;
				padding-top: 10px;
			}
			.input{
				width: 200px;
				height:40px;
			}
			.lable{
				font-family:serif;
				font-size:15px;
				margin-left: -120px;
			}
			.login{
				background-color: blue ;
				 color:ffffff;
				 font-size: 15px;
				 padding:10px;
  				 margin-left: -120px;
  				 margin-bottom: -30px;
			}
		</style>

		
	</head>
<body>
	<h1>Privilege Manage</h1>
	<div class="div">
		<form action="login.action" method="post">
			<div>
				<label class="lable">用户名</label><br>
				<input class="input" name="username" type="text">
			</div>
			<div>
				<label class="lable">密码</label><br>
				<input class="input" name="password" type="text">
			</div>
			<label class="login" onclick="submit()">登录</label>
		</form>
	</div>
</body>
</html>
