package pl.coderslab.classes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "earandeyesrecoveraccesories")
public class EarandeyesrecoverAccesories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    @Size(min = 5,message ="Musi mieć więcej niż 5 cyfr")
    private String name;
    @Column(name = "price",nullable = false)
    @NotNull(message = "Podaj cenę")
    private double price;
    @Column(name = "description",nullable = false)
    @Size(min = 5,max = 100,message ="Musi mieć więcej niż 5 cyfr a mniej niż 100")
    private String description;
    @Column(name = "type",nullable = false)
    @NotNull(message = "Podaj typ ochrona wzroku/słuchu")
    private String type;
    @Column(name = "photo",nullable = false)
    @NotNull(message = "Podaj nazwę zdjęcia")
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public EarandeyesrecoverAccesories(){}
    public EarandeyesrecoverAccesories(int id, String name, double price, String description, String type, String photo) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
        this.photo = photo;
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
