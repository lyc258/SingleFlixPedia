<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<%@include file="../include/css.jsp"%>
<c:set var="loginId" value="${sessionScope.member_id}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>FlixPedia – Online Movies, TV Shows & Cinema HTML
	Template</title>
<link rel="stylesheet" href="resources/css/comment.css" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body class="body">
	<%@include file="../include/header.jsp"%>
	<div class="sign section--bg"
		data-bg="<%=request.getContextPath()%>/resources/img/section/section.jpg"
		style="margin-top: 100px;">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="sign__content">

							<form class="sign__form" id="form" action="" method="post"
							style="width: 100%;" enctype="multipart/form-data">
							
							<input name="board_seq" type="hidden"
								value="${boardDto.board_seq }" />

							<div class="price">
								<div class="price__item price__item--first">
									<h2>공지 사항 상세보기</h2>
									<span></span>
								</div>
								<br>
								<div class="price__item">
									<span>제목</span> <input class="sign__qna__write " name="title"
										type="text" value="${boardDto.title }" />
								</div>
								<br>

								<div class="price__item">
									<span>내용</span>
									<textarea class="sign__qna__write" name="content"
										style="height: auto; padding: 10px 17px; height: 300px;">${boardDto.content }</textarea>
								</div>
								<br>

								<div class="price__item">
									<span>작성일</span> <input class="sign__qna__write" name="regdate"
										type="date"
										value="<fmt:formatDate value="${boardDto.regdate}" pattern = "yyyy-MM-dd"/>">
								</div>
								<br>

								<div class="price__item">
									<span>첨부파일</span>
									<c:if test="${boardDto.fileName ne null}">
										 <input type="text" id="fileName" name="fileName"
											class="sign__qna__write" value="${boardDto.fileName }"
											accept="image/jpeg, image/jpg, image/png" multiple
											onclick="location.href = '<%=request.getContextPath()%>/file/download?fileName=${boardDto.fileName}'"> 
											<%-- <a href="/down.do?id=board&filename?fileName=${boardDto.fileName}"></a> --%>
									</c:if>
								</div>


								<div class="price__item">
									<span>작성자</span> <input class="sign__qna__write"
										readonly="readonly" name="writer" type="text"
										value="${boardDto.writer }" />
								</div>
						</div>
						</div>
						
							<div style=" text-align: center;">
							<c:if test="${boardDto.writer eq loginId}">
								
									<button class="sign__btn" type="button" id="updateBtn"
										style="width: 100px; height: 30px; margin: 2px; display: inline-block;">수정</button>
									<button class="sign__btn" type="button" id="deleteBtn"
										style="width: 100px; height: 30px; margin: 2px; display: inline-block;">삭제</button>
								
							</c:if>
								<button class="sign__btn" type="button" id="writeBtn"
									style="width: 100px; height: 30px; margin: 2px; display: inline-block;">글쓰기</button>
								<button class="sign__btn" type="button" id="listBtn"
									style="width: 100px; height: 30px; margin: 2px; display: inline-block;">목록</button>
						
							</div>

					
					</div>
			
				</div>
			</div>
			
	</div>
		</form>
		<!--댓글 한칸 시작  -->
				
				
											<form>
											<div id = "commentList">
											</div>
											</form>
												
											<form class="form" name="myform">
											
											<textarea class="form__textarea" placeholder="Review" name="comment" id="comment" ></textarea>
											<div align = "right" >
											<button type="button" class="form__btn" id="wrtRepBtn" onclick = "dateToString">Send</button>
											</div>
											
											</form>
	

	<%@include file="../include/footer.jsp"%>
	
											<div id="modalWin" class="modal">
        <!-- Modal content -->
        <div class="modal-content">
            <span class="close" onclick="$('#modalWin').hide()">&times;</span>
            <p>
            <h2> | 댓글 수정</h2>
            <div id="modify-writebox">
                <div class="commenter commenter-writebox"></div>
                <div class="modify-writebox-content">
                    <textarea name="comment_modify" id="comment_modify" cols="30" rows="5" placeholder="댓글을 남겨보세요"></textarea>
                </div>
                <div id="modify-writebox-bottom">
                    <div class="register-box">
                        <a href="#" class="btn" id="btn-write-modify" onclick="modifyBtnClick();">댓글수정</a>
                    </div>
                </div>
            </div>
            </p>
        </div>
											</div>

</body>
<script>
	$(document).ready(function() {
	
		$("#deleteBtn").on("click",function() {
		if (!confirm("게시글을 삭제하시겠습니까?"))
			return;
	let form = $("#form");
	form.attr("action","<c:url value = 'delete${searchCondition.queryString}'/>");
	form.attr("method", "post");
	form.submit();
		});

		$("#updateBtn").on("click",function() {
		if (!confirm("게시글을 수정하시겠습니까?"))
			return;
		let form = $("#form");
		form.attr("action","<c:url value = 'update${searchHandler.queryString}'/>");
		form.attr("method", "post");
		form.submit();
			});

		$("#listBtn").on("click",function() {
			location.href = "<c:url value='/list?page=${page}&pageSize=${pageSize}'/>";
					});
						
		$("#writeBtn").on("click", function() {
			location.href = "<c:url value='/go_insert'/>";
						});

	});
</script>
<script>	
     
     /*      댓글 부분  */
     
	
	let board_seq = $("input[name=board_seq]").val();
   

	let showList = function(board_seq) {
   		$.ajax({
            type:'GET',       // 요청 메서드
            url: 'project/comments?board_seq='+board_seq,  // 요청 URI
         	success : function(result){
            $("#commentList").html(toHtml(result));
            },
            error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
     }
	
	$(document).ready(function() {
		
		showList(board_seq);
		
		$("#sendBtn").click(function() {
			let comment = $("input[name=comment]").val();
			
			
			$.ajax({
                type:'POST',       // 요청 메서드
                url: 'project/comments?board_seq='+board_seq,  // 요청 URI
                headers: {"content-type": "application/json"},
				data: JSON.stringify({board_seq:board_seq , comment:comment}),
             	success : function(result){
              		alert(result);
             		showList(board_seq);
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
			
			
		});
		
		
		
		
		$("#wrtRepBtn").click(function() {
			
			let comment = $("textarea[name=comment]").val();
			let a = document.getElementById("comment").value='';
			
			let board_seq = $("input[name=board_seq]").val();
			let pcomment_seq = $("#replyForm").parent().attr("data-pcomment_seq");
			//let pcomment_seq = $("#replyForm").parent().attr("data-pcomment_seq");
			
			
			$.ajax({
                type:'POST',       // 요청 메서드
                url: 'project/comments?board_seq='+board_seq,  // 요청 URI
                headers: {"content-type": "application/json"},
				data: JSON.stringify({pcomment_seq:pcomment_seq , board_seq:board_seq , comment:comment}),
             	
				success : function(result){
              		alert(result);
             		showList(board_seq);
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax
           
		
	});

		$("#commentList").on("click" , "#delBtn",function() {
			let comment_seq = $(this).closest("li").attr("data-comment_seq");
			let board_seq = $(this).closest("li").attr("data-board_seq");
			
			$.ajax({
                type:'DELETE',       // 요청 메서드
                url: 'project/comments/'+comment_seq+'?board_seq'+board_seq, // 요청 URI
             	success : function(result){
             		
              		alert(result);
             		showList(board_seq);
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
		});
		
		$("#commentList").on("click" , "#modBtn",function(e) {
			
		    let comment_seq = $(this).closest("li").attr("data-comment_seq");
			let board_seq = $(this).closest("li").attr("data-board_seq");
			let comment_id = $(this).attr("data-comment-id");
			//console.log(comment_id)
		    //let comment = $("p.reviews__text", $(this).closest("li")).text();
			let comment = $("#"+comment_id).text();
		    
		    let li = $("li[data-cno="+comment_seq+"]");
		    
		   //console.log("받은 comment:" + comment);
		   
		    
		   // $("#modalWin .commenter").text(commenter);
            $("#modalWin textarea").val(comment);
            //$("#btn-write-modify").attr("data-cno", comment_seq);
           // $("#btn-write-modify").attr("data-pcno", pcno);
            //$("#btn-write-modify").attr("data-bno", board_seq);
            

            // 팝업창을 열고 내용을 보여준다.
            $("#modalWin").css("display","block");
            //console.log("ok");
       
            $("#btn-write-modify").attr("data-seq", comment_seq)
            
            
            $("#btn-write-modify").click(function(){
                // 1. 변경된 내용을 서버로 전송
                // 2. 모달 창을 닫는다. 
                $(".close").trigger("click");
            });
            
            $(".close").click(function(){
                $("#modalWin").css("display","none");
            });
		});	
	
});		
	
	function modifyBtnClick() {
	    	event.stopPropagation();
	    	event.preventDefault();
	    	
	    	//console.log("등록 버튼 클릭됨");
	    	
	    	let comment_seq = $("#btn-write-modify").attr("data-seq");
	    	let comment = $("#comment_modify").val();
	    	
	    	//alert(comment);
	    	
				 $.ajax({
	                type:'PATCH',       // 요청 메서드
	                url: 'project/comments/'+comment_seq, // 요청 URI
	                headers: {"content-type": "application/json"},
					data: JSON.stringify({comment_seq:comment_seq , comment:comment}),
	             	success : function(result){
	             		
	              		//alert(result);
	             		showList(board_seq);
	                },
	                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
	            }); // $.ajax() 		    	
	    	
	}
	
	let toHtml = function(comments) {
		let temp = "<ul>";
		var uid = '<%=(String)session.getAttribute("member_id")%>'
		
			let dateToString = function(ms=0) {
            let date = new Date(ms);

          
            let yyyy = date.getFullYear();
            let mm = date.getMonth() + 1;
            let dd = date.getDate();

            let HH = date.getHours();
            let MM = date.getMinutes();
            let ss = date.getSeconds();          

            return yyyy+"."+mm+"."+dd+ " " + HH + ":" + MM + ":" + ss;            
        }
   
		
		let idx=0;
		comments.forEach(function(comment) {
		temp += '<li data-comment_seq=' + comment.comment_seq
		temp += ' data-pcomment_seq=' + comment.pcomment_seq
		temp += ' data-board_seq=' + comment.board_seq + '>'
		if(comment.pcomment_seq != comment.comment_seq)
	
		 temp += '<div class="reviews__autor">'
		temp += '<span class = "reviews__name"> 작성자 :  ' + comment.writer + '</span>'
	    temp += '<span class = "reviews__time"> 작성일 :  ' + dateToString(comment.regdate) + '</span>'
		temp += '</div>' 
		temp += '<p class="reviews__text" id="reviews__text'+idx+'">' + comment.comment + '</p>'
		temp += '<div id = "son" align = "right">' 
		if(comment.writer == uid) {
		temp += '<button style="width:60px; height: 60px; display: inline-block; "  type="button" class="form__btn" id = "delBtn">삭제</button>'
		temp += '<button style="width:60px; height: 60px; display: inline-block; "  type="button" class="form__btn" id = "modBtn" data-comment-id="reviews__text'+idx+'"> 수정</button>'
		temp += '<button style="width:60px; height: 60px; display: inline-block; "  type="button" class="form__btn"> 답글</button>'
		}
		temp += '</li>'
	    temp += '</div>' 
		//temp += '</li>'
    	idx++
		
	});
		return temp + "</ul>";
	}
</script>
</html>







