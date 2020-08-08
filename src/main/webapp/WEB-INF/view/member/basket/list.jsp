<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="../../js/member/basket.js"></script>
    <main class="main">

        <section class="content-container">
            <div class="path">
                <ol>
                    <li>
                        <a href="/index.html"></a>
                    </li>
                    <li>
                        <a href="/user/cart.html">장바구니</a>
                    </li>
                </ol>
            </div>

            <h1 class="page-title">장바구니</h1>
            
			<c:if test="${bl.size() == 0 }">
				<div class="no-text">장바구니에 상품이 없습니다.</div>
			</c:if>
			<c:if test="${bl.size() >= 1 }">
	            <section class="cart-section">
	                <h1 class="d-none">장바구니 목록</h1>
	                <table class="cart-table">
	                    <caption class="d-none">장바구니 내역</caption>
	
	                    <thead>
	                        <tr>
	                            <th class="num-col">
	                                <span>
	                                    <input type="checkbox" id="check_all" class="all-check-button" checked>
	                                    <label class="d-none">전체 상품 선택</label>
	                                </span>
	                            </th>
	                            <th>상품정보</th>
	                            <th class="price-col">상품금액</th>
	                            <th class="price-col">수량</th>
	                            <th class="price-col">총 금액</th>
	                            <th class="price-col">배송비</th>
	                        </tr>
	                    </thead>
	
	                    <tbody>
	                    
	                    
	                    <!-- 반복시작 -->
	                        <c:forEach var="b" items="${bl}">
		                        <tr>
		                            <td>
		                                <input type="checkbox" checked value="${b.id}"/>
		                                <label class="d-none">상품 선택</label>
		                            </td>
		                            <td class="cart-table-bold">
		                                <img src="/upload/${b.image }" alt="상품 이미지">
		                                <span>
		                                	${b.itemName }
		                                </span>
		                            </td>
									<td>${b.price }원</td>
									
		                            <td>
		                            	<input type="number" min="1" max="99" value="${b.qty }" class="qty"/>
                   	                    <button type="button" class="update-button" value=${b.id }>변경</button>
		                            </td>
		
		                            <td class="cart-table-bold item-price">${b.price*b.qty }원</td>
		
		                            <td class="cart-table-bold fee-price">${b.deliveryFee }원</td>
		                        </tr>
	                        </c:forEach>
	                        <!-- 반복 부분 마지막 -->
	
	                    </tbody>
	
	                </table>
	
	                <div class="product-button-wrap">
	                    <button type="button" class="del-button">선택상품 삭제</button>
	                </div>
	            </section>
			</c:if>

            <section class="order-price">
                <h1 class="d-none">상품 총액</h1>
                <div class="price-list">
                    <dl>
                        <dt>총 상품금액</dt>
                        <dd><span class="item-total-price">${totalPrice}원</span></dd>
                    </dl>
                    <dl>
                        <dt>배송비</dt>
                        <dd><span class="fee-total-price">${totalDf }원</span></dd>
                    </dl>
                    
                </div>
                <div class="total-price">
                    	총 주문금액 <span>${totalPrice + totalDf }원</span>
                </div>
            </section>

            <div class="order-button-wrap">
                <button type="button" class="home">쇼핑 홈 가기</button>
                <button type="button" class="order">선택 주문</button>
            </div>
        </section>
    </main>