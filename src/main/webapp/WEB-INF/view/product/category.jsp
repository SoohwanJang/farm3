<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <main class="main">
        <section class="content-container">
            <div class="path">
                <ol>
                    <li>
                        <a href="/index"> </a>
                    </li>
                    <li>
                        <a href="/product/list">전체상품</a>
                    </li>
                </ol>
            </div>
            
            <h1 class="page-title">
                은풍한 팜 전체상품
            </h1>

			<c:set var="count" value="${count}" />
            <div class="product-list-menu">
                <span>
                    전체상품 <b class="product-allCount">${count}</b>개
                </span>
                <ul>
                    <li class="checked">신상품</li>
                    <li>인기상품</li>
                    <li>낮은가격</li>
                    <li>높은가격</li>
                </ul>
            </div>
            
            
            <section class="product-container">
                <h1 class="d-none">상품영역</h1>

                <ul>
                    <c:forEach var="item" items="${send}">
                    <li>
                        <a href="/product/details/${item.id}">
                            <p class="product-image">
                                <img src="/images/product1.jpg">
                            </p>
                            <p class="product-detail">
                                <span class="product-title">${item.name}</span>
                                <span class="product-price">${item.price }</span>
                                <span>${item.detail}</span>
                            </p>
                        </a>
                    </li>
                    </c:forEach>
                </ul>
                
            </section>
            
            <div class="pager">
				<span class="btn btn-prev" onclick="alert('다음 페이지가 없습니다.');">이전</span>
				<ul class="page-list">
					<c:forEach var="i" begin="1" end="5">
						<c:set var="orange" value="" />
						<c:if test="${i==1}">
							<c:set var="orange" value="-text- orange bold" />
						</c:if>
						<li><a class="checked" href="?p=${i}&t=&q=">${i}</a></li>
					</c:forEach>
				</ul>
				<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
			</div>
			
        </section>
        
    </main>

<script src="/js/list.js"></script>