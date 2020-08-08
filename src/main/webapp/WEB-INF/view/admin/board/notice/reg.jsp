<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main class="admin-main">
	<section class="admin-sub-main">
		<h1 class="page-title">공지사항</h1>
		<section class="writer-container">
			<h1 class="d-none">글쓰기 디테일</h1>
			<div class="title">
         		<input type="text" name="title" placeholder="제목을 입력해주세요.">
         	</div>
			<div class="editor"></div>          
			<div class="pup">
			    <input type="checkbox" name="pub"> 바로공개
			</div>
		</section>

		<div class="admin-button">
         	<input type="submit" value="등록" class="notice-reg-button">
         	<a href="list">목록</a>
         </div>
	</section>
</main>

<script src="/ckeditor5/build/ckeditor.js"></script>
<script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
<script type="module" src="/ckeditor5/build/notice-reg.js"></script>