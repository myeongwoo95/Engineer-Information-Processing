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
    
	<title>학생 등록</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section insert-section">
		<h1>학생 등록</h1>
		<form name="myForm" method="POST" action="insertpro.do">
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
					<th>이름</th>
					<td>
						<input type="text" name="sname">
					</td>
				</tr>
				
				<tr>
					<th>생년월일</th>
					<td>
						<input type="text" name="birth">
					</td>
				</tr>
				
				<tr>
					<th>성별</th>
					<td>
						<label>
							<input type="radio" name="gender" value="M">
							남성
						</label>
						
						<label>
							<input type="radio" name="gender" value="F">
							여성
						</label>
					</td>
				</tr>
				
				<tr>
					<th>전화번호</th>
					<td>
						<input type="text" name="tel1">-
						<input type="text" name="tel2">-
						<input type="text" name="tel3">
					</td>
				</tr>
				
			</table>
			
			<div class="btnlist">
				<input type="button" onclick="check()" value="학생등록">
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
			
			if(myForm.sname.value==""){
				alert("이름이 입력되지 않았습니다.");
				myForm.sname.focus();
				return;
			}
			
			if(myForm.birth.value==""){
				alert("생년월일이 입력되지 않았습니다!.");
				myForm.birth.focus();
				return;
			}
			
			if(!$('input:radio[name=gender]').is(':checked')){
				alert("성별을 선택하세요");
				return;
			}
			
			
			if(myForm.tel1.value==""){
				alert(" 전화번호가 입력되지 않았습니다");
				myForm.tel1.focus();
				return;
			}
			
			if(myForm.tel2.value==""){
				alert(" 전화번호가 입력되지 않았습니다");
				myForm.tel2.focus();
				return;
			}
			
			if(myForm.tel3.value==""){
				alert(" 전화번호가 입력되지 않았습니다");
				myForm.tel3.focus();
				return;
			}
			
			
			myForm.submit();
		}
		
		function remove(){
			alert("정보를 지우고 처음부터 다시 시작합니다.")
			myForm.syear.value=""
			myForm.sclass.value=""
			myForm.sno.value=""
			myForm.sname.value=""
			myForm.birth.value=""
			$("input:radio[name='gender']:radio").prop('checked', false);
			myForm.tel1.value=""
			myForm.tel2.value=""
			myForm.tel3.value=""
			myForm.syear.focus()
			
		}
	</script>
	
</body>
</html>