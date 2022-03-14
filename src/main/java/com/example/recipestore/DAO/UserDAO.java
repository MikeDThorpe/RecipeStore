package com.example.recipestore.DAO;

import com.example.recipestore.hibernateUtil;
import com.example.recipestore.models.user.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {

    public boolean registerNewUser(User newUser){
        Transaction transaction = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            // look at intellij feature for writing hibernate queries
            boolean usernameExists = authenticateUser(newUser);
            if(usernameExists){
                return false;
            }
            session.save(newUser);
            transaction.commit();
            return true;
        } catch(Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean authenticateUser(User userToAuthenticate){
        Transaction transaction = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            User user = (User) session.createQuery("FROM User u WHERE u.username = :userName")
                    .setParameter("userName", userToAuthenticate.getUsername())
                    .uniqueResult();

            if(user != null) {
                return true;
            }
            transaction.commit();
        } catch(Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}
