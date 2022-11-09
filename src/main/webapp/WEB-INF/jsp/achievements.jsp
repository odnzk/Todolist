<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="Achievements">
    <div class="d-container-fluid p-3">
        <h1>Achievements</h1>

        <c:forEach var="category" items="${requestScope.get('categories')}">
            <h3>Category: ${category}</h3>
            <div class="card" style="width: 100%">
                <ul class="list-group list-group-flush">
                    <c:forEach var="uiAchiv" items="${requestScope.get('uiAchievements')}">
                        <c:if test="${uiAchiv.achievement.category.equals(category)}">
                            <li class="list-group-item d-flex <c:if test="${!uiAchiv.unlocked}">disabled</c:if>">
                                <i class="bi bi-award-fill"></i>
                                <p>${uiAchiv.achievement.title}</p>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
            </div>
            <br>
        </c:forEach>
    </div>

</t:mainLayout>
