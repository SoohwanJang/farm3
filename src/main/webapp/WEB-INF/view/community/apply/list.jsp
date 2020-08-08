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
					<li><a href="/community/apply/list">입점신청</a></li>
				</ol>
			</div>

			<h1 class="page-title">입점신청</h1>

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
						<th class="reg-col">승인</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="l" items="${list}" varStatus="st" end="10">
						<fmt:formatDate var="dateTempParse" pattern="yyyy-MM-dd"
							value="${l.regDate}" />
						<tr>
							<td>${st.count}</td>
							<td><a href="${l.id }">${l.title }</a></td>
							<td>${l.staffName }</td>
							<td>${dateTempParse }</td>
							<td>${l.appDate!=null ? "승인 대기 중" : "승인"}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="write-button">
				<a href="reg">
					<button>글쓰기</button>
				</a>
			</div>

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
