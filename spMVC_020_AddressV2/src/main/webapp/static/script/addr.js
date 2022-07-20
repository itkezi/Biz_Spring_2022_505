document.addEventListener("DOMContentLoaded", () => {
  const addr_table = document.querySelector("table.hj-ta");
  const btn_save = document.querySelector("button.save");

  addr_table?.addEventListener("click", (e) => {
    // table에 click event를 적용하면 가장 안쪽의 td가 target으로 작동한다
    const target = e.target;
    // 가장 안쪽의 td가 클릭이되면 td를 감싸고 있는 tr을 찾아가라
    const tr = target?.closest("TR");
    const seq = tr?.dataset.seq;

    if (seq) {
      document.location.href = `${rootPath}/detail?seq=${seq}`;
    }
  });

  btn_save?.addEventListener("click", (btn) => {
    const a_name = document.querySelector("input[name='a_name']");
    const a_tel = document.querySelector("input[name='a_tel']");
    const a_address = document.querySelector("input[name='a_address']");

    if (a_name?.value === "") {
      alert("이름!");
      a_name.focus();
      return false;
    }

    if (a_tel?.value === "") {
      alert("전화번호!");
      a_tel.focus();
      return false;
    }

    if (a_address?.value === "") {
      alert("주소!");
      a_address.focus();
      return false;
    }

    const form = btn.currentTarget.closest("FORM");
    form.submit();
  });
});
