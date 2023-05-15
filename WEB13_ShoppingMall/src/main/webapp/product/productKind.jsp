<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.html" %>

<article>
	<h2>Item</h2>
	<c:forEach items="${productKindList}" var="productVO">
		<div id="item">
			<a href="shop.do?command=productDetail&pseq=${productVO.pseq }">
				<img src="product_images/${productVO.image }" />
				<h3>${productVO.name }</h3>
				<p><fmt:setLocale value="ko_KR"/><fmt:formatNumber value="${productVO.price2}" type="currency"/></p>
			</a>
		</div>
	</c:forEach>
	<div class="clear"></div>
</article>

<%@ include file="../footer.jsp" %>