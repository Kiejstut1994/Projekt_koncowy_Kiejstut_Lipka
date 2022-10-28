package pl.coderslab.classes;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "street",nullable = false,length=20)
    @Size(min = 5,max = 20,message ="Musi mieć więcej niż 5 cyfr a mniej niż 20")
    private String street;
    @Column(name = "flatnumber",nullable = false,length=20)
    @NotNull(message = "Podaj numer domu/bloku")
    private int flatnumber;
    @Column(name = "housenumber",length=20)
    private int housenumber;
    @Column(name = "postcode",length=5,nullable = false)
    @Pattern(regexp = "[0-9]{5}",message = "Błędny kod pocztowy, UWAGA: bez kreski")
    private String postcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getFlatnumber() {
        return flatnumber;
    }

    public void setFlatnumber(int flatnumber) {
        this.flatnumber = flatnumber;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address(){}
    public Address(int id, String street, int flatnumber, int housenumber, String postcode) {
this.id=id;
        this.street = street;
        this.flatnumber = flatnumber;
        this.housenumber = housenumber;
        this.postcode = postcode;
    }
}
