<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <sec:csrfMetaTags/>

    <title>Minimal To-do List And Task Manager App</title>

    <link href="${contextPath}/resources/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
    <link href='${contextPath}/resources/css/fonts.google.css' rel='stylesheet' type='text/css'>
    <!-- CSS -->
    <script src="${contextPath}/resources/js/jquery.min.js"></script>
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
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            Welcome ${pageContext.request.userPrincipal.name}
            <button class="logout" type="submit">Logout</button>
        </form>

    </c:if>

    <h1>Minimal To-do List And Task Manager App</h1>

    <ul id="list-items"></ul>
    <form id="todoForm" action="${contextPath}/api/todos" method="post" class="add-items">
        <input type="text" class="form-control" name="title" id="todo-list-item" placeholder="What do you need to do today?">
        <input id="csrf" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="add" type="submit">Add to List</button>
    </form>

</div>

</body>
</html>
