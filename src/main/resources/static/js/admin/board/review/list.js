$(()=>{

    let table = $(".review-table");
    let tbody = table.find("tbody");
    
    let searchForm = $(".search-form");
    let searchButton = searchForm.find("input[type=submit]");
    let searchInput = searchForm.find("input[type=search]");
    let searchfield = searchForm.find("select");
        
    let allCheckButton = $(".all-check");
    let checkBox = tbody.find("input[type=checkbox]");
    let allDeleteBtn = $(".all-del");

    let rate = table.find(".rate");
    let rateText = rate.find(".rate-text");

    let pager = $(".pager");

    var starInsert = function(){

        rate = table.find(".rate");
        rateText = rate.find(".rate-text");
        rate.each(index =>{

            let text = rateText.eq(index).text();
            let starImg = "";
            
            for(let i=0; i<5; i++) {
                if(i<text)
                    starImg  += '<img src ="/images/color-star-icon.png" />' ;
                else
                    starImg  += '<img src ="/images/star-icon.png" />' ;
            }
            rate.eq(index).html(starImg);
    
        });
        
    }

    allCheckButton.click(e=>{
        if(allCheckButton.prop("checked"))
            checkBox.prop("checked",true)
        else
            checkBox.prop("checked",false)
    });

    allDeleteBtn.click(e=>{
        e.preventDefault();

        let selectIds = [];

        checkBox.each(index => {
            if (checkBox.eq(index).prop("checked"))
                selectIds.push(checkBox.eq(index).val());
        });

        if(selectIds.length < 1) {
            alert("하나 이상을 선택하세요");
            return;
        };

        fetch(`del?id=${selectIds}`)
        .then(res => res.json())
        .then(json=>{
            changeTbody();
            for(let list of json)
                bind(list);

            starInsert();

            checkBox = tbody.find("input[type=checkbox]");

        })
    })

    searchButton.click(e=>{
        e.preventDefault();

        let page = e.target.innerText;
        let query = searchInput.val();
        let field = searchfield.val();

        fetch(`api/list?p=1&q=${query}&f=${field}`)
        .then(res=>res.json())
        .then(json=>{
            changeTbody();
            for(let list of json)
                bind(list);

            starInsert();

            checkBox = tbody.find("input[type=checkbox]");
        })
        allCheckButton.prop("checked",false);
    });

    pager.click(e=>{
        e.preventDefault();

        if(e.target.tagName != "A") return;

        let page = e.target.innerText;
        let query = searchInput.val();
        let field = searchfield.val();

        fetch(`api/list?p=${page}&q=${query}&f=${field}`)
        .then(res=>res.json())
        .then(json=>{
            changeTbody();
            for(let list of json)
                bind(list);

            starInsert();

            checkBox = tbody.find("input[type=checkbox]");
        })
        allCheckButton.prop("checked",false);
    });

    const changeTbody = ()=>{
        tbody.remove();
        let newTbody = $("<tbody></tbody>");
        tbody = newTbody;
        tbody.appendTo(table);
    }

    const bind = list=>{

        let tr = $(`
            <tr>
                <td>${list.id}</td>
                <td>
                    <img src="/images/product2.jpg" alt="리뷰 제품 사진">
                </td>
                <td>
                    <a href="${list.id}">
                        ${list.title}
                    </a>
                </td>
                <td class="rate">
                    <span class="d-none rate-text">${list.rate}</span>
                </td>
                <td>${list.name}</td>
                <td>${list.regDate}</td>
                <td>${list.hit}</td>
                <td>
                    <input type="checkbox" value="${list.id}">
                </td>
            </tr>
        `);

        tr.appendTo(tbody);
    }
    
})