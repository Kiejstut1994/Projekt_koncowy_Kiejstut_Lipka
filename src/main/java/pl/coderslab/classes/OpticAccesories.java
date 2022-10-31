package pl.coderslab.classes;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "opticaccesories")
public class OpticAccesories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @Size(min = 5,max = 30,message ="Musi mieć więcej niż 5 cyfr a mniej niż 30")
    private String name;
    @Column(name = "description")
    @Size(min = 5,max = 100,message ="Musi mieć więcej niż 5 cyfr a mniej niż 100")
    private String description;
    @Column(name = "price",precision = 2)
    @Positive(message = "Podaj cenę,wartość dodatnia")
    private double price;
    @Column(name = "rating",precision = 1)
    @Positive(message = "Podaj ocenę,wartość dodatnia")
    private double rating;
    @Column(name = "type")
    @NotNull(message = "Podaj typ optyki")
    private String type;
    @Column(name = "photo")
    @NotEmpty(message = "Podaj zdjęcie")
    private String photo;

public OpticAccesories(){}
    public OpticAccesories(int id, String name, String description, double price, double rating, String type, String photo) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.type = type;
        this.photo = photo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpticAccesories that = (OpticAccesories) o;
        return id == that.id && Double.compare(that.price, price) == 0 && Double.compare(that.rating, rating) == 0 && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(type, that.type) && Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, rating, type, photo);
    }
}
