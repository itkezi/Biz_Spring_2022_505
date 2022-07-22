document.addEventListener("DOMContentLoaded", () => {
    const addr_table = document.querySelector("table.memo");
  
    addr_table?.addEventListener("click", (e) => {
      // table에 click event를 적용하면 가장 안쪽의 td가 target으로 작동한다
      const target = e.target;
      // 가장 안쪽의 td가 클릭이되면 td를 감싸고 있는 tr을 찾아가라
      const tr = target?.closest("TR");
      const seq = tr?.dataset.seq;
  
      /*
      JS에서 변수값이
      0, undefined, null, NaN, "" 등은 if에서 모두 false로 인식한다
      seq 값이 정상적인 범위의 값일 때만 detail로 jump
      */
  
      if (seq) {
        document.location.href = `${rootPath}/memo/${seq}/detail`;
      }
    });
  });