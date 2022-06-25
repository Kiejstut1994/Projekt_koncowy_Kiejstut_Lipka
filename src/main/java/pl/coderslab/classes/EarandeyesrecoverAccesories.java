package pl.coderslab.classes;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "earandeyesrecoveraccesories")
public class EarandeyesrecoverAccesories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "price",nullable = false)
    private double price;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "type",nullable = false)
    private String type;
    public EarandeyesrecoverAccesories(){}
    public EarandeyesrecoverAccesories(int id, String name, double price, String description, String type) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
