<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>반갑습니다</h1>
	<form method="POST">
		<div>
			<input name="st_num1" placeholder="숫자1 입력"> 
			<input	name="st_num2" placeholder="숫자2 입력">
			<button>서버로 보내기</button>
			<div> 결과 : ${result}</div>
		</div>
	</form>

</body>
</html>