package com.example.recipestore;

import com.example.recipestore.models.Ingredient;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IngredientDAO {

    public void saveIngredient(Ingredient newIngredient){
        Transaction transaction = null;
        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(newIngredient);
            transaction.commit();
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
