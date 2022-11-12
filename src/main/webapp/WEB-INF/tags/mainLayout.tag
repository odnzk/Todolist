<%@tag description="Default Layout Tag" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="title" %>
<%@attribute name="jsFiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>${title}</title>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/style/bootstrap.min.css"/>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

    <c:forTokens items="${jsFiles}" delims=", " var="file">
        <script defer src="<c:url value="/js/${file}"/>"></script>
    </c:forTokens>
</head>
<body>

<div class="d-container-inline-fluid">
    <jsp:include page="/WEB-INF/parts/nav_menu.jsp"/>
</div>

<jsp:doBody/>

</body>
</html>
