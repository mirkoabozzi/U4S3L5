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


    @Column(name = "loan_start_data")
    private LocalDate loanStartData;
    @Column(name = "loan_end_data")
    private LocalDate loanEndData;
    @Column(name = "effective_end_loan")
    private LocalDate effectiveEndLoan;


}
