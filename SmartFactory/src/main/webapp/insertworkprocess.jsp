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
    
	<title>작업공정등록</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<section class="main-section insert-section">
		<h1>작업공정등록</h1>
		<form name="myForm" method="POST" action="insertworkprocesspro.do">
			<table>
				<tr>
					<th>작업지시번호</th>
					<td>
						<input type="text" name="w_workno">
						<span>예)20190001</span>
					</td>
				</tr>
				
				<tr>
					<th>재료준비</th>
					<td>
						<label>
							<input type="radio" name="p_p1" value="Y">
							완료
						</label>
						<label>
							<input type="radio" name="p_p1" value="N">
							작업중
						</label>
					</td>
				</tr>
				
				<tr>
					<th>인쇄공정</th>
					<td>
						<label>
							<input type="radio" name="p_p2" value="Y">
							완료
						</label>
						<label>
							<input type="radio" name="p_p2" value="N">
							작업중
						</label>
					</td>
				</tr>
				
				<tr>
					<th>코팅공정</th>
					<td>
						<label>
							<input type="radio" name="p_p3" value="Y">
							완료
						</label>
						<label>
							<input type="radio" name="p_p3" value="N">
							작업중
						</label>
					</td>
				</tr>
				
				<tr>
					<th>합지공정</th>
					<td>
						<label>
							<input type="radio" name="p_p4" value="Y">
							완료
						</label>
						<label>
							<input type="radio" name="p_p4" value="N">
							작업중
						</label>
					</td>
				</tr>
				
				<tr>
					<th>접합공정</th>
					<td>
						<label>
							<input type="radio" name="p_p5" value="Y">
							완료
						</label>
						<label>
							<input type="radio" name="p_p5" value="N">
							작업중
						</label>
					</td>
				</tr>
				
				<tr>
					<th>포장적재</th>
					<td>
						<label>
							<input type="radio" name="p_p6" value="Y">
							완료
						</label>
						<label>
							<input type="radio" name="p_p6" value="N">
							작업중
						</label>
					</td>
				</tr>
				
				<tr>
					<th>최종작업일자</th>
					<td>
						<input type="text" name="w_lastdate"> 예)20190101
					</td>
				</tr>
				
				<tr>
					<th>최종작업시간</th>
					<td>
						<input type="text" name="w_lasttime"> 예)1300
					</td>
				</tr>
				
			</table>
			
			<div class="btnlist">
				<input type="button" onclick="check()" value="공정등록">
				<input type="button" onclick="modify()" value="공정수정">
				<input type="button" onclick="remove()" value="다시쓰기">
			</div>
			
		</form>
	</section>
	<%@include file="footer.jsp"%>
	
	<script>
		function check(){
			if(myForm.w_workno.value==""){
				alert("작업지시번호가 입력되지 않았습니다!");
				myForm.w_workno.focus();
				return;
			}
			
			if(myForm.p_p1.value==""){
				alert("재료준비항목이 선택되지 않았습니다!");
				myForm.p_p1.focus();
				return;
			}
			
			if(myForm.p_p2.value==""){
				alert("인쇄공정 항목이 선택되지 않았습니다!");
				myForm.p_p2.focus();
				return;
			}
			
			if(myForm.p_p3.value==""){
				alert("코팅공정 항목이 선택되지 않았습니다!");
				myForm.p_p3.focus();
				return;
			}
			
			if(myForm.p_p4.value==""){
				alert(" 합지공정 항목이 선택되지 않았습니다!");
				myForm.p_p4.focus();
				return;
			}
			
			if(myForm.p_p5.value==""){
				alert("접합공정 항목이 선택되지 않았습니다!");
				myForm.p_p5.focus();
				return;
			}
			
			if(myForm.p_p6.value==""){
				alert("포장적재 항목이 선택되지 않았습니다!");
				myForm.p_p6.focus();
				return;
			}
			
			if(myForm.w_lastdate.value==""){
				alert("최종작업일자가 입력되지 않았습니다!");
				myForm.w_lastdate.focus();
				return;
			}
			
			if(myForm.w_lasttime.value==""){
				alert("최종작업시간이 입력되지 않았습니다!");
				myForm.w_lasttime.focus();
				return;
			}	
			alert("공정상태가 정상적으로 등록되었습니다.")
			myForm.submit();
		}
		
		function modify(){
			if(myForm.w_workno.value==""){
				alert("작업지시번호가 입력되지 않았습니다!");
				myForm.w_workno.focus();
				return;
			}
			
			if(myForm.p_p1.value==""){
				alert("재료준비항목이 선택되지 않았습니다!");
				myForm.p_p1.focus();
				return;
			}
			
			if(myForm.p_p2.value==""){
				alert("인쇄공정 항목이 선택되지 않았습니다!");
				myForm.p_p2.focus();
				return;
			}
			
			if(myForm.p_p3.value==""){
				alert("코팅공정 항목이 선택되지 않았습니다!");
				myForm.p_p3.focus();
				return;
			}
			
			if(myForm.p_p4.value==""){
				alert(" 합지공정 항목이 선택되지 않았습니다!");
				myForm.p_p4.focus();
				return;
			}
			
			if(myForm.p_p5.value==""){
				alert("접합공정 항목이 선택되지 않았습니다!");
				myForm.p_p5.focus();
				return;
			}
			
			if(myForm.p_p6.value==""){
				alert("포장적재 항목이 선택되지 않았습니다!");
				myForm.p_p6.focus();
				return;
			}
			
			if(myForm.w_lastdate.value==""){
				alert("최종작업일자가 입력되지 않았습니다!");
				myForm.w_lastdate.focus();
				return;
			}
			
			if(myForm.w_lasttime.value==""){
				alert("최종작업시간이 입력되지 않았습니다!");
				myForm.w_lasttime.focus();
				return;
			}	
			alert("공정상태가 정상적으로 등록되었습니다.")
			myForm.submit();
		}
		
		function remove(){
			myForm.w_workno.value=""
			$("input:radio[name='p_p1']:radio").prop('checked', false);
			$("input:radio[name='p_p2']:radio").prop('checked', false);
			$("input:radio[name='p_p3']:radio").prop('checked', false);
			$("input:radio[name='p_p4']:radio").prop('checked', false);
			$("input:radio[name='p_p5']:radio").prop('checked', false);
			$("input:radio[name='p_p6']:radio").prop('checked', false);
			myForm.w_lastdate.value=""
			myForm.w_lasttime.value=""
			myForm.w_workno.focus()
		}
	</script>
	
</body>
</html>