<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>은풍한 팜 관리자페이지</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/index.js"></script>
    <script src="/js/seller/seller.js"></script>
</head>
<body>
    <header class="admin-header">
        <h1>
            판매자페이지
            <span>판매자님 반갑습니다.</span>
        </h1>
        <ul>
            <li>
                <a href="/index">메인 홈</a>
            </li>
            <li>
                <a href="/seller/index">관리자홈</a>
            </li>
            <li>로그아웃</li>
        </ul>
    </header>
   <div class="admin-body">
        <aside class="aside">
            <h1 class="d-none">관리자페이지 메뉴</h1>
            <ul class="admin-menu">
                <li>
                    <h2 class="admin-menu-title">
                        상품관리
                    </h2>
                    <ul class="admin-draw-menu">
                        <li><a href="/seller/item/reg">상품등록</a></li>
                        <li><a href="/seller/item/list">상품목록</a></li>
                        <li><a href="/seller/item/qna/list">상품문의</a></li>
                        <li><a href="/seller/item/review/list">상품후기</a></li>
                    </ul>
                </li>
                <li>
                    <h2 class="admin-menu-title">매매관리</h2>
                    <ul class="admin-draw-menu">
                        <li><a href="/seller/selling/list">주문현황</a></li>
                    </ul>
                </li>
            </ul>
         </aside>

        <main class="admin-main">
	        <section class="admin-sub-main">
	            <section>
	                <h1 class="page-title">주문현황</h1>
	                <form method="POST" action="list">
	                    <fieldset>
		        	        <div>
								<select name="st">
					    			<option value=""		${st eq '전체' ? 'selected' : '' }	>전체</option>
					    			<option value="입금대기"	${st eq '입금대기' ? 'selected' : '' }	>입금대기</option>
					    			<option value="입금확인"	${st eq '입금확인' ? 'selected' : '' }	>입금확인</option>
					    			<option value="배송중"	${st eq '배송중' ? 'selected' : '' }	>배송중</option>
					    			<option value="배송완료"	${st eq '배송완료' ? 'selected' : '' }	>배송완료</option>
					    			<option value="주문취소"	${st eq '주문취소' ? 'selected' : '' }	>주문취소</option>
					    		</select>	        	        
		        	        </div>
	                        <div class="board-search">
	                            <select name="f">
	                                <option value="iName">상품명</option>
	                                <option value="iRegName">등록상품명</option>
	                            </select>
	                            <input type="search" name="q" placeholder="검색어를 입력하세요.">
	                            <input type="hidden" name="p" value="${p}">
	                            <input type="submit" value="검색" />
	                        </div>
	                    </fieldset>
	                </form>
	
	                <c:choose>
	                <c:when test="${empty oiList}">
	                    <h1>들어온 주문이 없습니다!!</h1>
	                </c:when>
	                <c:otherwise>
	                    <table class="board-table">
	                        <tbody>
	                            <thead>
	                                <tr>
	                                    <th class="num-col">번호</th>
	                                    <th class="reg-col">상태</th>
	                                    <th class="reg-col">주문자(이름)</th>
	                                    <th class="reg-col">상품명</th>
	                                    <th class="reg-col">등록상품명</th>
	                                    <th class="reg-col">가격</th>
	                                    <th class="reg-col">개수</th>
	                                    <th class="reg-col">총가격</th>
	                                    <th class="reg-col">주문일</th>
	                                    <th class="reg-col">주문관리</th>
	                                </tr>
	                            </thead>
	                            <c:forEach var="ol" items="${oiList }" varStatus="status">
	                                <tr>
	                                    <td>${status.count}</td>
	                                    <td>${ol.status}</td>
	                                    <td>${ol.mUid}(${ol.mName})</td>
	                                    <td>${ol.iName}</td>
	                                    <td>${ol.iRegName}</td>
	                                    <td>${ol.iPrice}</td>
	                                    <td>${ol.qty}</td>
	                                    <td>${ol.qty*ol.iPrice}</td>
	                                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ol.oRegDate}" /></td>
	                                    <td class="admin-button"><a href="/seller/selling/${ol.id}">주문관리</a></td>
	                                </tr>
	                            </c:forEach>
	                        </tbody>
	                    </table>
	                </c:otherwise>
	                </c:choose>
	                <div class="pager">	
	                    <span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
	                    <ul class="page-list">
	                        <li><a href="?p=1&st=${st}&f=${f}&q=${q}">1</a></li>
	                        <li><a href="?p=2&st=${st}&f=${f}&q=${q}">2</a></li>
	                        <li><a href="?p=3&st=${st}&f=${f}&q=${q}">3</a></li>
	                        <li><a href="?p=4&st=${st}&f=${f}&q=${q}">4</a></li>
	                        <li><a href="?p=5&st=${st}&f=${f}&q=${q}">5</a></li>
	                    </ul>
	                    <span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
	                </div>
	            </section>
	        </section>
        </main>
    </div>
    <footer class="footer">
        <button class="up-button"> </button>
    </footer>
</body>
</html>