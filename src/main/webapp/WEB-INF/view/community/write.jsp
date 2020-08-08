<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/js/index.js"></script>
<script src="/js/community.js"></script>
<title>은풍한 팜</title>
</head>

<body>
	<header class="header">
		<h1 class="d-none">은풍한 Farm</h1>
		<section>
			<h1 class="d-none">헤더</h1>
			<section class="top-header">
				<h1 class="d-none">상단헤더</h1>
				<div class="inner-header">
					<nav class="util-menu">
						<h1 class="d-none">유틸메뉴</h1>
						<ul>
							<li>사이트맵</li>
							<li>즐겨찾기</li>
						</ul>
					</nav>
					<nav class="member-menu">
						<h1 class="d-none">멤버메뉴</h1>
						<ul>
							<li><a href="/member/login.html">로그인</a></li>
							<li><a href="/member/signup.html">회원가입</a></li>
						</ul>
					</nav>
					<nav class="order-menu">
						<h1 class="d-none">상품메뉴</h1>
						<ul>
							<li>관심상품</li>
							<li>장바구니</li>
							<li>주문조회</li>
						</ul>
					</nav>
				</div>
			</section>
			<section class="bottom-header">
				<div class="inner-header">
					<h1 class="logo">
						<a href="/index.html"> <img src="/images/logo.png" alt="로고">
						</a>
					</h1>
					<span class="search-form">
						<form>
							<fieldset>
								<input type="search"> <input type="submit" value="검색">
							</fieldset>
						</form>
					</span>
				</div>
			</section>
			<nav class="main-menu">
				<h1 class="d-none">메뉴</h1>
				<ul>
					<li class="whole-menu">전체메뉴</li>
					<li><a href="/product/list.html">상품</a></li>
					<li><a href="/community/index">커뮤니티</a></li>
					<li><a href="/farmIntro/index">은풍한 팜</a></li>
				</ul>
			</nav>
			<section class="draw-menu">
				<h1 class="d-none">전체메뉴</h1>
				<div class="inner-draw">
					<div class="draw-list draw-main-menu">
						<div>
							<ul>
								<li class="catg" data-rno="1"><a
									href="/product/category?q=곡물">곡물</a></li>
								<li class="catg" data-rno="7"><a href="/product/list?q=쌀">쌀</a>
								</li>
								<li class="catg" data-rno="8"><a href="/product/list?q=잡곡">잡곡</a>
								</li>
							</ul>
							<ul>
								<li class="catg" data-rno="3"><a
									href="/product/category?q=채소">채소</a></li>
								<li class="catg" data-rno="10"><a href="/product/list?q=배추">배추</a>
								</li>
								<li class="catg" data-rno="11"><a href="/product/list?q=당근">당근</a>
								</li>
							</ul>
							<ul>
								<li class="catg" data-rno="4"><a
									href="/product/category?q=음료">음료</a></li>
								<li class="catg" data-rno="4"><a href="/product/list?q=쥬스">쥬스</a>
								</li>
								<li class="catg" data-rno="4"><a href="/product/list?q=즙">즙</a>
								</li>
							</ul>
						</div>
						<div>
							<ul>
								<li class="catg" data-rno="2"><a
									href="/product/category?q=과일">과일</a></li>
								<li class="catg" data-rno="2"><a href="/product/list?q=포도">포도</a>
								</li>
								<li class="catg" data-rno="13"><a href="/product/list?q=딸기">딸기</a>
								</li>
							</ul>
							<ul>
								<li class="catg" data-rno="5"><a
									href="/product/category?q=기타">기타</a></li>
								<li class="catg" data-rno="19"><a
									href="/product/list?q=아이스크림">아이스크림</a></li>
							</ul>
						</div>
					</div>
					<div class="draw-list draw-sub-menu">
						<ul>
							<li>은풍한 팜</li>
							<li><a href="/farmIntro/index">은풍한 팜 소개</a></li>
							<li><a href="/community/notice/list">공지사항</a></li>
							<li><a href="/community/apply/list">입점신청</a></li>
							<li><a href="/community/qna/list">Q &amp; A</a></li>
							<li><a href="/community/review/list">상품후기</a></li>
						</ul>
					</div>
				</div>
			</section>
		</section>
	</header>

	<main class="main">
		<section class="content-container">
			<div class="path">
				<ol>
					<li><a href="/index.html"></a></li>
					<li><a href="/community/community.html">커뮤니티</a></li>
					<li><a href="/community/qna.html">Q &amp; A</a></li>
					<li><a href="/community/write.html">Q &amp; A 작성</a></li>
				</ol>
			</div>

			<h1 class="page-title">Q &amp; A</h1>

			<form action="post">
				<div class="write-container">
					<table class="write-table">
						<thead>
							<th>글쓰기</th>
						</thead>
						<tr>
							<td>
								<table class="table-content">
									<tr>
										<td>문의 유형</td>
										<td><select>
												<option value="상품문의">상품 문의</option>
												<option value="결제문의">결제 문의</option>
												<option value="배송문의">배송 문의</option>
												<option value="입점문의">입점 문의</option>
												<option value="기타문의">기타 문의</option>
										</select></td>
									</tr>
									<tr>
										<td>작성자</td>
										<td>(로그인후 default된 id)</td>
									</tr>
									<tr>
										<td>제목</td>
										<td><input type=text name=title></td>
									</tr>

									<tr>
										<td>내용</td>
										<td><textarea name=content></textarea></td>
									</tr>

									<tr>
										<td>파일 첨부</td>
										<td><input type=file size=10 maxlength=10></td>
									</tr>
									<tr>
										<td>공개여부</td>
										<td><input type="radio" name="radio" value="공개">
											공개&nbsp;&nbsp; <!-- <br>--> <input type="radio" name="radio"
											value="비공개"> 비공개 <!-- <textarea name="pwd">비번</textarea> -->

										</td>
									</tr>
								</table>

								<div class="write-button-wrap">
									<input type="submit" value="등록"> <input type="submit"
										value="취소">
								</div>
							</td>
						</tr>
					</table>
				</div>
			</form>

		</section>
	</main>

	<!-- ------------footer------------------------------- -->
	<footer class="footer">

		<button class="up-button"></button>
	</footer>

</body>

</html>