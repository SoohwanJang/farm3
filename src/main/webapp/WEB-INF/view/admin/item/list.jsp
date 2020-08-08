<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <main class="admin-main">
            <section class="admin-sub-main">
                <h1 class="d-none">상품 리스트</h1>
                <nav class="product-category-menu">
                    <h1 class="d-none">상품 카테고리 리스트</h1>
                    <ul>
	                    <c:forEach var="c" items="${ccv }" varStatus="vs">
	                    <c:if test="${vs.first }">
	                        <li class="select-category">
	                           	<span>${c.name }</span>  <span>${c.count }</span>
	                        </li>
	                    </c:if>
	                    <c:if test="${!vs.first }">
	                        <li>
	                           	<span>${c.name }</span>  <span>${c.count }</span>
	                        </li>
	                    </c:if>
	                    </c:forEach>
                    </ul>
                </nav>
                <section class="product-list">
                    <h1 class="page-title">전체상품</h1>
                
                    <span class="search-form">
                        <form>
                            <fieldset>
                                <legend class="d-none">상품관리 검색 필드</legend>
                                <label class="d-none">검색분류</label>
                                <select name="f">
                                    <option value="regName">등록명</option>
                                    <option value="name">상품명</option>
                                    <option value="tag">태그명</option>
                                    <option value="sellerName">판매자 이름</option>
                                    <option value="sellerUid">판매자 아이디</option>
                                </select>
                                <label class="d-none">검색어</label>
                                <input type="search" name="q" value="">
                                <input type="submit" value="검색">
                            </fieldset>
                        </form>
                    </span>
                    
                    <table class="product-table">
                        <colgroup>
                            <col class="num-col">
                            <col class="text-col">
                            <col>
                            <col class="expand-col">
                        </colgroup>
                        <thead>
                            <tr>
                                <th class="num-col">
                                    <span>
                                        <input type="checkbox" id="check_all" class="all-check-button">
                                        <label class="d-none">전체 상품 선택</label>
                                    </span>
                                </th>
                                <th colspan="3">상품정보</th>
                            </tr>
                        </thead>
                        <tbody>
							
							<c:forEach var="i" items="${list}">
	                            <tr>
	                                <td>
	                                    <input type="checkbox" value=${i.id }>
	                                </td>
	                                <td>
	                                    <img src="/upload/${i.image }">
	                                </td>
	                                <td>
	                                    <dl>
	                                        <dt>등록명</dt>
	                                        <dd>${i.regName }</dd>
	                                    </dl>
	                                    <dl>
	                                        <dt>상품명</dt>
	                                        <dd>${i.name }</dd>
	                                    </dl>
	                                    <dl>
	                                        <dt>카테고리</dt>
	                                        <dd>${i.catgPName } &gt; ${i.catgName }</dd>
	                                    </dl>
	                                    <dl>
	                                        <dt>판매가격</dt>
	                                        <dd>${i.price }</dd>
	                                    </dl>
	                                </td>
	                                <td>
	                                    <dl>
	                                        <dt>판매자(ID)</dt>
	                                        <dd>${i.sellerName }(${i.sellerUid})</dd>
	                                    </dl>
	                                    <dl>
	                                        <dt>판매기간</dt>
	                                        <dd>
	                                         	<fmt:formatDate value="${i.startDate }" pattern="YYYY/MM/dd"/>
	                                         	~
	                                         	<fmt:formatDate value="${i.endDate }" pattern="YYYY/MM/dd"/>
	                                         	
	                                        </dd>
	                                    </dl>
	                                    <dl>
	                                        <dt>태그</dt>
	                                        <dd>${i.tag }</dd>
	                                    </dl>
	                                    <dl>
	                                        <dt>공개여부</dt>
	                                        <dd>${i.pub }</dd>
	                                    </dl>
	                                </td>
	                            </tr>
							</c:forEach>
                            
                        </tbody>
                    </table>

                    <div class="product-list-button">
                        <button class="del-button">일괄삭제</button>
                    </div>

                    <div class="pager">	
                        <span class="btn btn-prev">이전</span>
                        <ul class="page-list">
                 			<c:forEach begin="1" end="5" var="i" varStatus="vs">
                 				<c:if test="${vs.first }">
		                            <li><a href="" class="page-button checked">${i }</a></li>
                 				</c:if>
                 				<c:if test="${!vs.first }">
		                            <li><a href="" class="page-button">${i }</a></li>
                 				</c:if>
                 			</c:forEach>
                        </ul>
                        <span class="btn btn-next">다음</span>
                    </div>

                </section>

            </section>
            
        </main>
        
        <script src="/js/admin/item/list.js"></script>