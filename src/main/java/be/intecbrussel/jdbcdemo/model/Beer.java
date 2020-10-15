package be.intecbrussel.jdbcdemo.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "beers")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String beerName;
    @Column(name = "Alcohol")
    private double alcoholPercentage;
    @Column(name = "Price")
    private double price;
    @Column(name ="Stock")
    private int stock;

    @ManyToOne
    @JoinColumn(name = "BrewerId")
    private Brewer brewer;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;

    public Beer() {
    }

    public Beer(String beerName, double alcoholPercentage, double price, int stock) {
        this.beerName = beerName;
        this.alcoholPercentage = alcoholPercentage;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Brewer getBrewer() {
        return brewer;
    }

    public void setBrewer(Brewer brewer) {
        this.brewer = brewer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", beerName='" + beerName + '\'' +
                ", alcoholPercentage=" + alcoholPercentage +
                ", price=" + price +
                ", stock=" + stock +
                ", brewer=" + brewer +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return Double.compare(beer.alcoholPercentage, alcoholPercentage) == 0 &&
                Double.compare(beer.price, price) == 0 &&
                stock == beer.stock &&
                Objects.equals(beerName, beer.beerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beerName, alcoholPercentage, price, stock);
    }
}
