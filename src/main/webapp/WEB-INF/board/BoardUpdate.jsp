<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >  
<center><b>글수정</b> </center>
<br>

<form method="post" name="writeform" 
	action="updatePro.jsp?pageNum=${board.num }" 
	onsubmit="return writeSave();">
	
<table width="400"  align="center">
  <tr>
    <td  width="70"   align="center">이 름</td>
    <td align="left" width="330">
       <input type="text" size="30" maxlength="10" name="writer" 
       		value="${board.writer }">
	   <input type="hidden" name="num" value="${board.num }"></td>
  </tr>
  <tr>
    <td  width="70"   align="center" >제 목</td>
    <td align="left" width="330">
       <input type="text" size="50" maxlength="50" name="subject" 
       		value="${board.subject }"></td>
  </tr>
  <tr>
    <td width="70"  align="center">Email</td>
    <td align="left" width="330">
       <input type="text" size="50" maxlength="30" name="email" 
       		value="${board.email }"></td>
  </tr>
  <tr>
    <td  width="70"   align="center" >내 용</td>
    <td align="left" width="330">
     <textarea name="content" rows="13" cols="50">${board.content }</textarea></td>
  </tr>
  <tr>
    <td  width="70"   align="center" >비밀번호</td>
    <td align="left" width="330" >
     <input type="password" size="10" maxlength="12" name="passwd">
     
	 </td>
  </tr>
  <tr>      
   <td colspan=2  align="center"> 
     <input type="submit" value="글수정" >  
     <input type="reset" value="다시작성">
     <input type="button" value="목록보기" 
       onclick="document.location.href='list.bo'">
   </td>
 </tr> 
 </table>
</form>
 
      
</body>
</html>