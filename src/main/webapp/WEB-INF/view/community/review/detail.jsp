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
					<li><a href="/community/review/list">상품후기</a></li>
				</ol>
			</div>
			<section class="comm-sub-main">
				<h1 class="page-title">상품후기</h1>

				<section class="detail-container">
					<h1 class="d-none">상품후기 디테일</h1>

					<div class="title">${r.title}</div>
					<div class="reg-info">
						<span>작성자: ${r.name }</span>

						<ul>
							<li>작성일: <fmt:formatDate pattern="yyyy-MM-dd"
									value="${r.regDate}" /></li>
							<%-- <li>조회수: ${q.hit}</li> --%>
						</ul>
					</div>
					<div class="content">
						<div class="content-img">
							<img src="/images/items/${r.image}" alt="리뷰 제품 사진">
						</div>
						<div class="content-text">
							<span class="rate"> <c:forEach
									begin="0" end="4" var="i">
									<c:choose>
										<c:when test="${i < r.rate}">
											<img src="/images/color-star-icon.png">
										</c:when>
										<c:otherwise>
											<img src="/images/star-icon.png">
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</span>
							
							<div>${r.content}</div>
						</div>
					</div>
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
