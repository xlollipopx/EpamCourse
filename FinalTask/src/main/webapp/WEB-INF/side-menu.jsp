<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

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

<div class="category-wrap">
  <ul>
    <li><a href="">Новинки</a></li>
    <li><a href="">Альбомы</a></li>
    <form name="FormThree" method="POST" action="${pageContext.request.contextPath}/controller?command=view-beats">
    <li><a href="javascript:document.FormThree.submit()">Каталог битов</a></li>
    </form>
  </ul>
</div>


     <div id="footer" align="center">Best Beats</div>
    </body>
</html>

