package models;

import io.ebean.Model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseModel extends Model {

    @Id
    public Integer id;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    /***
     * Wrapper for superclass Model .save() method.
     * Used to set the time created and updated to the current time.
     */
    @Override
    public void save() {
        setTimeCreated();
        super.save();
    }

    /***
     * Wrapper for superclass Model .update() method.
     * Used to set the time updated to the current time.
     */
    @Override
    public void update() {
        setTimeUpdated();
        super.update();
    }

    private void setTimeUpdated() {
        this.updatedAt = LocalDateTime.now();
    }

    private void setTimeCreated() {
        this.createdAt = this.updatedAt = LocalDateTime.now();
    }

}
