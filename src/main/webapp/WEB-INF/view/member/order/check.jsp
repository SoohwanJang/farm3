<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<<script src="/js/member/check.js"></script>
<main class="main">
    <section class="content-container">
        <h1 class="d-none">주문 체크</h1>
        <div class="order-notice">
            <h1  class="page-title">주문/결제</h1>
            <div class="notice-msg-wrapper">
            	<c:if test="${check == 1 }">
	                <span>주문이 완료되었습니다.</span>
            	</c:if>
            	<c:if test="${check==2 }">
	                <span class="font-color-red">주문 오류, 다시 확인해주세요.</span>
            	</c:if>
            	
            </div>
            <div class="button-container">
                <button class="home-button">홈으로</button>
                <c:if test="${check == 1 }">
                	<button class="order-button">주문확인</button>
                </c:if>
            </div>
        </div>
    </section>
</main>