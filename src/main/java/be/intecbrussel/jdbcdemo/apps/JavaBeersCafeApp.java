package be.intecbrussel.jdbcdemo.apps;

import be.intecbrussel.jdbcdemo.data.BeerDao;
import be.intecbrussel.jdbcdemo.data.BeerDaoJdbcImpl;
import be.intecbrussel.jdbcdemo.data.BeerDaoJpaImpl;
import be.intecbrussel.jdbcdemo.data.BeerDaoListImpl;
import be.intecbrussel.jdbcdemo.model.Beer;

import java.util.ArrayList;
import java.util.List;

public class JavaBeersCafeApp {



    public static void main(String[] args){



        BeerDao beerDao = new BeerDaoJpaImpl();
        Beer beer = beerDao.readBeer(1501);
        beer.getBrewer().getBeerList().stream().forEach(System.out::println);
    }


}
