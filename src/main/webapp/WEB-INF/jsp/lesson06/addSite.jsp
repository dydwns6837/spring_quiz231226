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
				<input type="text" id="url" name="url" class="form-control">
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
		});
	</script>
</body>
</html>