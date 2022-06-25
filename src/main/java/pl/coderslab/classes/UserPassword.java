package pl.coderslab.classes;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userpassword")
public class UserPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "password",nullable = false,unique = true)
    @Size(min=5,max = 10000,message = "Za krótkie lub za długie hasło")
    private String password;

    public UserPassword(int id, String password) {
        this.id = id;
        this.password = password;

    }
    public UserPassword() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}