<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@include file="base.jsp" %>  
<%
	String username =null;
	String userID=null;
	userID = session.getAttribute("userID").toString();
	username = session.getAttribute("username").toString();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
<title>Insert title here</title>
</head>
<body onload="init(<%=userID%>)">
<div id="cc" class="easyui-layout" style="width:100%;height:100%;">   
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
	    <div  style="height: 20%; width: 100%; line-height: 100%; padding-top: 20px;">
	    <div style="position: relative;float: right; padding: 10px;">
	    	<select id="themes" onchange="changeTheme()">
	    		<c:forEach var="theme" items="${themes }">
		    		<option value="${theme }">${theme }</option>
	    		</c:forEach>
	    	</select>
	    </div>
	    
		<div id ="menus"></div>
		<div style="position: relative;float: right; padding: 10px;"><a href="#"  ><%=username %></a>你好</div>
		</div>
    </div>   
    <div data-options="region:'south',title:'South Title',split:true,collapsed:true" style="height:100px;"></div>   
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true,collapsed:true" style="width:100px;"></div>   
    <div data-options="region:'west',title:'West',split:true,collapsed:true" style="width:100px;"></div>   
    <div id="center" data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
    	<div id="centerpanel"></div>
    </div>   
</div>  
</body>
</html>