$(()=>{
   let addressInfoContainer = $(".address-info-container");
   let addressRadio = addressInfoContainer.find("input[type=radio]");
   let ordererAdress = addressInfoContainer.find(".orderer-address");
   let ordererAdressInput = addressInfoContainer.find(".orderer-address-input");
   let deliveryMemo = addressInfoContainer.find(".delivery-memo");
   let methodContainer = $(".method-container");
   let payButtonContainer = $(".pay-button-container");
   let payButton = payButtonContainer.find(".pay-button");
   let termContailer = $(".term-container");
   let agreeCheck = termContailer.find("#agree-check");

   let destination = "";

   payButton.click(e=>{
        
     if(!agreeCheck.prop("checked")){
          alert("약관을 동의하고 주문해주세요");
          return;
     }

     let checkedAddressRadio = addressInfoContainer.find("input[type=radio]:checked");
     if(checkedAddressRadio.val() == 'new'){
          destination = ordererAdressInput.val();
          if(destination==""){
               alert("주소를 입력하세요");
               return;
          }
     }

     let checkedMethodRadio = methodContainer.find("input[type=radio]:checked")
     let method = checkedMethodRadio.val();
     if(method==null){
          alert("결제 방식을 선택해주세요");
          return;
     }

     let selectRows = $(e.target).data("rows");

          let data = {
               'destination' : destination,
               'method' : method,
               'deliveryMemo' : deliveryMemo.val(),
               'selectRows' : selectRows,
               'addressCheck' : checkedAddressRadio.val()
          }

          fetch('../order', {
               method: 'POST',
               body: JSON.stringify(data), 
               headers:{
               'Content-Type': 'application/json'
               }
          })
          .then(res=>res.json())
          .then(json=>{
               if(json==1)
                    window.location.href="../../order/check?c=1";
               else
                    window.location.href="../../order/check?c=0";
          })
  });
  
   
   addressRadio.click(e=>{
       if($(e.target).val() == "new"){
          ordererAdress.addClass("d-none");
          ordererAdressInput.removeClass("d-none");
       }
       else{
          ordererAdress.removeClass("d-none");
          ordererAdressInput.addClass("d-none");
       }
     });
});

