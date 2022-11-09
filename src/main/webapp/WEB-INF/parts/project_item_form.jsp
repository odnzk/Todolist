<form method="post" action="addItem" class="">

    <div>
        <input type="text" class="form-control" name="projectItemTitle" id="projectItemTitle"
               placeholder="Enter new project item" required>
    </div>
    <input type="text" class="invisible" value="${requestScope.get('')}">
    <input class="btn btn-primary" type="submit" value="Add">
</form>
