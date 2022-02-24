<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michaelthorpe
  Date: 08/02/2022
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <title>${requestScope.recipe.title}</title>
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
        <h1 class="mb-3 text-center">${requestScope.recipe.title}</h1>
        <div class="d-flex justify-content-center">
            <p class="m-0">A ${requestScope.recipe.category} recipe</p>
            <div class="vr mx-3"></div>
            <p class="m-0">${requestScope.recipe.prep_time} minutes to prepare</p>
            <div class="vr mx-3"></div>
            <p class="m-0">${requestScope.recipe.cook_time} minutes to cook</p>
        </div>
        <hr class="my-5"/>
        <section class="d-flex">
            <%--recipe data--%>
            <div class="col-4">
                <div>
                    <h3 class="mb-3">About this recipe</h3>
                    <hr class="my-4" />
                    <div>
                        ${requestScope.recipe.description}
                    </div>
                </div>
                <div>
                    <h3 class="mt-4">Ingredients</h3>
                    <hr class="my-4 mb-3" />
                    <div>
                        <p>
                            ${requestScope.recipe.ingredients}
                        </p>
                    </div>
                </div>
            </div>
            <%--divider--%>
                <div class="vr mx-4 col-1"></div>
            <%--recipe instructions--%>
            <div class="col-7">
                <h3 class="mb-3">Instructions</h3>
                <hr class="my-4" />
                <div>
                    <p>
                        ${requestScope.recipe.instructions}
                    </p>
                </div>
            </div>
        </section>
    </main>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>


<%--
400g prawns
200g pasta
1 lemon
1 onion
salt & pepper
75g parmesan
1 cup peas
75ml white wine
1l vegetable stock
--%>
<%--
1) finely slice the onion and fry gentle with the garlic for 5 minutes
2) add the risotto rice and mix with the onion and garlic
3) deglaze the pan with the white wine a cook for 2 minutes on a high heat
--%>