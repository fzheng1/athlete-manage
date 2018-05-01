package models;

import io.ebean.Finder;
import play.data.validation.Constraints;

import javax.persistence.Entity;

<<<<<<< HEAD
=======
@Entity
public class Sport{

    public static Finder<Integer, Sport> find = new Finder<>(Sport.class);
>>>>>>> 17caf4064e481ce49fdd098e0e98483ea821fa77

@Entity
public class Sport extends BaseModel {

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
