<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="test3"><!-- Controller 클래스 내부의 RequestMapping에서 text1을 검색하고 그 메서드 실행 -->
   <table border="1" cellspacing="0">
      <tr><th>아이디</th><td><input type="text" name="id"/></td></tr>
      <tr><th>이름</th><td><input type="text" name="name"/></td></tr>
      <tr><td colspan="2" align="center"><input type="submit" value="전송"/></td></tr>
   </table>
</form>

</body>
</html>