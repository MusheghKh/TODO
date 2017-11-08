<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Minimal To-do List And Task Manager App</title>
    <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Quicksand' rel='stylesheet' type='text/css'>
    <!-- CSS -->
    <script src="http://code.jquery.com/jquery-3.1.0.slim.min.js"></script>
    <script src="${contextPath}/resources/js/home.js" type="application/javascript"></script>
    <link href="${contextPath}/resources/css/home.css" rel="stylesheet">
    <style>
        body {
            background-color: #fafafa;
            font-family: 'Quicksand';
        }

        .container {
            margin: 150px auto;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Minimal To-do List And Task Manager App</h1>
    <ul id="list-items"></ul>
    <form class="add-items">
        <input type="text" class="form-control" id="todo-list-item" placeholder="What do you need to do today?">
        <button class="add" type="submit">Add to List</button>
    </form>
</div>

</body>
</html>
