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
	
	<title>반별통계</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section view-section">
		<h1>반별통계</h1>
		<table>

			<tr>
				<th>학년</th>
				<th>반</th>
				<th>교사명</th>
				<th>국어총점</th>
				<th>영어총점</th>
				<th>수학총점</th>
				<th>국어평균</th>
				<th>영어평균</th>
				<th>수학평균</th>
			</tr>
			
			<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.syear }</td>
				<td>${list.sclass }</td>
				<td>${list.tname }</td>
				<td>${list.sum_kor }</td>
				<td>${list.sum_eng }</td>
				<td>${list.sum_mat }</td>
				<td>${list.avg_kor }</td>
				<td>${list.avg_eng }</td>
				<td>${list.avg_mat }</td>
			</tr>
			</c:forEach>
			
		</table>
	</section>
	<%@include file="footer.jsp"%>
</body>
</html>