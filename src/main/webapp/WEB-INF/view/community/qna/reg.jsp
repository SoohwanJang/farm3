<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/ckeditor5/sample/styles.css">

	<main class="main">
		<section class="content-container">
			<div class="path">
				<ol>
					<li><a href="/index"></a></li>
					<li><a href="/community/index">커뮤니티</a></li>
					<li><a href="/community/qna/list">Q &amp; A</a></li>
				</ol>
			</div>

			<h1 class="page-title">Q &amp; A</h1>

			<section class="admin-main">
				<section class="admin-sub-main">
					<h1 class="page-title">공지사항</h1>
					<section class="writer-container">
						<h1 class="d-none">글쓰기 디테일</h1>
						<div class="title">
							<input class="editor-title" type="text" name="title"
								placeholder="제목을 입력해주세요.">
						</div>
						<div class="editor"></div>
					</section>

					<div class="admin-button">
						<input class="qna-reg" type="button" value="등록"> <a
							href="list">목록</a>
					</div>
				</section>
			</section>

		</section>
	</main>


	<script src="/js/admin/board/notice/reg.js"></script>
	<script src="/ckeditor5/build/ckeditor.js"></script>
	<script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
	<script type="module" src="/ckeditor5/build/qna-edit-reg.js"></script>
