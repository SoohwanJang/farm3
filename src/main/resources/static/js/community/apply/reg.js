window.addEventListener("load",()=>{

    let mainSection = document.querySelector(".main");
    let memberDefaultInfo = mainSection.querySelector(".member-default-info");
    let applySignupTable = memberDefaultInfo.querySelector(".apply-signup-table");
    let titleInput = applySignupTable.querySelector("input[name='title']");
    let comNameInput = applySignupTable.querySelector("input[name='comName']");
    let brnInput = applySignupTable.querySelector("input[name='brn']");
    let repNameInput = applySignupTable.querySelector("input[name='repName']");
    let staffNameInput = applySignupTable.querySelector("input[name='staffName']");
    let emailInput = applySignupTable.querySelector("input[name='email']");
    let telephoneInput = applySignupTable.querySelector("input[name='telephone']");
    let phoneInput = applySignupTable.querySelector("input[name='phone']");
    let filesInput = applySignupTable.querySelector("input[name='files']");
    let sellingUrlInput = applySignupTable.querySelector("input[name='sellingUrl']");
    let contentInput = applySignupTable.querySelector("input[name='content']");
        
    //submit button
    let submitBtn = mainSection.querySelector("input[type='submit']");

    submitBtn.addEventListener("click",(e)=>{

        if(titleInput.value == "") {
            alert("제목을 입력해주세요.");
            return;
        }
        if(comNameInput.value == "") {
            alert("법인명(단체명)을 입력해주세요.");
            return;
        }
        if(brnInput.value == "") {
            alert("법인/사업자번호를 입력해주세요.");
            return;
        }
        if(comNameInput.value == "") {
            alert("대표자 이름을 입력해주세요.");
            return;
        }
        if(staffNameInput.value == "") {
            alert("담당자 이름을 입력해주세요.");
            return;
        }
        if(emailInput.value == "") {
            alert("이메일을 입력해주세요.");
            return;
        }
        if(titleInput.value == "") {
            alert("제목을 입력해주세요.");
            return;
        }
        if(telephoneInput.value == "") {
            alert("휴대전화를 입력해주세요.");
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
        
        var json = {
        		//db name: name of Iniput.value
        		title: titleInput.value, 
        		content: contentInput.value, 
        		comName: comNameInput.value, 
        		brn: brnInput.value, 
        		repName: repNameInput.value, 
        		staffName: sataffNameInput.value, 
        		telephone: telephoneInput.value, 
        		phone: phoneInput.value, 
        		email: emailInput.value, 
        		files: filesInput.value, 
        		sellingUrl: sellingUrlInput.value, 
        		titleImage: titleImageInput.value
        		};
        
        var data = JSON.stringify(json);
        xhr.send(data);
        location.href="list";
        
    });

})