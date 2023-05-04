<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoes Shop</title>
<link rel="stylesheet" href="css/shopping.css">
<script src="member/member.js"></script>
<script src="mypage/mypage.js"></script>
</head>
<body>

<div id="wrap">

	<header>
		<div id="logo">
			<a href="shop.do?command=index">
				<img src="images/logo.png" width="180" height="100" >
			</a>
		</div>
		<nav id="top_menu">
			<ul>
				<c:choose>
					<c:when test="${empty loginUser}">
					<li><a>LOGIN</a></li>
					<li><a>JOIN</a></li>
				</c:when>
				<c:otherwise>
					<li>${loginUser.name}(${loginUser.id})</li>
					<li><a>정보수정</a></li>
					<li><a>LOGOUT</a></li>
				</c:otherwise>
				</c:choose>
				<li><a>CART</a></li>
				<li><a>MY PAGE</a></li>
				<li><a>Q &amp; A</a></li>
			</ul>
		</nav>
		
		<nav id="catagory_menu">
			<ul>
				<li><a href="shop.do?command=category&kind=1">Heels</a></li>
				<li><a href="shop.do?command=category&kind=2">Boots</a></li>
				<li><a href="shop.do?command=category&kind=3">Sandals</a></li>
				<li><a href="shop.do?command=category&kind=4">Sneakers</a></li>
				<li><a href="shop.do?command=category&kind=5">Sleepers</a></li>
				<li><a href="shop.do?command=category&kind=6">On Sale</a></li>
			</ul>
		</nav>
		
	</header>















