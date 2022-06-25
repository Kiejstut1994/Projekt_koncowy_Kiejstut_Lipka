package pl.coderslab.classes;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",length=20,nullable = false)
    @Size(min = 3,message = "Za krótkie imię")
    private String name;
    @Column(name = "surname",length=20,nullable = false)
    @Size(min = 3,message = "Za krótkie nazwisko")
    private String surname;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_password_id",unique=true)
    private UserPassword userPassword;

    public User(){}


    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;

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


    public UserPassword getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(UserPassword userPassword) {
        this.userPassword = userPassword;
    }
}

