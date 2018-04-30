<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Страница заказов</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-4.1.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bootstrap-4.1.0/starter-template.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="http://localhost:8080">Такси</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Тарифы</a>
            </li>
        </ul>
    </div>
</nav>

<main role="main" class="container">

    <div class="starter-template">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Номер заказа</th>
                <th>Время создания заказа</th>
                <th>Время начала исполнения заказа</th>
                <th>Время завершения заказа</th>
                <th>Расстояние</th>
                <th>Цена</th>
                <th>Тариф</th>
                <th colspan=2>Действия</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orders}" var="order">
            <tr>
                <td><c:out value="${order.id}" /></td>
                <td><c:out value="${order.creatingOrder}" /></td>
                <td><c:out value="${order.startExecutionOrder}" /></td>
                <td><c:out value="${order.closingOrder}" /></td>
                <td><c:out value="${order.distance}" /></td>
                <td><c:out value="${order.cost}" /></td>
                <td><c:out value="${order.tariffName}" /></td>
                <td><a class="btn btn-primary" href="orderActions?action=edit&orderId=<c:out value="${order.id}"/>" role="button">Редактировать</a></td>
                <td><a class="btn btn-primary" href="orderActions?action=delete&orderId=<c:out value="${order.id}"/>" role="button">Удалить</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="orderActions?action=insert" class="btn btn-primary btn btn-block" role="button" aria-pressed="true">Добавить заказ</a>
    </div>

</main><!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery-3.3.1.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="js/jquery-3.3.1.js"><\/script>')</script>
<script src="bootstrap-4.1.0/assets/js/vendor/popper.min.js"></script>
<script src="bootstrap-4.1.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
