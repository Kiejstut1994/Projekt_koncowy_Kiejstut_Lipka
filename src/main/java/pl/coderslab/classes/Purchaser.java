package pl.coderslab.classes;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "purchaser")
public class Purchaser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @Size(min=5,max = 30,message="Musi mieć więcej niż 5 liter i mniej niż 30")
    private String name;
    @Column(name = "surname")
    @Size(min=5,max = 30,message="Musi mieć więcej niż 5 liter i mniej niż 30")
    private String surname;
    @Column(name = "PESEL",length=11,unique = true)
    @PESEL(message="11 cyfr dokładnie")
    private String PESEL;
    @Column(name = "email",unique = true)
    @Email(message = "Za krótka przednia część lub brak @")
    @NotEmpty(message = "Pole email nie może być puste")
    private String email;
    @Column(name = "emailveryfication",nullable = false)
    private boolean emailveryfication;
    @Column(name = "firearmslicensce",nullable = false)
    private boolean firearmslicensce;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "password_id",unique=true)
    private Password password;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id",unique=true)
    private Address address;

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Purchaser(){}
    public Purchaser(int id, String name, String surname, String PESEL, String email, boolean emailveryfication, boolean firearmslicensce) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.PESEL=PESEL;
        this.email = email;
        this.emailveryfication = emailveryfication;
        this.firearmslicensce = firearmslicensce;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailveryfication() {
        return emailveryfication;
    }

    public void setEmailveryfication(boolean emailveryfication) {
        this.emailveryfication = emailveryfication;
    }

    public boolean isFirearmslicensce() {
        return firearmslicensce;
    }

    public void setFirearmslicensce(boolean firearmslicensce) {
        this.firearmslicensce = firearmslicensce;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }
}
