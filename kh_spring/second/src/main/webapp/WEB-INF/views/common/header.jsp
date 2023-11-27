<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>second</title>
<style type="text/css">
header { margin : 0; padding: 0; }
header h1#logo {
	font-size: 36pt;
	font-style: italic;
	color : navy;
	text-shadow: 2px 2px 2px gray;
}
header ul#menubar { 
	list-style: none; 
	position: relative;
	left: 150px;
	top: -30px;
}
header ul#menubar li {
	float: left;
	width: 120px;
	height: 30px;
	margin-right: 5px;
	padding: 0;
}
header ul#menubar li a {
	text-decoration: none;
	width: 120px;
	height: 30px;
	display: block;
	background-color: orange;
	text-align: center;
	color: navy;
	font-weight: bold;
	margin: 0;
	text-shadow: 1px 1px 2px white;
	padding-top: 5px;
}
header ul#menubar li a:hover{
	text-decoration: none;
	width: 120px;
	height: 30px;
	display: block;
	background-color: navy;
	text-align: center;
	color: white;
	font-weight: bold;
	margin: 0;
	text-shadow: 1px 1px 2px navy;
	padding-top: 5px;
}
hr { clear: both; }
</style>
</head>
<body>
<header>
<h1 id="logo">second</h1>
<c:if test="${ !empty loginMember and loginMember.userid eq 'admin' }">
   
<ul id="menubar">
<li><a href="/mlist">회원관리</a></li>
<li><a href="adnlist.do">공지글관리</a></li>
<li><a href="blist.do">게시글관리</a></li>
<li><a href="#">QnA관리</a></li>
<li><a href="#">사진게시판관리</a></li>
<li><a href="/testm/views/test/testPage.jsp">필터테스트</a></li>
<li><a href="#">#</a></li>
<li><a href="${ pageContext.servletContext.contextPath }/main.do">Home</a></li>
</ul>
</c:if>   
<c:if test="${ !empty sessionScope.loginMember and loginMember.userid ne 'admin' }" >
<ul id="menubar">
<li><a href="${ pageContext.servletContext.contextPath }/enrollPage.do">암호화회원가입</a></li>
<li><a href="nlist.do">공지사항</a></li>
<li><a href="blist.do?page=1">게시글</a></li>
<li><a href="#">QnA</a></li>
<li><a href="#">사진게시판</a></li>
<li><a href="/testm/views/test/testPage.jsp">필터테스트</a></li>
<li><a href="#">#</a></li>
<li><a href="${ pageContext.servletContext.contextPath }/main.do">Home</a></li>
</ul>  
</c:if>
<c:if test="${ empty sessionScope.loginMember }" >
<ul id="menubar">
<li><a href="${ pageContext.servletContext.contextPath }/enrollPage.do">회원가입</a></li>
<li><a href="nlist.do">공지사항</a></li>
<li><a href="blist.do">게시글</a></li>
<li><a href="${ pageContext.servletContext.contextPath }/moveFile.do">파일업로드/다운로드 테스트</a></li>
<li><a href="moveCrypto.do">암호화회원가입</a></li>
<li><a href="${ pageContext.servletContext.contextPath }/moveAjax.do">Ajax테스트</a></li>
<li><a href="moveAoP.do">AOP란?</a></li>
<li><a href="${ pageContext.servletContext.contextPath }/main.do">Home</a></li>
</ul>  
</c:if>
</header>
</body>
</html>
