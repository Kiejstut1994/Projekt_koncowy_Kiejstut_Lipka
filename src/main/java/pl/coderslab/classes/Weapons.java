package pl.coderslab.classes;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "weapons")
public class Weapons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",length = 200, nullable = false)
    @Size(min = 5,message ="Za krótka nazwa" )
    private String name;
    @Column(name = "weight", precision = 2,nullable = false)
    @NotNull(message = "Podaj wagę")
    private double weight;
    @Column(name = "producent",length=100,nullable = false)
    @Size(min = 5,max = 30,message ="Nazwa producenta między 5 a 30 znaków" )
    private String producent;
    @Column(name = "price", precision = 2,nullable = false)
    @NotNull(message = "Podaj cenę")
    private double price;
    @Column(name = "caliber",length=20,nullable = false)
    @Size(min = 2,message ="Za krótka nazwa kalibru" )
    private String caliber;
    @Column(name = "rating", precision = 1,nullable = false)
    @NotNull(message = "Podaj ocenę")
    private double rating;
    @Column(name = "type",length=20,nullable = false)
    @NotNull(message = "Proszę wybrać jedną opcję")
    private String type;
    @Column(name = "photo",length = 200,nullable = false)
    @NotNull(message = "To nie może być puste")
    private String photo;

    public Weapons(){}
    public Weapons(int id, String name, double weight, String producent, double price, String caliber, double rating, String type, String photo) {
        this.id = id;
        this.name=name;
        this.weight = weight;
        this.producent = producent;
        this.price = price;
        this.caliber = caliber;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
