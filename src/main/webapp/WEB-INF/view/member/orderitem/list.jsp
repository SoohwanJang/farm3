<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="../../../js/member/order.js"></script>
    <main class="main">

        <section class="content-container">
            <div class="path">
                <ol>
                    <li>
                        <a href="/member/index"></a>
                    </li>
                    <li>
                        <a href="/member/orderitem/list">주문조회</a>
                    </li>
                </ol>
            </div>

            <h1 class="page-title">주문조회</h1>

            <section class="order-section">
                <h1 class="d-none">주문목록</h1>

                <div class="order-cur-box">

                    <c:forEach var="c" items="${colist}">
                    	<c:choose>
						    <c:when test="${c.element eq '배송중'}">
								<c:set var="count1" value="${c.count}" />
						    </c:when>
					     	<c:when test="${c.element eq '배송완료'}">
								<c:set var="count2" value="${c.count}" />
						    </c:when>
							<c:when test="${c.element eq '주문취소'}">
								<c:set var="count3" value="${c.count}" />
						    </c:when>
						    <c:otherwise>

						    </c:otherwise>
						</c:choose>
                    </c:forEach>
                    			<c:if test="${count1 eq null }">
										<c:set var="count1" value="0" />
								</c:if>
								<c:if test="${count2 eq null }">
										<c:set var="count2" value="0" />
								</c:if>
								<c:if test="${count3 eq null }">
										<c:set var="count3" value="0" />
								</c:if>
                    <dl>
                        <dt>${count1 }</dt>
                        <dd>배송중</dd>
                    </dl>
                    
                    <dl>
                        <dt>${count2 }</dt>
                        <dd>배송완료</dd>
                    </dl>
                    
                    <dl>
                        <dt>${count3 }</dt>
                        <dd>주문취소</dd>
                    </dl>          
                </div>

                <table class="order-table">
                    <caption class="d-none">장바구니 내역</caption>

                    <thead>
                        <tr>
                            <th class="num-col d-none">
                                <span>
                                    <input type="checkbox" id="check_all" checked>
                                    <label class="d-none">전체 상품 선택</label>
                                </span>
                            </th>
                            <th>상품정보</th>
                            <th class="reg-col">상품금액(수량)</th>
                            <th class="reg-col">진행상태</th>
                            <th class="reg-col"></th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="n" items="${oilist}">
                        <tr class="mis">
                            <td class="d-none">
                                <input type="checkbox"/>
                                <label class="d-none">상품 선택</label>
                            </td>
                            <td class="cart-table-bold">
                                <img src="/upload/${n.iImage }" alt="상품 이미지">
                                <span>
                                   ${n.iName }
                                </span>
                            </td>

                            <td>${n.iPrice }원(${n.qty }개)</td>

                            <td>${n.status }</td>

                            <td>
                            <c:set var="status" value="${n.status }" />

								<c:choose>
								    <c:when test="${status eq '입금대기'}">
								       <a href="/product/details/${n.itemId }" class="re-button">리뷰작성</a>
								       <a href="/product/details/${n.itemId }" class="re-button">상품 QnA</a>
								       <a href="cancle?id=${n.id }" class="re-button cancle">주문취소</a>
								    </c:when>
								     <c:when test="${status eq '입금확인'}">
								       <a href="/product/details/${n.itemId }" class="re-button">리뷰작성</a>
								       <a href="/product/details/${n.itemId }" class="re-button">상품 QnA</a>
								       <a href="cancle?id=${n.id }" class="re-button cancle">주문취소</a>
								    </c:when>
								     <c:when test="${status eq '배송중'}">
								       <a href="/product/details/${n.itemId }" class="re-button">리뷰작성</a>
								       <a href="/product/details/${n.itemId }" class="re-button">상품 QnA</a>
								       <a href="https://tracker.delivery/#/${n.dComId }/${n.waybillNum }" target="_blank" class="re-button">배송확인</a>
								    </c:when>
								     <c:when test="${status eq '배송완료'}">
								       <a href="/product/details/${n.itemId }" class="re-button">리뷰작성</a>
								       <a href="/product/details/${n.itemId }" class="re-button">상품 QnA</a>
								    </c:when>
								     <c:when test="${status eq '주문취소'}">
								       <a href="/product/details/${n.itemId }" class="re-button">상품 QnA</a>
								    </c:when>
								</c:choose>
                            </td>
                        </tr>
                        </c:forEach>

                    </tbody>
					
                </table>
                <div class="product-button-wrap d-none">
                    <button type="button" class="product-button">선택상품 취소</button>
                    <button type="button" class="product-button">선택상품 변경</button>
                </div>
            </section>

            <div class="order-button-wrap">
                <button type="button"  onClick="location.href='/index'">쇼핑 홈 가기</button>
                <button type="button"  onClick="location.href='/member/basket/list'">장바구니</button>
            </div>
        </section>
    </main>