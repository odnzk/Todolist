<%@ page import="model.ui.UiProjectWithItems" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="model.ui.UiProjectWithItems" %>
<%@ page import="java.util.List" %>


<t:mainLayout title="Home" jsFiles="main_page.js">
    <!-- MODALS -->
    <jsp:include page="/WEB-INF/parts/modal_add_project.jsp"/>
    <jsp:include page="/WEB-INF/parts/modal_clear_all.jsp"/>

    <!--HEADER-->
    <div class="d-container-fluid p-3 mt-2">

        <h3 class=""><b>List of projects</b></h3>
        <div class="d-flex justify-content-end">
            <button data-toggle="modal" data-target="#addProjectModal" id="addProject" type="button"
                    class="btn btn-primary pl-24 pr-24  mr-1"><i class="bi bi-plus"></i>
            </button>
            <button id="clearAll" type="button" class="btn btn-primary pl-24 pr-24"><i class="bi bi-trash-fill"></i>
            </button>
        </div>
    </div>

    <!--LIST OF PROJECTS-->
    <div class="container-fluid p-3 d-flex flex-wrap">

        <c:if test="${requestScope.get('isUiProjectsEmpty')}">
            <h3>There will be your projects</h3>
        </c:if>

        <c:set var="uiProjects" value="${requestScope.get('uiProjects')}"/>

        <c:forEach var="uiProject" items="${uiProjects}">
            <div class="card mt-2" style="width: 20rem;">
                <div class="card-body">

                    <a class="" href="${pageContext.request.contextPath}/delete?id=${uiProject.project.id}">
                        <i class="bi bi-x-square-fill float-end"></i>
                    </a>

                    <h5 class="card-title">${uiProject.project.title}</h5>

                    <p class=""><b>Deadline:</b> ${uiProject.project.deadlineDate}</p>

                    <div class="progress">
                        <div class="progress-bar progress-bar-striped" role="progressbar"
                             style="width: ${uiProject.progress}%" aria-valuenow="${uiProject.progress}"
                             aria-valuemin="0" aria-valuemax="100">${uiProject.progress}%
                        </div>
                    </div>

                    </br>
                    <ul class="list-group">
                        <c:forEach var="uiProjectItem" items="${uiProject.listProjectItem}">

                            <t:projectItemLayout uiProjectItem="${uiProjectItem}">
                            </t:projectItemLayout>
                        </c:forEach>
                    </ul>
                    <br>
                    <t:itemForm projectId="${uiProject.project.id}"></t:itemForm>
                </div>
            </div>
        </c:forEach>
    </div>
</t:mainLayout>
