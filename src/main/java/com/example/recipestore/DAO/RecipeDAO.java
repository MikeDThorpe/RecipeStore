package com.example.recipestore.DAO;

import com.example.recipestore.hibernateUtil;
import com.example.recipestore.models.Recipe;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class RecipeDAO {

    public Recipe getRecipe(Long id) {
        Transaction transaction = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            // look at intellij feature for writing hibernate queries
           Optional<Recipe> recipe = session.createQuery("FROM Recipe r WHERE recipe_id = " + id, Recipe.class)
                   .stream().findFirst();
            return recipe.orElse(null);
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public void saveRecipe(Recipe recipeToSave) throws SQLException {
        Transaction transaction = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(recipeToSave);
            transaction.commit();
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateRecipe(Recipe recipeToUpdate) {
        Transaction transaction = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(recipeToUpdate);
            transaction.commit();
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Recipe> getAllRecipes() {
        Transaction transaction = null;
        List<Recipe> recipes = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            recipes = session.createQuery("From Recipe r", Recipe.class).getResultList();
            transaction.commit();
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return recipes;
    }

    public void deleteRecipe(Long id){
        Transaction transaction = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.createQuery("FROM Recipe DELETE WHERE Recipe.id = " + id, Recipe.class).getResultList();
            transaction.commit();
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
