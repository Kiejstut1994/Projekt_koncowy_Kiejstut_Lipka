package pl.coderslab.classes;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "ammunition")
public class Ammunition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    @Size(min = 5,message = "Za krótka nazwa")
    private String name;
    @Column(name = "weight",precision = 2,nullable = false)
    @NotNull(message = "Podaj wagę")
    private double weight;
    @Column(name = "caliber",nullable = false)
    @NotNull(message = "Podaj kaliber broni")
    private String caliber;
    @Column(name = "type",nullable = false)
    @NotNull(message = "Podaj typ do jakiej broni jest ona przeznaczona")
    private String type;
    @Column(name = "price",nullable = false)
    @NotNull(message = "Podaj cenę (liczbę)")
    private double price;
    @Column(name = "numberinpack",nullable = false)
    @NotNull(message = "Liczba naboi w paczce")
    private int numberinpack;
    @Column(name = "photo",nullable = false)
    @NotNull(message = "Podaj nazwę zdjęcia")
    private String photo;

    public Ammunition(int id, String name, double weight, String caliber, String type, double price, int numberinpack, String photo) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.caliber = caliber;
        this.type = type;
        this.price = price;
        this.numberinpack = numberinpack;
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Ammunition(){}
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberinpack() {
        return numberinpack;
    }

    public void setNumberinpack(int numberinpack) {
        this.numberinpack = numberinpack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
