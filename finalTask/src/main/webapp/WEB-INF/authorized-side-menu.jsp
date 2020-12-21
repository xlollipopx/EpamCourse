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
   	<link rel="stylesheet" type="text/css" href="static/css/catalog.css">
    </head>
    <body>


<div class="category-wrap">
  <ul>
    <li><a href="">Новинки</a></li>
    <li><a href="">Альбомы</a></li>

    <c:if test="${account.role == 'ADMINISTRATOR'}">
    <form name="FormSix" method="POST" action="${pageContext.request.contextPath}/controller?command=view-beats-to-admin">
    <li><a href="javascript:document.FormSix.submit()">Каталог Битов</a></li>
    </form>
    </c:if>

     <c:if test="${account.role == 'CUSTOMER'}">
     <form name="FormTwo" method="POST" action="${pageContext.request.contextPath}/controller?command=view-beats-to-customer">
     <li><a href="javascript:document.FormTwo.submit()">Каталог битов</a></li>
     </form>
     </c:if>

  </ul>
</div>

    </body>
</html>

