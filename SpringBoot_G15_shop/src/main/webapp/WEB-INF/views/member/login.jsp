<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/headerfooter/header.jsp" %> 
<%@ include file="../include/sub01/sub_image_menu.html" %>

<article>
   <form method="post" action="login" name="loginFrm">
      <fieldset><legend>LogIn</legend>
      <label>User ID</label><input name="id" type="text" value="${dto.id}"><br> 
      <label>Password</label><input name="pwd" type="password" ><br> 
        </fieldset>
        <div id="buttons">
            <input type="submit" value="로그인" class="submit" style="width:200px;">
            <input type="button" value="회원가입" class="cancel" onclick="location.href='contract'"style="width:200px;">
            <input type="button" value="아이디 비밀번호 찾기" class="submit" onclick="" style="width:200px;">
            <br>
            <a href="kakaostart"><img src="/images/kakao.png" style="width:300px; "></a>
            <a href="googlestart"><img src="/images/google.png" style="width:300px; "></a>
            <a href="naverstart"><img src="/images/naver.png" style="width:300px; "></a>
            <a href="facebookstart"><img src="/images/facebook.png" style="width:300px; "></a>
        </div>
   </form>    
   ${message}
</article>

 <%@ include file="../include/headerfooter/footer.jsp" %>