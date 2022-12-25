<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--suppress XmlUnboundNsPrefix -->
<html>
<head>
    <meta charset="UTF-8">
    <title> Welcome</title>

    <style>
        h3 {
          color: blue;
          font-family: verdana;
          font-size: 200%;

            margin: auto;
            width: 50%;
            padding: 10px;
        }
        h2 {
            color: yellow;
            font-family: verdana;
            font-size: 100%;

              margin: auto;
              width: 50%;
              padding: 10px;
        }
    </style>
</head>

<body class="center">

<main>
<h3>Hello, ${person.get().getName()}</h1>
<p>
<h2>Click <a href="/servlets/personList">here</a> to check all persons here)! </h2></p>

</main>

</body>

</html>