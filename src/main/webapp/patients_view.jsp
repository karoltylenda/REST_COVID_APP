<%--
  Created by IntelliJ IDEA.
  User: karol
  Date: 23.10.2020
  Time: 10:42
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
<% List<PatientDto> patients = (List<PatientDto>) request.getAttribute("patients"); %>
<div class="container-fluid">
    <%@include file="/tables/patients_table.jsp"%>
</div>

</body>
</html>
