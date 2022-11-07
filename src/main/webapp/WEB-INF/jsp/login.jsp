<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="Login">

    <div class="d-flex justify-content-center">


        <form method="post" action="login" class="w-50 p-5">
            <h1>Login</h1>
            <br>

            <c:if test="${message != null}"><h2>${message}</h2></c:if>

            <div>
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" name="username" id="username"
                       placeholder="Enter username" required>
            </div>

            <div class="mb-3">
                <label class="form-label" for="password">Password</label>
                <input class="form-control" placeholder="Enter password" type="password" name="password" id="password"
                       required>
            </div>

            <input class="btn btn-primary" type="submit" value="Log in">

        </form>
    </div>
</t:mainLayout>
