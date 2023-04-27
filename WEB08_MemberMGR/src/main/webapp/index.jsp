<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<!-- 서버에서 웹사이트 설정시 클라이언트 요청에 표시될 첫페이지를 index.jsp로 설정해둘 수 있음
		이는 클라이언트가 index.jsp 파일 유무나 이름을 몰라도 첫페이지를 자동으로 다운받아 볼 수 있다는 뜻 -->
	<%response.sendRedirect("login.do");%>
	<!-- 별도의 POST표시가 없으면 GET 방식의 호출 -->
	<!-- 서블릿을 거쳐서 포워딩된 페이지는 외부로 노출되지 않음 -->
</body>
</html>