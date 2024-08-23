package mirkoabozzi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String username;
    @Column(name = "local_date")
    private LocalDate birthDate;
    @Column(name = "card_id")
    private int cardId;

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
