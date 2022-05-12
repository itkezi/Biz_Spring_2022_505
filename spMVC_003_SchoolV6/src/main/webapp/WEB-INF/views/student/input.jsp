<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<Style>
form {
	width: 95%;
	margin: 5px auto;
}

form div {
	display: flex;
	margin: auto;
	width: 80%;
	width: 80%;
	margin-bottom: 5px;
}

form label, form input {
	padding: 8px;
}

form label {
	flex: 1;
	text-align: right;
	display: flex;
}

form input {
	flex: 3;
	width: 65%;
	margin-left: 5px;
}

form div:last-of-type {
	justify-content: flex-end;
	margin: 10px auto;
	
}

form div:first-of-type div {
	flex: 3;
	margin: 0;
}

form div:first-of-type input {
	flex: 2;
	margin: 0;
}

form div:first-of-type input {
	flex: 2;
	margin-right: 5px;
}


form div:first-of-type button {
	flex: 1;
}
</Style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/std_input_save.js?ver=2022-05-12-002"></script>

<script src="${rootPath}/static/js/std_input.js?ver=2022-05-12-004"></script>

<h1>학생정보 등록</h1>
<form method="POST">
	<div>
		<label> 학번 </label>
		<div>
			<input type="text" name="st_num">
			<button type="button" class="btn-green std-num-check">중복검사</button>
		</div>
	</div>
	<div>
		<label> 이름 </label> <input type="text" name="st_name">
	</div>
	<div>
		<label> 학과 </label> <input type="text" name="st_dept">
	</div>
	<div>
		<label> 학년 </label> <input type="text" name="st_grade">
	</div>
	<div>
		<label> 전화번호 </label> <input type="text" name="st_tel">
	</div>
	<div>
		<label> 주소 </label> <input type="text" name="st_addr">
	</div>
	<div>
		<button type="button" class="btn-blue std-save">저장</button>
	</div>
</form>