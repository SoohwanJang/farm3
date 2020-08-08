<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>

    <header class="header">
        <h1 class="d-none">은풍한 Farm</h1>
        <section>
            <h1 class="d-none">헤더</h1>
            <section class="top-header">
                <h1 class="d-none">상단헤더</h1>
                <div class="inner-header">
                    <nav class="member-menu">
                        <h1 class="d-none">멤버메뉴</h1>
                        
                        <ul>
	                        <s:authorize access="isAnonymous()">
	                            <li>
	                                <a href="/member/login">로그인</a>                                
	                            </li>
							</s:authorize>
							<s:authorize access="isAuthenticated()">
                            	<li>
                            		<a href="/member/logout">로그아웃</a>
                            	</li>
                            </s:authorize>
                            <s:authorize access="isAnonymous()">
	                            <li>
	                                <a href="/member/signup">회원가입</a>
	                            </li>
                            </s:authorize>
                            <s:authorize access="hasAnyRole('SELLER', 'ADMIN', 'MEMBER')">
	                        	<li>
	                        		<a href="/member/index">마이페이지</a>
	                        	</li>                        	
                        	</s:authorize>
                        	<s:authorize access="hasRole('SELLER')">
	                        	<li>
	                        		<a href="/seller/index">판매자 페이지</a>
	                        	</li>                        	
                        	</s:authorize>
                        	<s:authorize access="hasRole('ADMIN')">
	                        	<li>
	                        		<a href="/admin/index">관리자 페이지</a>
	                        	</li>                        	
                        	</s:authorize>
                        </ul>
                    </nav>
                    <nav class="order-menu">
                        <h1 class="d-none">상품메뉴</h1>
                        <ul>
                            <li>
                            	<a href="/member/index">관심상품</a>
                            </li>
                            <li>
                                <a href="/member/basket/list">장바구니</a>
                            </li>
                            <li>
                                <a href="/member/orderitem/list">주문조회</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </section>
            <section class="bottom-header">
                <div class="inner-header">
                    <h1 class="logo">
                        <a href="/index">
                            <img src="/images/logo.png" alt="로고">
                        </a>
                    </h1>
                    <span class="search-form">
                        <form name="search" action="/product/list">
                            <fieldset name="f">
                                <input type="search" name="q" value="" placeholder="상품 이름을 입력하세요.">
								<input type="submit" value="검색">
                            </fieldset>
                        </form>
                    </span>
                </div>
            </section>
            <nav class="main-menu">
                <h1 class="d-none">메뉴</h1>
                <ul>
                    <li class="whole-menu">전체메뉴</li>
                    <li>
                        <a href="/product/list">상품</a>
                    </li>
                    <li>
                        <a href="/community/index">커뮤니티</a>
                    </li>
                    <li>
                        <a href="/farmIntro/index">은풍한 팜</a>
                    </li>
                </ul>
            </nav>
            <section class="draw-menu">
                <h1 class="d-none">전체메뉴</h1>
                <div class="inner-draw">
                    <div class="draw-list draw-main-menu">
                        <div>
                            <ul>
                                <li class="catg" data-rno="1">
                                	<a href="/product/category?q=곡물">곡물</a>
                                </li>
                                <li class="catg" data-rno="7">
                                	<a href="/product/list?q=쌀">쌀</a>
                                </li>
                                <li class="catg" data-rno="8">
                                	<a href="/product/list?q=잡곡">잡곡</a>
                                </li>
                            </ul>
                            <ul>
                                <li class="catg" data-rno="3">
                                	<a href="/product/category?q=채소">채소</a>
                                </li>
                                <li class="catg" data-rno="10">
                                	<a href="/product/list?q=배추">배추</a>
                                </li>
                                <li class="catg" data-rno="11">
                                	<a href="/product/list?q=무">무</a>
                                </li>
                                <li class="catg" data-rno="12">
                                	<a href="/product/list?q=감자">감자</a>
                                </li>
                            </ul>
                            <ul>
                                <li class="catg" data-rno="4">
                                	<a href="/product/category?q=음료">음료</a>
                                </li>
                                <li class="catg" data-rno="16">
                                	<a href="/product/list?q=당근주스">당근주스</a>
                                </li>
                                <li class="catg" data-rno="15">
                                	<a href="/product/list?q=케일주스">케일주스</a>
                                </li>
                                <li class="catg" data-rno="17">
                                	<a href="/product/list?q=포도즙">포도즙</a>
                                </li>
                            </ul>
                        </div>
                        <div>
                            <ul>
                                <li class="catg" data-rno="2">
                                	<a href="/product/category?q=과일">과일</a>
                                </li>
                                <li class="catg" data-rno="9">
                                	<a href="/product/list?q=사과">사과</a>
                                </li>
                                <li class="catg" data-rno="13">
                                	<a href="/product/list?q=딸기">딸기</a>
                                </li>
                            </ul>
                            <ul>
                                <li class="catg" data-rno="5">
                                	<a href="/product/category?q=기타">기타</a>
                                </li>
                                <li class="catg" data-rno="19">
                                	<a href="/product/list?q=아이스크림">아이스크림</a>
                                </li>
                                <li class="catg" data-rno="14">
                                	<a href="/product/list?q=꿀">꿀</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="draw-list draw-sub-menu">
                        <ul>
                            <li>은풍한 팜</li>
                            <li>
                                <a href="/farmIntro/index">은풍한 팜 소개</a>
                            </li>
                            <li>
                                <a href="/community/notice/list">공지사항</a>
                            </li>
                            <li>
                                <a href="/community/apply/list">입점신청</a>
                            </li>
                            <li>
                                <a href="/community/qna/list">Q &amp; A</a>
                            </li>
                            <li>
                                <a href="/community/review/list">상품후기</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </section>
        </section>
    </header>