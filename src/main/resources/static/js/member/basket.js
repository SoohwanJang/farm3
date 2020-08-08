$(()=>{
    let cartTable = $(".cart-table");
    let tbody = cartTable.find("tbody");
    let allCheckButton = cartTable.find(".all-check-button");
    let checkBox = tbody.find("input[type=checkbox]")
    let updateButton = tbody.find(".update-button");
    let productButtonWrapper = $(".product-button-wrap");
    let delButton = productButtonWrapper.find(".del-button");
    let priceContainer = $(".order-price");
    let itp = priceContainer.find(".item-total-price");
    let ftp = priceContainer.find(".fee-total-price");
    let tp = priceContainer.find(".total-price>span");
    let orderButtonWrapper = $(".order-button-wrap");
    let orderButton = orderButtonWrapper.find(".order");
    let homeButton = orderButtonWrapper.find(".home");
    
    // 
    let selectRows = [];

    homeButton.click(e=>{
        window.location.href="/index";
    });

    orderButton.click(e=>{
        if(selectRows.length<=0){
            alert("하나 이상 선택해주세요");
            return;
        }
        window.location.href=`pay/${selectRows}`;
    })

    checkBox.each(idx => {
        if (checkBox.eq(idx).prop("checked"))
            selectRows.push(checkBox.eq(idx).val());
    });
    
    let totalPrice = 0;
    let totalFeePrice = 0;

    // 상품 개수 변경
    updateButton.click(e=>{
        let id = $(e.target).val();
        let qty = $(e.target).siblings("input").val();
        fetch(`update?id=${id}&qty=${qty}`)
        .then(()=>{
            window.location.reload();
        });
    });


    // 선택 상품 삭제
    delButton.click(e=>{
        fetch(`del?srs=${selectRows}`)
        .then(()=>{
            window.location.reload();
        });
    });


    //전체체크
    allCheckButton.click(e=>{
        selectRows =[];
        totalPrice = 0;
        totalFeePrice = 0;

        if(allCheckButton.prop("checked"))
            checkBox.prop("checked",true);
        else
            checkBox.prop("checked",false);

        checkBox.each(idx => {
            if (checkBox.eq(idx).prop("checked")){
                selectRows.push(checkBox.eq(idx).val());
                calcTotal(checkBox.eq(idx));    
            }
        });


        itp.text(totalPrice+"원");
        ftp.text(totalFeePrice+"원");
        tp.text(totalPrice+totalFeePrice+"원");
    });

    checkBox.click(e=>{
        selectRows = [];
        totalPrice = 0;
        totalFeePrice = 0;

        if(!$(e.target).prop("checked"))
            allCheckButton.prop("checked",false);

        checkBox.each(idx => {
            if (checkBox.eq(idx).prop("checked")){
                selectRows.push(checkBox.eq(idx).val());
                calcTotal(checkBox.eq(idx));    
            }
        });


        itp.text(totalPrice+"원");
        ftp.text(totalFeePrice+"원");
        tp.text(totalPrice+totalFeePrice+"원");
    })

    const calcTotal = checkedBox =>{
        let priceString = checkedBox.parent().siblings(".item-price").text();
        let feeString = checkedBox.parent().siblings(".fee-price").text();

        let price = parseInt(priceString.substring(0,priceString.length-1));
        let fee = parseInt(feeString.substring(0,feeString.length-1));

        totalPrice += price;
        totalFeePrice += fee;
    }

})	