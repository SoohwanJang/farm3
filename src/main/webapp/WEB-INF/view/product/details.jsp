<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<main class="main">
		<section class="msg-box d-none">
         <span class="close">X</span>
          <div class="msg">메세지</div>
          <div class="button-wrapper d-none">
             <button class="accept-button">수락</button>
             <button class="reject-button">거절</button>
          </div>
       </section>
		<section class="content-container">
			<h1 class="d-none">상품 디테일</h1>

			<div class="path">
				<ol>
					<li><a href="/index"> </a></li>
					<li><a href="/product/list">${itemOfDetail.subCategory}</a></li>
					<li><a href="/product/details">${ itemOfDetail.category}</a></li>
				</ol>
			</div>
 
			<section class="detail-info-container">
				<h1 class="d-none">상품 이미지, 정보</h1>
				<section class="product-image">

					<h1 class="d-none">상품이미지</h1>
					<img style="height: 100%;"src="/images/items/${itemOfDetail.image}">

				</section>

				<section class="product-explain">

					<h1 class="d-none">상품 설명</h1>

					<dl>
						<dt class="product-dt" data-id="${itemOfDetail.id}">${itemOfDetail.name}</dt>
						<dd class="product-dd">${itemOfDetail.detail}</dd>
					</dl>

					<ul>
						<li>원산지<span>${itemOfDetail.subOrigin} &#183; ${itemOfDetail.origin}</span></li>
						<li>판매가<span class="price font-color-green">\ ${itemOfDetail.price}</span></li>
						<li>배송비<span>${itemOfDetail.deliveryFee}</span></li>
					</ul>



					<form action="" method="post" class="detail-form">
						<table class="current-product">
							<caption class="d-none">추가된 상품</caption>
							<col width="">
							<col width="100">
							<col width="150">

							<thead>
								<th>상품명</th>
								<th>상품수</th>
								<th>가격</th>
							</thead>
							
							<tbody>
								<tr>
									<td style="text-align: center;">${itemOfDetail.name}</td>
																		
									<td>
									<input class="product-count" type="number" name="count" value="1" min="1">
										<button disabled>수량취소</button>
									</td>
									
									<td class="font-color-green">${itemOfDetail.price}</td>
								</tr>
							</tbody>
						</table>

						<span class="total-price">
						 <b>총 상품금액(수량)</b> 
						 <b class="font-color-green">1(개)</b> 
						</span>

						<div class="submits">
							<input type="submit" value="바로구매" class="order-button"> 
							<input type="submit" value="장바구니" class="basket-button"> 
							<input type="submit" value="관심상품" class="att-button">
						</div>

					</form>

				</section>
			</section>

			<section class="detail-container">
				<h1 class="d-none">상품 상세페이지</h1>

				<ul class="detail-list">
					<li class="clicked">상세정보</li>
					<li>이용후기</li>
					<li>Q &amp; A</li>
					<li>반품/교환정보</li>
				</ul>

				<!-- 판매자 이미지 노출 부분 -->
				<section class="detail-image">
					<h1 class="d-none">상품 상세 이미지</h1>
					<img src="/images/detail-image.jpg" alt="상세이미지">
				</section>



				<section class="detail-reaview">
					<h1 class="section-title">상품후기</h1>
					<div class="write-button">
					    	<button>글쓰기</button>
					</div>
					<table class="board-table">
						<thead>
							<tr>
								<th class="num-col">번호</th>
								<th>제목</th>
								<th class="reg-col">평점</th>
								<th class="reg-col">작성자</th>
								<th class="reg-col">작성일</th>
								<th class="num-col">조회수</th>
							</tr>
						</thead>

						<tbody class="review-tbody">
							<c:forEach var="reviews" items="${reivewNotice}">
								<tr class="review">
									<td class="notice-id">${reviews.id}</td>
									<td>${reviews.title}</td>	
									
									<c:choose>
										<c:when test="${reviews.rate eq 5 }"><td>★★★★★</td></c:when>
										<c:when test="${reviews.rate eq 4 }"><td>★★★★☆</td></c:when>
										<c:when test="${reviews.rate eq 3 }"><td>★★★☆☆</td></c:when>
										<c:when test="${reviews.rate eq 2 }"><td>★★☆☆☆</td></c:when>
										<c:when test="${reviews.rate eq 1 }"><td>★☆☆☆☆</td></c:when>
									</c:choose>
									
									<td>${reviews.uid}</td>
									<fmt:formatDate var="reviewRegDate" value="${reviews.regDate}" pattern="yyyy-MM-dd"/>
									<td>${reviewRegDate}</td>
									<td>${reviews.hit}</td>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>

					<button class="review-button more-button" data-id="${itemId}">더보기</button>
				</section>

				<section class="detail-reaview">
					<h1 class="section-title">Q &amp; A</h1>
					
					<div class="write-button">
						<button>글쓰기</button>
					</div>
					
					<table class="board-table">

						<thead>
							<tr>
								<th class="num-col">번호</th>
								<th>제목</th>
								<th class="reg-col">작성자</th>
								<th class="reg-col">작성일</th>
								<th class="num-col">조회수</th>
							</tr>
						</thead>

						<tbody class="QnA-tbody">
						
						<c:forEach var="QnANotice" items="${QnANotice}">
							<tr class="qna">
								<td class="notice-id">${QnANotice.id}</td>
								<td>${QnANotice.title}</td>
								<td>${QnANotice.uid}</td>
								<fmt:formatDate var="QnARegDate" value="${QnANotice.regDate}" pattern="yyyy-MM-dd"/>
								<td>${QnARegDate}</td>
								<td>${QnANotice.hit}</td>
							</tr>
							
						</c:forEach>
							
						</tbody>
						
					</table>
					
					<button class="QnA-button more-button" data-id="${itemId}">더보기</button>
					
				</section>

			</section>
		</section>
	</main>
<script src="/js/item/detail.js"></script>
<script src="/js/item/detail2.js"></script>
