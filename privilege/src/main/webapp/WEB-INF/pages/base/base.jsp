<%@page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <script type="text/javascript" src="/privilege/js/jquery-easyui-1.4.2/jquery.min.js"></script>
    <script type="text/javascript" src="/privilege/js/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/privilege/js/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/privilege/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="/privilege/js/util.js"></script>
    <%
    	String themeName = "default";
	    Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals("themeName")){
				themeName = c.getValue();
				break;
			}
		}
    %>
    <link id="themelink" rel="stylesheet" href="/privilege/js/jquery-easyui-1.4.2/themes/<%=themeName%>/easyui.css">
    <link rel="stylesheet" href="/privilege/js/jquery-easyui-1.4.2/themes/icon.css">
