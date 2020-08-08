<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/js/index.js"></script>
<title>은풍한 팜</title>
<script src="/js/item/detail.js"></script>

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
					<li><a href="/community/community.html">커뮤니티</a></li>
					<li><a href="/community/intro.html">은풍한 팜</a></li>
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
			</section>
		</section>
	</header>
	<main class="main">
		<section class="msg-box d-none">
			<span class="close">X</span>
			<div class="msg">메세지</div>
			<div class="button-wrapper d-none">
				<button class="accept-button">수락</button>
				<button class="reject-button">거절</button>
			</div>
		</section>

		<section class="content-container">
			<h1 class="d-none">상품 디테일</h1>

			<div class="path">
				<ol>
					<li><a href="/index.html"> </a></li>
					<li><a href="/product/list.html">음료</a></li>
					<li><a href="/product/details.html">차 &#183; 즙</a></li>
				</ol>
			</div>

			<section class="detail-info-container">
				<h1 class="d-none">상품 이미지, 정보</h1>
				<section class="product-image">
					<h1 class="d-none">상품이미지</h1>
					<img src="/images/product1.jpg">
				</section>

				<section class="product-explain">
					<h1 class="d-none">상품 설명</h1>

					<dl>
						<dt class="product-dt" data-id="${i.id}">${i.name }</dt>
						<dd class="product-dd">상품 설명</dd>
					</dl>

					<ul>
						<li>원산지<span></span></li>
						<li>판매가<span class="price font-color-green"></span></li>
						<li>배송비<span></span></li>
					</ul>

					<div class="select-product">
						<span>옵션 선택</span> <select name="product" id="">
							<option value="">- [필수] 옵션을 선택해주세요 -</option>
							<option value="">옵션1</option>
							<option value="">옵션2</option>
							<option value="">옵션3</option>
						</select>
					</div>

					<span class="product-info"> 위 옵션선택 박스를 선택하시면 아래에 상품이 추가됩니다.
					</span>

					<form class="detail-form">
						<table class="current-product">
							<caption class="d-none">추가된 상품</caption>
							<col width="">
							<col width="100">
							<col width="150">

							<thead>
								<th>상품명</th>
								<th>상품수</th>
								<th>가격</th>
							</thead>
							<tbody>
								<tr>
									<td></td>
									<td><input type="number" value="1" min="1"
										class="product-count">
										<button disabled>수량취소</button></td>
									<td class="font-color-green">1억</td>
								</tr>
							</tbody>
						</table>

						<span class="total-price"> <b>총 상품금액</b> (수량) <b
							class="font-color-green"></b> &nbsp;(개)
						</span>

						<div class="submits">
							<input type="submit" value="바로구매" class="order-button"> <input
								type="submit" value="장바구니" class="basket-button"> <input
								type="submit" value="관심상품" class="att-button">
						</div>

					</form>

				</section>
			</section>

			<section class="detail-container">
				<h1 class="d-none">상품 상세페이지</h1>

				<ul class="detail-list">
					<li class="clicked">상세정보</li>
					<li>이용후기</li>
					<li>Q &amp; A</li>
					<li>반품/교환정보</li>
				</ul>

				<section class="detail-image">
					<h1 class="d-none">상품 상세 이미지</h1>
					<img src="/images/detail-image.jpg" alt="상세이미지">
				</section>

				<section class="detail-reaview">
					<h1 class="section-title">상품후기</h1>
					<div class="write-button">
						<button>글쓰기</button>
					</div>
					<table class="board-table">
						<thead>
							<tr>
								<th class="num-col">번호</th>
								<th>제목</th>
								<th class="reg-col">평점</th>
								<th class="reg-col">작성자</th>
								<th class="reg-col">작성일</th>
								<th class="num-col">조회수</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>8</td>
								<td><a href="detail.html"> 후기 입니다 어떤가 생각해보니 정말 굉장히 좋은
										상품이였던것 같은데 웬지 모르게 배가 고프네 언제 집에가야하나 </a></td>
								<td>★ ★ ★ ★ ☆</td>
								<td>은</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>7</td>
								<td><a href="detail.html">문의</a></td>
								<td>★ ★ ★ ★ ☆</td>
								<td>은</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>6</td>
								<td><a href="detail.html">문의</a></td>
								<td>★ ★ ★ ★ ☆</td>
								<td>한</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>5</td>
								<td><a href="detail.html">문의</a></td>
								<td>★ ★ ★ ★ ☆</td>
								<td>F</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>4</td>
								<td><a href="detail.html">문의</a></td>
								<td>★ ★ ★ ★ ☆</td>
								<td>a</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>3</td>
								<td><a href="detail.html">문의</a></td>
								<td>★ ★ ★ ★ ☆</td>
								<td>r</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>2</td>
								<td><a href="detail.html">문의</a></td>
								<td>★ ★ ★ ★ ☆</td>
								<td>m</td>
								<td>2020-07-31</td>
								<td>150</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="detail.html">문의</a></td>
								<td>★ ★ ★ ★ ☆</td>
								<td>은풍한Farm</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
						</tbody>
					</table>

					<button class="more-button">더보기</button>
				</section>

				<section class="detail-reaview">
					<h1 class="section-title">Q &amp; A</h1>
					<div class="write-button">
						<button>글쓰기</button>
					</div>
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
							<tr>
								<td>8</td>
								<td><a href="detail.html"> 후기 입니다 어떤가 생각해보니 정말 굉장히 좋은
										상품이였던것 같은데 웬지 모르게 배가 고프네 언제 집에가야하나 </a></td>
								<td>은</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>7</td>
								<td><a href="detail.html">문의</a></td>
								<td>은</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>6</td>
								<td><a href="detail.html">문의</a></td>
								<td>한</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>5</td>
								<td><a href="detail.html">문의</a></td>
								<td>F</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>4</td>
								<td><a href="detail.html">문의</a></td>
								<td>a</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>3</td>
								<td><a href="detail.html">문의</a></td>
								<td>r</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
							<tr>
								<td>2</td>
								<td><a href="detail.html">문의</a></td>
								<td>m</td>
								<td>2020-07-31</td>
								<td>150</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="detail.html">문의</a></td>
								<td>은풍한Farm</td>
								<td>2020-06-30</td>
								<td>150</td>
							</tr>
						</tbody>
					</table>
					<button class="more-button">더보기</button>
				</section>

			</section>
		</section>
	</main>

	<footer class="footer">
		<button class="up-button"></button>
	</footer>

</body>

</html>