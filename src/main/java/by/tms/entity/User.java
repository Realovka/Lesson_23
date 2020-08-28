package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private static int INTID=1;
    private int id=INTID++;

    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }


}
