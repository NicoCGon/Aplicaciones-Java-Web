package ar.edu.unaj.apjw.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int isbn;
	private String title;
	private String author;
	
	public Book() {
	}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return String.join(" ","Titulo:", this.title,"Autor:",this.author);
	}
}
