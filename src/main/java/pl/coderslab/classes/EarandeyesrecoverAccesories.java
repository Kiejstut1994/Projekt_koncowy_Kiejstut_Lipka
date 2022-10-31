package pl.coderslab.classes;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "earandeyesrecoveraccesories")
public class EarandeyesrecoverAccesories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @Size(min = 5,max=40,message ="Musi mieć więcej niż 5 cyfr ale mniej niż 40")
    private String name;
    @Column(name = "price")
    @Positive(message = "Podaj cenę, wartość dodatnia")
    private double price;
    @Column(name = "description")
    @Size(min = 5,max = 100,message ="Musi mieć więcej niż 5 cyfr a mniej niż 100")
    private String description;
    @Column(name = "type")
    @NotNull(message = "Podaj typ ochrona wzroku/słuchu")
    private String type;
    @Column(name = "photo")
    @NotEmpty(message = "Podaj nazwę zdjęcia")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EarandeyesrecoverAccesories that = (EarandeyesrecoverAccesories) o;
        return id == that.id && Double.compare(that.price, price) == 0 && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(type, that.type) && Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, type, photo);
    }
}
