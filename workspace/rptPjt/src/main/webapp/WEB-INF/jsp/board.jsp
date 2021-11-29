<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
<h2>글 목록</h2><hr>
글 갯수 : ${count }
<table>
<tr><th>번호</th><th>제목</th><th>글쓴이</th><th>날짜</th><th>조회수</th></tr>
<c:forEach var="board" items="${boards}">
<tr><td>${board.idx }</td><td><a href="boardDetail.do?&idx=${board.idx}&title=${board.title}&content=${board.content}&writer=${board.writer }&updatedate=${board.updatedate }&viewcnt=${board.viewcnt }">
${board.title }
</a>
</td><td>${board.writer }</td><td>${board.updatedate }</td><td>${board.viewcnt }</td>
</tr>
</c:forEach>
</table>
<a href="boardAdd.do">추가하기</a>
</body>
</html>