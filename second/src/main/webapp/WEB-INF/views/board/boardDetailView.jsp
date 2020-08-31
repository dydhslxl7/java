<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="currentPage" value="${ requestScope.currentPage }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testm</title>
</head>
<body>
<%-- <%@ include file="../common/header.jsp" %> --%>
<c:import url="/views/common/header.jsp"/>
<hr>
<h2 align="center">${ board.boardNum }번 게시글 상세보기</h2>
<br>
<table align="center" width="500" border="1" cellspacing="0" 
cellpadding="5">
<tr><th width="120">제 목</th><td> ${ board.boardTitle }</td></tr>
<tr><th>작성자</th><td>${ board.boardWriter }</td></tr>
<tr><th>등록날짜</th><td><fmt:formatDate value="${ board.boardDate }" pattern="yy/MM/dd"/></td></tr>
<tr>
	<th>첨부파일</th>
	<td>
		<c:if test="${ !empty board.boardOriginalFileName }">
			<c:url var="bf" value="/bfdown">
				<c:param name="ofile" value="${ board.boardOriginalFileName }" />
				<c:param name="rfile" value="${ board.boardRenameFileName }" />
			</c:url>
			<a href="${ bf }">${ board.boardOriginalFileName }</a>
		</c:if>
		<c:if test="${ empty board.boardOriginalFileName }">
		&nbsp;
		</c:if>
	</td>
</tr>
<tr><th>내 용</th><td>${ board.boardContent }</td></tr>
<tr><th colspan="2">
<c:if test="${ !empty sessionScope.loginMember }">
	<c:if test="${ loginMember.userid eq board.boardWriter }">
		<c:url var="bu" value="/bupview">
			<c:param value="${ board.boardNum }" name="bnum"/>
			<c:param value="${ currentPage }" name="page" />
		</c:url>
		<a href="${ bu }">[수정페이지로 이동]</a>
		&nbsp; &nbsp;
		<c:url var="bdel" value="/bdelete">
			<c:param value="${ board.boardNum }" name="bnum"/>
			<c:param value="${ board.boardLevel }" name="level" />
			<c:param value="${ board.boardRenameFileName }" name="rfile" />
		</c:url>
		<a href="${ bdel }">[글삭제]</a> <!-- 글삭제 클릭하면 파일도 삭제하게 함 -->
		&nbsp; &nbsp; 
	</c:if>
	<c:if test="${ loginMember.userid ne board.boardWriter }">
		<c:url var="brf" value="/views/board/boardReplyForm.jsp">
			<c:param value="${ board.boardNum }" name="bnum"/>
			<c:param value="${ currentPage }" name="page"/>
		</c:url>
		<a href="${ brf }">[댓글달기]</a>
	</c:if>
</c:if>
&nbsp; &nbsp;
<c:url var="bl" value="/blist">
	<c:param name="page" value="${ currentPage }"/>
</c:url>
<button onclick="javascript:location.href='${ bl }'"> 목록</button></th>
</tr>

</table>
</body>
</html>