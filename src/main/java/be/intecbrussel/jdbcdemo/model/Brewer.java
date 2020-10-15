package be.intecbrussel.jdbcdemo.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "brewers")
public class Brewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String zipcode;
    private int turnover;
    @OneToMany(mappedBy = "brewer", fetch = FetchType.EAGER)
    private List<Beer> beerList;


    public Brewer() {
    }

    public Brewer(String name, String address, String zipcode, int turnover) {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.turnover = turnover;
    }

    public List<Beer> getBeerList() {
        return beerList;
    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    @Override
    public String toString() {
        return "Brewer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", turnover=" + turnover +
                '}';
    }
}
