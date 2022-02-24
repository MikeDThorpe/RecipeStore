package com.example.recipestore;

import com.example.recipestore.models.Ingredient;
import com.example.recipestore.models.Instruction;
import com.example.recipestore.models.MealPlan;
import com.example.recipestore.models.Recipe;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class hibernateUtil {

    public static SessionFactory sessionFactory;

    // private constructor to prevent multiple instances being created
    private hibernateUtil(){}

    public static synchronized SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try{
                Configuration configuration = new Configuration();

                // set hibernate settings
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/recipe_store?autoReconnect=true&useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "pass");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(Environment.SHOW_SQL, "false");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Recipe.class);
                configuration.addAnnotatedClass(MealPlan.class);
                configuration.addAnnotatedClass(Instruction.class);
                configuration.addAnnotatedClass(Ingredient.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
