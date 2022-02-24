<%--
  Created by IntelliJ IDEA.
  User: michaelthorpe
  Date: 23/02/2022
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Create New Recipe</title>
</head>
<body class="bg-light">
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
<main class="container">
    <h2>Create a new recipe</h2>
    <form action="${pageContext.request.contextPath}/recipes/new" method="POST">
        <div class="row">
            <div class="form-group col">
                <label for="title">Title</label>
                <input type="text" class="form-control" name="title" id="title">
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                <label for="category">Category</label>
                    <select class="custom-select" name="category" id="category" required>
                        <option value="" selected>Select category</option>
                        <option value="meat">Meat</option>
                        <option value="seafood">Seafood</option>
                        <option value="vegetarian">Vegetarian</option>
                        <option value="vegan">Vegan</option>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="prep_time">Prep time</label>
                    <select class="custom-select" name="prep_time" id="prep_time" required>
                        <option value="" selected>Select prep time</option>
                        <option value="5">5 minutes</option>
                        <option value="10">10 minutes</option>
                        <option value="15">15 minutes</option>
                        <option value="30">30 minutes</option>
                        <option value="60">60 minutes</option>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="cook_time">Cook time</label>
                    <select class="custom-select" name="cook_time" id="cook_time" required>
                        <option value="" selected>Select cook time</option>
                        <option value="15">15 minutes</option>
                        <option value="30">30 minutes</option>
                        <option value="60">60 minutes</option>
                        <option value="90">90 minutes</option>
                        <option value="120">120 minutes</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col">
                <label for="description">Description</label>
                <textarea name="description" id="description" rows="5" class="form-control" required></textarea>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label for="ingredients">Ingredients</label>
                <textarea rows="10" id="ingredients" name="ingredients" class="form-control" required></textarea>
            </div>
            <div class="form-group col-md-8">
                <label for="instructions">Instructions</label>
                <textarea name="instructions" id="instructions" rows="10" class="form-control" required></textarea>
            </div>
        </div>
        <button class="btn btn-success w-100" type="submit">Save</button>
    </form>

</main>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
