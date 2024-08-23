package mirkoabozzi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book extends Catalog {
    @Column(name = "author")
    private String author;
    @Column(name = "genere")
    private String genere;

    public Book(String title, LocalDate publicationDate, int pageNumber, String author, String genere) {
        super(title, publicationDate, pageNumber);
        this.author = author;
        this.genere = genere;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
