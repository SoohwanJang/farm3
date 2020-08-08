<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <main class="main">
        <section class="content-container signup-section">
            <div class="path">
                <ol>
                    <li>
                        <a href="/index"> </a>
                    </li>
                    <li>
                        <a href="signup">회원가입</a>
                    </li>
                </ol>
            </div>

            <header>
                <h1 class="signup-title-font">회원 가입</h1>
                <div><span class="font-color-red">*</span>필수입력사항</div>
            </header>

            <table class="signup-table">
                <tr>
                    <td><span class="font-color-red">*</span> 회원구분</td>
                    <td> 
                        <ul class="division-list">
                            <li><input type="radio" name="role" value="ROLE_MEMBER" checked>개인회원</li>
                            <li><input type="radio" name="role" value="ROLE_SELLER">사업자회원</li>
                        </ul>
                    </td>
                </tr>
            </table>

            <section class="member-default-info">
               <h1 class="signup-title-font">기본정보</h1>
			
               <table class="signup-table">
                    <tr>
                        <td><span class="font-color-red">*</span> 아이디</td>
                        <td>
                        	<input type="text" name="uid" placeholder="6자리 이상 10자리 이하 영문과 숫자만 입력해주세요.">
                        	<span class="font-color-red d-none id-err">
                        		&nbsp;&nbsp;아이디는 6자리 이상 10자리 이하 영문과 숫자만 입력해주세요.
                        	</span>
                        	<span class="font-color-red d-none id-duple-err">
                        		&nbsp;&nbsp;중복된 아이디 입니다.
                        	</span>
                        	<span class="font-color-blue d-none id-confirm">
                        		&nbsp;&nbsp;사용 가능한 아이디 입니다.
                        	</span>
                        </td>
                    </tr>
                    <tr>
                        <td><span class="font-color-red">*</span> 비밀번호</td>
                        <td>
                        	<input type="password" name="pwd" placeholder="4자리 이상 10자리 이하 영문과 숫자만 입력해주세요.">
                        	<span class="font-color-red d-none pwd-err">
	                       		&nbsp;&nbsp;비밀번호는 4자리 이상 10자리 이하 영문과 숫자만 입력해주세요.
	                       	</span>
                        </td>
                    </tr>
                    <tr>
                        <td><span class="font-color-red">*</span> 비밀번호 확인</td>
                        <td>
                        	<input type="password" name="pwd-check">
                        	<span class="font-color-red d-none pwd-check-err">
	                       		&nbsp;&nbsp;비밀번호가 일치하지 않습니다.
	                       	</span>
                        </td>
                    </tr>
                    <tr>
                        <td><span class="font-color-red">*</span> 이름</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td><span class="font-color-red">*</span> 이메일</td>
                        <td>
                        	<input type="text" name="email" placeholder="예) test@gmail.com">
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
                            <input type="text" class="zip required" readonly>
                            <button class="address-search-button">우편번호</button><br>
                            <input type="text" class="address-basic address required" readonly><br>
                            <input type="text" class="address-detail address" placeholder="상세 주소">
							<input type="text" class="address-ect address" placeholder="참고 주소">
                        </td>
                    </tr>
                    <tr>
                        <td><span class="font-color-red">*</span> 휴대전화 </td>
                        <td class="phone-row">
                            <select name="mobile1">
                                <option value="010">010</option>
                                <option value="011">011</option>
                                <option value="016">016</option>
                                <option value="017">017</option>
                                <option value="019">019 </option>
                            </select> -
                            <input type="text" name="mobile2" class="num-input required" maxlength="4"> -
                            <input type="text" name="mobile3" class="num-input required" maxlength="4">
                        </td>
                    </tr>
                    <tr>
                        <td class="option-td">일반전화</td>
                        <td class="phone-row">
                            <select name="phone1">
                                <option value="02">02</option>
                                <option value="031">031</option>
                                <option value="032">032</option>
                                <option value="033">033</option>
                                <option value="041">041</option>
                                <option value="042">042</option>
                                <option value="043">043</option>
                                <option value="044">044</option>
                                <option value="051">051</option>
                                <option value="052">052</option>
                                <option value="053">053</option>
                                <option value="054">054</option>
                                <option value="055">055</option>
                                <option value="061">061</option>
                                <option value="062">062</option>
                                <option value="063">063</option>
                                <option value="064">064</option>
                                <option value="0502">0502</option>
                                <option value="0503">0503</option>
                                <option value="0504">0504</option>
                                <option value="0505">0505</option>
                                <option value="0506">0506</option>
                                <option value="0507">0507</option>
                                <option value="070">070</option>
                                <option value="010">010</option>
                                <option value="011">011</option>
                                <option value="016">016</option>
                                <option value="017">017</option>
                                <option value="018">018</option>
                                <option value="019">019</option>
                                <option value="0508">0508</option>
                            </select> -
                            <input type="text" name="phone2" class="num-input" maxlength="4"> -
                            <input type="text" name="phone3" class="num-input" maxlength="4">
                        </td>
                    </tr>
               </table>

           	</section>

            <div class="signup-button-container">
                <input type="submit" value="회원가입" class="signup-button">
            </div>
	            
        </section>
    </main>
    
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="/js/member/postcode.js"></script>
    <script src="/js/member/signup.js"></script>