package ar.edu.unaj.apjw;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import ar.edu.unaj.apjw.entities.Book;
import ar.edu.unaj.apjw.repository.BookRepository;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class SpringProyectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringProyectApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringProyectApplication.class);
	}
	
	@Bean
    public CommandLineRunner testApp(BookRepository bookRepository) {
        return (args) -> {
        	try {

    			List<Book> listBook = Arrays.asList(
    					new Book("Artificial Intelligence: A Modern approach.", "Stuart Russell y Peter Norvig"),
    					new Book("Computer Networks.","Andrew Tanenbaum y David Wetherall"),
    					new Book("Modern Operating Systems."," Andrew Tanenbaum y Herbert Bos")
    			);
    			listBook.forEach( book -> {
    				bookRepository.save(book);
    			});
    			
    			Iterable<Book> getListBook = bookRepository.findAll();
    			getListBook.forEach(System.out::println);
        	}
        	catch (Exception e) {
				e.printStackTrace();
			}
        };
    }

}
