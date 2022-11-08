<%@ page import="model.ui.UiProjectWithItems" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="model.ui.UiProjectWithItems" %>
<%@ page import="java.util.List" %>


<t:mainLayout title="Home">
    <script>
        document.addEventListener('DOMContentLoaded', function (url) {
            let btnAdd = document.getElementById('addProject');
            let btnClear = document.getElementById('clearAll');

            function addProject() {
                $('#addModal').modal('show');
            }
            function clearAllProjects() {
                $('#clearAllModal').modal('show');
            }

            if (btnAdd) {
                btnAdd.addEventListener('click', addProject);
            }
            if(btnClear){
                btnClear.addEventListener('click', clearAllProjects)
            }
        });</script>

    <!-- MODALS -->
    <jsp:include page="/WEB-INF/parts/modal_add.jsp"/>
    <jsp:include page="/WEB-INF/parts/modal_clear_all.jsp"/>

    <!--HEADER-->
    <div class="d-container-fluid p-3 mt-2">

        <h3><b>List of projects</b></h3>
        <div class="d-flex justify-content-end">
            <button id="addProject" type="button" class="btn btn-primary pl-24 pr-24  mr-1">Add project</button>
            <button id="clearAll" type="button" class="btn btn-primary pl-24 pr-24">Clear all</button>
        </div>
    </div>

    <!--LIST OF PROJECTS-->
    <div class="container-fluid p-3 d-flex flex-wrap">

        <c:set var="uiProjects" value="${requestScope.get('uiProjects')}"/>

        <c:forEach var="uiProject" items="${uiProjects}">
            <div class="card mt-2" style="width: 20rem; ">
                <div class="card-body">

                    <h5 class="card-title">${uiProject.project.title}</h5>
                    <p>Progress: ${uiProject.progress}</p>

                    <div class="progress">
                        <div class="progress-bar progress-bar-striped" role="progressbar"
                             style="width: ${uiProject.progress}%" aria-valuenow="${uiProject.progress}"
                             aria-valuemin="0" aria-valuemax="100"></div>
                    </div>

                    </br>
                    <ul class="list-group">
                        <c:forEach var="uiProjectItem" items="${uiProject.listProjectItem}">
                            <li class="list-group-item">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="">
                                    <label class="form-check-label">
                                            ${uiProjectItem.title}
                                    </label>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </c:forEach>
    </div>
</t:mainLayout>
