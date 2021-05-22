<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages"/>

<html>
    <head>
   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/sign-in.css">
   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/menu.css">
    </head>

    <body>
       <jsp:include page="header.jsp"/>

      <h1 align="center"><fmt:message key="local.enter_the_site" /></h1>
      <h2 align="center"> invalid login </h2>
       <div class="container">
            <form method = "POST" action = "${pageContext.request.contextPath}/controller?command=login" >
            <label for="login"><b><fmt:message key="local.name" /></b></label>
            <input type="text" name="login" />
            <label for="psw"><b><fmt:message key="local.password" /></b></label>
            <input  type="password" name="password" />
            <input type="submit" value=<fmt:message key="local.sign_in" /> class="registerbtn"/>
            </form>
       </div>
    </body>
</html>