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
    <h3>Add new doctor form:</h3><br><br>

    <form method="post" action="/jjdzr11restdemo/covid/doctor/addDoctor">
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
        <div class="row justify-content-start">
            <div class="col-4">
                <button type="submit" class="btn btn-primary">Add new doctor</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
