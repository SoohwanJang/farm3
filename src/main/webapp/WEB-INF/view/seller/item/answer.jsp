<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>은풍한 팜 관리자페이지</title>
    <link rel="stylesheet" href="/css/reset.css" />
    <link rel="stylesheet" href="/css/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/index.js"></script>
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
      <main>
      	<form action="answer2" method="POST">
        	<div class="editor">
        	</div>
        
        <div class="ans-button" style="width: 100px; height: 100px;">저장
        </div>
        <input class="ans-data" type="hidden" name="ans-content" value="">
        <input type="hidden" name="qnaId" value="${qnaId }">
        <input type="submit" value="답변등록">

        <script src="/ckeditor5/build/ckeditor.js"></script>
        <script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
        <script type="module" src="/ckeditor5/build/itemqna-answer.js"></script>
        </form>
      </main>
      
    </div>
    <footer class="footer">
      <button class="up-button"></button>
    </footer>
  </body>
</html>
