<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <main class="admin-main">
	        <section class="admin-sub-main">
	            <h1 class="page-title">Q &amp; A</h1>
	
	            <span class="board-search">
	                <form name="search" class="search-form">
	                    <fieldset>
							<legend class="d-none">Q &amp; A 검색 필드</legend>
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
	                        <th class="num-col">
	                        	<input type="checkbox" class="all-check">
	                        </th>
	                    </tr>
	                </thead>
	
	                <tbody>
	                    <c:forEach var="list" items="${list}" varStatus="st">
		                    <tr>
		                        <td>${st.count}</td>
		                        <td class="qna-table-title">
		                            <a href="${list.id}">
		                            	<c:choose>
											<c:when test="${list.regDateA eq null}">
												${list.title}
											</c:when>
											<c:otherwise>
												${list.title} <span>답변완료</span>
											</c:otherwise>
										</c:choose>
		                            </a>
		                        </td>
		                        <td>${list.name}</td>
		                        <td>
		                        	<fmt:formatDate pattern="yyyy-MM-dd" value="${list.regDate}" />
		                        </td>
		                        <td>
		                        	<input type="checkbox" value="${list.id}">
		                        </td>
		                    </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
	
	            <div class="write-button list-button">
	            	<input type="submit" name="" value="일괄삭제" class="all-del">
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
        
        <script src="/js/admin/board/qna/list.js"></script>