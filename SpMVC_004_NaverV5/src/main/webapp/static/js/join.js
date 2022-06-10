document.addEventListener("DOMContentLoaded", () => {
  console.log("불러오기");

  const username = document.querySelector("#username");
  const password = document.querySelector("#password");
  const re_password = document.querySelector("#re-password");
  const email = document.querySelector("#email");
  const name = document.querySelector("#name");
  const nickname = document.querySelector("#nickname");
  const btn_join = document.querySelector("#btn-join");

  btn_join?.addEventListener("click", () => {
    console.log("클릭");
    if (username.value === "") {
      alert("ID는 반드시 입력하세요");
      username.focus();
      return false;
    }
    if (username.value.length > 20) {
      alert("ID는 20자 이내로 입력하세요");
      username.focus();
      return false;
    }

    // toUpperCase() : 대문자로 바꾸기
    // ID와 비밀번호를 모두 대문자로 바꿔서 비교
    if (username.value.toUpperCase() === password.value.toUpperCase()) {
      alert("ID와 비밀번호를 다르게 입력하세요");
      password.focus();
      return false;
    }

    // 숫자, 문자를 포함([A-Z , a-z, 0-9])한 6~12자리({6,12}) 문자열 검사 패턴
    const passRule = /^[A-Za-z0-9]{6,12}$/;
    // 숫자(*\d), 문자(*[a-zA-Z]), 특수문자(*[!@#$%^&+=])를 포함한 8 ~ 15자리 문자열 검사 패턴
    const passRule2 =
      /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

    // password.value의 값이 패턴에 일치하지 않으면
    if (passRule.test(password.value) === false) {
      alert("비밀번호는 문자, 숫자 포함 6 ~ 12자리까지 입력하세요");
      password.focus();
      return false;
    }

    if (re_password === "") {
      alert("비밀번호 확인을 입력해주세요");
      re_password.focus();
      return false;
    }

    if (password.value !== re_password.value) {
      alert("비밀번호가 일치하지 않습니다");
      re_password.focus();
      return false;
    }

    const emailRule =
      /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

    if (emailRule.test(email.value) === false) {
      alert("이메일 형식이 잘못되었습니다");
      email.focus();
      return false;
    }
    document.querySelector("form.join")?.submit();
  });
});
