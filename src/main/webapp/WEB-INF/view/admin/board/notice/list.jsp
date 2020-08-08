<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<main class="admin-main">
        <section class="admin-sub-main">
            <h1 class="page-title">공지사항</h1>

            <span class="board-search">
                <form name="search">
                    <fieldset>
						<legend class="d-none">공지사항 검색 필드</legend>
						<label class="d-none">검색분류</label>
                        <select name="f">
                            <option value="title">제목</option>
                            <option value="content">내용</option>
                        </select>
                        <label class="d-none">검색어</label>
                        <input type="search" name="q" value="" placeholder="검색어를 입력하세요.">
                        <input type="submit" value="검색">
                    </fieldset>
                </form>
            </span>

            <table class="board-table">
                <thead>
                    <tr>
                    	<th class="num-col">번호</th>
                        <th>제목</th>
                        <th class="reg-col">작성자</th>
                        <th class="reg-col">작성일</th>
                        <th class="num-col">조회수</th>
                        <th class="date-col checkbox-col">
                        	공개유무
                        </th>
                        <th class="num-col">
                        	<input type="checkbox" class="all-check">
                        </th>
                    </tr>
                </thead>

                <tbody>
	                <c:forEach var="list" items="${list}" varStatus="st">
	                    <tr>
	                        <td>${st.count}</td>
	                        <td>
	                            <a href="${list.id}">
	                            	${list.title}
	                            </a>
	                        </td>
	                        <td>관리자</td>
	                        <td>
	                        	<fmt:formatDate pattern="yyyy-MM-dd" value="${list.regDate}" />
	                        </td>
	                        <td>${list.hit}</td>
	                        <td>		                        
		                        <c:choose>
									<c:when test="${list.pub eq 'true'}">
										공개
									</c:when>
									<c:otherwise>
										비공개
									</c:otherwise>
								</c:choose>
	                        </td>
	                        <td>
	                        	<input type="checkbox" value="${list.id}">
	                        </td>
	                    </tr>
	                </c:forEach>
                </tbody>
            </table>
            
            <div class="write-button list-button">
            	<input type="submit" name="" value="일괄공개" class="all-show">
            	<input type="submit" name="" value="일괄삭제" class="all-del">
            	<a href="reg">
                	<button>글쓰기</button>
                </a>
            </div>

            <div class="pager">	
                <span class="btn btn-prev">이전</span>
                <ul class="page-list">
                    <c:forEach begin="1" end="5" var="p">
                           <li><a href="" class="page-button">${p}</a></li>
               		</c:forEach>
                </ul>
                <span class="btn btn-next">다음</span>
            </div>
        </section>
	</main>
    
    <script src="/js/admin/board/notice/list.js"></script>