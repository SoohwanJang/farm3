/**
 * 
 */

$(function(){
	let allFavItem = $(".all-view-font.fav-item");
	let favItemList = $(".att-list.fav-item-list");

	allFavItem.click(function(e){
		e.preventDefault();
		
		fetch(`/member/favitemlist`)
	    .then(res => res.json())
	    .then(json=>{
	    	let a = $(".fav-item");
	    	a.remove();    	
	    	for(let n of json ){
	    		favItemList.append(
	    		`<a class="fav-item" href="/product/details/${n.itemId}">
                            		<div class="att-item">
                            			<img src="/upload/${n.itemImgName }">
                            			<div class="att-item-des">[은팜독점] ${ n.itemName}</div>
                            		</div>
                            	</a>`);
	    	}

	    });
	});
	
	let allFavSeller = $(".all-view-font.fav-seller");
	let favSellermList = $(".att-list.fav-seller-list");
	
	allFavSeller.click(function(e){
		e.preventDefault();
		fetch(`/member/favsellerlist`)
	    .then(res => res.json())
	    .then(json=>{
	    	let a = $(".fav-seller");
	    	a.remove();    	
	    	for(let n of json ){
	    		favSellermList.append(
	    		`<a class="fav-seller" href="">
                            		<div class="att-item">
                            			<img src="../images/sellertitle/${n.titleImage }">
                            			<div class="att-item-des">${ n.comName}</div>
                            		</div>
                            	</a>`);
	    	}

	    });
		
	});
	
	
	
	
	
});
	


	