<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>은풍한 팜</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/admin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/admin/index.js"></script>
</head>

<body>
    <!-- header 부분 -->

    <tiles:insertAttribute name="header" />

	<!-- --------------------------- <body> --------------------------------------- -->
	<div class="admin-body">		

		<!-- --------------------------- aside --------------------------------------- -->
		<tiles:insertAttribute name="aside" />

		
		<!-- --------------------------- main --------------------------------------- -->
		<tiles:insertAttribute name="main" />
			
		
	</div>

    <!-- ------------------- <footer> --------------------------------------- -->
	<tiles:insertAttribute name="footer" />
        
</body>

</html>