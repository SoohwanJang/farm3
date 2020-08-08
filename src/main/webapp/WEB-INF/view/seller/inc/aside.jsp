<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside class="aside">
   <h1 class="d-none">관리자페이지 메뉴</h1>
   <ul class="admin-menu">
       <li>
           <h2 class="admin-menu-title">상품관리</h2>
           <ul class="admin-draw-menu">
               <li><a href="/seller/item/reg">상품등록</a></li>
               <li><a href="/seller/item/list">상품목록</a></li>
               <li><a href="/seller/item/qna/list">상품문의</a></li>
               <li><a href="/seller/item/review/list">상품후기</a></li>
           </ul>
       </li>
       <li>
           <h2 class="admin-menu-title">매매관리</h2>
           <ul class="admin-draw-menu">
               <li><a href="/seller/selling/list">주문현황</a></li>
           </ul>
       </li>
   </ul>
</aside>