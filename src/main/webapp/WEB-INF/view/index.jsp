<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

    <main class="main">
        <section>
            <h1 class="d-none">메인</h1>
            <div class="slider">
		     	<div class="slide showing"></div>
		     	<div class="slide"></div>
				<button type="button" class="left slide-btn"></button>
				<button type="button" class="right slide-btn"></button>
		    </div>

            <section class="content-container main-product">
                <h1 class="d-none">판매 상품</h1>
                <ul class="category-list">
                    <li class="clicked">곡물</li>
                    <li>채소</li>
                    <li>음료</li>
                    <li>기타</li>
                </ul>

                <ul class="product-list">
                	<c:forEach var="item" items="${items}">
	                    <li>
		                    <p class="product-image">
	                    		<img src="/images/items/${item.image}">
		                    </p>
		                    <p class="product-detail">
		                        <span class="product-title">${item.name}</span>
		                        <span class="product-price">${item.price }</span>
		                        <span>${item.detail}</span>
		                    </p>
	                    </li>
                    </c:forEach>
                </ul>
            </section>

            <section class="content-container current">
                <h1 class="d-none">시세 정보</h1>
                <div>
                    <span> 
                        <h2 class="section-title">도매 가격(중도매인 판매가격)</h2>
                        <span>상품,원</span>
                    </span>
                    <img src="images/current1.jpg">
                </div>
                <div>
                    <span>
                        <h2 class="section-title">소매 가격</h2>
                        <span>상품,원</span>
                    </span>
                    <img src="images/current2.jpg">
                </div>
            </section>
            <section class="content-container review">
                <h1 class="section-title">상품후기</h1>
                <ul class="ul-class">
                	<c:forEach var="reviews" items="${reviews}">
                	<li>
                		<a href = /product/details/${reviews.itemId}>                		
	                       
                        	<div class="review-img">
                        		<img src="images/items/${reviews.image}">
                        	</div>
	                        
	                        <p class="review-text">
	                            <span class="review-product-title">상품명: ${reviews.productName}</span>
	                            <span class="review-title">${reviews.content } (${reviews.name })</span>
	                            <span class="rate-star">
		                            <c:choose>
										<c:when test="${reviews.rate eq 5 }">★★★★★</c:when>
										<c:when test="${reviews.rate eq 4 }">★★★★☆</c:when>
										<c:when test="${reviews.rate eq 3 }">★★★☆☆</c:when>
										<c:when test="${reviews.rate eq 2 }">★★☆☆☆</c:when>
										<c:when test="${reviews.rate eq 1 }">★☆☆☆☆</c:when>
									</c:choose>
								</span>
	                        </p>
                        </a>
                    </li>
               </c:forEach>
               </ul>
           </section>
       </section>
   </main>
 <script src="/js/slide.js"></script>