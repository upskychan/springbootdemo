<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>Index Jsp 页面</title>
</head>
<body>
index.jsp<br>
pageContext.request.contextPath:${pageContext.request.contextPath}
<br>
${msg}
<br>
${person.name}--${person.age}--${person.note}
</body>
</html>