package library_managment.repository;

import library_managment.entitys.BookCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BookCase, Long> {
}
