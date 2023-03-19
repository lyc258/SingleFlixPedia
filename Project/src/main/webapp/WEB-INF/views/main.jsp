<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Filxpedia</title>
    <link rel="stylesheet" href="<c:url value='resources/css/menu.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>    
</head>
<body>
<script>
let msg = "${msg}";
if(msg == "NO_ID") alert("회원만 사용가능 합니다 먼저 로그인 후 이용해주시기 바랍니다."); 


</script>
<div id="menu">
	<ul>
	    <li id="logo">fastcampus</li>
	    <li><a href="<c:url value='/'/>">Home</a></li>
	    <li><a href="<c:url value='list'/>">Board</a></li>
	    <li><a href="<c:url value='loginForm'/>">login</a></li>    
	    <li><a href="<c:url value='/register'/>">Sign in</a></li>
	     <li><a href="<c:url value='/logout'/>">log out</a></li>
	   <!--  <li><a href=""><i class="fas fa-search small"></i></a></li> -->
	</ul> 
</div>
<div style="text-align:center">
	<h1>This is HOME</h1>
	<h1>This is HOME</h1>
	<h1>This is HOME</h1>
</div>