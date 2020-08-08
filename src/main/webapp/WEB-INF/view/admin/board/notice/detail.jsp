<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/ckeditor5/sample/styles.css">
<main class="admin-main">
	<section class="admin-sub-main">
		<h1 class="page-title">공지사항</h1>

		<section class="detail-container">
	     	<h1 class="d-none">공지사항 디테일</h1>
     	
			<div class="title">${n.title}</div>
			<div class="reg-info">
				<span>
					글쓴이: 관리자
				</span>
				<ul>
					<li>작성일: <fmt:formatDate pattern="yyyy-MM-dd" value="${n.regDate}" /></li>
					<li>조회수: ${n.hit}</li>
					<li>
						공개유무: 
						<c:choose>
							<c:when test="${n.pub eq 'true'}">
								공개
							</c:when>
							<c:otherwise>
								비공개
							</c:otherwise>
						</c:choose>	
					</li>
				</ul>
			</div>
			<div class="content">
				${n.content}
			</div>
		</section>

		<div class="admin-button">
			<a href="edit?id=${n.id}" class="edit-button">수정</a>
			<a href="del?id=${n.id}">
				<input type="submit" value="삭제">
			</a>
			<a href="list">목록</a>
		</div>
	</section>
</main>
<script src="/js/admin/board/notice/list.js"></script>
