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
    
	<title>백신별접종건수</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section saleslist-section">
		<h1>백신별접종건수</h1>
		<table>
			<tr>
				<th>백신코드</th>
				<th>백신주사명</th>
				<th>백신별총건수</th>
			</tr>
			
			<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.i_code }</td>
				<td>${list.i_name }</td>
				<td>${list.count }</td>
			</tr>
			</c:forEach>
			
		</table>
	</section>
	
	<%@include file="footer.jsp"%>
	
</body>
</html>