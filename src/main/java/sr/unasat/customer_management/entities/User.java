package sr.unasat.customer_management.entities;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints=
@UniqueConstraint(columnNames={"id", "username"}))
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "level_id")
    private UserLevel level;



    public User(String username,
                String password,
                String name,
                UserLevel level) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.level = level;
    }

    public User () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}


