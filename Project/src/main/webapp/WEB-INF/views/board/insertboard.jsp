<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@include file="../include/css.jsp" %>
<title>FlixPedia – Online Movies, TV Shows & Cinema HTML
	Template</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main.css">
</head>
<body class="body">

   <%@include file="../include/header.jsp" %>
   

<section class="section section--first section--bg" data-bg="<%=request.getContextPath() %>/resources/img/section/section.jpg">
<div class="sign section--bg" data-bg="<%=request.getContextPath() %>/resources/img/section/section.jpg" style="margin-top: 100px;"></div>
      <div class="container">
      	
         <div class="row">
            <div class="col-12">
               <h1 class="home__title" style="margin-top: 100px"><b>공지사항 </b></h1>
             	  <br><br>
					
					<form class="sign__form" id = "form" enctype="multipart/form-data" name="myform" style="width: 100%;">
					
					<%--  <a href="${commonURL}/" class="sign__logo">
                        <img src="${commonURL}/resources/img/logoimg.png" alt="">
                     </a> --%>
	
					 <div class="sign__group" style="width: 100%">
                        <input class="sign__qna" placeholder="제목을 입력하세요"  name="title" type="text" />
                     </div>
                     <br>
                     
                     <div class="sign__group" style="width: 100%">
                        <textarea class="sign__qna" placeholder="내용을 입력하세요"  name="content" style="height: 300px; padding: 10px;"></textarea>
                     </div>
                     
                     <div class="sign__group" style="width: 100%">
                     	<input class="sign__qna" type = "file" name = "upload"   value = "${boardDto.uploadFile}" accept="image/jpeg, image/jpg, image/png"  multiple />
                     	</div>
                     	
                     <!-- <div class="sign__group" style="width: 100%">
                        <input class="sign__qna" placeholder="조회수"  name="hit" type="text" />
                     </div>	 -->
                    
                    
                     
                   <div class="sign__group" style="width: 100%"><p style="color:white;">작성자</p>
                        <input class="sign__qna" name="writer" type="text" value="${writer }" />
                     </div>
                     <br>
   				    
   				     <div>
                     <button class="sign__btn" id = "insertBtn" type="submit"  style="width:100px; height: 30px; margin:2px;  display: inline-block; ">글 등록</button>
                  
                     <button class="sign__btn" type="button" onclick="location.href='list'" style="width:100px; height: 30px; margin:2px;  display: inline-block; ">글 목록 </button>
   				     </div>
                     
                     </form>
                  <!-- end authorization form -->
               </div>
            </div>
         </div>
    
	
<%@include file="../include/footer.jsp" %>
 </section> 
</body>
<script>
$(document).ready(function() {
	$("#insertBtn").on("click",function() {
	if (!confirm("게시글을 등록하시겠습니까?"))
		return;
	let form = $("#form");
	form.attr("action","<c:url value = 'insert'/>");
	form.attr("method", "post");
	form.submit();
		});
});
</script>
</html>