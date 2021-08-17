package library_managment.controller;

import library_managment.DTO.RentDTO;
import library_managment.entitys.RentedBook;
import library_managment.exception.LibraryException;
import library_managment.repository.BooksRepository;
import library_managment.repository.ClientRepository;
import library_managment.repository.RentRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/rent")
public class RentController {

    private final RentRepository rr;
    private ClientRepository client;
    private BooksRepository book;

    public RentController(RentRepository rr) {
        this.rr = rr;
    }

    @PostMapping("/")
    public void rentBook(@RequestBody RentDTO rdto){
        RentedBook rb = new RentedBook();

        rb.setBook_cod(rdto.getBook_cod());
        rb.setRent_client(rdto.getRent_client());
        LocalDate ld = LocalDate.now();
        rb.setRent_date(ld);

        rr.save(rb);
    }

    @DeleteMapping("/")
    public void refundBook(@PathVariable Long rent_cod) {
        rr.findById(rent_cod)
                .orElseThrow(() -> new LibraryException("Rent code not found!"));
        rr.deleteById(rr.getById(rent_cod).getId());
    }

}
