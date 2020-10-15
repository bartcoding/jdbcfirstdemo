package be.intecbrussel.jdbcdemo.apps;

import be.intecbrussel.jdbcdemo.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.jdbcdemo.model.Beer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Scanner;

public class JpaSandboxApp {

    public static void main(String[] args) {

        EntityManagerFactory emf = EntityManagerFactoryProvider.getInstance().getEmf();
        EntityManager entityManager = null;
        try{
            entityManager = emf.createEntityManager();
            Beer beer = entityManager.find(Beer.class,1563);
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            beer.setBeerName("sandbeer 2");
            transaction.commit();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            if (entityManager != null){
                entityManager.close();
            }
        }


    }
}
