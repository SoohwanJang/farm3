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
					<li><a href="/community/notice/list">공지사항</a></li>
				</ol>
			</div>

			<h1 class="page-title">공지사항</h1>

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

			<table class="board-table">
				<thead>
					<tr>
						<th class="num-col">번호</th>
						<th>제목</th>
						<th class="reg-col">작성자</th>
						<th class="reg-col">작성일</th>
						<th class="num-col">조회수</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="l" items="${list}" varStatus="st">
						<fmt:formatDate var="dateTempParse" pattern="yyyy-MM-dd"
							value="${l.regDate}" />
						<tr>
							<td>${l.id }</td>
							<td><a href="${l.id }">${l.title }</a></td>
							<td>관리자</td>
							<td>${dateTempParse }</td>
							<td>${l.hit }</td>
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
