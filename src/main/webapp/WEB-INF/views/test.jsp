<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:url var="url_jqlib" value="/resources/js/jquery-3.2.1.min.js"/>
<script src="${url_jqlib}"></script>
<script>
$(document).ready(function(){
	alert('jq is ready');
});
</script>
<title>Insert title here</title>
</head>
<body>
<h1>
AJAX TEST PAGE
</h1>
</body>
</html>