<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body style="min-height: 100vh" class="bg-light">
<main class="container">
    <div class="jumbotron">
        <a class="text-center" href="${pageContext.request.contextPath}/recipes"><h4>Add Recipe</h4></a>
    </div>

</main>
</body>
</html>