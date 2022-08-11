document.addEventListener("DOMContentLoaded", () => {
  const name = document.querySelector("input[name='a_name']");
  const tel = document.querySelector("input[name='a_tel']");
  const address = document.querySelector("input[name='a_address']");
  const button = document.querySelector("button.button-save");

  if (button) {
    button.addEventListener("click", () => {
      if (name.value === "") {
        alert("이름를 입력해 주세요");
        name.focus();
        return false;
      }
      if (tel.value === "") {
        alert("전화번호를 입력해 주세요");
        tel.focus();
        return false;
      }
      if (address.value === "") {
        alert("주소를 입력해 주세요");
        address.focus();
        return false;
      }
    });
  }
});
