<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages"/>

<html>
    <head>
   	<link rel="stylesheet" type="text/css" href="src/main/webapp/static/css/sign-in.css">
   	<link rel="stylesheet" type="text/css" href="src/main/webapp/static/css/menu.css">
    </head>

    <body>
      <nav class="top-menu">
        <ul class="menu-main">
          <li class="left-item"><a href="index.jsp"><fmt:message key="local.home" /></a></li>
          <li class="right-item lang"><a href="" target="_blank">ln</a>
          <ul>
                <li ><a href="?lang=ru"><fmt:message key="local.RU" /></a></li>
                <li ><a href="?lang=en"><fmt:message key="local.EN" /></a></li>
          </ul>
          </li>
          <li class="right-item"><a href=""><fmt:message key="local.registration" /></a></li>
          <li class="right-item"><a href="sign-in-page.jsp"><fmt:message key="local.sign_in" /></a></li>
      </ul>
      </nav>



      <h1 align="center"><fmt:message key="local.enter_the_site" /></h1>

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

