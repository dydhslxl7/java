<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
<h2 align="center">${ notice.noticeno }번 공지 상세보기</h2>
<br>
<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
<tr><th>제 목</th><td>${ notice.noticetitle }</td></tr>
<tr><th>작성자</th><td>${ notice.noticewriter }</td></tr>
<tr><th>등록날짜</th><td><fmt:formatDate value="${ notice.noticedate }" type="both"/> </td></tr>
<tr>
	<th>첨부파일</th>
	<td>
		<c:if test="${ !empty notice.original_filepath }">
		<c:url var="nfd" value="nfdown.do">
			<c:param name="ofile" value="${ notice.original_filepath }"/>
			<c:param name="rfile" value="${ notice.rename_filepath }"/>
		</c:url>
		<a href="${ nfd }">${ notice.original_filepath }</a>
		</c:if>
		<c:if test="${ empty notice.original_filepath }">
		&nbsp;
		</c:if>
	</td>
</tr>
<tr><th>내 용</th><td>${ notice.noticecontent }</td></tr>
<tr><th colspan="2">
<c:url var="npm" value="npmove.do">
	<c:param name="noticeno" value="${ notice.noticeno }"/>
</c:url>
<c:url var="nd" value="ndel.do">
	<c:param name="noticeno" value="${ notice.noticeno }"/>
	<c:param name="rename_filepath" value="${ notice.rename_filepath }"/>
</c:url>
<button onclick="javascript:location.href='${ npm }';">수정페이지로 이동</button> &nbsp; 
<button onclick="javascript:location.href='${ nd }';">삭제하기</button> &nbsp; 
<button onclick="javascript:history.go(-1);">목록</button></th></tr>
</table>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>

