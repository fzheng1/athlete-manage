package models;

import io.ebean.Finder;

import javax.persistence.Entity;

@Entity
public class Admin extends Person {
    public Admin(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public static Finder<String, Admin> find = new Finder<>(Admin.class);
}
