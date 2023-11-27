<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="listCount" value="${ requestScope.listCount }" />
<c:set var="startPage" value="${ requestScope.startPage }" />
<c:set var="endPage" value="${ requestScope.endPage }" />
<c:set var="maxPage" value="${ requestScope.maxPage }" />
<c:set var="currentPage" value="${ requestScope.currentPage }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testm</title>
<script type="text/javascript">
   function showWriteForm() {
      location.href = "/testm/views/board/boardWriteForm.jsp";
   }
</script>
</head>
<body>
   <c:import url="/views/common/header.jsp"/><hr>
   <h2 align="center">
      게시글 목록 : 총 ${ listCount }개
   </h2>
   <c:if test="${ !empty sessionScope.loginMember }">
   <div style="align:center; text-align:center;">
      <button onclick="showWriteForm();">글쓰기</button>
   </div>
   </c:if>
   <br>
   <table align="center" border="1" cellspacing="0" width="700">
      <tr>
         <th>번호</th>
         <th>제목</th>
         <th>작성자</th>
         <th>날짜</th>
         <th>조회수</th>
         <th>첨부파일</th>
      </tr>
      <c:forEach var="b" items="${ requestScope.list }">
            <tr>
               <td align="center"> ${ b.boardNum }</td>
               <td>
               <!--  댓글일때는 제목을 들여쓰기함 -->
               <c:if test="${ b.boardLevel eq 1 }">
               &nbsp; &nbsp; ▶
               </c:if>
               <c:if test="${ b.boardLevel eq 2 }">
               &nbsp; &nbsp; &nbsp; &nbsp; ▶▶
               </c:if>
               <!-- 로그인한 사용자만(회원만) 상세보기 할 수 있게 함 -->
               <c:if test="${ !empty sessionScope.loginMember }">
               		<c:url var="bde" value="/bdetail">
               			<c:param name="bnum" value="${ b.boardNum }"/>
               			<c:param name="page" value="${ currentPage }" />
               		</c:url>
               		<a href="${ bde }">${ b.boardTitle }</a>
               </c:if>
               <c:if test="${ empty sessionScope.loginMember }">
               		${ b.boardTitle }
               </c:if>
               </td>
               <td align="center">${ b.boardWriter }</td>
               <td align="center"><fmt:formatDate value="${ b.boardDate }" type="date" pattern="yy.MM.dd"/></td>
               <td align="center">${ b.boardReadCount }</td>
               <td align="center">
               <c:if test="${ !empty b.boardOriginalFileName }">
					 ◎
			   </c:if>
			   <c:if test="${ empty b.boardOriginalFileName }">
               &nbsp;
               </c:if>
               </td>
            </tr>
      </c:forEach>
   </table>
	<br>
	<!--  페이징처리 -->
	<div style="text-align:center;">
	<c:if test="${ currentPage le 1 }"> <!-- le == <= -->
			[첫페이지]&nbsp;
	</c:if>
	<c:if test="${ currentPage > 1 }">
		<c:url var="bl" value="/blist">
			<c:param name="page" value="1"/>
		</c:url>
		<a href="${ bl }">[맨처음]</a>
	</c:if>
	<!--  이전 그룹으로 이동 처리  -->
	<c:if test="${ (currentPage - 10) lt startPage and (currentPage - 10) > 1 }">
		<c:url var="bl2" value="/blist">
			<c:param name="page" value="${ startPage - 10 }"/>
		</c:url>
		<a href="${ bl2 }">[이전그룹]</a>
	</c:if>
	<c:if test="${ !((currentPage - 10) lt startPage and (currentPage - 10) > 1) }">
			[이전그룹]&nbsp;
	</c:if>
	<!-- 현재 페이지가 속한 페이지그룹의 숫자 출력 처리  -->
	<c:forEach var="p" begin="${ startPage }" end="${ endPage }" step="1">
		<c:if test="${ p eq currentPage }">
			<font color="red" size="4"><b>[${ p }]</b></font>
		</c:if>
		<c:if test="${ p ne currentPage }">
			<c:url var="bl3" value="/blist">
				<c:param name="page" value="${ p }"/>
			</c:url>
			<a href="${ bl3 }">${ p }</a>
		</c:if>
	</c:forEach>
	<!-- 다음 그룹으로 이동 처리 -->
	<c:if test="${ (currentPage + 10) > endPage && (currentPage + 10) < maxPage }">
		<c:url var="bl4" value="/blist">
			<c:param name="page" value="${ endPage + 10 }"/>
		</c:url>
	<a href="${ bl4 }">[다음그룹]</a>
	</c:if>
	<c:if test="${ !((currentPage + 10) > endPage && (currentPage + 10) < maxPage) }">
			[다음그룹]&nbsp;
	</c:if>
	
	<c:if test="${ currentPage >= maxPage }">
			[맨끝]&nbsp;
	</c:if>
	<c:if test="${ currentPage < maxPage }">
		<c:url var="bl5" value="/blist">
			<c:param name="page" value="${ maxPage }"/>
		</c:url>
			<a href="${ bl5 }">[맨끝]</a>
	</c:if>
		
	</div>
	<hr>
   <%-- <%@ include file="../common/footer.jsp"%> --%>
   <c:import url="/views/common/footer.jsp"/>
</body>
</html>