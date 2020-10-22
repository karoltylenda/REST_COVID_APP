<%@ page import="java.util.List" %>
<%@ page import="com.restdemo.dto.DoctorDto" %>
<%@ page import="com.restdemo.dto.AddressDto" %>
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
<% List<AddressDto> addresses = (List<AddressDto>) request.getAttribute("addresses"); %>
<div class="container-fluid">
    <h3>Add new patient form:</h3><br><br>

    <form method="post" action="${pageContext.request.contextPath}/addNewPatient">
        <div class="row justify-content-start">
            <div class="col-4">
                <input type="text" name="name" class="form-control" placeholder="Name" aria-label="name" required>
            </div>
            <div class="col-4">
                <input type="text" name="lastName" class="form-control" placeholder="Lastname" aria-label="lastName" required>
            </div>
        </div><br>
        <div class="row justify-content-start">
            <div class="col-4">
                <input type="text" name="pesel" class="form-control" placeholder="PESEL" aria-label="pesel" required>
            </div>
        </div><br>
        <div class="row justify-content-start">
            <div class="col-1">
                <label>Select doctor: </label>
            </div >
            <div class="col-3">
                <select name="doctorId" class="form-control">
                    <% for (DoctorDto doctor: doctors) { %>
                    <option value="<%=doctor.getId()%>"><%=doctor.getLastName()%> <%=doctor.getName()%></option>
                <% } %>
                </select>
            </div>
            <div class="col-4">
                <a href="addNewDoctor"><button type="button" class="btn btn-primary">Add new doctor</button></a>
            </div>
        </div><br>

        <div class="row justify-content-start">
            <div class="col-1">
                <label>Select address: </label>
            </div >
            <div class="col-3">
                <select name="addressId" class="form-control">
                    <% for (AddressDto address: addresses) { %>
                    <option value="<%=address.getId()%>"><%=address.getCity()%>, <%=address.getStreet()%> <%=address.getStreetNr()%></option>
                    <% } %>
                </select>
            </div>
            <div class="col-4">
                <a href="addNewAddress.jsp"><button type="button" class="btn btn-primary">Add new address</button></a>
            </div>
        </div><br>

        <div class="row justify-content-start">
            <div class="col-4">
                <button type="submit" class="btn btn-primary">Add new patient</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
