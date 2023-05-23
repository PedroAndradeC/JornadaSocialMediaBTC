package entities;

import java.util.List;

public class User {

    private String email;
    private String password;
    private String name;
    private String birthdate;
    private String relationship;

    public User (String email, String password, String name, String birthdate, String relationship) {
        super();
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthdate = birthdate;
        this.relationship = relationship;
    }

    public User(String name, String birthdate, String relationship) {
        super();
        this.name = name;
        this.birthdate = birthdate;
        this.relationship = relationship;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
