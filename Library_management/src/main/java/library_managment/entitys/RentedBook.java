package library_managment.entitys;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "rented_books")
public class RentedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_cod")
    private Long id;

    @JoinColumn(name = "book_cod")
    private Long book_cod;


    @JoinColumn(name = "rent_client")
    private Long rent_client;

    @Column(name = "rent_date")
    private LocalDate rent_date;

    public Long getBook_cod() {
        return book_cod;
    }

    public RentedBook setBook_cod(Long book_cod) {
        this.book_cod = book_cod;
        return this;
    }

    public Long getRent_client() {
        return rent_client;
    }

    public RentedBook setRent_client(Long rent_client) {
        this.rent_client = rent_client;
        return this;
    }

    public LocalDate getRent_date() {
        return rent_date;
    }

    public RentedBook setRent_date(LocalDate rent_date) {
        this.rent_date = rent_date;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RentedBook setId(Long id) {
        this.id = id;
        return this;
    }
}
