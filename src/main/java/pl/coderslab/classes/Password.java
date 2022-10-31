package pl.coderslab.classes;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "password")
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "password")
    @Size(min=5,max = 10000,message = "Za krótkie hasło")
    private String password;

    public Password(int id, String password) {
        this.id=id;
        this.password = password;
    }

    public Password() {

    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
