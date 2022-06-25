package pl.coderslab.classes;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "guncovers")
public class Guncovers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "price",nullable = false)
    private int price;
    @Column(name = "description",nullable = false)
    private String description;

    public Guncovers(String name, int price,String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public Guncovers() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
