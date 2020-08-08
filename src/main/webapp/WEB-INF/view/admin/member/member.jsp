<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.farm.web.entity.Member"%>
<%@ page import="com.farm.web.entity.SellerApply"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<main class="admin-main">
		<section class="admin-sub-main">
			<h1 class="page-title">구매자관리</h1>

			<span class="board-search">
				<form name="search">
					<fieldset>
						<legend class="d-none">공지사항 검색 필드</legend>
						<label class="d-none">검색분류</label> 
						<select name="f">
							<option value="name">이름</option>
							<option value="uid">아이디</option>
						</select> 
						<label class="d-none">검색어</label> 
						<input type="search" name="query" value="" placeholder="검색어를 입력하세요.">
						<input type="submit" value="검색">
					</fieldset>
				</form>
			</span>

			<table class="board-table">
				<thead>
					<tr>
						<th class="num-col">번호</th>
						<th class="reg-col">아이디</th>
						<th class="num-col">이름</th>
						<th class="reg-col">이메일</th>
						<th class="reg-col">주소</th>
						<th class="reg-col">연락처1</th>
						<th class="reg-col">연락처2</th>
						<th class="num-col">가입일</th>
						<th class="reg-col">관리</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="b" items="${list2 }" varStatus="st">
						<tr>
							<td>${st.count }</td>
							<td>${b.uid }</td>
							<td>${b.name }</td>
							<td>${b.email }</td>
							<td>${b.address }</td>
							<td>${b.mobile }</td>
							<td>${b.phone }</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd" value="${b.regDate }" />
							</td>
							<td>
								<button class="member-delete">회원탈퇴</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="pager">
				<span class="btn btn-prev" onclick="alert('다음 페이지가 없습니다.');">이전</span>
				<ul class="page-list">
					<c:forEach var="i" begin="1" end="5">
						<li><a class="checked" href="?p=${i}&t=&q=">${i }</a></li>
					</c:forEach>
				</ul>
				<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
			</div>
		</section>
	</main>