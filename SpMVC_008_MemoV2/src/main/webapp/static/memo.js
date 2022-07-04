document.addEventListener("DOMContentLoaded", () => {
  const memo_div = document.querySelector("div.memo");
  memo_div?.addEventListener("click", (e) => {
    const target = e.target;
    const content = target?.closest("div.content");
    const seq = content?.dataset.seq;
    console.log(seq);
    if (seq) {
      document.location.href = `${rootPath}/memo/${seq}/detail`;
    }
  });

  // const memo_talbe = document.querySelector("table.memo");
  // memo_talbe?.addEventListener("click", (e) => {
  //   // table 에 click 이벤트를 적용하면
  //   // 가장 안쪽의 td가 target 으로 작동한다.
  //   const target = e.target;
  //   // 가장 안쪽의 td가 클릭 되면
  //   // td를 감싸고 있는 tr을 찾아라
  //   const tr = target?.closest("TR");
  //   const seq = tr?.dataset.seq;

  //   /*
  //   js 에서 변수값이
  //   0, undefined, null, NaN, "" 등은 if 에서 모두 false로 인식한다.

  //   seq 값이 정상적인 범위의 값일때만 detail 로 점프하기
  //   */
  //   if (seq) {
  //     document.location.href = `${rootPath}/memo/${seq}/detail`;
  //   }
  // });
});
