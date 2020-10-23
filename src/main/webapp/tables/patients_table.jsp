<%@ page import="com.restdemo.dto.PatientDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: karol
  Date: 23.10.2020
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h4>Table of patients: </h4><br><br>
<div class="row justify-content-start">
    <div class="col-4">
        <input type="text" class="form-control" id="searchInputTableOfPatients" onkeyup="myFunction()"
               placeholder="Search by patient name...">
    </div>
</div>
<br><br>
<table id="patientsTable" class="table table-striped" cellspacing="0" width="100%">
    <thead class="th-sm">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">PESEL</th>
        <th scope="col">Address</th>
        <th scope="col">Doctor</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <% int i = 0; %>
    <% for (PatientDto patient : patients) { %>
    <% i++; %>
    <tr>
        <th scope="row"><%=i%>
        </th>
        <td><%=patient.getName()%> <%=patient.getLastName()%>
        </td>
        <td><%=patient.getPesel()%>
        </td>
        <td><%=patient.getAddress().getCity()%>
            , <%=patient.getAddress().getStreet()%> <%=patient.getAddress().getStreetNr()%>
        </td>
        <% if (patient.getDoctor() == null) { %>
        <td>Doctor not set</td>
        <% } else { %>
        <td><%=patient.getDoctor().getName()%> <%=patient.getDoctor().getLastName()%>
        </td>
        <% } %>
        <td>
            <button type="button" class="btn btn-outline-warning">Edit</button>
            <button type="button" class="btn btn-outline-danger">Delete</button>
        </td>
    </tr>
    <% } %>
    </tbody>

</table>

<script>
    function myFunction() {
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("searchInputTableOfPatients");
        filter = input.value.toUpperCase();
        table = document.getElementById("patientsTable");
        tr = table.getElementsByTagName("tr");

        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>