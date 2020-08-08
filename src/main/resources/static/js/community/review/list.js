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
    
})