<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <script src="/js/seller/review.js"></script>
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
	                <h1 class="page-title">상품후기</h1>
	                <div class="option-header">
	                    <span class="seller-list"> 
	                        <div>
	                            <h1>...님이 판매 중 이신 아이템</h1>
	                        </div>  
	                        <form name="seller-item" method="POST" action="">
	                            <select name="seller-items-list">
	                                <option>쌀</option>
	                                <option>상품을 등록해 주세요</option>
	                                <option>상품을 등록해 주세요</option>
	                            </select>
	                        </form>
	                    </span>
	
	                    <span class="board-search">
	                        <form name="search" method="POST" action="">
	                            <fieldset>
	                                <select name="search-option">
	                                    <option>제목</option>
	                                    <option>내용</option>
	                                    <option>제목+내용</option>
	                                </select>
	                                <input type="search" placeholder="검색어를 입력하세요.">
	                                <input type="submit" value="검색">
	                            </fieldset>
	                        </form>
	                    </span>
	                </div>
	                <table class="board-table review-table">
	                    <col width="50">
	                    <col width="200">
	                    <col width="">
	                    <col width="120">
	                    <col width="120">
	                    <col width="80">
	    
	                    <thead>
	                        <tr>
	                            <th class="num-col">번호</th>
	                            <th class="reg-col">상품정보</th>
	                            <th>제목</th>
	                            <th class="reg-col">평점</th>
	                            <th class="reg-col">작성자</th>
	                            <th class="reg-col">작성일</th>
	                            <th class="num-col">조회수</th>
	                        </tr>
	                    </thead>
	    
	                    <tbody>
	                    <c:forEach var="r" items="${review}" varStatus="st">
	                        <tr>
	                            <td>${st.count}</td>
	                            <td>
	                            	<img src="/images/items/${r.image }">
	                            </td>
	                            <td class="review-title">
	                                <a>${r.title}</a>
	                            </td>
	                            <td>${r.rate}</td>
	                            <td>${r.name}</td>
	                            <td>${r.regDate}</td>
	                            <td>${r.hit}</td>
	                        </tr>
	
	                        <tr class="detail-container d-none">
	                            <td colspan="7">
	                                <div class="title">
	                                    <span>${r.title}</span>
	                                    <span>
	                                        <fmt:formatDate pattern="yyyy-MM-dd" value="${r.regDate}" />
	                                    </span>
	                                </div>
	                                <div class="content">
	                                    ${r.content}
	                                </div> 
	                                
	                                <div class="admin-button">
							            <a href="edit">상품페이지로 이동</a>
						            	<input class="review-reply" type="submit" value="답변">
						            	<input type="submit" value="삭제">
						            	<a href="list">목록</a>
						            </div>  
	                            </td>
	                        </tr>
	                        <tr class="reply-container d-none">
	                            <td colspan="7">
	                                <div class="title">
	                                    <span>
	                                        <fmt:formatDate pattern="yyyy-MM-dd" value="${r.regDate}" />
	                                    </span>
	                                </div>
	                               					            
						            <form name="답글등록" method="POST" action="reg">
	                                    <div class="content reply">
	                                        <textarea rows="" cols="" style="width:600px;height:300px" name="reply">
	                                        
	                                        </textarea>
	                                    </div> 
	                                    <div class="admin-button">
	                                        <a href="">상품페이지로 이동</a>
	                                        <input class="review-apply" type="submit" value="등록">
	                                        <input type="button" value="취소">
	                                        <a href="list">목록</a>
	                                    </div>
						            </form>
						            
	                            </td>
	                        </tr>
	                       </c:forEach>
	                        
	                    </tbody>
	                </table>
	
	                <div class="pager">	
	                    <span class="btn btn-prev">이전</span>
	                    <ul class="page-list">
	                        <li><a href="" class="checked">1</a></li>
	                        <li><a href="">2</a></li>
	                    </ul>
	                    <span class="btn btn-next">다음</span>
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