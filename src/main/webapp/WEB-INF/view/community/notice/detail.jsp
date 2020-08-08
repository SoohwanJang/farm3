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


			<section class="comm-sub-main">
				<h1 class="page-title">공지사항</h1>

				<section class="detail-container">
					<h1 class="d-none">공지사항 디테일</h1>

					<div class="title">${n.title }</div>
					<div class="reg-info">
						<span>작성자: ${n.name }</span>
						<ul>
							<li>작성일: <fmt:formatDate pattern="yyyy-MM-dd"
									value="${n.regDate}" /></li>
							<%-- <li>조회수: ${q.hit}</li> --%>
						</ul>
					</div>
					<div class="content">${n.content}</div>
				</section>

				<div class="admin-button">
					<a href="list">목록</a>
				</div>
			</section>

		</section>
	</main>


