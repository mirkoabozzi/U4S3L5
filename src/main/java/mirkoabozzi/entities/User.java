package mirkoabozzi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String username;
    @Column(name = "local_date", nullable = false)
    private LocalDate birthDate;
    @Column(name = "card_id", nullable = false)
    private int cardId;

    @OneToMany(mappedBy = "user")
    private List<Loan> loanList;

    public User() {
    }

    public User(String name, String username, LocalDate birthDate, int cardId) {
        this.name = name;
        this.username = username;
        this.birthDate = birthDate;
        this.cardId = cardId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", birthDate=" + birthDate +
                ", cardId=" + cardId +
                '}';
    }
}
