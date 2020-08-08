<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<main class="main">
		<section class="content-container">
			<h1 class="d-none">커뮤니티 메인</h1>
			<div class="path">
				<ol>
					<li><a href="/index"></a></li>
					<li><a href="/community/index">커뮤니티</a></li>
				</ol>
			</div>
			<section class="community-section">
				<h1 class="d-none">게시판 모음</h1>
				<div>
					<table>
						<col>
						<col class="date-col">

						<tr>
							<td colspan="2"><a href="/community/notice/list">공지사항</a></td>
						</tr>
						<c:forEach var="notice" items="${notice}" varStatus="st">
							<fmt:formatDate var="dateTempParse" pattern="yyyy-MM-dd"
								value="${notice.regDate}" />
							<tr>
								<td><a href="notice/${notice.id } ">${notice.title }</a></td>
								<td>${dateTempParse }</td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<div>
					<table>
						<col>
						<col class="date-col">

						<tr>
							<td colspan="2"><a href="/community/apply/list">입점신청</a></td>
						</tr>
						<c:forEach var="apply" items="${apply}" varStatus="st">
							<fmt:formatDate var="dateTempParse" pattern="yyyy-MM-dd"
								value="${apply.regDate}" />
							<tr>
								<td><a href="apply/${apply.id } ">${apply.title }</a></td>
								<td>${dateTempParse }</td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<div>
					<table>
						<col>
						<col class="date-col">

						<tr>
							<td colspan="2"><a href="/community/qna/list">Q &amp; A</a>
							</td>
						</tr>
						<c:forEach var="qna" items="${qna}" varStatus="st">
							<fmt:formatDate var="dateTempParse" pattern="yyyy-MM-dd"
								value="${qna.regDate}" />
							<tr>
								<td><a href="qna/${qna.id } ">${qna.title }</a></td>
								<td>${dateTempParse }</td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<div>
					<table>
						<col>
						<col class="date-col">

						<tr>
							<td colspan="2"><a href="/community/review/list">상품후기</a></td>
						</tr>
						<c:forEach var="review" items="${review}" varStatus="st">
							<fmt:formatDate var="dateTempParse" pattern="yyyy-MM-dd"
								value="${review.regDate}" />
							<tr>
								<td><a href="review/${review.id } ">${review.title }</a></td>
								<td>${dateTempParse }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</section>
		</section>
	</main>
