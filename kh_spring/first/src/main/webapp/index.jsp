<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<%-- <%
	//스프링 프로젝트에서는 index.jsp는 시작을 위한 페이지일 뿐
	//내용 보여지는 역할을 할 수 없음 (스프링 뷰 파일의 위치를 정해 놓았음)
	request.getRequestDispatcher("main.do").forward(request, response);
%> --%>
<jsp:forward page="main.do" />
</body>
</html>