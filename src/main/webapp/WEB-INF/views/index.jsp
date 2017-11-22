<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login - ContactApp</title>
<s:url var="url_css" value="resources/css/style.css" />
<link rel="stylesheet" href="${url_css}" type="text/css" />
</head>
<s:url var="url_bg" value="/resources/images/bg.jpg" />
<body background="${url_bg}">
	<table border="1" width="80%" align="center">
		<tr>
			<td height="80px">
				<%------Header-----%> <jsp:include page="include/header.jsp" />
			</td>
		</tr>
		<tr>
			<td height="25px">
				<%------menu------%> <jsp:include page="include/menu.jsp" />
			</td>
		</tr>
		<tr>
			<td height="350px" valign="top">
				<%-----page content area --%>
				<h3>User Login</h3> 
				<c:if test="${err!=null}">
					<p class="error">${err}</p>
				</c:if>
				<c:if test="${param.act eq 'lo'}">
					<p class="success">You've Been Logged Out</p>
				</c:if>
				<c:if test="${param.act eq 'reg'}">
					<p class="success">You've been Successfully registered. Please Login </p>
				</c:if>
				<s:url var="url_login" value="/login" /> 
				<f:form action="${url_login}" modelAttribute="command">
					<table border="1">
						<tr>
						<td>Username</td>
						<td><f:input path="loginName"/></td>				
						</tr>
						<tr>
						<td>Password</td>
						<td><f:password path="password"/></td>				
						</tr>
						<tr>
						<td colspan="2" align="right">
						<button>Login</button>
						<a href="<s:url value="/reg_form"/>">New User Registration Link</a>
						</td>				
						</tr>
					</table>
				</f:form>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<%------footer------%> <jsp:include page="include/footer.jsp" />
			</td>
		</tr>
	</table>
</body>
</html>