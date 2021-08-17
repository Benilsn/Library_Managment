package library_managment.repository;

import library_managment.entitys.RentedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<RentedBook, Long>{


}

