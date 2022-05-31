document.addEventListener("DOMContentLoaded", () => {
  const stnum_input = document.querySelector("input[name='st_num']");
  const std_table = document.querySelector("table.stdlist");
  const index = {
    name: 0,
    grade: 1,
    tel: 2,
    addr: 3,
  };
  const student_get = async (stnum_value) => {
    const get_url = `${rootPath}/student/${stnum_value}/getter`;

    const res = await fetch(get_url);
    const studentVO = await res.json();

    const studentInfo = document.querySelectorAll("div.std span");

    studentInfo[index.name].innerText = studentVO.st_name;
    studentInfo[index.grade].innerText = studentVO.st_grade;
    studentInfo[index.tel].innerText = studentVO.st_tel;
    studentInfo[index.addr].innerText = studentVO.st_addr;

    if (stnum_input) {
      stnum_input.value = studentVO.st_num;
    }
  };
  if (stnum_input) {
    // stnum tag 에 대한 모든 것이 매개변수 e 에 담겨서 함수로 전달된다.
    // stnum 입력박스에 키보드로 무엇인가 입력하면
    stnum_input.addEventListener("keypress", async (e) => {
      // 입련된(press) 키의 ASCII code 13dlaus
      // ASCII Code 13 는 Enter
      // ASCII Code 27 는 ESC
      // ASCII Code 32 는 space
      // ASCII Code 48 는 문자열 0
      // ASCII Code 65 는 A
      // ASCII Code 97 는 a
      if (e.keyCode === 13) {
        // alert(e.target.value);
        const stnum_value = e.target.value;
        student_get(stnum_value);
      }
    });
  } // end if stnum_input
  if (std_table) {
    std_table.addEventListener("click", (e) => {
      const td = e.target;
      // click 된 요소가 TD이면
      if (td.tagName === "TD") {
        // 나의(TD) 부모 요소의 TR을 가져와라
        const parent_tr = td.closest("TR");
        // tr tag에 data-stnum로 설정된 값을 가져와라
        const st_num_value = parent_tr.dataset.stnum;
        console.log(st_num_value);
        student_get(st_num_value);
      }
    });
  }
});
