$(()=>{
    let pager = $(".pager");
    let table = $(".product-table");
    let tbody = table.find("tbody");
    let searchForm = $(".search-form");
    let searchButton = searchForm.find("input[type=submit]");
    let searchInput = searchForm.find("input[type=search]");
    let searchfield = searchForm.find("select");
    let allCheckButton = $(".all-check-button");
    let checkBox = tbody.find("input[type=checkbox]")
    let categoryMenu = $(".product-category-menu");
    let productButtonList = $(".product-list-button");
    let delButton = productButtonList.find(".del-button");

    let productList = $(".product-list");
    let pageTitle = productList.find(".page-title");

    let query = "";
    let field = "name";
    let catg = "";

    // 일괄삭제 버튼
    delButton.click(e=>{
        let selectRows = [];

        checkBox.each(idx => {
            if (checkBox.eq(idx).prop("checked"))
                selectRows.push(checkBox.eq(idx).val());
        });

        if(selectRows.length < 1) {
            alert("하나 이상을 선택하세요");
            return;
        };

        //요청으로 delete 하고 (해당 카테고리/ 해당 검색 값)1p 얻어오기
        fetch(`api/del?srs=${selectRows}`)
        .then(res=>{
            window.location.reload();
        })
        
    })

    // 카테고리 필터
    categoryMenu.click(e=>{
        let select = null;
        if(e.target.tagName == "LI")
            select = $(e.target);
        else if(e.target.tagName == "SPAN")
            select = $(e.target.parentElement);
            
        let categoryLi = categoryMenu.find("li");
        categoryLi.removeClass("select-category");

        select.addClass("select-category");
        catg = select.find(":first-child").text();

        pageTitle.text(catg);

        if(catg=="전체상품")
            catg = "";

        fetch(`api/list?c=${catg}`)
        .then(res => res.json())
        .then(json=>{
            changeTbody();
            for(let i of json)
                bindList(i);
                
                checkBox = tbody.find("input[type=checkbox]")
            });

            allCheckButton.prop("checked",false);
        })

    allCheckButton.click(e=>{
        if(allCheckButton.prop("checked"))
            checkBox.prop("checked",true)
        else
            checkBox.prop("checked",false)
    })

    searchButton.click(e=>{
        e.preventDefault();

        query = searchInput.val();
        field = searchfield.val();

     
        fetch(`api/list?p=1&q=${query}&f=${field}&c=${catg}`)
        .then(res => res.json())
        .then(json=>{
            changeTbody();
            for(let i of json)
                bindList(i);

            checkBox = tbody.find("input[type=checkbox]")
        });
        allCheckButton.prop("checked",false);
    })

    pager.click(e=>{
        if(e.target.tagName != "A") return;
        e.preventDefault();
        let pageButton = pager.find("a");
        pageButton.removeClass("checked");
        $(e.target).addClass("checked");
        let page = e.target.innerText;

        let query = searchInput.val();
        let field = searchfield.val();

        fetch(`api/list?p=${page}&q=${query}&f=${field}&c=${catg}`)
        .then(res=>res.json())
        .then(json=>{
            changeTbody();
            for(let i of json)
                bindList(i);

            checkBox = tbody.find("input[type=checkbox]")
        })   

        allCheckButton.prop("checked",false);
    });

    const changeTbody = ()=>{
        tbody.remove();
        let newTbody = $("<tbody></tbody>");
        tbody = newTbody;
        tbody.appendTo(table);
    }

    const bindList = i =>{
        let sellDate = i.startDate.substring(0,10)+" ~ "+i.endDate.substring(0,10); 
        let tr = $(`<tr>
                    <td>
                        <input type="checkbox" value=${i.id}>
                    </td>
                    <td>
                        <img src="/upload/${i.image}">
                    </td>
                    <td>
                        <dl>
                            <dt>등록명</dt>
                            <dd>${i.regName }</dd>
                        </dl>
                        <dl>
                            <dt>상품명</dt>
                            <dd>${i.name }</dd>
                        </dl>
                        <dl>
                            <dt>카테고리</dt>
                            <dd>${i.catgPName } &gt; ${i.catgName }</dd>
                        </dl>
                        <dl>
                            <dt>판매가격</dt>
                            <dd>${i.price }</dd>
                        </dl>
                    </td>
                    <td>
                        <dl>
                            <dt>판매자(ID)</dt>
                            <dd>${i.sellerName }(${i.sellerUid})</dd>
                        </dl>
                        <dl>
                            <dt>판매기간</dt>
                            <dd>
                                ${sellDate}
                            </dd>
                        </dl>
                        <dl>
                            <dt>태그</dt>
                            <dd>${i.tag }</dd>
                        </dl>
                        <dl>
                            <dt>공개여부</dt>
                            <dd>${i.pub }</dd>
                        </dl>
                    </td>
                </tr>`);
        tr.appendTo(tbody);
    }
})