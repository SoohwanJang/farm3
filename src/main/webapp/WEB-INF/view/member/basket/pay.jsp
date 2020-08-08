<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <script src="/js/member/pay.js"></script>
    <main class="main">
        <section class="content-container">
            <div class="path">
                <ol>
                    <li>
                        <a href="/index.html"></a>
                    </li>
                    <li>
                        <a href="/user/order.html">장바구니</a>
                    </li>
                    <li>
                        주문/결제
                    </li>
                </ol>
            </div>

            <h1 class="page-title">주문/결제</h1>
            
            <section>
                <h1 class="d-none">상품 정보</h1>
                <table class="order-item-table">
                    <thead>
                        <th class="expand-col">상품정보</th>
                        <th>판매자</th>
                        <th>배송기간/배송비</th>
                        <th>수량</th>
                        <th>주문금액</th>
                    </thead>
                    <tbody>
                   		<c:forEach var="p" items="${pl }">
	                        <tr>
	                            <td>
	                                <img src="/upload/${p.image }"/>
	                                <span data-value="${p.id }">${p.itemName }</span>
	                            </td>
	                            <td>${p.sellerComName }(${p.sellerName })</td>
	                            <td>
	                            	<div class="delivery-date">
		                            	<span class="delivery-icon"></span>
		                                <span >${p.leadTime }일</span><br>
	                            	</div>
	                                <span><fmt:formatNumber pattern="#,###" value="${p.deliveryFee }"/>원</span>
	                            </td>
	                            <td>${p.qty }개</td>
	                            <td class="cart-table-bold"><fmt:formatNumber pattern="#,###" value="${p.price* p.qty}"/>원</td>
	                        </tr>
                   		</c:forEach>
                      
                        
                       
                    </tbody>
                </table>

            </section>
            <section class="delivery-info-container">
                <h1 class="d-none">배송 정보</h1>
                <section class="address-info-container">
                    <h1>배송지 정보</h1>

                    <span>배송지 선택</span>
                    <input type="radio" name="address" checked="checked" value="old"> <span>기존 배송지</span>
                    <input type="radio" name="address" value="new"> <span>신규 배송지</span>
                    <div class="address-info-wrapper">
                        <span class="orderer-name">${m.ordererName }</span>
                        <span class="orderer-address">${m.ordererAddress }</span>
                        <input class="orderer-address-input d-none" placeholder="주소직접입력"/>
                        <input type="text" placeholder="택배요청사항을 입력합니다" maxlength="50" class="delivery-memo">
                    </div>
                </section>
                <section class="orderer-info-container">
                    <h1>주문자 정보</h1>
                    <div class="orderer-info-wrapper">
                        <span>${m.ordererName }</span>
                        <span>${m.ordererMobile }</span>
                        <span>${m.ordererEmail }</span>
                    </div>
                    <span class="order-warn-text">
			                        주문자 정보로 결제관련 정보가 제공됩니다.<br>
			                        정확한 정보로 등록되어있는지 확인해주세요.
                    </span>
                </section>
            </section> 
            
            <section class="pay-info-container">
                <h1 class="d-none">결제 정보</h1>

                <section class="method-container">
                    <h1>결제 수단</h1>
                    <div>
                        <input type="radio" name="method" value="card">
                        <span>카드 결제</span>
                        <input type="radio" name="method" value="transfer">
                        <span>무통장 입금</span>
                    </div>
                </section>

                <section class="price-container">
                    <h1>결제 금액</h1>
                    <div class="price-statis">
                        <div><span class="statis-price"><fmt:formatNumber pattern="#,###" value="${tp+tf }" /></span> 원</div>
                        <div><span>총 상품금액</span><span><fmt:formatNumber pattern="#,###" value="${tp }" />원</span></div>
                        <div><span>배송비</span><span>(+) <fmt:formatNumber pattern="#,###" value="${tf }" />원</span></div>
                    </div>
                </section>

            </section>
            
            <section class="term-container">
                <h1 class="d-none">약관 동의</h1>
                <input class="d-none" type="checkbox" id="agree-check"><label for="agree-check"></label>
                <span>위 상품의 구매조건 확인 및 결제진행 동의</span>
            </section>

            <section class="pay-button-container">
                <h1 class="d-none">주문/결제 버튼</h1>
                <button class="pay-button" data-rows="${idList }">주문하기</button>
            </section>

        </section>
    </main>
