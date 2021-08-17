package library_managment.DTO;

import library_managment.entitys.RentedBook;

import java.time.LocalDate;

public class RentDTO {

    private Long id;

    private Long book_cod;

    private Long rent_client;

    private LocalDate rent_date;

    public static RentDTO converter(RentedBook rb){
        RentDTO rdto = new RentDTO();
        rdto.setId(rb.getId());
        rdto.setBook_cod(rb.getBook_cod());
        rdto.setRent_client(rb.getRent_client());
        rdto.setRent_date(rb.getRent_date());
        return rdto;
    }

    public Long getId() {
        return id;
    }

    public RentDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getBook_cod() {
        return book_cod;
    }

    public RentDTO setBook_cod(Long book_cod) {
        this.book_cod = book_cod;
        return this;
    }

    public Long getRent_client() {
        return rent_client;
    }

    public RentDTO setRent_client(Long rent_client) {
        this.rent_client = rent_client;
        return this;
    }

    public LocalDate getRent_date() {
        return rent_date;
    }

    public RentDTO setRent_date(LocalDate rent_date) {
        this.rent_date = rent_date;
        return this;
    }
}
