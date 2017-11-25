<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login - ComicBookApp</title>
<s:url var="url_css" value="/resources/css/style.css"/>
<link rel="stylesheet" href="${url_css}" type="text/css"/>
</head>
<s:url var="url_bg" value="/resources/images/bg.jpg"/>
<body background="${url_bg}">
	<table border="1" width="80%" align="center">
	<tr>
	<td height="80px">
	<%------Header-----%>
	<jsp:include page="include/header.jsp"/>
	</td>
	</tr>
	<tr>
	<td height="25px">
	<%------menu------%>
	<jsp:include page="include/menu.jsp"/>
	</td>
	</tr>
	<tr>
	<td height="350px" valign="top">
	<%-----page content area --%>
	<h1>Admin Dashboard</h1>
	
	</td>
	</tr>
	<tr>
	<td height="25px">
	<%------footer------%>
	<jsp:include page="include/footer.jsp"/>
	</td>
	</tr>
	</table>
</body>
</html>