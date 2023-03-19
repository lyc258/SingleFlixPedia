<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@include file="../include/css.jsp" %> 
<title>FlixPedia – Online Movies, TV Shows & Cinema HTML
	Template</title>
<%--  <link href="${pageContext.request.contextPath}/resources/css/main1.css" rel="stylesheet" type="text/css">  --%>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
  <style>
    
   
</style>
</head>
<body>
<script>
let msg = "${msg}";
if(msg == "DELETE_OK") alert("성공적으로 삭제되었습니다.");
if(msg == "DELETE_ERROR") alert("삭제에 실패하였습니다 다시 시도해 주세요.");
if(msg == "INSERT_OK") alert("성공적으로 등록되었습니다.");
if(msg == "UPDATE_OK") alert("게시글이 수정되었습니다");
</script>
<%@include file="../include/header.jsp" %>

	<div class="container">
			<div class="row">
				<div class="col-12">
					<h1 class="home__title"><b>공지사항</b></h1>
					
				</div>
			</div>
		</div>
		<br>
		<br>	
		

<div style="text-align:center">
  <div class="board-container">
    <div class="search-container">
      <form action="<c:url value="list"/>" class="search-form" method="get">
        <select class="search-option" name="option">
          <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
          <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
          <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
        </select>

        <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}" placeholder="검색어를 입력해주세요">
        <input type="submit" class="search-button" value="검색">
      </form>
      <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/go_insert"/>'"><i class="fa fa-pencil"></i> 글쓰기</button>
    </div>
    
    

	<div class="qa2_accordion" id="qa2_accordion" >
						<div class="qa2_accordion__card">
							<div class="qa2_card-header" id="headingOne">
								</div>
							
							<div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
								<div class="qa2_card-body">
		<!-- <table border = 1 class="qa2_accordion__list"> -->
		<table>
		<tr>
			<th width="100">글번호
			<th width="200">제목
			<th width="150">내용
			<th width="150">등록일
			<th width="150">조회수
			<th width="150">작성자
		</tr>
		<c:forEach items="${list}" var="boardDto">

			<tr>
				<td>${boardDto.board_seq }</td>
				<td align="left"><a href="<c:url value="read${ph.sc.queryString}&board_seq=${boardDto.board_seq}"/>">
						<c:out value = "${boardDto.title}" /></a></td>
				<td><c:out value = "${boardDto.content}" /></td>
				<td><fmt:formatDate value="${boardDto.regdate}" pattern="yyyy-MM-dd" /></td>
				<td>${boardDto.hit }</td>
				<td>${boardDto.writer }</td>
			</tr>
		</c:forEach>
	
	</table>
	</div>
	</div>
	<br>
	 <div class="paging-container">
      <div class="paging">
        <c:if test="${totalCnt==null || totalCnt==0}">
          <div class = "ment"> 게시물이 없습니다. </div>
        </c:if>
        <c:if test="${totalCnt!=null && totalCnt!=0}">
          <c:if test="${ph.showPrev}">
            <a class="page" href="<c:url value="/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
          </c:if>
          <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
            <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/list${ph.sc.getQueryString(i)}"/>">${i}</a>
          </c:forEach>
          <c:if test="${ph.showNext}">
            <a class="page" href="<c:url value="/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
          </c:if>
        </c:if>
      </div>
    </div>
  </div>
</div>
</div>
</div>
</body>
</html>