<%@tag description="Default Layout Tag" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="uiProjectItem" type="model.ProjectItem" %>

<li class="list-group-item">
    <div class="form-check">
        <input class="form-check-input checkbox-project-item ${uiProjectItem.id}"
               type="checkbox" value=""
               <c:if test="${uiProjectItem.done}">checked</c:if>>
        <label class="form-check-label project-item-label<c:if test="${uiProjectItem.done}">completed-project-item</c:if>">
            ${uiProjectItem.title}
        </label>
        <a class="" href="${pageContext.request.contextPath}/deleteitem?id=${uiProjectItem.id}">
            <i class="bi bi-dash-square-fill float-end"></i>
        </a>
    </div>
</li>

<jsp:doBody/>

