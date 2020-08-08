$(function() {
	const $window = $(window);
	
	const navLi = $('.detail-list > li');
	
	const detailTab = $('.detail-list');
	const detailSection = $('.detail-container > section');
	const detailContainer = $ ('.detail-container');
	const detailTop = detailTab.offset().top;
	
	const prCount = $('.product-count');
	const totalCount = $('.total-price b:last-child');
	const totalPrice = $('.current-product td:last-child');
	const total = $('.total-price b:first-child');
	const productPrice = parseInt(totalPrice.text());
	
	const reviewButton = $('.review-button');	
	let reviewBody = $('.review-tbody');
	let reviewTr = $('.review-tbody > tr');

	const qnaButton = $('.QnA-button');
	let qnaBody = $('.QnA-tbody');
	let qnaTr = $('.QnA-tbody > tr');
	
	
	
	$window.scroll( () => {
		
		if($(this).scrollTop() >= detailTop){
			detailTab.addClass('stick');
		}else{
			detailTab.removeClass('stick');
		}
		
		detailSection.each( function(){
			
			var idx =$(this).index()-2;
		if($(this).offset().top <= $window.scrollTop() +100){
			navLi.removeClass('clicked');
			navLi.eq(idx).addClass('clicked');
			}
		});
	
	});	
	
	
	
	
	
	navLi.click( (e) => {
		e.preventDefault();
		$(e.target).addClass('clicked').siblings().removeClass('clicked');
		var idx = $(e.target).index();
		
		var section = detailSection.eq(idx);
		var sectionDistance = section.offset().top-100;
	
		
		
		$('html,body').stop().animate({scrollTop : sectionDistance});
		
	});
	
	
	prCount.change( function(e) {
		
		var count = parseInt($(this).val());
		var price = count * productPrice;
		totalCount.text(`(${count}개)`);
		totalPrice.text(`\\${price}`);
		total.text(`총 상품 금액 : \\${price} (수량)`);
	});
	
	
	
	
	
		reviewButton.click(function (e){
		
		e.preventDefault();
		let prId = reviewButton.data('id');
		
		var url = `/product/details/review/plus/${prId}`;
		
		fetch(url)
		  .then(response => response.json())
		  
		  .then( reviewNotices => {
			  
  
			 			  
			  if(reviewNotices.length === 0){			  
				  alert('더이상 게시글이 없습니다.');
				  
			  }else{				  
				  let temp ='';
				  let rate ='';
				 
				  for(const review of reviewNotices){
					  
				
					  switch(review.rate){
						case 5 : 
							rate = `<td>★★★★★</td>`
							break;
						case 4 : 
							rate = `<td>★★★★☆</td>`
							break;
						case 3 : 
							rate =`<td>★★★☆☆</td>`
							break;
						case 2 : 
							rate = `<td>★★☆☆☆</td>`
							break;
						case 1 : 
							rate = `<td>★☆☆☆☆</td>`
							break;						
						}
					  
					  temp += `<tr class="review">
								  	<td class="notice-id">${review.id}</td>
								  	<td>${review.title}</td>
								  	${rate}								
									<td>${review.uid}</td>
									<td>${review.regDate.substring(0,10)}</td>
									<td>${review.hit}</td>
								</tr>`;					  
				  	}
				  		
						$('.review-tbody').append(temp);
						reviewTr = $('.review-tbody > tr');
				  }
			  });
		  });

		reviewBody.click(function (e){
		
			if(e.target.tagName != "TD") return;
			
			if(!$(e.target).parent().hasClass('review'))return;
		
		
		let td = $(e.target);
		let tr = td.parent('tr');
		let noticeId = tr.find('.notice-id').text();
		let prId = reviewButton.data('id');	
		const url = `/product/details/review/notice?itemId=${prId}&noticeId=${noticeId}`;
		let newTr ='';
		
		tr.toggleClass('clicked');
		
		
		if(tr.next().hasClass('newTr')){
			td.siblings().css("color" , "#666");
			td.css("color" , "#666");
			tr.next().remove();
		}else{
			td.siblings().css("color" , "white");
			td.css("color" , "white");
			
		fetch(url)
		  .then(response => response.json())
		  .then( review => {
			  		
			  console.log(review.image);
			   newTr = 
				   	$(
						`<tr class="newTr">
						<td colspan="6">
						 <img src="/images/items/${review.image || ''}"/>
				   			${review.content || ''} 
						 </td>
						
						</tr>`
					   );
			   
			   	tr.after(newTr);
		  		});		
		}
		
	});
		qnaButton.click( function(e){
			
			e.preventDefault();
		
			
			let prId = qnaButton.data('id');	
		
			var url = `/product/details/itemQnA/plus/${prId}`;
			let temp ='';
			
			fetch(url)
			  .then(response => response.json())			  
			  .then( QnANotices => {
				  
				  for(const notice of QnANotices){
					  
					  
					  temp += `<tr class="qna">
								  	<td class="notice-id">${notice.id}</td>
								  	<td>${notice.title}</td>								
									<td>${notice.uid}</td>
									<td>${notice.regDate}</td>
									<td>${notice.hit}</td>
								</tr>`;					  
				  	}
				  
				  $('.QnA-tbody').append(temp);			  
			  
			  }); 
			});
	
		
		qnaBody.click(function (e){
			
			if(e.target.tagName != "TD") return;
			if(!$(e.target).parent().hasClass('qna'))return;
			
			
			let td = $(e.target);
			let tr = td.parent('tr');
			let noticeId = tr.find('.notice-id').text();
			let prId = qnaButton.data('id');	
			var url = `/product/details/itemQnA/${noticeId}`;
			let newTr ='';
			
			tr.toggleClass('clicked');
			
			
			if(tr.next().hasClass('newTr')){
				
				td.siblings().css("color" , "#666");
				td.css("color" , "#666");
				tr.next().remove();
			}else{	
				
				
				td.siblings().css("color" , "white");
				td.css("color" , "white");
			fetch(url)
			  .then(response => response.json())
			  .then( QnA => {
				  		
				  
				   newTr = 
					   	$(
							`<tr class="newTr">
							<td colspan="5">
							${QnA.content || ''} ${QnA.image || ''}
							 </td>
							
							</tr>`
						   );
				   
				   	tr.after(newTr);
			  		});		
			}
			
		});
	
	

});


