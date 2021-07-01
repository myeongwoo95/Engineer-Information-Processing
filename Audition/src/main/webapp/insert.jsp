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
    
	<title>오디션 등록</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section insert-section">
		<h1>오디션 등록</h1>
		<form name="myForm" method="POST" action="insertpro.do">
			<table>
				<tr>
					<th>참가번호</th>
					<td>
						<input type="text" name="artist_id">
						<span>참가번호는(A000)4자리입니다.</span>
					</td>
				</tr>
				
				<tr>
					<th>참가자명</th>
					<td><input type="text" name="artist_name"></td>
				</tr>
				
				<tr>
					<th>생년월일</th>
					<td>
						<input type="text" name="year">년
						<input type="text" name="month">월
						<input type="text" name="day">일
					</td>
				</tr>
				
				<tr>
					<th>성별</th>
					<td>
						<label>
							<input type="radio" name="gender" value="M" checked>
							남성
						</label>
						<label>
							<input type="radio" name="gender" value="F">
							여성
						</label>
					</td>
				</tr>
				
				<tr>
					<th>특기</th>
					<td>
						<select name="talent" id="select-box">
							<option value="">특기선택</option>
							<option value="1">댄스</option>
							<option value="2">노래</option>
							<option value="3">랩</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th>소속사</th>
					<td>
						<input type="text" name="agency">
					</td>
				</tr>
				
			</table>
			
			<div class="btnlist">
				<input type="button" onclick="check()" value="오디션등록">
				<input type="button" onclick="remove()" value="다시쓰기">
			</div>
			
		</form>
	</section>
	<%@include file="footer.jsp"%>
	
	<script>
		function check(){
			if(myForm.artist_id.value==""){
				alert("참가번호가 입력되지 않았습니다");
				myForm.artist_id.focus();
				return;
			}
			
			if(myForm.artist_name.value==""){
				alert(" 참가자명이 입력되지 않았습니다.");
				myForm.artist_name.focus();
				return;
			}
			
			if(myForm.year.value==""){
				alert("생년월일 입력되지 않았습니다.");
				myForm.year.focus();
				return;
			}
			
			if(myForm.month.value==""){
				alert("생년월일 입력되지 않았습니다.");
				myForm.month.focus();
				return;
			}
			
			if(myForm.day.value==""){
				alert("생년월일 입력되지 않았습니다.");
				myForm.day.focus();
				return;
			}
			
			if(myForm.talent.value==""){
				alert(" 특기가 선택되지 않았습니다.");
				myForm.talent.focus();
				return;
			}
			
			if(myForm.agency.value==""){
				alert("소속사가 입력되지 않았습니다");
				myForm.agency.focus();
				return;
			}
			
			myForm.submit();
		}
		
		function remove(){
			myForm.artist_id.value=""
			myForm.artist_name.value=""
			myForm.year.value=""
			myForm.month.value=""
			myForm.day.value=""
			myForm.agency.value=""
			$("#select-box option:eq(0)").prop("selected", true);
			$("input:radio[name='gender']:radio[value='M']").prop('checked', true);
		}
	</script>
	
</body>
</html>