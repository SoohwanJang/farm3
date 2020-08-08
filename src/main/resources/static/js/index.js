$(function(){

    var header = $(".header");
    var wholeMenu = header.find(".whole-menu");
    var drawMenu = header.find(".draw-menu");
    var upBtn = $(".up-button");

    var categoryList = $(".category-list li");
    var productListContainer = $(".product-list-container");
    var productList = $(".product-list");
    

    categoryList.click( function(){
        productListContainer.show();
        var index = $(this).index()
        var categoryText = $(this).text();
        var url = `/index/items?category=${categoryText}`;
        	
        
        productList.html("");
        
        const api =  (async () => { 
        	
        	
        const response = await fetch(url);
        const items = await response.json();
        
        for(item of  items){
	    	let temp = $(`<li>
	                    <p class="product-image">
	                		<img src="/images/items/${item.image}">
	                    </p>
	                    <p class="product-detail">
	                        <span class="product-title">${item.name}</span>
	                        <span class="product-price">${item.price }</span>
	                        <span>${item.detail}</span> <span>${item.subOrigin} ${item.origin}<span/>
	                    </p>
	                </li>`);
    		temp.appendTo(productList);
        	}
        })();
    });

    wholeMenu.hover(
        function() {
            drawMenu.show();
        }, function() {
            drawMenu.hide();
        }
    );

    drawMenu.hover(
        function() {
            drawMenu.show();
        }, function() {
            drawMenu.hide();
        }
    );

    
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            upBtn.fadeIn(500);
        } else {
            upBtn.fadeOut(500);
        }
    });

    upBtn.click(function (e) {
        e.preventDefault();
        $('html, body').animate({scrollTop: 0}, 200);
    });
    
    //-----------------------------------//
    
    $(function() {
		var clickedBtn = $(".category-list > li");	// 버튼 정의
		clickedBtn.click(function() {
			clickedBtn.removeClass("clicked"); // 버튼 속에 'clicked' 클래스를 삭제 한다.
			$(this).addClass("clicked"); // 클릭한 li태그에 'clicked' 클래스를 넣는다. → 클릭되지 않은 li태그는 clicked 클래스 삭제
		});
	});
		
		
//	var notices = `${si}`;
//	
//	clickedBtn.onclick = function(e){
//		// 엘리먼트 노드가 가지는 기본 행위를 막는 함수
//		e.preventDefault();
//		// A 태그가 클릭 된 것이 아닌 경우 함수를 끝내기 
//		if(e.target.nodeName != "A") return;
//		console.log(e.target);
//		
//		// XmlHttpRequest : callback 개념의 라이브러리
//		var xhr = new XMLHttpRequest();
//		xhr.open('GET', '/index', true); // 비동기옵션
//		xhr.onload = function () {
//			notices = JSON.parse(xhr.responseText);
//			bind(); // 호출
//		};
//		
//		xhr.send(null);       
//		//정의
//		function bind(){
//			var ul = $(".ul-class");
//			var ulContent = "";
//			for(var i in notices){
//				var n = notices[i];
//				var template = $(`<li>
//	                    <p class="product-image">
//                    		<img src="/images/product1.jpg">
//	                    </p>
//	                    <p class="product-detail">
//	                        <span class="product-title">${item.name}</span>
//	                        <span class="product-price">${item.price }</span>
//	                        <span>${item.detail}</span>
//	                    </p>
//                    </li>`);
//				template.appendTo(ul);
//			}
//		};
//	};
    
});