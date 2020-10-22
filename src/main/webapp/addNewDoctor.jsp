<%@ page import="com.restdemo.dto.AddressDto" %>
<%@ page import="java.util.List" %>
<%@ page import="com.restdemo.dto.PatientDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>COVID App :P</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<% List<AddressDto> addresses = (List<AddressDto>) request.getAttribute("addresses"); %>
<% List<PatientDto> patients = (List<PatientDto>) request.getAttribute("patients"); %>
<div class="container-fluid">
    <h3>Add new doctor form:</h3><br><br>

    <form method="post" action="${pageContext.request.contextPath}/addNewDoctor">
        <div class="row justify-content-start">
            <div class="col-4">
                <input type="text" name="name" class="form-control" placeholder="Name" aria-label="name">
            </div>
            <div class="col-4">
                <input type="text" name="lastName" class="form-control" placeholder="Lastname" aria-label="LastName">
            </div>
        </div><br>
        <div class="row justify-content-start">
            <div class="col-4">
                <input type="text" name="pesel" class="form-control" placeholder="PESEL" aria-label="pesel">
            </div>
            <input type="text" name="isDoctor" value="true" hidden>
        </div><br>

        <!-- list of patients -->
        <div class="row justify-content-start">
            <div class="col-4">
                <select multiple class="form-control" name="patients">
                    <% for (PatientDto patient: patients) { %>
                        <option><%=patient.getLastName()%> <%=patient.getName()%>, PESEL nr: <%=patient.getPesel()%></option>
                    <% } %>
                </select>
            </div>
            <div class="col-4">
                <a href="addNewPatient"><button type="button" class="btn btn-primary">Add new patient</button></a>
            </div>
        </div><br>

        <!-- list of addresses -->
        <div class="row justify-content-start">
            <div class="col-4">
                <select class="form-control" name="addressId">
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
                <button type="submit" class="btn btn-primary">Add new doctor</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
