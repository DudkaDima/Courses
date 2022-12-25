<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--suppress XmlUnboundNsPrefix -->
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
             html,
             body {
               height: 100%;
             }

             body {
               display: flex;
               align-items: center;
               padding-top: 40px;
               padding-bottom: 40px;
               background-color: #f5f5f5;
             }

             .form-floating-row {
              width: 100%;
                            max-width: 330px;
                            padding: 15px;
                            margin: auto;

             }
             .form-signin {
               width: 100%;
               max-width: 330px;
               padding: 15px;
               margin: auto;
             }

             .form-signin .checkbox {
               font-weight: 400;
             }

             .form-signin .form-floating:focus-within {
               z-index: 2;
             }

             .form-signin input[type="email"] {
               margin-bottom: -1px;
               border-bottom-right-radius: 0;
               border-bottom-left-radius: 0;
             }


             .form-signin input[type="password"] {
               margin-bottom: 10px;
               border-top-left-radius: 0;
               border-top-right-radius: 0;
             }

    </style>
    <link href="signin.css" rel="stylesheet">
</head>

<body class="center">

<main class="form-signin">
    <form class="container center" method="post" action="/servlets/login">
        <div class="row row-cols-3">
            <div class="form-floating col">
                <label for="input">Login</label>
                <input type="text" class="form-control" id="input" name="login" placeholder="login">
            </div>
            <div class="form-floating col">
                <label for="pass">Password</label>
                <input type="password" class="form-control" id="pass" name="password" placeholder="*****">
            </div>
            <div class="form-floating-row">
            <%
                        String login_msg=(String)request.getAttribute("error");
                        if(login_msg!=null)
                        out.println("<font color=red size=4px>"+login_msg+"</font>");
                        %>
            </div>

        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Log in</button>
    </form>
</main>

</body>

</html>