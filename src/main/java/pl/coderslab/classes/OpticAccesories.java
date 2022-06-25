package pl.coderslab.classes;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "opticaccesories")
public class OpticAccesories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "price",precision = 2,nullable = false)
    private double price;
    @Column(name = "rating",precision = 1,nullable = false)
    private double rating;
    @Column(name = "type",nullable = false)
    private String type;
    //enum jako 3 opcje
public OpticAccesories(){}
    public OpticAccesories(int id, String name, String description, double price, double rating, String type) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
