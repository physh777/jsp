<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
안녕하세요 ${user.name}님, 반갑습니다.<br>
${user.name}님의 정보는 아래와 같아요~<br>
ID : ${user.id}<br>
Password : ${user.pwd}<br>
취미 : ${user.hobby}<br>
사시는곳 : ${user.address}<br>
성별 : ${user.trans==1?"남자":"여자"}<br>
</body>
</html>