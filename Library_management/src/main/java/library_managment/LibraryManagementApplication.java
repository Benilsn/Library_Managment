package library_managment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.SQLException;


@SpringBootApplication(scanBasePackages = "library_managment")
@EntityScan(basePackages = "library_managment.entitys")
public class LibraryManagementApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(LibraryManagementApplication.class, args);





	}

}
