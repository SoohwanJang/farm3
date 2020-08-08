<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <script src="/js/seller/list.js"></script>
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

        <!--list 관련 css -> admin.css 에 있음-->

        <main class="admin-main">
	        <section class="admin-sub-main">
	            <section>
	                <h1 class="d-none">상품 리스트</h1>
	                <nav class="product-category-menu">
	                    <h1 class="d-none">상품 카테고리 리스트</h1>
	                    <c:set var="q" value="전체상품" />
	                    <ul>
	                    <c:forEach var="c" items="${cl}" varStatus="st">
	                	   <c:set var="catg" value="${c.name}" />
	                	 	<c:if test="${catg ==q}">
	                	 	<c:set var="catg" value="" />
	                	  	</c:if>
	                        <li>
	                      	  <a href="?catg=${catg}&count=${c.count}">
	                      	   ${c.name} <span>${c.count }</span>
	                      	   </a>
	                        </li>
	                    </c:forEach>
	                    </ul>
	                </nav>
	                <section class="product-list">
	                    <h1 class="page-title">전체상품</h1>
	                    <span class="search-form">
	                        <form>
	                            <fieldset>
	                                <legend class="d-none">상품관리 검색 필드</legend>
	                                <label class="d-none">검색분류</label>
	                                <select name="f">
	                                    <option value="name">상품명</option>
		                                <option value="regName">등록명</option>
	                                    <!-- <option value="sellerId">아이디</option> -->
	                                </select>
	                                <label class="d-none">검색어</label>
	                                <input type="search" name="q" value="" />
	                                <input class="d-none" name="catg" value="${param.catg}" />
	                                <input type="submit" value="검색">
	                            </fieldset>
	                        </form>
	                    </span>
					<form action="pub" method="post">
	                    <table class="product-table seller">
	                        <colgroup>
	                            <col class="num-col">
	                            <col class="text-col">
	                            <col>
	                            <col class="expand-col">
	                        </colgroup>
	                        <thead>
	                            <tr>
	                                <th class="num-col">
	                                    <span>
	                                        <input class="all-check-button" type="checkbox" >
	                                        <label class="d-none">전체 상품 선택</label>
	                                    </span>
	                                </th>
	                                <th colspan="3">상품정보</th>
	                                <th></th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                        <c:forEach var="n" items="${list}" varStatus="st">
	                        	<fmt:formatDate var="regdate" value="${n.regDate}" pattern="yyyy-MM-dd"/>
								<fmt:formatDate var="startDate" value="${n.startDate }" pattern="yyyy-MM-dd"/>
								<fmt:formatDate var="endDate" value="${n.endDate}" pattern="yyyy-MM-dd"/>
									<c:set var="pub" value="비공개" />
									<c:if test="${n.pub==true}">
										<c:set var="pub" value="공개" />
									</c:if>
	                            <tr>
	                                <td>
	                                    <input type="checkbox" name=item-id value="${n.id}">
	                                </td>
	                                <td>
	                                    <img src="/upload/${n.image }">
	                                </td>
	                                <td>
	                                	<dl>
	                                        <dt>등록명</dt>
	                                        <dd>${n.regName }</dd>
	                                    </dl>
	                                    <dl>
	                                        <dt>상품명</dt>
	                                        <dd>${n.name }</dd>
	                                    </dl>
	                                    <dl>
	                                        <dt>판매가격</dt>
	                                        <dl>${n.price } 원</dl>
	                                    </dl>
	                                    <dl>
	                                        <dt>품목명</dt>
	                                        <dl>${n.firstcatg } > ${n.secondcatg }</dl>
	                                    </dl>
	                                    <dl>
	                                        <dt>판매기간</dt>
	                                        <dl>${startDate }~${endDate }</dl>
	                                    </dl>
	                                </td>
	                                <td>
	                                    <dl>
	                                        <dt>원산지</dt>
	                                        <dd>${n.firstorigin} > ${n.secondorigin}</dd>
	                                    </dl>
	                                    <dl>
	                                        <dt>재고량</dt>
	                                        <dl>${n.qty}(아직은 입고량)</dl>
	                                    </dl>
	                                    <dl>
	                                        <dt>판매량</dt>
	                                        <dl>0</dl>
	                                    </dl>
	                                    <dl>
	                                        <dt>등록일</dt>
	                                        <dl>${regdate}</dl>
	                                    </dl>
	                                     <dl>
	                                        <dt>공개여부</dt>
	                                        <dl>${pub}</dl>
	                                    </dl>
	                                </td>
	                                <!-- 0718추가 -->
	                                <td>
	                                    <nav>
	                                    <a class ="seller-pub" href = "pub?item-id=${n.id}"><div>공개전환</div></a>
	                                    <a href = "edit"><div>수정</div></a>
	                                    <a href = "del?item-id=${n.id}"><div>삭제</div></a>
	                                    </nav>
	                                </td>
	                                <!--  -->
	                            </tr>
	                            </c:forEach>
	                            
	                        </tbody>
	                    </table>
	
	                    	<div class="product-list-button">
	                        	<input type="submit" value="일괄전환" >
	                       		<input class="d-none" type="submit" value="일괄삭제" >
	                    	</div>
	                    </form>
	
	                    <div class="pager">	
	                        <span class="btn btn-prev">이전</span>
	                        <ul class="page-list">
	                        <c:forEach var ="i" begin="1" end="5" >
	                            <li><a href="?p=${i }&catg=${param.catg}" class="checked">${i }</a></li>
							</c:forEach>
	                        </ul>
	                        <span class="btn btn-next">다음</span>
	                    </div>
	
	                </section>
	
	            </section>
	        </section>   
        </main>
    </div>
    <footer class="footer">
        
        <button class="up-button"> </button>
    </footer>
</body>
</html>