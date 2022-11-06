<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="Login">
    <form action="login.jsp" method="post">
        <input type="text" name="username">
        <input type="password" name="password">
        <br><br>
        <input type="submit" value="Submit">
    </form>
</t:mainLayout>
