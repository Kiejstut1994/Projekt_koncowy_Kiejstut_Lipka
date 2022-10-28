package pl.coderslab.classes;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userpassword")
public class UserPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "userpassword",nullable = false,unique = true)
    @Size(min=5,max = 10000,message = "Za krótkie lub za długie hasło")
    private String userpassword;

    public UserPassword(int id, String userpassword) {
        this.id = id;
        this.userpassword = userpassword;

    }
    public UserPassword() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}