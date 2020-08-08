<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <main class="main">
        <section class="content-container signup-section">
            <div class="path">
                <ol>
                    <li>
                        <a href="/index"> </a>
                    </li>
                    <li>
                        <a href="edit">회원정보수정</a>
                    </li>
                </ol>
            </div>
 <form action="edit" method="post">
            <section class="member-default-info">
               <h1 class="signup-title-font">기본정보</h1>
               <table class="signup-table">
                    <tr>
                        <td><span class="font-color-red">*</span> 이름</td>
                        <td>${m.name }</td>
                    </tr>
                    <tr>
                        <td><span class="font-color-red">*</span> 이메일</td>
                        <td>
                           <input type="text" name="email" placeholder="예) test@gmail.com" value="${m.email }">
                           <span class="font-color-red d-none email-err">
                                &nbsp;&nbsp;잘못된 이메일 형식입니다.
                             </span>
                             <span class="font-color-red d-none email-duple-err">
                                &nbsp;&nbsp;중복된 이메일 입니다.
                             </span>
                      </td>
                    </tr>
                    <tr>
                        <td><span class="font-color-red">*</span> 주소</td>
                        <td class="add-row">
                        <c:forTokens var="a" items="${m.address}" delims="/" varStatus="st">
                        	<c:if test="${st.index eq 0 }">
                        		<input type="text" name="a" value="${a }" class="zip required" readonly>
                            	<button class="address-search-button">우편번호</button><br>
                        	</c:if>
                        	<c:if test="${st.index eq 1 }">
                        		<input type="text" name="a" value="${a }" class="address-basic required" readonly><br>
                        	</c:if>
                        	<c:if test="${st.index eq 2 }">
                        		<input type="text" name="a" value="${a }" class="address-detail" placeholder="상세 주소">
                        	</c:if>
                        	<c:if test="${st.index eq 3 }">
                        		<input type="text" name="a" value="${a }" class="address-ect" placeholder="참고 주소">
                        	</c:if>
                        </c:forTokens>
                        </td>
                    </tr>
                    
                    <tr>
                        <td><span class="font-color-red">*</span> 휴대전화 </td>
                        <td class="phone-row">
                        
                        <c:if test="${m.mobile eq null }">
                        	<input type="text" name="m" class="num-input" maxlength="4"> -
                        	<input type="text" name="m" class="num-input" maxlength="4"> -
                        	<input type="text" name="m" class="num-input" maxlength="4">
                        </c:if>
                        
                        <c:forTokens var="p" items="${m.mobile}" delims="-" varStatus="st"> 
            				<c:if test="${st.last}">
            					<input type="text" name="m" value="${p}" class="num-input" maxlength="4">
            				</c:if>
            				<c:if test="${st.last eq false}">
                             <input type="text" name="m" value="${p}" class="num-input" maxlength="4"> -
							</c:if>
                        </c:forTokens>
                        
                        </td>
                    </tr>

                    <tr>
                        <td class="option-td">일반전화</td>
                        <td class="phone-row">
                        <c:if test="${m.phone eq null }">
                        	<input type="text" name="p" class="num-input" maxlength="4"> -
                        	<input type="text" name="p" class="num-input" maxlength="4"> -
                        	<input type="text" name="p" class="num-input" maxlength="4">
                        </c:if>
                        <c:forTokens var="p" items="${m.phone}" delims="-" varStatus="st"> 
                             <input type="text" name="p" value="p" class="num-input" maxlength="4"> -
                             <c:if test="${st.last }">
                             	<input type="text" name="p" value="p" class="num-input" maxlength="4">
                             </c:if>
                        </c:forTokens>
                        </td>
                    </tr>
               </table>
              </section>
            <div class="signup-button-container">
                <input type="submit" value="정보수정" class="signup-button">
            </div>
          </form>
               
        </section>
    </main>
    
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="/js/member/postcode.js"></script>
    <script src="/js/member/memberedit.js"></script>