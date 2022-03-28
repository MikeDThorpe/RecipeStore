<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Recipes</title>
</head>
<body style="min-height: 100vh" class="bg-light">
<header>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/recipes">Recipes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/meal-plans">Meal Plans</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>
<c:if test="${errorMessage ne null}">
<div class="fixed-top alert alert-danger alert-dismissible fade show" role="alert">
${errorMessage}
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
</c:if>
<c:if test="${successMessage ne null}">
    <div class="fixed-top alert alert-success alert-dismissible fade show" role="alert">
            ${successMessage}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
<c:if test="${warningMessage ne null}">
    <div class="fixed-top alert alert-warning alert-dismissible fade show" role="alert">
            ${warningMessage}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</c:if>
<main class="container">
    <h1 class="text-center mb-5">Recipes</h1>
    <table class="table table-striped table-advance table-hover">
        <thead class="thead-light">
        <tr>
            <th><strong>#</strong></th>
            <th scope="col">Title</th>
            <th scope="col">Category</th>
            <th scope="col">Cook Time</th>
            <th scope="col">Prep Time</th>
            <th><a href="${pageContext.request.contextPath}/recipes/new"><button class="btn btn-success w-100">Add recipe</button></a></th>
        </tr>
        </thead>
        <tbody>
        <%--print out the data for each recipe--%>
        <c:if test="${requestScope.recipes.size() > 0}">
            <c:forEach var="recipe" items="${recipes}">
                <tr>
                    <th scope="row">${recipes.indexOf(recipe) + 1}</th>
                    <td>${recipe.title}</td>
                    <td>${recipe.category}</td>
                    <td>${recipe.prep_time} minutes</td>
                    <td>${recipe.cook_time} minutes</td>
                    <td><a href="/recipes/${recipe.recipe_id}"><button class="btn btn-info w-100">Manage</button></a></td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <form action="/logout" method="POST">
        <button type="submit">Logout</button>
    </form>
</main>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>