<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_EL.jsp</title>
</head>
<body>


<!-- 표현 언어(EL, Expression Language)JSP의 전달값이나 변수값 등 자료를 출력할 때의 번거로움을 간단히 해결하기 위해 만들어진 출력 문법,
jsp의 문법을 html5에서 좀더 구분하기 쉽고, 오류를 줄여서 운용하기 위해 개발된 언어.
주로 pageContext, request, session, application에 전달되는 Attribute의 값을 getter를 이용하지 않고 출력할 때 많이 사용함 -->


<h3>
JSP 문법 사용1:<%="Hello" %><br>
JSP 문법 사용2:<%out.println("Hello"); %><br>
EL 문법 사용:${"Hello"}
</h3>


<br><br>
<h3>
정수형 :${10}
실수형 :${5.6}<br>
문자열형 :${"홍길동"}<br>
논리형 :${true}<br>
null :${null}<br>
</h3>

<h3>
<!-- 산술연산 -->
10과 2의 합 : ${10+2 }<br>
<!-- 
\${10+2}는 모양 그대로 출력
${10+2}는 계산된 결과 출력
 -->
 
 \${10-2} : ${10-2}<br>
 \${10*2} : ${10*2}<br>
 \${10/2} : ${10/2}<br>
 \${10%2} : ${10%2}<br>
 \${10 mod 2} : ${10 mod 2}<br>
</h3>

<br><br>
<h3>
<!-- 관계연산(비교연산) -->
 \${10==2} : ${10==2}<br>
 \${10 eq 2} : ${10 eq 2}<br>
 \${10!=2} : ${10!=2}<br>
 \${10 ne 2} : ${10 ne 2}<br>
 \${10<2} : ${10<2}<br>
 \${10 lt 2} : ${10 lt 2}<br>
 \${10<=2} : ${10<=2}<br>
 \${10 le 2} : ${10 le 2}<br>
 \${5 >= 4} : ${5 >= 4}<br>
 \${5 ge 4} : ${5 ge 4}<br>
 \${5 > 4} : ${5 > 4}<br>
 \${5 gt 4} : ${5 gt 4}<br>
 \${empty("")} : ${empty("")}<br>

</h3>

<h3>
<!-- 서로 다른 자료형간의 연산 -->
 \${"2"+5} = ${"2"+5}<br>
 \${"2"+"5"} = ${"2"+"5"}<br>
 \${"2" *5} = ${"2" *5}<br>
 \${null +5} = ${null +5}<br>
</h3>

<br><br>
<h3>
<!-- 문자열 연결(EL 3.0 추가) -->
\${"문자"+="열"+="연결" }=${"문자"+="열"+="연결" }<br>
</h3>



<!-- 서버 객체의 내용을 getAttribute 메서드 없이 사용 -->
<%
pageContext.setAttribute("name", "홍길서");
request.setAttribute("name", "홍길동");
session.setAttribute("name", "홍길남");
application.setAttribute("name", "홍길북");
%>

<h3>
JSP 문법 :<%=request.getAttribute("name") %><br>
JSP 문법 :<%String str=(String) request.getAttribute("name"); %><%=str %><br>
EL 문법 : ${name}<br> <!-- 만약 같은 이름의 변수가 여러개면 위에서부터 우선권을 얻음 -->
EL 문법 : ${requestScope.name}<br> <!-- 같은 이름이 여러개면 이렇게 앞에 따로 지정해도됨 -->
EL 문법 : ${sessionScope.name}<br> 
EL 문법 : ${applicationScope.name}<br> 

<!-- EL을 이용할 때 서버객체의 내용을 출력하고자 할때 어떤 객체인지 명시하지 않고, 애트리뷰터 이름만 사용하면
사용하려는 애트리뷰트가 있는 객체를 순서(pageContext->request->session->application)대로 검사해 가장 먼저 발견된 내용 출력
name이라는 어트리뷰트를 갖고 있는 객체 중에서 순서적으로 가장 우선인 객체 내용이 출력됨 -->



</h3>






</body>
</html>