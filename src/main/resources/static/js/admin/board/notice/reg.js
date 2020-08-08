window.addEventListener("load",()=>{

    let adminSection = document.querySelector(".admin-main");
    let writerSection = adminSection.querySelector(".writer-container");
    let titleInput = writerSection.querySelector("input[name='title']");
    let content = writerSection.querySelector(".content");
    let pubInput = writerSection.querySelector("input[name='pub']");
    let submitBtn = adminSection.querySelector("input[type='submit']");

    submitBtn.addEventListener("click",(e)=>{

        if(titleInput.value == "") {
            alert("제목을 입력해주세요.");
            return;
        }

        if(pubInput.checked)
        	pubInput.value = true;
        else
        	pubInput.value = false;
        
        var xhr = new XMLHttpRequest();
        xhr.open('POST','reg', true);
        xhr.setRequestHeader("content-type","application/json");        
        
        xhr.onload = function(){
            //window.location.href = "list";
        }
        
        var json = {title: titleInput.value, content: content.value, pub: pubInput.value};
        
        var data = JSON.stringify(json);
        xhr.send(data);
        
    });


})