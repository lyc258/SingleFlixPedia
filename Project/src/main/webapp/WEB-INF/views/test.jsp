<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Title</title>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
	<h2>CommentList</h2>
	comment : <input type = "text" name = "comment"><br>
	<button id="sendBtn" type="button">SEND</button>
	<button id="updBtn" type = "button">수정</button>
	
	<div id="commentList"></div>
    <div id ="replyForm" style = "display:none">
    <input type = "text" name = "replyComment">
    <button id = "wrtRepBtn" type = "button">등록</button>
    </div>
	<script>
        	
    		let board_seq = 1;
    
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
    		$("#commentList").on("click" , ".delBtn",function() {
    			let comment_seq = $(this).parent().attr("data-comment_seq");
    			let board_seq = $(this).parent().attr("data-board_seq");
    			$.ajax({
                    type:'DELETE',       // 요청 메서드
                    url: 'project/comments/'+comment_seq+'?board_seq'+board_seq,  // 요청 URI
                 	success : function(result){
                  		alert(result);
                 		showList(board_seq);
                    },
                    error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
                }); // $.ajax()
    		});	
    			
    		
    		$("#wrtRepBtn").click(function() {
				
				let comment = $("input[name=replyComment]").val();
				//let pcomment_seq = $("#replyForm").parent().attr("data-pcomment_seq");
				//let pcomment_seq = $("#replyForm").parent().attr("data-pcomment_seq");
				
				
				$.ajax({
                    type:'POST',       // 요청 메서드
                    url: '/comments?board_seq='+board_seq,  // 요청 URI
                    headers: {"content-type": "application/json"},
					data: JSON.stringify({pcomment_seq:pcomment_seq , board_seq:board_seq , comment:comment}),
                 	success : function(result){
                  		alert(result);
                 		showList(board_seq);
                    },
                    error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
                }); // $.ajax
                $("#replyForm").css("display" , "none");
                 $("input[name=replyComment]").val('');
                $("#replyForm").appendTo("body"); 
			
		});
    		});	
    		let toHtml = function(comments) {
    			let temp = "<ul>";
    			
    		comments.forEach(function(comment) {
    			temp += '<li data-comment_seq=' + comment.comment_seq
    			temp += ' data-pcomment_seq=' + comment.pcomment_seq
    			temp += ' data-board_seq=' + comment.board_seq + '>'
    			if(comment.pcomment_seq != comment.comment_seq)
    			
    			temp += ' writer=<span class = "writer">' + comment.writer + '</span>'
    			temp += ' comment=<span class = "comment">' + comment.comment + '</span>'
    			temp += '<button class = "delBtn">삭제</button>'
    			temp += '<button class = "updBtn"> 수정</button>'
    			temp += '<button class = "replyBtn"> 답글</button>'
    			temp += '</li>'
    		});
    			return temp + "</ul>";
    		}
    </script>
</body>
</html>