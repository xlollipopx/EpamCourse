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
   	<link rel="stylesheet" type="text/css" href="static/css/catalog.css">
   	<link rel="stylesheet" type="text/css" href="static/css/side-menu.css">
    </head>
    <body>
          <jsp:include page="header.jsp"/>

<div class="parent">
<div class="category-wrap">
  <ul>
    <li><a href="">Новинки</a></li>
    <li><a href="">Альбомы</a></li>
    <form name="FormThree" method="POST" action="${pageContext.request.contextPath}/controller?command=view-beats">
    <li><a href="javascript:document.FormThree.submit()">Каталог битов</a></li>
    </form>
  </ul>
</div>

<c:forEach var="beat"  items="${beatList}">

<div class="single-goods">
<h3>${beat.name}</h3>
<p>Cost: </p>
<img src=""/>
<input type="submit" value="buy" class=""/>
</div>
</c:forEach>
</div>

  <%--For displaying Page numbers.
    The when condition does not display a link for the current page--%>
    <table border="1" cellpadding="5" >
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
       <form name="FormFour" method="POST" action="${pageContext.request.contextPath}/controller?command=view-beats&page=${i}">
                        <td><a href="javascript:document.FormFour.submit()">${i}</a></td>
                        </form>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>



     <div id="footer" align="center">Best Beats</div>


    </body>
</html>

