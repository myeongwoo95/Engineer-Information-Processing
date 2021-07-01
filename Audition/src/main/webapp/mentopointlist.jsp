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
    
	<title>index</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section view-section">
		<h1>참가자목록조회</h1>
		<table>

			<tr>
				<th>채점번호</th>
				<th>참가번호</th>
				<th>참가자명</th>
				<th>생년월일</th>
				<th>점수</th>
				<th>평점</th>
				<th>멘토</th>
			</tr>
			
			<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.serial_no }</td>
				<td>${list.artist_id }</td>
				<td>${list.artist_name }</td>
				<td>
					<c:set var="TextValue" value="${list.artist_birth }"/>
					${fn:substring(TextValue,0,4)}년
					${fn:substring(TextValue,4,6)}월
					${fn:substring(TextValue,6,8)}일
				</td>
				<td>${list.point }</td>
				<td>${list.grade }</td>
				<td>${list.mento_name }</td>
			</tr>
			</c:forEach>
			
		</table>
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>