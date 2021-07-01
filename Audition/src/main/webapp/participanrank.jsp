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
</head>
<body>
	<%@include file="header.jsp"%>
	<section class="main-section view-section">
		<h1>참가자목록조회</h1>
		<table>

			<tr>
				<th>참가번호</th>
				<th>참가자명</th>
				<th>성별</th>
				<th>총점</th>
				<th>평균</th>
				<th>등수</th>
			</tr>
			
			<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.artist_id }</td>
				<td>${list.artist_name }</td>
				<td>
					<c:choose>
						<c:when test="${list.artist_gender eq 'M'}">
							남성
						</c:when>
						
						<c:when test="${list.artist_gender eq 'F' }">
							여성
						</c:when>
					</c:choose>
				</td>
				<td>${list.sum }</td>
				<td>${list.avg }</td>
				<td>${list.rank }</td>
			</tr>
			</c:forEach>
		</table>
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>