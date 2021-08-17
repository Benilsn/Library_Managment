package library_managment.entitys;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "books")
public class BookCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "quant")
    private String quant;

    @Column(name = "rent_price")
    @NotEmpty
    private String rent_price;

    public Long getId() {
        return id;
    }

    public BookCase setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookCase setName(String name) {
        this.name = name;
        return this;
    }

    public String getQuant() {
        return quant;
    }

    public BookCase setQuant(String quant) {
        this.quant = quant;
        return this;
    }

    public String getRent_price() {
        return rent_price;
    }

    public BookCase setRent_price(String rent_price) {
        this.rent_price = rent_price;
        return this;
    }
}
