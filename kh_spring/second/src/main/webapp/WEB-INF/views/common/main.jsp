<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/WEB-INF/views/common/error.jsp"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>second</title>
<style type="text/css">
div.lineA {
	height: 100px;
	border: 1px solid gray;
	float: left;
	position: relative;
	left: 120px;
	margin: 5px;
	padding: 5px;
}

div#banner {
	width: 750px;
	padding: 0;
}

div#loginBox {
	width: 274px;
	font-size: 9pt;
	text-align: left;
	padding-left: 20px;
}

div#loginBox button {
	width: 250px;
	height: 35px;
	background-color: navy;
	color: white;
	margin-top: 10px;
	margin-bottom: 15px;
	font-size: 14pt;
	font-weight: bold;
}

div#banner img {
	margin: 0;
	padding: 0;
	width: 750px;
	height: 110px;
}
</style>
<script type="text/javascript" src="resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
		/*
			주기적으로 반복 요청하려면
			setInterval(function(){ %.ajax(); },시간);
			시간은 밀리세컨드임 : 1000 이 1초임
		*/
		/* setInterval(function(){
				console.log("setinterval()에 의해 자동 실행 확인");
		}, 100); */
		
		//최근 등록한 공지글 3개 출력되게 함


	$.ajax({
		url : "ntop3.do",
		type : "get",
		dataType : "json",
		success : function(data) {
			console.log("success : " + data);
			// object ==> string으로 변환
			var jsonStr = JSON.stringify(data);
			// string ==> json 객채로 바꿈
			var json = JSON.parse(jsonStr);

			var values = "";
			for ( var i in json.list) {
				values += "<tr><td>"
						+ json.list[i].no
						+ "</td><td><a href='ndetail.do?noticeno="
						+ json.list[i].no
						+ "'>"
						+ decodeURIComponent(json.list[i].title).replace(/\+/gi, " ") + "</a></td><td>"
						+ json.list[i].date + "</td></tr>";
			} // for in

			$("#newnotice").html($("#newnotice").html() + values);
		},
		error : function(jqXHR, textstatus, errorthrown) {
			console.log("error : " + jqXHR + ", " + textstatus + ", "
					+ errorthrown);
		}
	});	//ajax
	
		//조회수 많은 인기 게시 원글 3개 조회 출력 처리
		$.ajax({
				url: "btop3.do",
				type: "get",
				dataType: "json",
				success : function(data) {
					console.log("success : " + data);
					// object ==> string으로 변환
					var jsonStr = JSON.stringify(data);
					// string ==> json 객채로 바꿈
					var json = JSON.parse(jsonStr);

					var values = "";
					for ( var i in json.list) {
						values += "<tr><td>"
								+ json.list[i].bnum
								+ "</td><td><a href='bdetail.do?bnum="
								+ json.list[i].bnum
								+ "'>"
								+ decodeURIComponent(json.list[i].btitle).replace(/\+/gi, " ") + "</a></td><td>"
								+ json.list[i].rcount + "</td></tr>";
					} // for in

					$("#toplist").html($("#toplist").html() + values);
				},
				error: function(jqXHR, textstatus, errorthrown) {
					console.log("error : " + jqXHR + ", " + textstatus + ", "
							+ errorthrown);
				}
		});
	
}); //document.ready


	function movePage() {
		location.href = "loginPage.do";
	}
</script>
</head>
<body>
	<c:import url="/WEB-INF/views/common/header.jsp"/>
	<hr style="clear: both;">
	<center>
		<div id="banner" class="lineA">
			<img src="resources/images/photo2.jpg">
		</div>
		
			<c:if test="${ empty loginMember }" >
		
		<div id="loginBox" class="lineA">
			Spring second 사이트 방문을 환영합니다.<br>
			<!-- <button onclick="javascript:location.href='views/member/loginPage.html';">로그인 하세요.</button><br> -->
			<button onclick="movePage();">로그인 하세요</button>
			<br> <a>아이디/비밀번호 조회</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; <a href="enrollPage.do">회원가입</a>
		</div>
		</c:if>
		<c:if test="${ !empty loginMember and loginMember.userid eq 'admin' } "> <%--userid 는 vo에 있는 변수명 --%>
		
		<div id="loginBox" class="lineA">
			${ sessionScope.loginMember.userid }
			님<br>
			<button onclick="javascript:location.href='logout.do';">로그아웃</button>
			<br>
			<c:url var="callMyinfo" value="myinfo.do">
				<c:param name="userid" value="${ loginMember.userid }" />
			</c:url>
			<a href="${ callMyinfo }">My Page</a>
		</div>
		</c:if>
		<c:if test="${ !empty sessionScope.loginMember }">
		<div id="loginBox" class="lineA">
			${sessionScope.loginMember.username}	님 <br>
			<button onclick="javascript:location.href='logout.do';">로그아웃</button>
			<br> <a>쪽지</a> &nbsp; &nbsp; <a>메일</a> &nbsp; &nbsp; &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
			<c:url var="callMyinfo2" value="myinfo.do">
				<c:param name="userid" value="${ loginMember.userid }" />
			</c:url>
			<a href="${ callMyinfo2 }">My Page</a>
			<!-- 쿼리스트링(Query String) : ?이름=전송값&이름=전송값 -->
		</div>
		</c:if>
		<hr style="clear: left;">
	</center>
	<section>
		<!--  최근 등록 공지글 3개 조회 출력 -->
		<div
			style="float: left; border: 1px solid navy; padding: 5px; margin: 5px">
			<h4>최근 공지글</h4>
			<table id="newnotice" border="1" cellspacing="0">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
			</table>
		</div>
		<!--  조회수 많은 게시글 3개 조회 출력 -->
		<div
			style="float: left; border: 1px solid navy; padding: 5px; margin: 5px">
			<h4>인기 게시글</h4>
			<table id="toplist" border="1" cellspacing="0">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>조회수</th>
				</tr>
			</table>
		</div>
	</section>
	<hr style="clear: both;">
	<c:import url="/WEB-INF/views/common/footer.jsp"/>
	
</body>
</html>

