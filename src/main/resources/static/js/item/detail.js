$(()=>{
    let itemExplain = $(".product-explain");
    let itemTitle = itemExplain.find(".product-dt");
    let orderForm = $(".detail-form");
    let orderButton = orderForm.find(".order-button");
    let basketButton = orderForm.find(".basket-button");
    let attButton = orderForm.find(".att-button");
    let itemCountInput = orderForm.find(".product-count");
    
    let msgBox = $(".msg-box");
    let msgContent = msgBox.find(".msg");
    let msgClose = msgBox.find(".close");
    let buttonWrapper = msgBox.find(".button-wrapper");
    let acceptButton = buttonWrapper.find(".accept-button");
    let rejectButton = buttonWrapper.find(".reject-button");
    
    //
    const itemId = itemTitle.data("id");
    let itemCount = itemCountInput.val();

    acceptButton.click(e=>{
        fetch(`/basket/append?id=${itemId}&qty=${itemCount}`)
        .then(()=>{
            msgBox.addClass("d-none");
            buttonWrapper.addClass("d-none");
        })
    });

    basketButton.click(e=>{
        e.preventDefault();
        itemCount = itemCountInput.val();

        fetch(`/basket/contain?id=${itemId}&qty=${itemCount}`)
        .then(res=> res.json())
        .then(json=>{
            if(json == 1)
                msg = "장바구니에 등록하였습니다.";
            else if(json == 2){
                msg = "이미 등록된 상품입니다. 추가하시겠습니까?";
                buttonWrapper.removeClass("d-none");
            }
            else
                msg = "장바구니에 등록할 수 없습니다.";

            alertMsgBox(msg);
        })

    })	

    attButton.click(e=>{
        e.preventDefault(); 

        fetch(`/favitem/contain?id=${itemId}`)
        .then(res => res.json())
        .then(json=>{
            if(json == 1)
                msg = "관심상품에 등록하였습니다.";
            else if(json == 2)
                msg= "관심상품에서 해제되었습니다.";
            else
                msp = "관심상품에 등록할 수 없습니다.";

            alertMsgBox(msg);
        })
    })
    
    orderButton.click(e=>{
        e.preventDefault();

        fetch(`/basket/containforce?id=${itemId}&qty=${itemCount}`)
        .then(res=>res.json())
        .then(json=>{
            console.log(json); //basket id
            window.location.href=`/member/basket/pay/${json}`;
        });
    })
    
    rejectButton.click(e=>{
        msgBox.addClass("d-none");
        buttonWrapper.addClass("d-none");
    })
    msgClose.click(e=>{
        msgBox.addClass("d-none");
        buttonWrapper.addClass("d-none");
    });

    const alertMsgBox = msg =>{
        msgContent.text(msg);
        msgBox.removeClass("d-none");
    }
})   