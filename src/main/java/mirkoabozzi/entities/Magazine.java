package mirkoabozzi.entities;

import jakarta.persistence.*;
import mirkoabozzi.enums.PeriodicityType;

import java.time.LocalDate;

@Entity
@Table(name = "magazine")
public class Magazine extends Catalog {
    @Column(name = "periodicity", nullable = false)
    @Enumerated(EnumType.STRING)
    private PeriodicityType periodicityType;

    public Magazine() {
    }

    public Magazine(String title, LocalDate publicationDate, int pageNumber, PeriodicityType periodicityType) {
        super(title, publicationDate, pageNumber);
        this.periodicityType = periodicityType;
    }

    public PeriodicityType getPeriodicityType() {
        return periodicityType;
    }

    public void setPeriodicityType(PeriodicityType periodicityType) {
        this.periodicityType = periodicityType;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicityType=" + periodicityType +
                '}';
    }
}
