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
    <script src="/js/seller/selling/detail.js"></script>
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
          <h1 class="page-title">주문관리</h1>

          <section class="detail-container">
            <h1 class="d-none">주문관리</h1>

            <div class="title">
              <table class="board-table">
                <thead>
                  <tr>
                    <th class="reg-col">상태</th>
                    <th class="reg-col">주문자(이름)</th>
                    <th class="reg-col">상품명</th>
                    <th class="reg-col">등록상품명</th>
                    <th class="reg-col">가격</th>
                    <th class="reg-col">개수</th>
                    <th class="reg-col">총가격</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>${oi.status}</td>
                    <td>${oi.mUid}(${oi.mName})</td>
                    <td>${oi.iName}</td>
                    <td>${oi.iRegName}</td>
                    <td>${oi.iPrice}</td>
                    <td>${oi.qty}</td>
                    <td>${oi.qty*ol.iPrice}</td>
                  </tr>
                </tbody>
              </table>
              <table class="board-table">
                <thead>
                  <tr>
                    <th class="reg-col">주문일</th>
                    <th class="reg-col">배송지</th>
                    <th class="reg-col">택배메모</th>
                    <th class="reg-col">택배회사</th>
                    <th class="reg-col">송장번호</th>
                    <th class="reg-col">입금확인여부</th>
                  </tr>
                </thead>
                <form action="${dtlNum}" method="POST">
                <tbody>
                  <tr class="confirm-payment-parent">
                    <td>
                      <fmt:formatDate
                        pattern="yyyy-MM-dd HH:mm:ss"
                        value="${oi.oRegDate}"
                      />
                    </td>
                    <td>${oi.oDes}</td>
                    <td>${oi.deliveryMemo}</td>
                    <td>
                      <select name="delivery">
                      <c:forEach var="d" items="${dl }">
                        <option value="${d.id }">${d.name }</option>
                      </c:forEach>
                      </select>
                    </td>
                    <td><input name="waybillNum" type="number" /></td>
                    <c:if test="${oi.status eq '입금대기'}">
                      <td class="admin-button confirm-payment">입금확인</td>
                    </c:if>
                    <c:if test="${oi.status ne '입금대기'}">
                      <td class="admin-button">확인됨</td>
                    </c:if>
                  </tr>
                </tbody>
              </table>
            </div>
            <input class="oi-id" type="hidden" value="${oi.id}">
          </section>

          <div class="admin-button">
            <input type="submit" value="배송" />
            <a href="list">목록</a>
          </div>
          
        </section>
        </form>
      </main>
    </div>
    <footer class="footer">
      <button class="up-button"></button>
    </footer>
  </body>
</html>
