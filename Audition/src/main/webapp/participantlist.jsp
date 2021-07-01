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
	
	<title>참가자목록조회</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section view-section">
		<h1>참가자목록조회</h1>
		<table>

			<tr>
				<th>참가번호</th>
				<th>참가자명</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>특기</th>
				<th>소속사</th>
			</tr>
			
			<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.artist_id }</td>
				<td>${list.artist_name }</td>
				<td>
					<c:set var="TextValue" value="${list.artist_birth }"/>
					${fn:substring(TextValue,0,4)}년
					${fn:substring(TextValue,4,6)}월
					${fn:substring(TextValue,6,8)}일
				</td>
				<td>
					<c:choose>
						<c:when test="${list.artist_gender eq 'M'}">
							남
						</c:when>
						
						<c:when test="${list.artist_gender eq 'F' }">
							여
						</c:when>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${list.talent eq 1}">
							댄스
						</c:when>
						
						<c:when test="${list.talent eq 2}">
							랩
						</c:when>
						
						<c:when test="${list.talent eq 3}">
							노래
						</c:when>
					</c:choose>
				</td>
				<td>
					${list.agency }
				</td>
			<tr>
			</c:forEach>
			
		</table>
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>