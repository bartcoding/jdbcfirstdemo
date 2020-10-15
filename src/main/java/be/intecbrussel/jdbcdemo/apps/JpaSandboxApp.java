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
            //find the beer in the database
            //put it in the persistence context
            Beer beer = entityManager.find(Beer.class,1563);
            //start a transaction
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            //change the name of the beer
            beer.setBeerName("sandbeer 2");
            //if we commit the transaction now, the beername will be changed in the db
            //we detach the beer
            entityManager.detach(beer);

            //attach the beer to the persistence context
            //you do this by creating a new beer object
            //this new beer object has the same
            //property content as the original beer object
            Beer newBeer = entityManager.merge(beer);
            //we change the beername yet again
            newBeer.setBeerName("I am attached to this persistence context!");
            //commit to your transaction
            //flush data to db
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
