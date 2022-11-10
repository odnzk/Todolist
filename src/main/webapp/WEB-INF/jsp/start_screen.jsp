<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="Start page">
    <div class="d-flex justify-content-center align-items-center p-5">
        <div id="carouselExampleCaptions" class="carousel slide w-50" data-bs-ride="false">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="<c:url value='/static/pic_slider.jpg'/>" class="d-block w-100" alt="First slider item">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Organize your life</h5>
                        <p>This application will help you to track your project smarted and easier</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="<c:url value='/static/pic_login.jpg'/>" class="d-block w-100" alt="Second slider item">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Plan and attain goals</h5>
                        <p>Plan and attain goals to make your life better</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="<c:url value='/static/pic_signup.jpg'/>" class="d-block w-100" alt="Last slider item">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Track your life</h5>
                        <p>Some representative placeholder content for the third slide</p>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
</t:mainLayout>
