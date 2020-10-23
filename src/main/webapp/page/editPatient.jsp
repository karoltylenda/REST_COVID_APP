<%@ page import="java.util.List" %>
<%@ page import="com.restdemo.dto.DoctorDto" %>
<%@ page import="com.restdemo.model.Person" %>
<%@ page import="com.restdemo.dto.PatientDto" %><%--
  Created by IntelliJ IDEA.
  User: karol
  Date: 23.10.2020
  Time: 13:43
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
<% List<DoctorDto> doctors = (List<DoctorDto>) request.getAttribute("doctors"); %>
<% PatientDto patient = (PatientDto) request.getAttribute("patient"); %>
<div class="container-fluid">
    <br>
    <h4>Edit patient:</h4>
    <br><br>

    <form method="post" action="/jjdzr11restdemo/patients">
        <input type="text" name="patientId" value="<%=patient.getId()%>" hidden>
        <div class="row justify-content-left">
            <div class="col-3">
                <input type="text" class="form-control" name="name" value="<%=patient.getName()%>">
            </div>
        </div>
        <br>
        <div class="row justify-content-left">
            <div class="col-3">
                <input type="text" class="form-control" name="lastName" value="<%=patient.getLastName()%>">
            </div>
        </div>
        <br>
        <div class="row justify-content-left">
            <div class="col-3">
                <input type="text" class="form-control" name="pesel" value="<%=patient.getPesel()%>">
            </div>
        </div>
        <br>
        <div class="row justify-content-left">
            <div class="col-3">
                <select class="form-control" name="doctorId">
                    <% for (DoctorDto doctor : doctors) { %>
                    <% if (patient.getDoctor() != null && doctor.getId() == patient.getDoctor().getId()) { %>

                    <option value="<%=doctor.getId()%>" selected>
                        <%=doctor.getName()%> <%=doctor.getLastName()%>
                    </option>

                    <% } else { %>

                    <option value="<%=doctor.getId()%>">
                        <%=doctor.getName()%> <%=doctor.getLastName()%>
                    </option>

                    <% } %>
                    <% } %>
                </select>
            </div>
        </div><br>
        <div class="row justify-content-start">
            <div class="col-3">
                <button type="submit" class="btn btn-primary">Update patient</button>
            </div>
        </div>
    </form>
    <br><br>
</div>
</body>
</html>
