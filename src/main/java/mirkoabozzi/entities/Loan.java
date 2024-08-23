package mirkoabozzi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue
    private UUID id;


    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "element_loan_id")
    private Catalog catalog;


    @Column(name = "loan_start_data")
    private LocalDate loanStartData;
    @Column(name = "loan_end_data")
    private LocalDate loanEndData;
    @Column(name = "effective_end_loan")
    private LocalDate effectiveEndLoan;


    public Loan() {
    }

    public Loan(User user, Catalog catalog, LocalDate loanStartData, LocalDate loanEndData, LocalDate effectiveEndLoan) {
        this.user = user;
        this.catalog = catalog;
        this.loanStartData = loanStartData;
        this.loanEndData = loanEndData;
        this.effectiveEndLoan = effectiveEndLoan;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public LocalDate getLoanStartData() {
        return loanStartData;
    }

    public void setLoanStartData(LocalDate loanStartData) {
        this.loanStartData = loanStartData;
    }

    public LocalDate getLoanEndData() {
        return loanEndData;
    }

    public void setLoanEndData(LocalDate loanEndData) {
        this.loanEndData = loanEndData;
    }

    public LocalDate getEffectiveEndLoan() {
        return effectiveEndLoan;
    }

    public void setEffectiveEndLoan(LocalDate effectiveEndLoan) {
        this.effectiveEndLoan = effectiveEndLoan;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user +
                ", catalog=" + catalog +
                ", loanStartData=" + loanStartData +
                ", loanEndData=" + loanEndData +
                ", effectiveEndLoan=" + effectiveEndLoan +
                '}';
    }
}
