<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside class="aside">
    <h1 class="d-none">관리자페이지 메뉴</h1>
    <ul class="admin-menu">
        <li>
            <h2 class="admin-menu-title">상품관리</h2>
            <ul class="admin-draw-menu">
                <li><a href="/admin/item/list">상품목록</a></li>
            </ul>
        </li>
        <li>
            <h2 class="admin-menu-title">회원관리</h2>
            <ul class="admin-draw-menu">
                <li><a href="/admin/member/seller">판매자</a></li>
                <li><a href="/admin/member/member">구매자</a></li>
            </ul>
        </li>
        <li>
            <h2 class="admin-menu-title">게시판관리</h2>
            <ul class="admin-draw-menu">
                <li><a href="/admin/board/notice/list">공지사항</a></li>
                <li><a href="/admin/board/apply/list">입점신청</a></li>
                <li><a href="/admin/board/qna/list">Q &amp; A</a></li>
                <li><a href="/admin/board/review/list">사용후기</a></li>
            </ul>
        </li>
    </ul>
</aside>