<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>은풍한 팜</title>
    <link rel="stylesheet" href="/css/reset.css" />
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/admin.css" />
    <link rel="stylesheet" href="/ckeditor5/sample/styles.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/index.js"></script>
    <script src="/js/seller/seller.js"></script>
    <script src="/js/seller/list.js"></script>
  </head>
  <body>
    <header class="admin-header">
      <h1>
        판매자페이지
        <span>판매자님 반갑습니다.</span>
      </h1>
      <ul>
        <li>
          <a href="/index">메인 홈</a>
        </li>
        <li>
          <a href="/seller/index">관리자홈</a>
        </li>
        <li>로그아웃</li>
      </ul>
    </header>
    <div class="admin-body">
      <aside class="aside">
        <h1 class="d-none">관리자페이지 메뉴</h1>
        <ul class="admin-menu">
          <li>
            <h2 class="admin-menu-title">
              상품관리
            </h2>
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
      <main class="admin-main">
        <section class="admin-sub-main">
          <h1 class="page-title">qna 디테일</h1>

          <section class="detail-container">
            <h1 class="d-none">qna 디테일</h1>

            <div class="title item-qna-title">
              <span>제목: ${i.title}</span>
              <span>
                등록일:
                <fmt:formatDate pattern="yyyy-MM-dd" value="${i.regDate}" />
              </span>
            </div>
            <div class="content">
              ${i.image } ${i.content}
            </div>


            <form action="${i.id}" method="POST">
            <c:if test="${not empty i.contentA }">
              <div class="title item-qna-title">
                <span>등록된 답변</span>
                <span>답변일: 
                <fmt:formatDate pattern="yyyy-MM-dd" value="${i.regDateA}" />
                </span>
              </div>
              <div>
                ${i.contentA }
              </div>
            </c:if>

            <c:if test="${empty i.contentA }">
              <div class="title">
                <span>답변하기</span>
              </div>
              <div class="editor-parent">
              	<br>
                <div class="editor"></div>
                <div class="ans-button" >임시저장</div>
                <input class="ans-data" type="hidden" name="ans-content" value="">
                <input type="hidden" name="qnaId" value="${qnaId }">
                
              </div>
            </c:if>
          </section>

          <div class="admin-button">
            <c:if test="${empty i.contentA }">
            <input type="submit" value="답변등록">
            </c:if>
            <a href="list">목록</a>
          </div>
        </form>
        </section>
      	<script src="/ckeditor5/build/ckeditor.js"></script>
	    <script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
	    <script src="/ckeditor5/build/itemqna-answer.js"></script>
      </main>
    </div>
    <footer class="footer">
      <button class="up-button"></button>
    </footer>

  </body>
</html>
