<html>
    <head>
   	<link rel="stylesheet" type="text/css" href="css/main.css">
   	<link rel="stylesheet" type="text/css" href="css/menu.css">
    </head>

    <body>

  <nav class="top-menu">
    <ul class="menu-main">
      <li class="left-item"><a href="biba.jsp">Home</a></li>
      <div class="dropdown">
      <li class="right-item"><a href="" target="_blank">lng</a>
      <ul class="dropdown">
            <li ><a href="#">Ссылка 1</a></li>
            <li ><a href="#">Ссылка 2</a></li>
      </ul>
      </li>
      <li class="right-item"><a href="">registration</a></li>
      <li class="right-item"><a href="">Sign in</a></li>

  </ul>
  </nav>

    <div class="container">
        <form method = "POST" action = "${pageContext.request.contextPath}/controller?command=login" >
         <label for="login"><b>Email</b></label>
        <input type="text" name="login" />
         <label for="psw"><b>Password</b></label>
        <input  type="password" name="password" />
        <input type="submit" class="registerbtn"/>
        </form>
        </div>
    </body>
</html>

