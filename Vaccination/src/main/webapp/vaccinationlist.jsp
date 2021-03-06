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
    
	<title>접종이력조회</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section saleslist-section">
		<h1>접종이력조회</h1>
		<table>
			<tr>
				<th>예방접종이력번호</th>
				<th>고객번호</th>
				<th>고객명</th>
				<th>백신코드</th>
				<th>백신주사명</th>
				<th>접종일자</th>
			</tr>
			
			<c:forEach var="list" items="${list }">
			<c:set var="seno" value="${list.p_seno }"/>
			<tr>
				<td>${fn:substring(seno,0,4)}-${fn:substring(seno,4,8)}</td>
				<td>${list.p_no }</td>
				<td>${list.p_name }</td>
				<td>${list.i_code }</td>
				<td>${list.i_name }</td>
				<td>${list.p_date }</td>
			</tr>
			</c:forEach>
			
		</table>
	</section>
	
	<%@include file="footer.jsp"%>
	
</body>
</html>