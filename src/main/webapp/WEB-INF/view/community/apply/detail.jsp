<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<main class="main">
		<section class="content-container apply-signup-section">
			<div class="path">
				<ol>
					<li><a href="/index"></a></li>
					<li><a href="/community/index">커뮤니티</a></li>
					<li><a href="/community/apply/list">입점신청</a></li>
				</ol>
			</div>

			<section class="comm-sub-main">
				<h1 class="page-title">입점신청</h1>

				<section class="detail-container">
					<h1 class="d-none">공 지 사 항 디테일</h1>

					<table class="apply-signup-table">
						<tr class="business-row d-none">
							<td>사업자 번호<span class="font-color-red">*</span></td>
							<td><input type="text"></td>
						</tr>
					</table>

					<section class="member-default-info">
						<h1 class="signup-title-font">기본정보</h1>
						<form action="/community/apply/reg" method="POST">
							<table class="apply-signup-table">
								<tr>
									<td>제목<span class="font-color-red">*</span></td>
									<td>${detail.title }</td>
								</tr>
								<tr>
									<td>법인명(단체명)<span class="font-color-red">*</span></td>
									<td>${detail.comName }</td>
								</tr>
								<tr>
									<td>법인/사업자 번호<span class="font-color-red">*</span></td>
									<td>${detail.brn }</td>
								</tr>
								<tr>
									<td>대표자 <span class="font-color-red">*</span></td>
									<td>${detail.repName }</td>
								</tr>
								<tr>
									<td>담당자 <span class="font-color-red">*</span></td>
									<td>${detail.staffName }</td>
								</tr>
								<tr>
									<td>이메일 <span class="font-color-red">*</span></td>
									<td>${detail.email }</td>
								</tr>
								<tr>
									<td>휴대전화 <span class="font-color-red">*</span></td>
									<td class="phone-row">${detail.telephone }</td>
								</tr>
								<tr>
									<td>일반전화</td>
									<td class="phone-row">${detail.phone }</td>
								</tr>
								<tr>
									<td>사진 업로드 <span class="font-color-red"></span></td>
									<td>${detail.files }</td>
								</tr>
								<tr>
									<td>상품 URL <span class="font-color-red"></span></td>
									<td>${detail.sellingUrl }</td>
								</tr>
								<tr>
									<td>내용 <span></span></td>
									<td>${detail.content }</td>
								</tr>
								<tr>
									<td>승인여부 <span></span></td>
									<td class="approve-status">${detail.appDate!=null ? '승인 대기 중' : '승인'}</td>
								</tr>
							</table>
							<div class="admin-button">
								<input type="submit" value="수정"> <a href="list">목록</a>
							</div>
						</form>
					</section>

				</section>
			</section>
		</section>
	</main>

