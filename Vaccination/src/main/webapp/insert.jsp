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
    
	<title>예방접종등록</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section insert-section">
		<h1>입출고등록</h1>
		<form name="myForm" method="POST" action="insertpro.do">
			<table>
				<tr>
					<th>예방접종이력번호</th>
					<td>
						<input type="text" name="p_seno">
						<span>예20200006</span>
					</td>
				</tr>
				
				<tr>
					<th>고객번호</th>
					<td><input type="text" name="p_no"></td>
				</tr>
				
				<tr>
					<th>백신코드</th>
					<td><input type="text" name="i_code"></td>
				</tr>
				
				<tr>
					<th>접종일자</th>
					<td><input type="date" name="p_date"></td>
				</tr>
				
				
			</table>
			
			<div class="btnlist">
				<input type="button" onclick="check()" value="입출고등록">
				<input type="button" onclick="remove()" value="다시쓰기">
			</div>
			
		</form>
	</section>
	<%@include file="footer.jsp"%>
	
	<script>
		function check(){
			if(myForm.p_seno.value==""){
				alert("예방접종이력번호가 입력되지 않았습니다!");
				myForm.p_seno.focus();
				return;
			}
			
			if(myForm.p_no.value==""){
				alert("고객번호가 입력되지 않았습니다!");
				myForm.p_no.focus();
				return;
			}
			
			if(myForm.i_code.value==""){
				alert("백신코드가 입력되지 않았습니다!");
				myForm.i_code.focus();
				return;
			}
			
			if(myForm.p_date.value==""){
				alert("접종일자가 입력되지 않았습니다!");
				myForm.p_date.focus();
				return;
			}
			
			myForm.submit();
		}
		
		function remove(){
			myForm.p_seno.value="";
			myForm.p_no.value="";
			myForm.i_code.value="";
			myForm.p_date.value="";
		}
	</script>
	
</body>
</html>