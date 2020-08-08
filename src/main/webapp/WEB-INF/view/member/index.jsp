<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/member/index.js"></script>
    <main class="main">
        <section class="content-container mypage-main-section">
            <h1 class="d-none">마이페이지</h1>
            <aside class="mypage-aside">
                <h1 class="d-none">aside</h1>
                <section class="profile-container">
                    <h1 class="d-none">프로필</h1>
                    <span class="profile-name">${m.name} 님</span><br>
                    <span class="profile-id">${m.uid}</span><br>
                    <button class="info-update-button" onClick="location.href='edit'">정보 변경</button>
                </section>
                <section class="menu-container">
                    <h1 class="d-none">메뉴</h1>
                    <section>
                        <h1 class="menu-h">관심</h1>
                        <ul>
                            <li><a href="#fav-item">관심 상품</a></li>
                            <li><a href="#lately">최근 본 상품</a></li>
                        </ul>
                    </section>
                    <section>
                        <h1 class="menu-h">주문 · 배송</h1>
                        <ul>
                            <li><a href="orderitem/list">주문/배송 조회</a></li>
                            <li><a href="basket/list">장바구니</a></li>
                        </ul>


                    </section>
                </section>
            </aside>
            <section class="mypage-body">
                <h1 class="d-none">myPage-body</h1>
                <section >
                    <h1 class="d-none">쇼핑메뉴</h1>
                    <div class="shopping-menu-container">
                        <div class="member-info-container">
                            <div class="member-grade-img">P</div><span class="member-info">개인 회원 <b>${m.name }</b> 님</span>
                        </div>
                        <div class="shopping-menu">
                            <div>
                                <div>${ocount }</div>
                                <span>주문/배송</span>
                            </div>
                            <div>
                                <div>${bcount }</div>
                                <span>장바구니</span>
                            </div>
                        </div>
                    </div>
                </section>
                <section class="att-container">
                    <h1 class="d-none">관심목록</h1>
                    <section>
                        <header>
                            <h1 id="fav-item" class="menu-h">관심상품</h1>
                            <a href="" class="all-view-font fav-item">전체보기</a>
                        </header>
                        <div class="att-list fav-item-list">
                        	<c:if test="${filist eq null}">
                            <div class="list-none-msg">관심 상품이 없습니다.</div>
                           </c:if>
                            <c:forEach var="n" items="${filist}" begin="0" end="3">	
                            	<a class="fav-item" href="/product/details/${n.itemId}">
                            		<div class="att-item">
                            			<img src="/upload/${n.itemImgName }">
                            			<div class="att-item-des">[은팜독점] ${ n.itemName}</div>
                            		</div>
                            	</a>
                            </c:forEach>
                        </div>
                    </section>
                    <section>
                        <header>
                            <h1 id="lately" class="menu-h">최근 본 상품</h1>
                        </header>
                        <div class="att-list asdffd">
                        	<c:if test="${recentItems eq null}">
                            <div class="list-none-msg">관심 상품이 없습니다.</div>
                           </c:if>
                            <c:forEach var="n" items="${recentItems}" begin="0" end="3">	
                            	<a class="recent-item" href="/product/details/${n.id}">
                            		<div class="att-item">
                            			<img src="/upload/${n.image }">
                            			<div class="att-item-des">[은팜독점] ${ n.name}</div>
                            		</div>
                            	</a>
                            </c:forEach>
                        </div>
                    </section>
                    <section>
                        <header>
                            <h1 class="menu-h">관심 Farm</h1>
                            <a href="" class="all-view-font fav-seller">전체보기</a>
                        </header>
                        <div class="att-list fav-seller-list">
                            <c:if test="${fslist eq null}">
                            <div class="list-none-msg">관심 상품이 없습니다.</div>
                           </c:if>
                           <!-- 나중에 판매자가 고객에게 보여줄 페이지가 있으면 아래의 a태그 수정 -->
                            <c:forEach var="n" items="${fslist}" begin="0" end="3">	
                            	<a class="fav-seller" href="">
                            		<div class="att-item">
                            			<img src="/upload/${n.titleImage }">
                            			<div class="att-item-des">${ n.comName}</div>
                            		</div>
                            	</a>
                            </c:forEach>
                        </div>
                    </section>
                </section>
            </section>
        </section>
    </main>