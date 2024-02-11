package Assissment.Assissment.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "new_User")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPassword")
    private String password;

    @Column(name = "userPhone")
    private int phoneno;
}

