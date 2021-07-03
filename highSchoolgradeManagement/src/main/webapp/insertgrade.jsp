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
	
	<script
    src="https://code.jquery.com/jquery-3.6.0.slim.min.js"
    integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI="
    crossorigin="anonymous"></script>
    
	<title>성적 입력</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section insert-section">
		<h1>성적 입력</h1>
		<form name="myForm" method="POST" action="insertgradepro.do">
			<table>
				<tr>
					<th>학년</th>
					<td>
						<input type="text" name="syear">
						(예)1
					</td>
				</tr>
				
				<tr>
					<th>반</th>
					<td>
						<input type="text" name="sclass">
						(예)01
					</td>
				</tr>
				
				<tr>
					<th>번호</th>
					<td>
						<input type="text" name="sno">
						(예01)
					</td>
				</tr>
				
				<tr>
					<th>국어</th>
					<td>
						<input type="number" name="kor" min="0" max="100">
						점수범위(0~100)
					</td>
				</tr>
				
				<tr>
					<th>영어</th>
					<td>
						<input type="number" name="eng" min="0" max="100">
						점수범위(0~100)
					</td>
				</tr>
				
				<tr>
					<th>수학</th>
					<td>
						<input type="number" name="mat" min="0" max="100">
						점수범위(0~100)
					</td>
				</tr>
				
				
			</table>
			
			<div class="btnlist">
				<input type="button" onclick="check()" value="성적저장">
				<input type="button" onclick="remove()" value="다시쓰기">
			</div>
			
		</form>
	</section>
	<%@include file="footer.jsp"%>
	
	<script>
		function check(){
			if(myForm.syear.value==""){
				alert("학년정보가 입력되지 않았습니다");
				myForm.syear.focus();
				return;
			}
			
			if(myForm.sclass.value==""){
				alert("반정보가 입력되지 않았습니다");
				myForm.sclass.focus();
				return;
			}
			
			if(myForm.sno.value==""){
				alert("번호정보가 입력되지 않았습니다!");
				myForm.sno.focus();
				return;
			}
			
			if(myForm.kor.value==""){
				alert("국어성적이 입력되지 않았습니다!");
				myForm.kor.focus();
				return;
			}
			
			if(myForm.eng.value==""){
				alert("영어성적이 입력되지 않았습니다!");
				myForm.eng.focus();
				return;
			}
			
			if(myForm.mat.value==""){
				alert("수학성적이 입력되지 않았습니다!");
				myForm.mat.focus();
				return;
			}
			
			alert("성적입력이 정상적으로 등록되었습니다.")
			myForm.submit();
		}
		
		function remove(){
			alert("정보를 지우고 처음부터 다시 시작합니다.")
			myForm.syear.value=""
			myForm.sclass.value=""
			myForm.sno.value=""
			myForm.kor.value=""
			myForm.eng.value=""
			myForm.mat.value=""
			myForm.syear.focus()
			
		}
	</script>
	
</body>
</html>