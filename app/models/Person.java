package models;

import io.ebean.Finder;

import javax.persistence.Entity;

@Entity
public class Person extends BaseModel{
    public String firstName;
    public String lastName;
    public String email;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String getLastFirst(){
        return this.lastName + ", " + this.firstName;
    }
    public String getFirstLast(){
        return this.firstName + " " + this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public static Finder<String, Person> find = new Finder<>(Person.class);
}
