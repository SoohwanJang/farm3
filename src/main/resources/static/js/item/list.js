$(function () {
	
	const listMenu = $(".product-list-menu");
	const menuLi = listMenu.find("li");
	const menuUl = listMenu.find("Ul");
	const productContainerUl = $(".product-container > ul");
	const count = $(".product-allCount");
	
	const url = "/product/list/items"
	const hitUrl = "/product/list/items-hit"
	
	const newProduct = 0;
	const hitProduct = 1;
	const lowPrice = 2;
	const highPrice = 3;
	
	const drawMenu = $(".draw-menu");
	const drawMenuList = drawMenu.find(".inner-draw");
	const ul = $("ul");
	const catg = ul.find(".catg");
	
	
	menuLi.click( function(){
		menuLi.removeClass("checked");
		$(this).toggleClass("checked");
	
		let idx =$(this).index();
		
		
		// 날짜를 초까지 있을경우 악용사례가 발생할 수 있으므로 당일 올린것을 신상품으로 취급함
		// new
		switch(idx){
			
		case newProduct :
			fetch(url)
			.then(res => res.json())
			.then(items => {
				
				const descending = (fir,sec) => {
					
					let dateA = new Date(fir.startDate);
					let dateB = new Date(fir.startDate);
					
					return dateA < dateB ? 1 : -1;
					
				};
				
				items.sort(descending);
				
				let temp ='';
				
				for(let item of items){
					console.log(item);
					temp += `<li>
								<a href=/product/details/${item.id}>
									<p class="product-image">
						              <img src=/images/items/${item.image}"/>
						            </p>
						            <p class="product-detail">
						                <span class="product-title">${item.name}</span>
						                <span class="product-price">${item.price}</span>
						                <span>${item.detail}</span>
						            </p>
						        </a>
						    </li>`
				}
				
				productContainerUl.text("");
				productContainerUl.append(temp);
				count.text(`${items.length}`);
				
			}); // endfetch
			
			break;
			
		case hitProduct : 
			
			
			
			fetch(hitUrl)
			.then(res => res.json())
			.then(items => {
				console.log(items);
				
				const descending = (fir,sec) => {
					
					
					
					return fir.count < sec.count ? 1 : -1;
					
				};
				
				items.sort(descending);
				
				let temp ='';
				
				for(let item of items){
					
					temp += `<li>
								<a href=/product/details/${item.id}>
									<p class="product-image">
						              <img src="/images/items/${item.image}">
						            </p>
						            <p class="product-detail">
						                <span class="product-title">${item.name}</span>
						                <span class="product-price">${item.price}</span>
						                <span>${item.detail}</span>
						            </p>
						        </a>
						    </li>`
				}
				
				productContainerUl.text("");
				productContainerUl.append(temp);
				count.text(`${items.length}`);
				
			}); // endfetch
			
			break;
		
		case lowPrice : 
					
			fetch(url)
			.then(res => res.json())
			.then(items => {
				
				
				
					const low = (fir,sec) => {
						
							
						
						return fir.price > sec.price ? 1 : -1;
						
					};
					
					items.sort(low);
					console.log(items);
					
					let temp ='';
					
					for(let item of items){
						
						temp += `<li>
									<a href=/product/details/${item.id}>
										<p class="product-image">
							             <img src="/images/items/${item.image}">
							            </p>
							            <p class="product-detail">
							                <span class="product-title">${item.name}</span>
							                <span class="product-price">${item.price}</span>
							                <span>${item.detail}</span>
							            </p>
							        </a>
							    </li>`
					}
					
					productContainerUl.text("");
					productContainerUl.append(temp);
					count.text(`${items.length}`);
					
				}); // endfetch
					
			break;
		case highPrice : 
			
			fetch(url)
			.then(res => res.json())
			.then(items => {
				
				
					const high = (fir,sec) => {
						
						
						
						return fir.price < sec.price ? 1 : -1;
						
					};
					
					items.sort(high);
					console.log(items);
					
					let temp ='';
					
					for(let item of items){
						
						temp += `<li>
									<a href=/product/details/${item.id}>
										<p class="product-image">
							             <img src="/images/items/${item.image}">
							            </p>
							            <p class="product-detail">
							                <span class="product-title">${item.name}</span>
							                <span class="product-price">${item.price}</span>
							                <span>${item.detail}</span>
							            </p>
							        </a>
							    </li>`
					}
					
					productContainerUl.text("");
					productContainerUl.append(temp);
					count.text(`${items.length}`);
					
				}); // endfetch
			
			break;
		} // end switch
		
		
		
		
	});// end Event
	
	
	
	
	
});