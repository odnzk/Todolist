<%@tag description="Default Tag" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="projectId" %>

<form method="post" action="addItem" class="">
    <input type="text" class="invisible" name="projectId" value="${projectId}">
    <div>
        <input type="text" class="form-control" name="projectItemTitle" id="projectItemTitle"
               placeholder="Enter new project item" required>
    </div>
    <input class="btn btn-primary" type="submit" value="Add">
</form>
