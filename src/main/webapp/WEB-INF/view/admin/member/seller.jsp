<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.farm.web.entity.Member"%>
<%@ page import="com.farm.web.entity.SellerApply"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


	<main class="admin-main">
		<section class="admin-sub-main">
			<h1 class="page-title">판매자관리</h1>

			<span class="board-search">
				<form name="search">
					<fieldset>
						<legend class="d-none">공지사항 검색 필드</legend>
						<label class="d-none">검색분류</label> <select name="f">
							<option value="name">이름</option>
							<option value="uid">아이디</option>
						</select> 
						<label class="d-none">검색어</label> 
						<input type="search" name="q" value="" placeholder="검색어를 입력하세요.">
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
						<th class="reg-col">상호명</th>
						<th class="reg-col">이메일</th>
						<th class="reg-col">주소</th>
						<th class="reg-col">연락처1</th>
						<th class="reg-col">연락처2</th>
						<th class="reg-col">가입일</th>
						<th class="reg-col">관리</th>
					</tr>
				</thead>

				<!-- 회원 삭제 버튼 기능 작동 스크립트(삭제x)
				<script>
					function idDelete(delID) {

						location.href = "delete?uid=" + delID; //get방식으로 삭제할아이디를 넘김

					}
				</script> -->

				<tbody>
					<c:forEach var="m" items="${list }" varStatus="st">
						<tr>
							<td>${st.count }</td>
							<td><a href="sellerDetail?id=${m.id }">${m.uid }</a></td>
							<td>${m.name }</td>
							<td>${m.comName }</td>
							<td>${m.email }</td>
							<td>${m.address }</td>
							<td>${m.mobile }</td>
							<td>${m.phone }</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd" value="${m.regDate }" />
							</td>
							<!-- <td>
								<button class="member-delete" type="button" value="삭제"
									onclick="idDelete('${m.uid}');">회원탈퇴</button>
							</td> -->
							<td>
								<button class="member-unable" data-rno="${m.id}" type="button" value="삭제">권한제거</button>
								<button class="member-enable" data-rno="${m.id}" type="button" value="삭제">권한부여</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="pager">
				<span class="btn btn-prev" onclick="alert('다음 페이지가 없습니다.');">이전</span>
				<ul class="page-list">
					<c:forEach var="i" begin="1" end="5">
						<c:set var="orange" value="" />
						<c:if test="${i==1}">
							<c:set var="orange" value="-text- orange bold" />
						</c:if>
						<li><a class="checked" href="?p=${i}&t=&q=">${i}</a></li>
					</c:forEach>
				</ul>
				<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
			</div>
		</section>
	</main>
	
	