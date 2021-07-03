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
	
	<title>학생성적조회</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<section class="main-section view-section">
		<h1>학생성적조회</h1>
		<table>

			<tr>
				<th>학년-반-번호</th>
				<th>이름</th>
				<th>성별</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
			</tr>
			<c:set var="pointOfKor" value="0"/>
			<c:set var="pointOfEng" value="0"/>
			<c:set var="pointOfMat" value="0"/>
			<c:set var="count" value="0"/>
			
			<c:forEach var="list" items="${list }">
				<c:set var="pointOfKor" value="${pointOfKor+list.kor}"/>
				<c:set var="pointOfEng" value="${pointOfEng+list.eng}"/>
				<c:set var="pointOfMat" value="${pointOfMat+list.mat}"/>
				<c:set var="count" value="${count+1}"/>

			<tr>
				<td>${list.syear}-${list.sclass}-${list.sno }</td>
				<td>${list.sname }</td>
				<td>
					<c:choose>
						<c:when test="${list.gender eq 'M'}">
							남성
						</c:when>
						
						<c:when test="${list.gender eq 'F' }">
							여성
						</c:when>
					</c:choose>
				</td>
				<td>${list.kor }</td>
				<td>${list.eng }</td>
				<td>${list.mat }</td>
				<td>${list.sum }</td>
				<td>${list.avg }</td>
				
			</tr>
			</c:forEach>
			
			<tr>
				<td></td>
				<td></td>
				
				<td>학년총점</td>
				<td>${pointOfKor}</td>
				<td>${pointOfEng}</td>
				<td>${pointOfMat}</td>
				
				<td></td>
				<td></td>
			</tr>
			
			<tr>
				<td></td>
				<td></td>
				
				<td>학년평균</td>
				<td><fmt:formatNumber value="${pointOfKor/count}" pattern=".0"/></td>
				<td><fmt:formatNumber value="${pointOfEng/count}" pattern=".0"/></td>
				<td><fmt:formatNumber value="${pointOfMat/count}" pattern=".0"/></td>
				
				<td></td>
				<td></td>
			</tr>
			
		</table>
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>