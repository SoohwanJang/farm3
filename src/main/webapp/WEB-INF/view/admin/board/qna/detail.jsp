<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<main class="admin-main">
	<section class="admin-sub-main">
		<h1 class="page-title">QnA</h1>

		<section class="detail-container">
	     	<h1 class="d-none">QnA 디테일</h1>
     	
			<div class="title">${q.title}</div>
			<div class="reg-info">
				<span>
					글쓴이: ${q.name}
				</span>
				<ul>
					<li>작성일: <fmt:formatDate pattern="yyyy-MM-dd" value="${q.regDate}" /></li>
				</ul>
			</div>
			<div class="content">
				${q.content}
			</div>
			<div class="comment-section">
			
				<c:choose>
					<c:when test="${q.regDateA eq null}">
						<span class="d-none">${q.id}</span>
						<textarea class="comment"></textarea>
						<input type="submit" value="등록">
					</c:when>
					<c:otherwise>						
			            <span>
							<b>관리자</b> (작성일: <fmt:formatDate pattern="yyyy-MM-dd" value="${q.regDateA}" />)
						</span>
						<span>
							${q.contentA }
						</span>
					</c:otherwise>
				</c:choose>
			</div>
		</section>

		<div class="admin-button">
			<a href="del?id=${r.id}">
				<input type="submit" value="삭제">
			</a>
			<a href="list">목록</a>
		</div>
	</section>
</main>

<script src="/js/admin/board/qna/detail.js"></script>
