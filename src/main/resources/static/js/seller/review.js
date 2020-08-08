$(document).ready(function(){
    var reviewTitle = $(".review-title");
    var detailContainer = $(".detail-container");
    var reviewReply = $(".review-reply");
    var replyContainer = $(".reply-container");
    
    reviewTitle.click(function(e){
        let detail = e.target.parentElement.nextElementSibling;
        console.log(e.target);
        if(e.target.tagName == 'A')
        	detail = e.target.parentElement.parentElement.nextElementSibling;
        
        detail.classList.toggle("d-none");
        replyContainer.addClass("d-none");
       
    });

    reviewReply.click(e=>{
    	let reply = e.target.parentElement;
    	console.log(e.tartget);
    	if(e.target.className == 'review-reply')
        	reply = e.target.parentElement.parentElement.parentElement.nextElementSibling;
        reply.classList.toggle("d-none");
        
    });
    
});