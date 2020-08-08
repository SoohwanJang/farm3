$(document).ready(function () {
  //카테고리
  $(".main-CATS").click((e) => {
    let idData = $(e.target).data("id");
    $.ajax({
      type: "get",
      url: `/api/seller/category/sub-categories?sup=${idData}`,
      async: "true",
      success: function (subCAT) {
        console.log(subCAT);
        var sub = subCAT;
        $(".sub-CAT").children("li").remove();

        for (var i of sub) {
          $(".sub-CAT").append(
            `<li class="sub-CAT-List">${i.name} <input class="${i.name}" type="checkbox" name="categoryId" value="${i.id}"></input></li>`
          );
        }
        // <input class="d-none" type="checkbox" name="categoryId" value="${sub.id}"></input>

        $(".sub-CAT-List").click(function (e) {
          $("input[type='checkbox']").prop("checked", false);
          let result = $(e.target).text();
          $(`input:checkbox[class=${result}]`).prop("checked", true);
          console.log(result);

          $(".category-result").children("span").remove();
          $(".category-result").append(`<span>${result}</span>`);
        });
      },
    });
  });

  //원산지 옵션
  let mainOri = $(".main-origin");
  let subOri = $(".sub-origin");
  mainOri.on("change", function () {
    let pid = mainOri.val();

    if (pid == "선택하세요") pid = 0;

    fetch(`/api/seller/origin/list?pid=${pid}`)
      .then((res) => res.json())
      .then((json) => {
        console.log(json);
        let option = subOri.children("option");
        option.remove();
        subOri.append("<option> 선택하시오 </option>");
        for (let i of json) {
          console.log(i);
          subOri.append(`
              <option value=${i.id}>${i.name}</option>`);
        }
      });
  });
});
