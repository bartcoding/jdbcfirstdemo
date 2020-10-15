package be.intecbrussel.jdbcdemo.data;

import be.intecbrussel.jdbcdemo.model.Beer;

import java.sql.*;

public class BeerDaoJdbcImpl implements BeerDao {

    public static final String CONNECTIONSTRING = "jdbc:mysql://localhost:3306/beersdb";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    @Override
    public void createBeer(Beer beer) {

        try (Connection connection = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, PASSWORD)) {
            // ask for a statement
            PreparedStatement statement = connection.prepareStatement("insert into beers(name,alcohol,Price,Stock) value (?,?,?,? )");
            statement.setString(1,beer.getBeerName());
            statement.setDouble(2,beer.getAlcoholPercentage());
            statement.setDouble(3,beer.getPrice());
            statement.setInt(4,beer.getStock());
            //use this statement to execute a query
            statement.execute();
            // do database things
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Beer readBeer(int beerId) {
        return null;
    }

    @Override
    public Beer readBeer(String beerName) {
        return null;
    }

    @Override
    public void updateBeer(Beer beer) {

    }

    @Override
    public void deleteBeer(Beer beer) {

    }
}
