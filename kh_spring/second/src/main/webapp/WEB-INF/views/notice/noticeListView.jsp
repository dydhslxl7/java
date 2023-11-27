<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>second</title>
</head>
<body>
	<%-- <%@ include file="../common/header.jsp" %> --%>
	<%-- <c:import url="../common/header.jsp" /> --%>
	<!-- 절대경로로 대상 파일의 위치를 지정한 경우 
		/context-root : 경로명 맨 앞에 표기함, web까지의 경로를 의미함
		JSTL에서는 절대경로 표기법이 달라짐 (스프링프레임워크에서도 달라짐)
		/context-root ==> /로 바뀜
		/testel ==> /
	-->
	<c:import url="/WEB-INF/views/common/header.jsp" />
	<hr>
	<h1 align="center">공지사항</h1>
	<br>
	<table align="center" width="500" border="1" cellspacing="0"
		cellpadding="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>첨부파일</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${ requestScope.list }" var="n">
			<tr>
				<td align="right">${ n.noticeno }</td>
				<c:url value="ndetail.do" var="und">
					<c:param name="noticeno" value="${ n.noticeno }"></c:param>
				</c:url>
				<td><a href="${ und }">${ n.noticetitle }</a></td>
				<td>${ n.noticewriter }</td>
				<td align="center">
				<c:if test="${ !empty n.original_filepath }">
					◎
				</c:if> 
				<c:if test="${ empty n.original_filepath}">
					&nbsp;
				</c:if></td>
				<td align="center"><fmt:formatDate value="${ n.noticedate }" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>