package ar.edu.unaj.apjw.repository;


import org.springframework.data.repository.CrudRepository;

import ar.edu.unaj.apjw.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	 Book findByIsbn(int isbn);
}
