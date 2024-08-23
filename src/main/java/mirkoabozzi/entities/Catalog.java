package mirkoabozzi.entities;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Catalog {
    private UUID isbn;
    private String title;
    private LocalDate publicationDate;
    private int pageNumber;

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
