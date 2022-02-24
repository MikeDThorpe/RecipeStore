package com.example.recipestore;

import com.example.recipestore.models.MealPlan;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class MealPlanDAO {

    public MealPlan getMealPlan(long id) {
        Transaction transaction = null;
        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Optional<MealPlan> mealPlan = session.createQuery(
                    "FROM MealPlan m LEFT JOIN FETCH m.recipes r WHERE m.meal_plan_id = " + id, MealPlan.class).stream().findFirst();
            return mealPlan.orElse(null);
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    public void saveMealPlan(MealPlan mealPlanToSave){
        Transaction transaction = null;
        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(mealPlanToSave);
            transaction.commit();
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<MealPlan> getAllMealPlans(){
        Transaction transaction = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            List<MealPlan> mealPlans = session.createQuery("FROM MealPlan m", MealPlan.class).getResultList();
            transaction.commit();
            return mealPlans;
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

}
