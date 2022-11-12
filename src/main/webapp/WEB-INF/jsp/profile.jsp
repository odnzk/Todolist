<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="Profile" jsFiles="profile.js">
    <div class="d-container-fluid d-flex w-100 p-3">
        <form method="post" action="updateUser" class="w-50 p-5">
            <h1>Profile</h1>
            <br>

            <c:if test="${requestScope.get('message') != null}"><h2>${requestScope.get('message')}</h2></c:if>

            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Username</span>
                <input type="text" class="form-control"
                       placeholder="${requestScope.get('username')}"
                       value="${requestScope.get('username')}"
                       maxlength="25" name="username"
                       aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon2">Email</span>
                <input type="text" class="form-control"
                       aria-label="Email" aria-describedby="basic-addon1"
                       placeholder="${requestScope.get('email')}"
                       value="${requestScope.get('email')}"
                       name="email" maxlength=30">
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon3">Password</span>
                <input type="password" class="form-control"
                       aria-label="Email" aria-describedby="basic-addon3"
                       name="password" maxlength="30" disabled
                       placeholder="${requestScope.get('password')}" value="${requestScope.get('password')}">
            </div>

            <input class="btn btn-primary w-100" type="submit" value="Change profile data">
            <br><br>
            <button class="btn btn-primary w-100" id="logout">Logout</button>
        </form>
    </div>
</t:mainLayout>
