<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%! String mes = ""; %>

<t:mainLayout title="Sign up">
    <div class="d-flex align-items-center">

    <div class="d-flex w-50">
        <form method="post" action="signup" class="p-5 w-100">
            <h1>Signup</h1>
            <br>

            <c:if test="${requestScope.get('message') != null}"><h2>${requestScope.get('message')}</h2></c:if>

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
                <input class="form-control" type="password" name="password" maxlength=20" minlength="8" id="password"
                       required  placeholder="Enter password">
                <div id="passwordHelpBlock" class="form-text">
                    Your password must be 8-20 characters long, contain letters and numbers, and must not contain
                    spaces,
                    special characters, or emoji.
                </div>
            </div>

            <div class="mb-3 form-check">
                <label class="form-check-label" for="agreement">Agree with user agreement</label>
                <input class="form-check-input" type="checkbox" name="agreement" id="agreement" required>
            </div>

            <input class="btn btn-primary" type="submit" value="Sign up">

        </form>
    </div>

        <div class="w-50">
            <img class="w-100" src="<c:url value='/static/pic_signup.jpg'/>">
        </div>
    </div>
</t:mainLayout>
