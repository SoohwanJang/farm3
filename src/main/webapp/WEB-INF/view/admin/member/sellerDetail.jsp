<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.farm.web.entity.Member"%>
<%@ page import= "com.farm.web.entity.SellerApply"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <main class="admin-main">
	        <section class="admin-sub-main">
	            <h1 class="page-title">입점신청 상세정보</h1>
	
	            <section class="detail-container">
	            	<h1 class="d-none">공지사항 디테일</h1>
	            	
	            	<div class="title">
                        	<span>${s.comName }</span>
	            		<span>
	            			<fmt:formatDate pattern="yyyy-MM-dd" value="${list.regDate}" />
	            		</span>
	            	</div>
	            	<div class="content">
                        <table class="board-table">
                            <thead>
                                <tr>
                                    <th class="reg-col">상호명</th>
                                    <th class="reg-col">사업자번호</th>
                                    <th class="num-col">대표자명</th>
                                    <th class="num-col">담당자명</th>
                                    <th class="reg-col">연락처</th>
                                    <th class="reg-col">이메일</th>
                                    <th class="reg-col">판매URL</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>${s.comName }</td>
                                    <td>${s.brn }</td>
                                    <td>${s.repName }</td>
                                    <td>${s.staffName }</td>
                                    <td>${s.phone }</td>
                                    <td>${s.email }</td>
                                    <td>${s.sellingUrl }</td>
                                </tr>
                            </tbody>
                        </table>
	            	</div>     	
	            </section>
	            
	            <div class="admin-button">
		            <!-- <a href="edit">수정</a> -->
	            	<a class="admin-button-piv" href="../member/seller">목록</a>
	            	<!-- <input type="submit" value="삭제"> -->
	            </div>
        	</section>
        </main>
        
        <script src="/js/admin/member/list.js"></script>