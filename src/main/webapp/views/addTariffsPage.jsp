<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Добавление заказа</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-4.1.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bootstrap-4.1.0/starter-template.css" rel="stylesheet">

    <script src="js/maskedinput.js" type="text/javascript"></script>
    <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
    <script src="js/jquery.maskedinput.js" type="text/javascript"></script>
</head>

<body onload="createMask()">

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="http://localhost:8080">Такси</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/orderActions">Заказы</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Тарифы</a>
            </li>

        </ul>
    </div>
</nav>

<main role="main" class="container">

    <form method="POST" action='orderActions' name="addOrder">
    <div class="form-group">
        <label for="orderId" class="col-xs-2 col-form-label">Номер заказа</label>
        <input class="form-control" type="number" id="orderId" name="orderId" value="<c:out value="${order.id}" />">
    </div>
    <div class="form-group">
        <label for="creatingOrder" class="col-xs-2 col-form-label">Время создания заказа</label>
        <input class="form-control" type="text" id="creatingOrder" name="creatingOrder" value="<c:out value="${order.creatingOrder}" />">
    </div>
    <div class="form-group">
        <label for="startExecutionOrder" class="col-xs-2 col-form-label">Время начала исполнения заказа</label>
        <input class="form-control" type="text" id="startExecutionOrder" name="startExecutionOrder" value="<c:out value="${order.startExecutionOrder}" />">
    </div>
    <div class="form-group">
        <label for="closingOrder" class="col-xs-2 col-form-label">Время завершения заказа</label>
        <input class="form-control" type="text" id="closingOrder" name="closingOrder" value="<c:out value="${order.closingOrder}" />">
    </div>
    <div class="form-group">
        <label for="distance" class="col-xs-2 col-form-label">Расстояние</label>
        <input class="form-control" type="number" id="distance" name="distance" value="<c:out value="${order.distance}" />">
    </div>
    <div class="form-group">
        <label for="tariffName" class="col-xs-2 col-form-label">Тариф</label>
        <select name="tariffName" id="tariffName">
            <option value="${order.tariffName}"><c:out value="${order.tariffName}" /></option>
            <c:forEach items="${tariffs}" var="tariff">
                <c:if test="${tariff.tariffName != order.tariffName}">
                    <option value="${tariff.tariffName}"><c:out value="${tariff.tariffName}" /></option>
                </c:if>
            </c:forEach>
        </select>
    </div>
        <input class="btn btn-primary btn-lg btn-block" type="submit" value="Submit">
    </form>

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
