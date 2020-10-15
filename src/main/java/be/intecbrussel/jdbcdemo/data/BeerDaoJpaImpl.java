package be.intecbrussel.jdbcdemo.data;

import be.intecbrussel.jdbcdemo.data.utils.EntityManagerFactoryProvider;
import be.intecbrussel.jdbcdemo.model.Beer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class BeerDaoJpaImpl implements BeerDao {
private EntityManagerFactory emf= EntityManagerFactoryProvider.getInstance().getEmf();
//create beer using jpa persist
    @Override
    public void createBeer(Beer beer) {
    EntityManager entityManager =null;
    try{
        entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(beer);
        transaction.commit();
    }
        catch (Exception ex){
        ex.printStackTrace();
        }
        finally {
        if (entityManager !=null){
            entityManager.close();
        }
    }

    }
//read beer using jpa find
    @Override
    public Beer readBeer(int beerId) {
        Beer beer = null;
        EntityManager entityManager =null;
        try{
            entityManager = emf.createEntityManager();
            beer = entityManager.find(Beer.class,beerId);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return beer;
    }

    //skip for now
    @Override
    public Beer readBeer(String beerName) {
        return null;
    }
//skip for now
    @Override
    public void updateBeer(Beer beer) {

    }
//skip for now
    @Override
    public void deleteBeer(Beer beer) {

    }
}
