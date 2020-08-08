<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<main class="main">
		<section class="content-container">
			<div class="path">
				<ol>
					<li><a href="/index"></a></li>
					<li><a href="/community/community/index">커뮤니티</a></li>
					<li><a href="/community/qna/list">Q &amp; A</a></li>
				</ol>
			</div>

			<h1 class="page-title">상품후기</h1>

			<span class="board-search">
				<form name="search" method="POST" action="">
					<fieldset>
						<select name="search-option">
							<option>제목</option>
							<option>내용</option>
							<option>제목+내용</option>
						</select> <input type="search" placeholder="검색어를 입력하세요."> <input
							type="submit" value="검색">
					</fieldset>
				</form>
			</span>

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
						<fmt:formatDate var="dateTempParse" pattern="yyyy-MM-dd"
							value="${r.regDate}" />
						<tr>
							<td>${st.count }</td>
							<td><img src="/images/items/${r.image}" alt="리뷰 제품 사진">
							</td>
							<td><a href="${r.id }">${r.title }</a></td>
							<td class="rate"><c:forEach begin="0" end="4" var="i">
									<c:choose>
										<c:when test="${i < r.rate}">
											<img src="/images/color-star-icon.png">
										</c:when>
										<c:otherwise>
											<img src="/images/star-icon.png">
										</c:otherwise>
									</c:choose>
								</c:forEach></td>
							<td>${r.name }</td>
							<td>${dateTempParse }</td>
							<td>${r.hit }</td>
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
	</main>

<script src="/js/community/review/list.js"></script>