<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 목록</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${siteList}" var="site">
				<tr>
					<td>${site.id}</td>
					<td>${site.name}</td>
					<td><a href="${site.url}" target="_blank">${site.url}</a></td>
					<td><button type="button" class="del-btn btn-danger">삭제</button></td>
				<tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
	$(document).ready(function() {
		// 삭제 버튼
		$(".del-btn").on('click', function(e) {
			//alert("삭제");
			// 1) button에 넣은 값 가져오기
			//let id = $(this).val();
			//let id = $(this).attr('value');
			//let id = e.target.value;
			
			// 2) data를 이용해서 값 가져오기
			let id = $(this).data('bookmark-id');
			//alert(id);
			
			$.ajax({
				// request
				type:"delete"
				, url:"/lesson06/quiz01/delete-bookmark"
				, data:{"id":id}
				
				// response
				, success:function(data) {
					// {"code":200, "result":"성공"}
					if (data.result == "성공") {
						// 새로고침
						location.reload();
					}
				}
				, error:function(e) {
					alert("삭제하는데 실패했습니다.");
				}
			});
		});
		
	});
	</script>
</body>
</html>