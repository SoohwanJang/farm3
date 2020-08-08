$(()=>{
    let detailSection = $(".detail-container");
    let applyCheck = detailSection.find(".apply-check");
    let approveBtn = applyCheck.find(".approve-btn");
    let rejectBtn = applyCheck.find(".reject-btn");
    let selectId = applyCheck.find("span").text();
    
    applyCheck.click((e)=>{
    	
    	if(e.target.tagName != "INPUT") return;
    	
        if($(e.target).val() == '승인') {
            fetch(`update?id=${selectId}&value=1`)
            .then(res => res.json())
            .then(json => {        	
                alert("승인이 완료되었습니다.");
                
                changeApplyCheck();
                bind();
            })
        } else if($(e.target).val() == '반려') {
        	fetch(`update?id=${selectId}&value=2`)
            .then(res => res.json())
            .then(json => {        	
                alert("승인이 반려되었습니다.");
            })
        }            
    });

    const changeApplyCheck = ()=>{
        applyCheck.remove();
        let newApplyCheck= $('<div class="apply-check"></div>');
        applyCheck = newApplyCheck;
        applyCheck.appendTo(detailSection);
    }

    const bind = ()=>{

        let templete = $(`
        	<span>입점승인이 완료되었습니다.</span>
        `);
        templete.appendTo(applyCheck);
    }
})