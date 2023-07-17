package com.example.UserRequest.DB.modelDB;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@Table(name = "usersRequests")
public class UserRequestDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private Integer requestCount;

    public UserRequestDB(String login) {
        this.login = login;
        this.requestCount = 1;
    }
    public void IncreaseRequestCount() {
        requestCount++;
    }
}
