<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>second</title>
</head>
<body>
<c:import url="/WEB-INF/views/common/header.jsp"/>
<hr>
<h1 align="center">공지사항</h1>
<div style="text-align:center;">
<button onclick="javascript:location.href='nwrite.do';">공지글 등록</button>
</div>
<br>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="1">
<tr><th>번호</th><th>제목</th><th>작성자</th><th>첨부파일</th>
<th>날짜</th></tr>
<c:forEach var="n" items="${ requestScope.list }">
<tr>
<td align="right">${ n.noticeno }</td>
<c:url var="uand" value="andetail.do">
	<c:param name="noticeno" value="${ n.noticeno }"/>
</c:url>
<td><a href="${ uand }">${ n.noticetitle }</a></td>
<td>${ n.noticewriter }</td>
<td align="center">
	<c:if test="${ !empty n.original_filepath }">
	◎
	</c:if>
	<c:if test="${ empty n.original_filepath }">
	&nbsp;
	</c:if>
</td>
<td align="center"><fmt:formatDate value="${ n.noticedate }" type="date" pattern="yy/MM/dd"/></td>
</tr>
</c:forEach>
</table>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>