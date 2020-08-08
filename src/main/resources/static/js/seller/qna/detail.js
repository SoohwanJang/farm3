//Community QnA js

$(()=>{
    let detailSection = $(".detail-container");
	let commentSection = detailSection.find(".comment-section");
    let comment = commentSection.find(".comment");
    let commentBtn = commentSection.find("input[type='submit']");
    
    let selectId = commentSection.find("span").text();

    commentBtn.click(()=>{

        fetch('edit', {
            method: "POST",
            headers: {
            	'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: selectId, 
                content: comment.val()
            })
        })
        .then(res=>res.json())
        .then(json => {
        	changSection();
            bind(json);
        });
    	
    });

    const changSection = ()=>{
        commentSection.remove();
        let newSection= $('<div class="comment-section"></div>');
        commentSection = newSection;
        commentSection.appendTo(detailSection);
    }

    const bind = (q)=>{

        let templete = $(`
        	<span>
				<b>관리자</b> (작성일: ${q.regDateA})
			</span>
			<span>
				${q.contentA }
			</span>
        `);
        templete.appendTo(commentSection);
    }


})