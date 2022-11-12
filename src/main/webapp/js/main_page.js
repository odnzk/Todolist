document.addEventListener('DOMContentLoaded', function (url) {

    const btnAdd = document.getElementById('addProject');
    const btnClear = document.getElementById('clearAll');

    function addProject() {
        $('#addProjectModal').modal('show')
    }

    function clearAllProjects() {
        $('#clearAllModal').modal('show');
    }

    function updateProjectItem(checkbox) {
        const id = checkbox.classList.item(checkbox.classList.length - 1)
        document.location = '${pageContext.request.contextPath}/updateProjectItem?id=' + id;
    }

    if (btnAdd) {
        btnAdd.addEventListener('click', addProject);
    }
    if (btnClear) {
        btnClear.addEventListener('click', clearAllProjects)
    }

    Array.prototype
        .slice
        .call(document.getElementsByClassName('checkbox-project-item')).forEach(cb => {
        cb.addEventListener('click', function () {
            updateProjectItem(cb);
        })
    })
});
