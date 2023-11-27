<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="currentPage" value="${ param.page }" />
<c:set var="boardNum" value="${ param.bnum }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testel</title>
</head>
<body>
<h1 align="center">${ boardNum }번 글 댓글달기 페이지</h1>
<%-- <%@ include file="../common/header.jsp" %> --%>
<c:import url="../common/header.jsp"/>
<hr>
<form action="/testm/breply" method="post" >
<input type ="hidden" name="bnum" value="${ boardNum }">
<input type = "hidden" name= "page" value = "${ currentPage }">
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
<th>제 목</th><td><input type="text" name="title" size="50"></td>
<tr><th>작성자</th><td><input type="text" name="writer" readonly value="${ loginMember.userid }"></td></tr>
</tr>
<tr>


	</td>
</tr>
<tr><th>내 용</th><td><textarea rows="5" cols="50" name="content"></textarea></td></tr>
<tr><th colspan="2">
<input type="submit" value="등록하기"> &nbsp; 
<input type="reset" value="작성취소"> &nbsp;
<c:url var="bl" value="/blist">
	<c:param name="page" value="${ currentPage }"/>
</c:url>
<button onclick="javascript:location.href='${ bl }'; return false;"> 목록</button>
</th></tr>
</table>
</form>

</body>
</html>