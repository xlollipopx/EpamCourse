<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<%@
         page language = "java"
         import = "com.epam.web.model.Account"
         session = "true"
%>
<% Account account = (Account)session.getAttribute("account"); %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages"/>

<html>
    <head>
   	<link rel="stylesheet" type="text/css" href="static/css/sign-in.css">
   	<link rel="stylesheet" type="text/css" href="static/css/menu.css">
   	<link rel="stylesheet" type="text/css" href="static/css/position.css">
   	<link rel="stylesheet" type="text/css" href="static/css/side-menu.css">
    </head>
    <body>
          <jsp:include page="authorized-header.jsp"/>
          <jsp:include page="authorized-side-menu.jsp"/>

     <div id="footer" align="center">Best Beats</div>
    </body>
</html>

