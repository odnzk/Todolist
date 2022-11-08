<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="Profile">
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            let btn = document.getElementById('logOut');
            function logOut() {
                if (confirm('Are you sure you want to log out?')) {
                    window.location.replace('http://localhost:9090/SemesterProject/logout');
                }
            }

            if (btn) {
                btn.addEventListener('click', logOut);
            }
        });</script>

    <div class="d-container-fluid d-flex w-50 p-3">
        <div class="profile-info">
            <h2>Profile</h2>
            <div class="field">
                <b>Username:</b> <p>${requestScope.get("username")}</p>
            </div>
            <div class="field">
                <b>Email:</b> <p>${requestScope.get("email")}</p>
            </div>
            <br>
            <a>
                <button type="submit" id="logOut" class="btn btn-primary">Log out</button>
            </a>
            <br>
        </div>
    </div>
</t:mainLayout>
