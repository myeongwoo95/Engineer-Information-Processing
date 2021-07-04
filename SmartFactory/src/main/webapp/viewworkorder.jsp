<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/main.css">
	
	<title>작업지시조회</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<section class="main-section view-section">
		<h1>작업지시조회</h1>
		<table>

			<tr>
				<th>작업지시번호</th>
				<th>제품코드</th>
				<th>제품명</th>
				<th>제품규격</th>
				<th>제품구분</th>
				<th>수량</th>
				<th>작업시작일</th>
			</tr>
			
			
			<c:forEach var="list" items="${list}">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			</c:forEach>
			
			
			
		</table>
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>