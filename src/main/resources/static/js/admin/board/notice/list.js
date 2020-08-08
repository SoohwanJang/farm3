window.addEventListener("load",()=>{

    let table = document.querySelector(".board-table");
    let tbody = table.querySelector("tbody");
    let checkboxCol = table.querySelector(".checkbox-col");
    let allCheckInput = table.querySelector(".all-check");
    let checkInputs = tbody.querySelectorAll("input[type='checkbox']");

    let allDeleteBtn = document.querySelector(".all-del");
    let allShowBtn = document.querySelector(".all-show");

    let search = document.querySelector(".board-search");
    let searchForm = search.querySelector("form[name='search'");
    let searchField = searchForm.querySelector("select");
    let searchInput = searchForm.querySelector("input[type='search']");
    let searchBtn = searchForm.querySelector("input[type='submit']");

    let pager = document.querySelector(".pager");
    
    allShowBtn.onclick = (e)=>{
        e.preventDefault();
        
        let selectIds = [];
        
        for(let i=0; i< checkInputs.length; i++) {
           if(checkInputs[i].checked)
              selectIds[i] = checkInputs[i].value;
        }

        selectIds  = selectIds.filter(function(item) {
            return item !== null && item !== undefined && item !== '';
        }); //배열에서 빈 값 삭제하는 필터
        
        fetch(`update?id=${selectIds}`)
        .then(res => res.json())
        .then(json=>{
            changeTbody();
            allCheckInput.checked = false;
            for(let list of json)
                bind(list);
            
            table.insertAdjacentElement("beforeend",tbody);
            checkInputs = tbody.querySelectorAll("input[type='checkbox']");

        })
        .catch((error)=>{
            console.log('There has been a problem with your fetch operation:',error.message);
        });
    }

    allDeleteBtn.onclick = (e)=>{
        e.preventDefault();
        
        let selectIds = [];        
        
        for(let i=0; i< checkInputs.length; i++) {
           if(checkInputs[i].checked)
              selectIds[i] = checkInputs[i].value;
        }

        if(selectIds.length < 1) {
            alert("하나 이상을 선택하세요");
            return;
        };

        selectIds  = selectIds.filter(function(item) {
            return item !== null && item !== undefined && item !== '';
        }); //배열에서 빈 값 삭제하는 필터        

        fetch(`del?id=${selectIds}`)
        .then(res => res.json())
        .then(json=>{
            changeTbody();
            allCheckInput.checked = false;
            for(let list of json)
                bind(list);
            
            table.insertAdjacentElement("beforeend",tbody);
            checkInputs = tbody.querySelectorAll("input[type='checkbox']");

        })
        .catch((error)=>{
            console.log('There has been a problem with your fetch operation:',error.message);
        });
        
    }

    pager.onclick = (e)=>{
        if(e.target.tagName != "A") return;
        e.preventDefault();

        let page = e.target.innerText;
        let query = searchInput.value;
        let field = searchField.value;

        fetch(`api/list?p=${page}&q=${query}&f=${field}`)
        .then(res => res.json())
        .then(json=>{
            changeTbody();
            allCheckInput.checked = false;
            for(let list of json)
                bind(list);
            
            table.insertAdjacentElement("beforeend",tbody);
            checkInputs = tbody.querySelectorAll("input[type='checkbox']");

        })
       .catch((error)=>{
            console.log('There has been a problem with your fetch operation:',error.message);
       });
    }
    
    searchBtn.onclick = (e)=>{
        e.preventDefault();

        let query = searchInput.value;
        let field = searchField.value;

        fetch(`api/list?p=1&q=${query}&f=${field}`)
        .then(res => res.json())
        .then(json=>{
            changeTbody();
            allCheckInput.checked = false;
            
            for(let list of json)
                bind(list);

            table.insertAdjacentElement("beforeend",tbody);
            checkInputs = tbody.querySelectorAll("input[type='checkbox']");
            
        })
        .catch((error)=>{
             console.log('There has been a problem with your fetch operation:',error.message);
        });
    }

    allCheckInput.onclick = ()=>{
        
        if(allCheckInput.checked) {
            for(var i=0; i< checkInputs.length; i++)
                checkInputs[i].checked = true;
       } else {
            for(var i=0; i< checkInputs.length; i++)
                checkInputs[i].checked = false;
       }
       
    }

    const changeTbody = ()=>{
        tbody.remove();
        let newTbody = document.createElement("tbody");
        
        tbody = newTbody;
    }

    const bind = list => {
       let pubText ="";
       if(list.pub)
          pubText = "공개";
       else
          pubText = "비공개";       
       
        let tr = 
           `<tr>
              <td>${list.id}</td>
               <td>
                   <a href="${list.id}">
                       ${list.title}
                   </a>
               </td>
               <td>관리자</td>
               <td>
                   ${list.regDate}
               </td>
               <td>${list.hit}</td>
               <td>
                  ${pubText}
               </td>
                <td>
                    <input type="checkbox" value="${list.id}">
                </td>
           </tr>`;
        
        tbody.insertAdjacentHTML("beforeend",tr);
    }

});