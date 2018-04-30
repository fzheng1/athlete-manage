package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sport extends Model {
    
    @Id
    public Integer id;

    @Constraints.Required
    public String name;

    @Constraints.Max(10)
    public Integer pointValue;
    
    public Sport(String name, Integer pointValue) {
        this.name = name;
        this.pointValue = pointValue;
    }
    
    
    public static Finder<Integer, Sport> find = new Finder<>(Sport.class);
  
}
