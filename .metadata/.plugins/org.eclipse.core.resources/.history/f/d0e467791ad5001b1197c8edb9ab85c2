<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/main.css">
    
	<title>입출고내역조회</title>
</head>
<body>
	<header class="index-header">
		<h1>(과정평가형 정보처리산업기사) 물류창고 입출고 프로그램 ver2020-02</h1>
		<ul class="index-ul">
			<li><a href="view.do">제품조회</a></li>
			<li><a href="insert.do">입출고등록</a></li>
			<li><a href="inputoutputlist.do">입출고내역조회</a></li>
			<li><a href="saleslist.do">출고매출이익</a></li>
			<li><a href="index.do">홈으로</a></li>
		</ul>
	</header>
	
	<section class="main-section inputoutputlist-section">
		<h1>입출고내역조회</h1>
		<table>
			<tr>
				<th>입출고번호</th>
				<th>제품코드</th>
				<th>제품명</th>
				<th>입출고구분</th>
				<th>수량</th>
				<th>거래처</th>
				<th>거래일자</th>
			</tr>
			
			<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.t_no }</td>
				<td>${list.p_code }</td>
				<td>${list.p_name }</td>
				<td>
					<c:choose>
					<c:when test="${list.t_type eq 'I' }">
						입고
					</c:when>
					<c:otherwise>
						출고
					</c:otherwise>
					</c:choose>
				</td>
				<td>${list.t_cnt }</td>
				<td>${list.c_name }</td>
				<td>${list.t_date }</td>
			</tr>
			</c:forEach>
			
		</table>
	</section>
	
	<footer class="index-footer">
		COMPANY : 잇츠웹 / OWNER : 김소연 / BUSINESS LICENCE : 781-19-00377 / ONLINE BUSINESS LICENCE : 신고준비중 / TEL : 000-000-0000
	</footer>
	
</body>
</html>