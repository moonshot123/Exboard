<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
		function insert(){
			location.href='writeBoard.bo'; 
		}
		
	</script>

<title>Insert title here</title>
</head>
<body>
	
BorderList.jsp<br>
<h2 align="center">게시판 목록보기</h2>
	<center>
	<form action="list.bo" method="get">
		<select name="whatColumn">
			<option value="all">전체 검색
			<option value="subject">제목
			<option value="writer">작성자
		</select>
		<input type="text" name="keyword" value="d">
		<input type="submit" value="검색">
	</form>
	</center>
	<table border="1" align="center">
		<tr>
			<td colspan="6" align="right">
				<input type="button" value="추가하기" onclick="insert();">
			</td>
		</tr>
		<tr>
			<th><span>번호</span></th>
			<th><span>제목</span></th>
			<th><span>작성자</span></th>
			<th><span>작성일</span></th>
			<th><span>조회수</span></th>
			<th><span>IP</span></th>			
		</tr>
		<c:forEach items="${boardLists}" var="list">
			<tr>
				<td align="center">
					<c:out value="${list.num}" />
				</td>
				<td align="left">
					<a href="detail.bo?num=<c:out value="${list.num}" />"><c:out value="${list.subject}" /></a><br>
					<!-- detail.me=>MemberDetailViewController -->
				</td>
				<td align="center">
					<c:out value="${list.writer}" />
				</td>
				<td align="left">
					<c:out value="${list.regdate}" />
				</td>				
				<td align="right">
					<c:out value="${list.readcount}" />
				</td>
				<td align="right">
					<c:out value="${list.ip}" />
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<br>
	<center>
		${pageInfo.pagingHtml}
	</center>
	
		
</body>
</html>