<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", () => {
	  const modal_box = document.querySelector("#modal_box");
	  const inputs = document.querySelectorAll("input");
	  const desc = document.querySelector("textarea");

	  const book_isbn = document.querySelector("input#isbn");
	  const book_title = document.querySelector("input#title");

	  /*
	    input event
	    input tag에 키보드로 문자를 입력할 때마다 발생하는 event
	    */
	  // if(book_isbn)을 실행하여 book_isbn 있으면 addEventListener를 부착하고
	  // 만약 book_isbn 객체가 없으면 오류를 발생시키지 말고 실행을 중단하라
	  book_isbn?.addEventListener("input", (e) => {
	    const isbn = e.target.value;
	    if (isbn.length >= 13) {
	      alert(isbn);
	    }
	  });

	  book_title?.addEventListener("keypress", (e) => {
	    if (e.keyCode === 13) {
	      // alert(e.target.value);
	      fetch(`${rootPath}/naver/books?title=${e.target.value}`)
	        .then((res) => res.text())
	        .then((result) => {
	          modal_box.innerHTML = result;
	        });
	    }
	  });
	});
</script>
</head>
<body>

	<H1>Home</H1>


	<header>
		<h1>도서정보관리</h1>
	</header>
	<section>
		<form method="POST" action="${rootPath}/naver/books">
			<div>
				<input name="isbn" id="isbn" placeholder="ISBN"> <input
					name="title" id="title" placeholder="도서명 입력 후 Enter">
			</div>
			<div>
				<input name="author" placeholder="저자"> <input
					name="publicher" placeholder="출판사"> <input name="pubdate"
					placeholder="출판일"> <input name="price" type="number">
			</div>
			<div>
				<input name="link" placeholder="자세히보기" /> <input name="image"
					placeholder="이미지경로" />
			</div>
			<textarea rows="10"></textarea>
			<button type="button">저장</button>
		</form>
	</section>
	<footer>
		<address>CopyRight &copy; itkezi@naver.com</address>
	</footer>
	<section class="modal" id="modal_box"></section>
</body>
</html>