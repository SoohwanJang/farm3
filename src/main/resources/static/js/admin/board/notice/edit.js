window.addEventListener("load",()=>{

    let adminSection = document.querySelector(".admin-main");
    let editBtn = adminSection.querySelector(".edit-button");
    let writerSection = adminSection.querySelector(".writer-container");
    let titleInput = writerSection.querySelector("input[name='title']");
    let content = writerSection.querySelector(".content");
    let pubInput = writerSection.querySelector("input[name='pub']");
    
    editBtn.onclick = (e)=>{
        e.preventDefault();

        let id = editBtn.nextElementSibling.innerText;

        if(pubInput.checked)
        	pubInput.value = true;
        else
            pubInput.value = false;
        
        fetch('edit', {
            method: "POST",
            headers: {
            	'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: id, title: titleInput.value, content: content.value, pub: pubInput.value
            })
        })
        .then(()=>{
        	window.location.href = "list";
        });
        
    }


})