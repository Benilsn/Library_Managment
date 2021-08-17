package library_managment.controller;

import library_managment.DTO.BooksDTO;
import library_managment.entitys.BookCase;
import library_managment.exception.LibraryException;
import library_managment.repository.BooksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksRepository booksRepository;

    public BooksController(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    @GetMapping("/")
    public List<BooksDTO> findAll(){
        var books = booksRepository.findAll();

        return books
                .stream()
                .map(BooksDTO::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BooksDTO findById(@PathVariable Long id){
        var book = booksRepository
                .findById(id).orElseThrow(() -> new LibraryException("Book not found!"));

        return BooksDTO.converter(book);
    }

    @PostMapping("/")
    public void addBook(@RequestBody BooksDTO bd){
        var book = new BookCase();
        book.setName(bd.getName());
        book.setQuant(bd.getQuant());
        book.setRent_price(bd.getRent_price());
        booksRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookByid(@PathVariable Long id){
            booksRepository.findById(id).orElseThrow(()-> new LibraryException("Book not found!"));
            booksRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id,@RequestBody BooksDTO b){
        var book = booksRepository.findById(id);

        if (book.isPresent()){
            var bookSave = book.get();
            bookSave.setName(b.getName());
            bookSave.setQuant(b.getQuant());
            bookSave.setRent_price(b.getRent_price());
            booksRepository.save(bookSave);
        }else{
            throw new LibraryException("Book not found!");
        }
    }


}
