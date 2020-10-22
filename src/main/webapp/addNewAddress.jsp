<%--
  Created by IntelliJ IDEA.
  User: karol
  Date: 22.10.2020
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>COVID App :P</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid">
        <h3>Add new address form:</h3><br><br>

        <form method="get" action="${pageContext.request.contextPath}/addNewAddress">
            <div class="row justify-content-start">
                <div class="col-3">
                    <input type="text" name="city" class="form-control" placeholder="City" aria-label="city">
                </div>
                <div class="col-3">
                    <input type="text" name="district" class="form-control" placeholder="District" aria-label="district">
                </div>
                <div class="col-2">
                    <input type="text" name="postalCode" class="form-control" placeholder="Postal Code" aria-label="postalCode">
                </div>
            </div><br>

            <div class="row justify-content-start">
                <div class="col-4">
                    <input type="text" name="street" class="form-control" placeholder="Street name" aria-label="street">
                </div>
                <div class="col-2">
                    <input type="text" name="streetNr" class="form-control" placeholder="Street number" aria-label="streetNr">
                </div>
                <div class="col-2">
                    <input type="text" name="localNr" class="form-control" placeholder="Local number" aria-label="localNr">
                </div>
            </div><br>

            <div class="row justify-content-start">
                <div class="col-4">
                    <button type="submit" class="btn btn-primary">Add new address</button>
                </div>
            </div><br>
        </form>
    </div>
</body>
</html>
