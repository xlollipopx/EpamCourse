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
   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/sign-in.css">
   	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/menu.css">
    </head>

    <body>
       <nav class="top-menu">
                   <ul class="menu-main">
                   <form name="FormOne" method="POST" action="${pageContext.request.contextPath}/controller?command=to-main">
                     <li class="left-item"><a href="javascript:document.FormOne.submit()"><fmt:message key="local.home" /></a></li>
                     </form>
                     <li class="right-item lang"><a href="">ln</a>
                     <ul>
                           <li ><a href="?lang=ru"><fmt:message key="local.RU" /></a></li>
                           <li ><a href="?lang=en"><fmt:message key="local.EN" /></a></li>
                     </ul>
                     </li>

                     <li class="right-item"><a href=""><fmt:message key="local.registration" /></a></li>
                      <form name="FormTwo" method="POST" action="${pageContext.request.contextPath}/controller?command=sign-in">
                      <input type="hidden" name="sign-in" value="sing-in">
                     <li class="right-item">
                          <a href="javascript:document.FormTwo.submit()">
                              <fmt:message key="local.sign_in" />
                          </a>
                     </li>
                     </form>

                     <c:if test="${account.role == 'ADMINISTRATOR' || account.role == 'CUSTOMER'}">
                     <li class="right-item"><a  >${account.name}</a></li>
                     </c:if>

                 </ul>
                 </nav>

    </body>
</html>

