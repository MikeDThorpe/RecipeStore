package com.example.recipestore;

import com.example.recipestore.models.Instruction;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InstructionDAO {

    public void saveInstruction(Instruction newInstruction){
        Transaction transaction = null;
        try (Session session = hibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(newInstruction);
            transaction.commit();
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
