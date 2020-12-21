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
   	<link rel="stylesheet" type="text/css" href="static/css/button.css">
   	<link rel="stylesheet" type="text/css" href="static/css/add-form.css">
    </head>
    <body>
          <jsp:include page="authorized-header.jsp"/>
          <jsp:include page="authorized-side-menu.jsp"/>

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

                        <td><a href="${pageContext.request.contextPath}/controller?command=view-beats-to-admin&page=${i}">${i}</a></td>

                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>


 <form method="POST" action="${pageContext.request.contextPath}/controller?command=add-beat">
<input type="submit" value="add beat" class="add-button"/>
</form>



<button class="open-button" onclick="openForm()">Add beat</button>

<div class="form-popup" id="myForm">
  <form method = "POST" action="${pageContext.request.contextPath}/controller?command=add-beat" class="form-container">

    <label for="text"><b>Name</b></label>
    <input type="text"  name="beatName" required>

    <label for="text"><b>timing</b></label>
    <input type="text"  name="beatTiming" required>

    <label for="text"><b>image path</b></label>
    <input type="text"  name="imagePath" required>

    <button type="submit" class="btn">Add</button>
    <button type="button" class="btn cancel" onclick="closeForm()">close</button>
  </form>
</div>

<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>




    </body>
</html>

