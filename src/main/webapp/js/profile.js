document.addEventListener('DOMContentLoaded', function () {
    let btn = document.getElementById('logout');

    function logOut() {
        if (confirm('Are you sure you want to log out?')) {
            document.location = '${pageContext.request.contextPath}/logout';
        }
    }

    if (btn) {
        btn.addEventListener('click', logOut);
    }
});
