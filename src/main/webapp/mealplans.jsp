<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Recipes</title>
</head>
<body style="min-height: 100vh" class="bg-light">
<header class="fixed-top">
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
<main class="container">
    <h1 class="text-center py-5">Meal Plans</h1>
    <table class="table table-striped table-advance table-hover">
        <thead class="thead-light">
        <tr>
            <th><strong>#</strong></th>
            <th scope="col">Title</th>
            <th scope="col">Start Date</th>
            <th scope="col">End date</th>
            <th scope="col">Exclusions</th>
            <th scope="col">Duration</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <form class="py-5" method="post" action="/meal-plans">
            <tr>
                <th></th>
                <td>
                    <input type="text" name="title" id="title" class="form-control" placeholder="Meal plan title" required>
                </td>
                <td>
                    <input type="date" class="form-control" name="start_date" id="start_date" />
                </td>
                <td>
                    <input type="date" class="form-control" name="end_date" id="end_date" />
                </td>
                <td>
                    <select class="custom-select" name="exclusions" id="exclusions" required>
                        <option value="none">No exclusions</option>
                        <option value="meat">Meat recipes</option>
                        <option value="seafood">Seafood recipes</option>
                        <option value="vegetarian">Vegetarian recipes</option>
                        <option value="vegan">Vegan recipes</option>
                    </select>
                </td>
                <td></td>
                <td>
                    <button class="btn btn-success w-100" type="submit">Generate</button>
                </td>
            </tr>
        </form>
        <c:forEach var="mealplan" items="${mealplans}">
            <tr>
                <th scope="row">${mealplans.indexOf(mealplan) + 1}</th>
                <td>${mealplan.title}</td>
                <td>${mealplan.startDate}</td>
                <td>${mealplan.endDate}</td>
                <c:if test="${mealplan.exclusions eq 'none'}">
                    <td>No exclusions apply</td>
                </c:if>
                <c:if test="${mealplan.exclusions ne 'none'}">
                    <td>Excludes ${mealplan.exclusions} recipes</td>
                </c:if>
                <td>
                        ${mealplan.duration}
                    <c:if test="${mealplan.duration == 1}">
                        day
                    </c:if>
                            <c:if test="${mealplan.duration > 1}">
                                days
                            </c:if>
                </td>
                <td><a href="/meal-plans/${mealplan.meal_plan_id}"><button class="btn btn-info w-100">Manage</button></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
