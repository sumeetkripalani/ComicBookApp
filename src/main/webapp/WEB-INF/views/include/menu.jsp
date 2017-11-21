<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<s:url var="url_logout" value="/logout"/>

<c:if test="${sessionScope.userId==null}">
	<s:url var="url_reg_form" value="/reg_form"/>
<a href="#">Home</a> | <a href="#">Login</a> | <a href="${url_reg_form}">Register</a> | <a href="#">About</a>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==1}">
<a href="#">Home</a> | <a href="#">User List</a> | <a href="${url_logout}">Logout</a>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==2}">
<s:url var="url_uhome" value="/user/dashboard"/>
<s:url var="url_cform" value="/user/contact_form"/>
<a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Contact</a> | <a href="#">Contact List</a> | <a href="${url_logout}">Logout</a>
</c:if>