package org.example;

public class TaskDTO {
    // Declare Long field to store task identifier
    private Long id;
    // Declare String field to store task name
    private String task;
    // Declare String field to store task description
    private String description;

    // Constructor with no parameters for creating empty DTO object
    public TaskDTO() {
    }

    // Constructor that initializes all fields with provided values
    public TaskDTO(Long id, String task, String description) {
        // Assign id parameter to instance field
        this.id = id;
        // Assign task parameter to instance field
        this.task = task;
        // Assign description parameter to instance field
        this.description = description;
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

    // Override toString method to provide custom string representation
    @Override
    public String toString() {
        // Build and return formatted string with all field values
        return "TaskDTO{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}




//package org.example;
//
//public class TaskDTO {
//    private int id;
//    private String task;
//    private String description;
//
//    public TaskDTO(){
//
//    }
//
//    public TaskDTO(int id, String task, String description){
//        this.id = id;
//        this.task = task;
//        this.description = description;
//
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
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
//    @Override
//    public String toString() {
//        return "TaskDTO{" +
//                "id=" + id +
//                ", task='" + task + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
//}
