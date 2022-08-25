document.addEventListener("DOMContentLoaded", () => {
  const address_table = document.querySelector("table.allnotbucket-table");
  console.log(address_table);
  address_table?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const a_seq = tr.dataset.seq;
      document.location.href = `${rootPath}/notbucket/detail?seq=${a_seq}`;
    }
  });
});
