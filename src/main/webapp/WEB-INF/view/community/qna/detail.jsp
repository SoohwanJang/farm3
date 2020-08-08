<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<main class="main">
		<section class="content-container">
			<div class="path">
				<ol>
					<li><a href="/index"></a></li>
					<li><a href="/community/index">커뮤니티</a></li>
					<li><a href="/community/qna/list">Q &amp; A</a></li>
				</ol>
			</div>


			<section class="comm-sub-main">
				<h1 class="page-title">Q &amp; A</h1>

				<section class="detail-container">
					<h1 class="d-none">Q & A 디테일</h1>

					<div class="title">${q.title}</div>
					<div class="reg-info">
						<span>작성자: ${q.name }</span>
						<ul>
							<li>작성일: <fmt:formatDate pattern="yyyy-MM-dd"
									value="${q.regDate}" /></li>
							<%-- <li>조회수: ${q.hit}</li> --%>
						</ul>
					</div>
					<div class="content">${q.content}</div>
					
					
			
						<c:choose>
							<c:when test="${q.regDateA eq null}">
								
							</c:when>
							<c:otherwise>
								<div class="comment-section">					
						            <span>
										<b>관리자</b> (작성일: <fmt:formatDate pattern="yyyy-MM-dd" value="${q.regDateA}" />)
									</span>
									<span>
										${q.contentA }
									</span>							
								</div>
							</c:otherwise>
						</c:choose>
					
				</section>

				<div class="admin-button">
					<a href="list">목록</a>
				</div>
			</section>

		</section>
	</main>


	<script src="/js/admin/board/notice/reg.js"></script>
	<script src="/ckeditor5/build/ckeditor.js"></script>
	<script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
	<script type="module" src="/ckeditor5/build/notice-edit-reg.js"></script>
