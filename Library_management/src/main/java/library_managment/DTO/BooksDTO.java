package library_managment.DTO;

import library_managment.entitys.BookCase;

public class BooksDTO {

    private Long id;

    private String name;

    private String quant;

    private String rent_price;


    public static BooksDTO converter(BookCase b){
        BooksDTO book = new BooksDTO();
        book.setId(b.getId());
        book.setName(b.getName());
        book.setQuant(b.getQuant());
        book.setRent_price(b.getRent_price());

        return book;
    }

    public Long getId() {
        return id;
    }

    public BooksDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BooksDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getQuant() {
        return quant;
    }

    public BooksDTO setQuant(String quant) {
        this.quant = quant;
        return this;
    }

    public String getRent_price() {
        return rent_price;
    }

    public BooksDTO setRent_price(String rent_price) {
        this.rent_price = rent_price;
        return this;
    }
}
