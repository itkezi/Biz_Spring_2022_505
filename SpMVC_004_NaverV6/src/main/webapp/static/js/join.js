document.addEventListener("DOMContentLoaded", () => {
  console.log("불러오기");

  const username = document.querySelector("#username");
  const password = document.querySelector("#password");
  const re_password = document.querySelector("#re-password");
  const email = document.querySelector("#email");
  const btn_join = document.querySelector("#btn-join");

  const div_index = {
    username: 0,
    password: 1,
    re_password: 2,
    email: 3,
    name: 4,
    nickname: 5,
  };

  const error_divs = document.querySelectorAll("div.error");

  // 숫자, 문자를 포함([A-Z , a-z, 0-9])한 6~12자리({6,12}) 문자열 검사 패턴
  const passRule = /^[A-Za-z0-9]{6,12}$/;
  const passRule1 = /^(?=^.{6,12}$)(?=.*\d)(?=.*[a-zA-Z]).*$/;
  // 숫자(*\d), 문자(*[a-zA-Z]), 특수문자(*[!@#$%^&+=])를 포함한 8 ~ 15자리 문자열 검사 패턴
  const passRule2 =
    /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
  // 이메일 형식 검사
  const emailRule =
    /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

  // 화면이 모두 그려지면 username input box에 포커싱하기
  username.focus();

  const error_msg = (div, message) => {
    div.classList.remove("w3-text-blue");
    div.classList.add("w3-text-red");
    div.innerText = message;
  };

  const ok_msg = (div, message) => {
    div.classList.remove("w3-text-red");
    div.classList.add("w3-text-blue");
    div.innerText = message;
  };

  /*
  input box에서 focus가 벗어났을 때 발생하는 event : focusout, blur
  focusout은 이벤트 버블링이 심하게 발생한다
  JS 코드에서는 주로 blur
  */
  username?.addEventListener("blur", (e) => {
    const current = e.currentTarget;
    const username_div = error_divs[div_index.username];
    if (current.value === "") {
      const msg = "* ID는 반드시 입력하세요";
      error_msg(username_div, msg);
      current.focus();
      return false;
    }

    // 중복검사 수행
    fetch(`${rootPath}/user/idcheck/${current.value}`)
      .then((res) => res.text())
      .then((result) => {
        // 서버에서 OK 문자열을 보내면 체크한 Username은 사용해도 된다
        if (result === "OK") {
          ok_msg(username_div, "* 사용가능한 ID입니다");
        } else {
          error_msg(username_div, "* 이미 가입된 ID입니다");
          username.focus();
        }
      });
  }); // end username event

  password?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const password_div = error_divs[div_index.password];

    if (passRule1.test(current.value)) {
      ok_msg(password_div, "* 올바른 비밀번호 양식입니다");
    } else {
      error_msg(
        password_div,
        "* 비밀번호는 문자, 숫자 포함 6 ~ 12자리까지 입력하세요"
      );
    }
  });

  re_password?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const re_password_div = error_divs[div_index.re_password];
    // const password_value = password?.value;

    if (current.value === password?.value) {
      ok_msg(re_password_div, "* 비밀번호 확인 완료");
    } else {
      error_msg(re_password_div, "* 비밀번호가 일치하지 않습니다");
    }
  });

  email?.addEventListener("input", (e) => {
    const current = e.currentTarget;
    const email_div = error_divs[div_index.email];
    if (emailRule.test(current.value)) {
      ok_msg(email_div, "* 올바른 이메일 양식입니다");
    } else {
      error_msg(email_div, "* 잘못된 이메일 양식입니다");
      // 이메일 양식 검사를 통과하지 못하면 다음 코드 실행 불가
      return false;
    } // 양식검사 end

    fetch(`${rootPath}/user/emailcheck?email=${current.value}`)
      .then((res) => res.text())
      .then((result) => {
        if (result === "OK") {
          ok_msg(uemail_div, "* 사용할 수 있는 이메일입니다");
        } else {
          error_msg(email_div, "* 이미 등록된 이메일입니다");
          current.focus();
        }
      });
  });

  btn_join?.addEventListener("click", () => {
    console.log("클릭");
    if (username.value === "") {
      alert("* ID는 반드시 입력하세요");
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

    if (emailRule.test(email.value) === false) {
      alert("이메일 형식이 잘못되었습니다");
      email.focus();
      return false;
    }
    document.querySelector("form.join")?.submit();
  });
});
