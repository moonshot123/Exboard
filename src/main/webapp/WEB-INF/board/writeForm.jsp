<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<b>글쓰기</b> <br>
		<form method="post" action="writeBoard.bo" > 
			<table width="430" border="1" cellspacing="0" cellpadding="0"
				 align="center">
				<tr>
					<td align="right" colspan="2" >
						<a href="list.bo"> 글목록</a>
					</td>
				</tr>
				<tr>
					<td width="100"  align="center">이 름</td>
					<td width="330" align="left">
					<input type="text" size="30" maxlength="10"	name="writer" 
							value="홍길동"></td>
				</tr>
				
				<tr>
					<td width="100"  align="center">제 목</td>
					<td width="330" align="left">					
						<input type="text" size="50" maxlength="50" name="subject" 
								value="어떤글">
					</td>
				</tr>
				
				<tr>
					<td width="100"  align="center">Email</td>
					<td width="330" align="left">
					<input type="text" size="50" maxlength="30"	name="email" 
							value="aa@xx.com"></td>
				</tr>
				
				<tr>
					<td width="100"  align="center">내 용</td>
					<td width="330" align="left">
						<textarea name="content" id="abc" rows="13" cols="50">호호호</textarea>
					</td>
				</tr>
				<tr>
					<td width="100"  align="center">비밀번호</td>
					<td width="330" align="left">
						<input type="password" size="10" maxlength="12"	name="passwd"  
								value="1234">
					</td>
				</tr>
				<tr>
					<td colspan=2  align="center" height="30">
						<input	type="submit" value="글쓰기">  
						<input type="reset"	value="다시작성"> 
						<input type="button" value="목록보기"	
								OnClick="window.location='list.bo'">
					</td>
				</tr>
			</table>	
		</form>
</body>
</html>