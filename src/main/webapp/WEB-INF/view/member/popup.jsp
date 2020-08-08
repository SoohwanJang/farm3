<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>아이디/비밀번호 찾기</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/popup.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/member/login.js"></script>
</head>
<body>
    <section class="search-pop">
    	<h1>ID / PW 찾기</h1>
    	
    	<ul>
    		<li class="id-menu click">아이디</li>
    		<li class="pwd-menu">비밀번호</li>
    	</ul>
    	
		<section class="id-search-section search-section">
    		<h1 class="d-none">아이디 찾기</h1>
    		<h2>등록된 이메일 주소로 찾기</h2>
    		<h3>가입시 등록하신 이메일 주소를 입력해주세요.</h3>
    		
    		<input type="text" name="email" placeholder="이메일을 입력해주세요.">
    		
    		<input type="submit" class="id-search-button"> 		
		</section>
		
		<section class="pwd-search-section search-section d-none">
    		<h1 class="d-none">비밀번호 찾기</h1>
    		<h2>등록된 아이디와 이메일 주소로 찾기</h2>
    		<h3>
    			가입시 등록하신 아이디와 이메일 주소를 입력해주세요.<br>
    			아이디와 비밀번호가 일치하신 경우에만
    			비밀번호 재설정 하실 수 있습니다.
    		</h3>
    		
    		<input type="text" name="uid" placeholder="아이디를 입력해주세요.">
    		
    		<input type="text" name="email" placeholder="이메일을 입력해주세요.">
    		
    		<input type="submit" class="pwd-search-button"> 		
		</section>
    </section>
    
</body>
</html>