document.addEventListener("DOMContentLoaded", () => {
  const st_li = document.querySelectorAll(".list");

  for (let i = 0; i < st_li.length; i++) {
    st_li[i]?.addEventListener("click", (e) => {
      // table에 click event를 적용하면 가장 안쪽의 td가 target으로 작동한다
      const target = e.target;
      // 가장 안쪽의 td가 클릭이되면 td를 감싸고 있는 tr을 찾아가라
      const ul = target?.closest("UL");
      const stnum = ul?.dataset.num;

      if (stnum) {
        document.location.href = `${rootPath}/student/detail?st_num=${stnum}`;
      }
    });
  }
});
