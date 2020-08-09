$(document).ready(function () {
  $(".confirm-payment").click((e) => {
    let cf = confirm("입금확인을 하셨습니까?");
    if (cf == true) {
      let id = $(".oi-id").val();
      console.log(id);

      $.ajax({
        type: "GET",
        url: `/api/seller/confirm?id=${id}`,
        success: function (response) {
          if (response == 1) {
            $(".confirm-payment").remove();
            $(".sts").remove();
            $(".confirm-payment-parent").append(`<td>확인됨</td>`);
            $(".sts-parent").prepend(`<td>입금확인</td>`);
          } else {
            return;
          }
        },
      });
      console.log("완료");
    } else if (cf == false) {
      return;
    }
  });
});
