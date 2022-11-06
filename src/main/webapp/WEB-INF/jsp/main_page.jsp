<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="Home">
<!--NAV-->
<div class="d-container-inline-fluid"> <jsp:include page="nav_menu.jsp" /></div>

<%--<div class="p-3">cwjoeij</div>--%>
<!--HEADER-->
<div class="d-container-fluid p-3 mt-2">
    <h3><b>List of projects</b></h3>
    <div class="d-flex justify-content-end">
        <button type="button" class="btn btn-primary pl-24 pr-24  mr-1">Add</button>
        <button type="button" class="btn btn-primary pl-24 pr-24"><i class="fa fa-trash"></i></button>
    </div>
</div>

<!--LIST OF PROJECTS-->
<div class="container-fluid p-3">
    <div class="card" style="width: 20rem; ">
        <div class="card-body">
            <h5 class="card-title">WeatherApp</h5>

            <div class="progress">
                <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
            </br>
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="">
                        <label class="form-check-label">
                           Swipe to refresh
                        </label>
                    </div>
                </li>
                <li class="list-group-item">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="">
                        <label class="form-check-label" >
                            Recycler view animations and homework
                        </label>
                    </div>
                </li>
                <li class="list-group-item"><div class="form-check">
                    <input class="form-check-input" type="checkbox" value="">
                    <label class="form-check-label">
                        Swipe to refresh
                    </label>
                </div></li>
                <li class="list-group-item"><div class="form-check">
                    <input class="form-check-input" type="checkbox" value="">
                    <label class="form-check-label">
                        Swipe to refresh
                    </label>
                </div></li>
            </ul>
        </div>
    </div>
</div>
</t:mainLayout>
