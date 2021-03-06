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
    
    <script
  src="https://code.jquery.com/jquery-1.12.4.js"
  integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
  crossorigin="anonymous"></script>
	
    <link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/main.css">
    
	<title>입출고등록</title>
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
	
	<section class="main-section insert-section">
		<h1>입출고등록</h1>
		<form name="myForm">
			<table>
				<tr>
					<th>입출고번호</th>
					<td>
						<input type="text" name="t_no" value="${maxTno }" readonly style="outline:0;">
						<span>예20200006</span>
					</td>
				</tr>
				
				<tr>
					<th>제품코드</th>
					<td><input type="text" name="p_code"></td>
				</tr>
				
				<tr>
					<th>입출고번호</th>
					<td>
						<label>
							<input type="radio" name="t_type" value="I" checked="checked">
							입고
						</label>
						
						<label>
							<input type="radio" name="t_type" value="O">
							출고
						</label>
					</td>
				</tr>
				
				<tr>
					<th>수량</th>
					<td><input type="number" name="t_cnt"></td>
				</tr>
				
				<tr>
					<th>거래일자</th>
					<td><input type="text" name="t_date"></td>
				</tr>
				
				<tr>
					<th>거래처</th>
					<td>
						<select name="c_code" class="c_code">
							<option value="">거래처명</option>
							<c:forEach var="list" items="${list }">
							<option value="${list.c_code}">${list.c_name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
			</table>
			
			<div class="btnlist">
				<input type="button" onclick="check()" value="입출고등록">
				<input type="button" onclick="remove()" value="다시쓰기">
				
			</div>
			
		</form>
		
	</section>
	
	<footer class="index-footer">
		COMPANY : 잇츠웹 / OWNER : 김소연 / BUSINESS LICENCE : 781-19-00377 / ONLINE BUSINESS LICENCE : 신고준비중 / TEL : 000-000-0000
	</footer>
	
	<script>
		function check(){
			
			if(myForm.t_no.value==""){
				alert("입출고번호 정보가 입력되지 않았습니다.")
				myForm.t_no.focus()
				return;
			}
			
			if(myForm.p_code.value==""){
				alert("제품코드 정보가 입력되지 않았습니다.")
				myForm.p_code.focus()
				return;
			}
			
			if(myForm.t_cnt.value==""){
				alert("수량 정보가 입력되지 않았습니다.")
				myForm.t_cnt.focus()
				return;
			}
			
			if(myForm.t_date.value==""){
				alert("거래일자 정보가 입력되지 않았습니다.")
				myForm.t_date.focus()
				return;
			}
			
			if(myForm.c_code.value==""){
				alert("거래처 정보가 입력되지 않았습니다.")
				myForm.c_code.focus()
				return;
			}
			
			var t_no = $("input[name='t_no']").val();
			var p_code = $("input[name='p_code']").val();
			var t_type = $("input:radio[name='t_type']:checked").val() ;
			var t_cnt = $("input[name='t_cnt']").val();
			var t_date = $("input[name='t_date']").val();
			var c_code = $("select[name='c_code']").val();

			 $.ajax({
				type:"post",
				url:"insertpro.do",
				data:{
					t_no:t_no,
					p_code:p_code,
					t_type:t_type,
					t_cnt:t_cnt,
					t_date:t_date,
					c_code:c_code
				},
				success:function(data){
					
					if(data=="success"){
						alert("입출고등록이 정상적으로 등록되었습니다.")
						location.href="index.do";
					}else{
						alert("입출고등록이 실패하였습니다.")
					}
				},
				error:function(xhr, status, error){
					alert(error);
				}
			});
		 
		}
		
		function remove(){
			alert("정보를 지우고 처음부터 다시 입력합니다.")
			myForm.p_code.value=""
			myForm.t_cnt.value=""
			myForm.t_date.value=""
			$(".c_code").val("").prop("selected", true);
		}
		
		
	</script>
</body>
</html>