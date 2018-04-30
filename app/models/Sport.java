package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sport{

    public static Finder<Integer, Sport> find = new Finder<>(Sport.class);

    @Id
    private Integer id;

    @Constraints.Required
    private String name;

    @Constraints.Max(10)
    private Integer pointValue;


    public Sport(String name, Integer pointValue) {
        this.name = name;
        this.pointValue = pointValue;
    }

    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getPointValue() {
        return this.pointValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPointValue(Integer pointValue) {
        this.pointValue = pointValue;
    }
}
