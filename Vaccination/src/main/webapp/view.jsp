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
    
	<title>고객조회</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section view-section">
		<h1>고객조회</h1>
		<table>

			<tr>
				<th>고객번호</th>
				<th>고객명</th>
				<th>고객생년월일</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>지역</th>
			</tr>
			
			<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.p_no }</td>
				<td>${list.p_name }</td>
				<td>
					<c:set var="TextValue" value="${list.p_birth }"/>
					${fn:substring(TextValue,0,4)}년
					${fn:substring(TextValue,4,6)}월
					${fn:substring(TextValue,6,8)}일
					
					<fmt:formatNumber var="nowyear"  value="${year}" type="number" pattern="00"/>
					<fmt:formatNumber var="useryear" value="${fn:substring(TextValue,0,4)}" type="number" pattern="00"/>
					(${nowyear-useryear-1})
					
					
				</td>
				<td>
					<c:choose>
						<c:when test="${list.p_gender eq 'M'}">
							남
						</c:when>
						
						<c:when test="${list.p_gender eq 'F' }">
							여
						</c:when>
						
					</c:choose>
				</td>
				<td>${list.p_tel1}-${list.p_tel2}-${list.p_tel3}</td>
				<td>
					<c:choose>
						<c:when test="${list.p_city eq 10 }">
							서울
						</c:when>
						<c:when test="${list.p_city eq 20 }">
							경기
						</c:when>
						<c:when test="${list.p_city eq 30 }">
							강원
						</c:when>
						<c:when test="${list.p_city eq 40 }">
							대구
						</c:when>
					</c:choose>
				</td>
			<tr>
			</c:forEach>
		</table>
	</section>
	
	<%@include file="footer.jsp"%>
	
</body>
</html>