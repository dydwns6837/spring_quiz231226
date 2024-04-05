<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<form method="post" action="/lesson06/quiz01/add-site">
			<div class="form-group">
				<label for="name">제목</label>
				<input type="text" id="name" name="name" class="form-control">
			</div>
			<div>
				<label for="url">주소</label>
				<div class="d-flex w-100">
					<input type="text" id="url" name="url" class="form-control mr-4">
					<button type="button" id="urlCheckBtn" class="btn btn-info col-1">중복확인</button>
				</div>
				<small id="duplicationText" class="text-danger d-none">중복된 url입니다.</small>
				<small id="availableText" class="text-success d-none">저장 가능한 url입니다.</small>
			</div>
			
			<button type="button" id="addBtn" class="btn btn-success w-100 mt-4">추가</button>
		</form>
	</div>
	
	<script>
		$(document).ready(function() {
			$("#addBtn").on("click", function() {
				//alert("클릭");
				
				let name = $("#name").val().trim();
				if (name == "") {
					alert("제목을 입력하세요");
					return;
				}
				
				let url = $("#url").val().trim();
				if (url == "") {
					alert("주소를 입력하세요");
					return;
				}
				
				if (url.startsWith("http://") == false && url.startsWith("https://") == false) {
					alert("주소 형식이 잘못되었습니다.");
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/lesson06/quiz01/add-site"
					, data:{"name":name, "url":url}
					, success:function(data) { // data: JSON String => parsing(jquery ajax가) => js dictionary
						/* alert(data.code);
						alert(data.result); */
						if (data.code == 200) {
							location.href = "/lesson06/quiz01/after-add-site-view";
						}
					}
					, error:function(xhr, status, error) {
						alert("추가하는데 실패했습니다. 관리자에게 문의해주세요.");
					}
				});
				
			});
			$("#urlCheckBtn").on("click", function() {
				
				let url = $("#url").val().trim();
				if (url == "") {
					alert("주소를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"POST" // get일 때 생략 가능
					, url:"/lesson06/quiz01/is-duplication-url"
					, data:{"url":url}
					
					, success:function(data) { // string -> JSON parsing => dictionary
						// {"code":200, "is_duplication:true"}
						// 중복일 때 문구 노출
						if (data.is_duplication) {
							$("#duplicationText").removeClass("d-none");
							$("#availableText").addClass("d-none");
						} else {
							$("#availableText").removeClass("d-none");
							$("#duplicationText").addClass("d-none");
						}
						
					}
					, error:function(error) {
						alert("이름 중복확인에 실패했습니다.");
					}
				});
                
			});
		});
	</script>
</body>
</html>