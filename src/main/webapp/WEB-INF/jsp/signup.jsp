<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign up</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body class="d-flex justify-content-center">

<form method="post" action="signUp" class="w-50 p-5">
    <div>
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control" name="username" maxlength="25" id="username"
               placeholder="Enter username" required>
    </div>

    <div class="mb-3">
        <label class="form-label" for="email">Email</label>
        <input class="form-control" type="email" name="email" maxlength=30" id="email" placeholder="Enter email"
               required>
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>


    <div class="mb-3">
        <label class="form-label" for="password">Password</label>
        <input class="form-control" type="password" name="password" maxlength=20" minlength="8" id="password" required>
        <div id="passwordHelpBlock" class="form-text">
            Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces,
            special characters, or emoji.
        </div>
    </div>

    <div class="mb-3 form-check">
        <label class="form-check-label" for="agreement">Agree with user agreement</label>
        <input class="form-check-input" type="checkbox" name="agreement" id="agreement" required>
    </div>

    <input class="btn btn-primary" type="submit" value="Submit">

</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
