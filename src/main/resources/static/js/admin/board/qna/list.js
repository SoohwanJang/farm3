$(()=>{

    let table = $(".board-table");
    let tbody = table.find("tbody");
    
    let searchForm = $(".search-form");
    let searchButton = searchForm.find("input[type=submit]");
    let searchInput = searchForm.find("input[type=search]");
    let searchfield = searchForm.find("select");
        
    let allCheckButton = $(".all-check");
    let checkBox = tbody.find("input[type=checkbox]");
    let allDeleteBtn = $(".all-del");

    let pager = $(".pager");

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
                    <a href="${list.id}">
                        ${list.title}
                    </a>
                </td>
                <td>이름</td>
                <td>${list.regDate}</td>
                <td>
                    <input type="checkbox" value="${list.id}">
                </td>
            </tr>
        `);

        tr.appendTo(tbody);
    }
    
})