<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<main class="main">
		<section class="content-container apply-signup-section">
			<div class="path">
				<ol>
					<li><a href="/index"></a></li>
					<li><a href="/community/index">커뮤니티</a></li>
					<li><a href="/community/apply/list">입점신청</a></li>
				</ol>
			</div>

			<header>
				<div class="apply-signup-title">
					<div class="signup-title-wrap">
						<h1 class="page-title">입점신청</h1>
						<div>
							<span class="font-color-red">*</span>필수입력사항
						</div>
					</div>
				</div>
			</header>

			<section class="member-default-info">
				<h1 class="signup-title-font">기본정보</h1>
				<form action="/community/apply/reg" method="POST">
					<table class="apply-signup-table">
						<tr>
							<td>제목<span class="font-color-red">*</span></td>
							<td><input name="title" type="text"></td>
						</tr>
						<tr>
							<td>법인명(단체명)<span class="font-color-red">*</span></td>
							<td><input name="comName" type="text"></td>
						</tr>
						<tr>
							<td>법인/사업자 번호<span class="font-color-red">*</span></td>
							<td><input name="brn_" type="text"></td>
						</tr>
						<tr>
							<td>대표자 <span class="font-color-red">*</span></td>
							<td><input name="repName" type="text"></td>
						</tr>
						<tr>
							<td>담당자 <span class="font-color-red">*</span></td>
							<td><input name="staffName" type="text"></td>
						</tr>
						<tr>
							<td>이메일 <span class="font-color-red">*</span></td>
							<td><input name="email" type="email"></td>
						</tr>
						<tr>
							<td>휴대전화 <span class="font-color-red">*</span></td>
							<td class="phone-row"><input name="telephone" type="tel"
								placeholder=" 예) 010-0000-0000"
								pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required></td>
						</tr>
						<tr>
							<td>일반전화</td>
							<td class="phone-row"><input name="phone" type="tel"
								placeholder=" 예) 02-0000-0000"
								pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}"></td>
						</tr>
						<tr>
							<td>사진 업로드 <span class="font-color-red"></span></td>
							<td><input name="files" type="text">
								<button value="사진 업로드">사진 업로드</button></td>
						</tr>
						<tr>
							<td>상품 URL <span class="font-color-red"></span></td>
							<td><input name="sellingUrl" type="text"></td>
						</tr>
						<tr>
							<td>내용 <span></span></td>
							<td><input name="content" class="font-content-area"
								type="text" style="width: 700px; height: 200px;"></td>
						</tr>
					</table>
					<div class="admin-button">
						<input type="submit" value="등록"> <a href="list">목록</a>
					</div>
				</form>
			</section>

		</section>
	</main>
