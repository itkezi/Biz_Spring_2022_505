const std_num_check_callback_cb = () => {
  const st_num = document.querySelector("input[name='st_num']");
  if (st_num.value === "") {
    alert("중복검사를 하려면 학번을 먼저 입력하세요");
    st_num.focus();
    return false;
  }
  // alert("입력한 학번 : " + st_num.value);
  fetch(`${rootPath}/student/st_num_check?st_num=${st_num.value}`)
    .then((res) => res.text())
    .then((result) => {
      if (result === "USE") {
        alert("이미 등록된 학번입니다.\n다시 입력하세요.");
      } else {
        alert("사용 가능한 학번입니다.");
      }
    });
};

document.addEventListener("DOMContentLoaded", () => {
  const std_num_check = document.querySelector("button.std-num-check");

  if (std_num_check) {
    std_num_check.addEventListener("click", std_num_check_callback_cb); // end callback
  }

  // 현재 html 화면에 있는 클래스가 std-save인 버튼을 챙겨서
  // 핸들링할 준비를 해달라
  const std_save = document.querySelector("button.std-save");

  // std_save가 정삭적으로 준비되었느냐
  if (std_save) {
    std_save.addEventListener("click", save_cb);
  }
});
