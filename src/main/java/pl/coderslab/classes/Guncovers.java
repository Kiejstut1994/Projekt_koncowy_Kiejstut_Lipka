package pl.coderslab.classes;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "guncovers")
public class Guncovers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @Size(min = 5,max = 30,message ="Musi mieć więcej niż 5 cyfr a mniej niż 30")
    private String name;
    @Column(name = "price")
    @Positive(message = "Podaj cenę, wartość dodatnia")
    private double price;
    @Column(name = "description")
    @Size(min = 5,max = 100,message ="Musi mieć więcej niż 5 cyfr a mniej niż 100")
    private String description;
    @Column(name = "photo")
    @NotEmpty(message = "Podaj nazwę zdjęcia")
    private String photo;


    public Guncovers(int id, String name, double price, String description, String photo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guncovers guncovers = (Guncovers) o;
        return id == guncovers.id && price == guncovers.price && Objects.equals(name, guncovers.name) && Objects.equals(description, guncovers.description) && Objects.equals(photo, guncovers.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, photo);
    }
}
