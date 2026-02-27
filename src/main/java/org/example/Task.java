package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Annotation marking this class as a JPA entity mapped to database table
@Entity
public class Task {

    // Annotation specifying this field is the primary key
    @Id
    // Annotation configuring auto-increment strategy for ID generation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Declare Long field to store unique task identifier
    private Long id;
    // Declare String field to store task name
    private String task;
    // Declare String field to store task description
    private String description;

    // Getter method to retrieve task name
    public String getTask() {
        // Return the task field value
        return task;
    }

    // Setter method to update task name
    public void setTask(String task) {
        // Assign task parameter to instance field
        this.task = task;
    }

    // Getter method to retrieve task ID
    public Long getId() {
        // Return the id field value
        return id;
    }

    // Setter method to update task ID
    public void setId(Long id) {
        // Assign id parameter to instance field
        this.id = id;
    }

    // Getter method to retrieve task description
    public String getDescription() {
        // Return the description field value
        return description;
    }

    // Setter method to update task description
    public void setDescription(String description) {
        // Assign description parameter to instance field
        this.description = description;
    }
}




//package org.example;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class Task {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long Id;
//    private String task;
//    private String description;
//    public void task(long id, String task, String description){
//        this.Id = id;
//        this.task = task;
//        this.description = description;
//    }
//    public long getId() {
//        return Id;
//    }
//
//    public void setId(long id) {
//        Id = id;
//    }
//
//    public String getTask() {
//        return task;
//    }
//
//    public void setTask(String task) {
//        this.task = task;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//}
