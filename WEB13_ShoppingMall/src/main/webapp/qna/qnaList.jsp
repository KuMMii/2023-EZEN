<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_image_menu.jsp" %>

<article>

<h2>1:1 고객 게시판</h2>
<h3>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
<form name="formm" method="post">
<table id="cartList">
	<tr><th>번호</th><th>제목</th><th>등록일</th><th>답변 여부</th></tr>
	<c:forEach items="${qnaList }" var="qnaVO">
		<tr><td>${qnaVO.qseq}</td>
			<td><a href="shop.do?command=qnaView&qseq=${qnaVO.qseq}">${qnaVO.subject}</a></td>
			<td><fmt:formatDate value="${qnaVO.indate }" type="date"/></td>
			<td><c:choose>
				<c:when test="${qnaBO.rep==1 }">no</c:when>
				<c:when test="${qnaBO.rep==2}">yes</c:when>
			</c:choose>
			</td>
		</tr>			
	</c:forEach>


</table>



</form>



</article>

<%@ include file="../footer.jsp" %>