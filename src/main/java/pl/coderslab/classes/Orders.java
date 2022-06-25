package pl.coderslab.classes;

import javax.persistence.*;
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
    @ManyToMany
    private List<Ammunition> ammunitions=new ArrayList<>();
    @ManyToMany
    private List<EarandeyesrecoverAccesories> earandeyesrecoverAccesories =new ArrayList<>();
    @ManyToMany
    private List<Guncovers> guncovers=new ArrayList<>();
    @ManyToMany
    private List<OpticAccesories> opticAccesories=new ArrayList<>();
    @ManyToMany
    private List<Weapons> weapons=new ArrayList<>();
    public Orders() {

    }
}
