package md.usm.taskmanagement.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "T_FOOD")

public class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "WEIGHT")
    private String weight;

    @Column(name = "PRICE")
    private BigDecimal price;

    private Food(){
        //for hibernate
    }

    public Food(String name, String weight, BigDecimal price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
