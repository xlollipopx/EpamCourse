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
   	<link rel="stylesheet" type="text/css" href="static/css/catalggg.css">
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
<p><image src=${beat.imagePath} width="100" height="100"/></p>
<audio controls>
      <source src=${beat.audioPath} type="audio/mpeg">
      </source>
</audio>
<input type="submit" value="buy" class=""/>
<form method = "POST" action="${pageContext.request.contextPath}/controller?command=view-comments&beatId=${beat.id}">
   <input type="submit" value="comments" class=""/>
   </form>

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





<button class="open-button" onclick="openForm()">Add beat</button>

<div class="form-popup" id="myForm">
  <form method = "POST" action="${pageContext.request.contextPath}/controller?command=add-beat"
   class="form-container" enctype="multipart/form-data">

    <label for="text"><b>Name</b></label>
    <input type="text"  name="beatName" required>

    <label for="text"><b>image</b></label>
    <input type="file" name="fileImage"/>

    <label for="text"><b>beat</b></label>
        <input type="file" name="fileBeat"/>

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

