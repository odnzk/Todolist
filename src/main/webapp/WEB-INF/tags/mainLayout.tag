<%@tag description="Default Layout Tag" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="title" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>${title}</title>

<%--    <!-- Latest compiled and minified CSS -->--%>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>

<%--    <!-- Optional theme -->--%>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">--%>
<%--    <!-- Latest compiled and minified JavaScript -->--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="<c:url value="/style/bootstrap.min.css"/>">
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</head>
<body>

<div class="d-container-inline-fluid">
    <jsp:include page="/WEB-INF/parts/nav_menu.jsp"/>
</div>

<jsp:doBody/>

</body>
</html>
