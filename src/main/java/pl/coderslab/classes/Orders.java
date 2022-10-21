package pl.coderslab.classes;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "purchaser_id")
    private int puchaserid;
    @OneToMany
    private List<Ammunition> ammunitions=new ArrayList<>();
    @OneToMany
    private List<EarandeyesrecoverAccesories> earandeyesrecoverAccesories=new ArrayList<>();
    @OneToMany
    private List<Guncovers> guncovers=new ArrayList<>();
    @OneToMany
    private List<Weapons> weapons=new ArrayList<>();
@Column(name = "price")
private double price;
@Column(name = "active")
private boolean active;
@Column(name = "paid")
private boolean paid;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuchaserid() {
        return puchaserid;
    }

    public void setPuchaserid(int puchaserid) {
        this.puchaserid = puchaserid;
    }

    public List<Ammunition> getAmmunitions() {
        return ammunitions;
    }

    public void setAmmunitions(List<Ammunition> ammunitions) {
        this.ammunitions = ammunitions;
    }

    public List<EarandeyesrecoverAccesories> getEarandeyesrecoverAccesories() {
        return earandeyesrecoverAccesories;
    }

    public void setEarandeyesrecoverAccesories(List<EarandeyesrecoverAccesories> earandeyesrecoverAccesories) {
        this.earandeyesrecoverAccesories = earandeyesrecoverAccesories;
    }

    public List<Guncovers> getGuncovers() {
        return guncovers;
    }

    public void setGuncovers(List<Guncovers> guncovers) {
        this.guncovers = guncovers;
    }

    public List<Weapons> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapons> weapons) {
        this.weapons = weapons;
    }

    public Orders() {

    }
}
