package pl.coderslab.classes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Entity
@Table(name = "guncovers")
public class Guncovers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    @Size(min = 5,max = 30,message ="Musi mieć więcej niż 5 cyfr a mniej niż 30")
    private String name;
    @Column(name = "price",nullable = false)
    @NotNull(message = "Podaj cenę")
    private int price;
    @Column(name = "description",nullable = false)
    @Size(min = 5,max = 100,message ="Musi mieć więcej niż 5 cyfr a mniej niż 100")
    private String description;
    @Column(name = "photo",nullable = false)
    @NotNull(message = "Podaj nazwę zdjęcia")
    private String photo;


    public Guncovers(int id, String name, int price, String description, String photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.photo = photo;
    }

    public Guncovers() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
