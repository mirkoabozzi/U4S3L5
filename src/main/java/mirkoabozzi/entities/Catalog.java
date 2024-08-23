package mirkoabozzi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "catalog_type")
public abstract class Catalog {
    @Id
    @GeneratedValue
    private UUID isbn;
    @Column(name = "title")
    private String title;
    @Column(name = "publication_date")
    private LocalDate publicationDate;
    @Column(name = "page_number")
    private int pageNumber;

    @OneToMany(mappedBy = "catalog")
    private List<Loan> loanList;

    public Catalog() {
    }

    public Catalog(String title, LocalDate publicationDate, int pageNumber) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.pageNumber = pageNumber;
    }

    public UUID getIsbn() {
        return isbn;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
