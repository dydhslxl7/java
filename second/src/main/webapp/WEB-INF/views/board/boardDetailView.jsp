<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="currentPage" value="${ requestScope.currentPage }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>second</title>
</head>
<body>
<c:import url="../common/header.jsp"/>
<hr>
<h2 align="center">${ board.board_num }번 게시글 상세보기</h2>
<br>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
<tr><th width="120">제 목</th><td> ${ board.board_title }</td></tr>
<tr><th>작성자</th><td>${ board.board_writer }</td></tr>
<tr><th>등록날짜</th><td><fmt:formatDate value="${ board.board_date }" pattern="yy/MM/dd"/></td></tr>
<tr>
	<th>첨부파일</th>
	<td>
		<c:if test="${ !empty board.board_original_filename }">
			<c:url var="bf" value="bfdown.do">
				<c:param name="ofile" value="${ board.board_original_filename }" />
				<c:param name="rfile" value="${ board.board_rename_filename }" />
			</c:url>
			<a href="${ bf }">${ board.board_original_filename }</a>
		</c:if>
		<c:if test="${ empty board.board_original_filename }">
		&nbsp;
		</c:if>
	</td>
</tr>
<tr><th>내 용</th><td>${ board.board_content }</td></tr>
<tr><th colspan="2">
<c:if test="${ !empty sessionScope.loginMember }">
	<c:if test="${ loginMember.userid eq board.board_writer }">
		<c:url var="bu" value="bupview.do">
			<c:param value="${ board.board_num }" name="bnum"/>
			<c:param value="${ currentPage }" name="page" />
		</c:url>
		<a href="${ bu }">[수정페이지로 이동]</a>
		&nbsp; &nbsp;
		<c:url var="bdel" value="bdelete.do">
			<c:param value="${ board.board_num }" name="bnum"/>
			<c:param value="${ board.board_level }" name="level" />
			<c:param value="${ board.board_rename_filename }" name="rfile" />
		</c:url>
		<a href="${ bdel }">[글삭제]</a> <!-- 글삭제 클릭하면 파일도 삭제하게 함 -->
		&nbsp; &nbsp; 
	</c:if>
	<c:if test="${ loginMember.userid ne board.board_writer }">
		<c:url var="brf" value="replyform.do">
			<c:param value="${ board.board_num }" name="bnum"/>
			<c:param value="${ currentPage }" name="page"/>
		</c:url>
		<a href="${ brf }">[댓글달기]</a>
	</c:if>
</c:if>
&nbsp; &nbsp;
<c:url var="bl" value="blist.do">
	<c:param name="page" value="${ currentPage }"/>
</c:url>
<button onclick="javascript:location.href='${ bl }'"> 목록</button></th>
</tr>
</table>
<c:import url="../common/footer.jsp"/>
</body>
</html>