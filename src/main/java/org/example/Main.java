package org.example;

import java.util.List;

public class Main {
    // Main method - entry point for the application
    public static void main(String[] args) {

        // Create a new TaskDAO instance for database operations
        TaskDAO dao = new TaskDAO();

        // Create first Task object
        Task t1 = new Task();
        // Set the task name for first task
        t1.setTask("Learn JPA");
        // Set the description for first task
        t1.setDescription("Full CRUD Practice");

        // Create second Task object
        Task t2 = new Task();
        // Set the task name for second task
        t2.setTask("Learn Hibernate");
        // Set the description for second task
        t2.setDescription("ORM Framework");

        // Create third Task object
        Task t3 = new Task();
        // Set the task name for third task
        t3.setTask("Learn JPQL");
        // Set the description for third task
        t3.setDescription("Query Language");

        // Insert first task into database and get DTO result
        TaskDTO dto1 = dao.create(t1);
        // Insert second task into database and get DTO result
        TaskDTO dto2 = dao.create(t2);
        // Insert third task into database and get DTO result
        TaskDTO dto3 = dao.create(t3);

        // Print header for inserted tasks section
        System.out.println("Inserted Tasks:");
        // Print first inserted task DTO
        System.out.println(dto1);
        // Print second inserted task DTO
        System.out.println(dto2);
        // Print third inserted task DTO
        System.out.println(dto3);

        // Print header for all tasks section
        System.out.println("\nAll Tasks After Insert:");
        // Retrieve all tasks from database as DTOs
        List<TaskDTO> allTasks = dao.findAll();
        // Print each task in the list using forEach method
        allTasks.forEach(System.out::println);

        // Update second task with new name and description using its ID
        TaskDTO updated = dao.update(dto2.getId(),
                "Master Hibernate",
                "Advanced ORM");
        // Print header for updated task section
        System.out.println("\nUpdated Task:");
        // Print the updated task DTO
        System.out.println(updated);

        // Delete first task from database using its ID
        dao.delete(dto1.getId());

        // Print header for tasks after deletion section
        System.out.println("\nAll Tasks After Deletion:");
        // Retrieve and print all remaining tasks from database
        dao.findAll().forEach(System.out::println);

        // Close EntityManager and EntityManagerFactory resources
        dao.close();
    }
}




//package org.example;
//
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//
//
////        System.out.println("Starting JPA ........");
////        EntityManagerFactory emf= Persistence.createEntityManagerFactory("taskPU");
////        System.out.println("EntityManagerFactory called successfully......");
////        emf.close();
////        System.out.println("Closed successfully....");
//
//        System.out.println("Starting JPA ........");
//
//        //===== Create ========
//        TaskDAO taskDAO=new TaskDAO();
//        Task task1=new Task();
//        task1.setTask("Learn Hibernate");
//        task1.setDescription("Complete Hibernate tutorial from basic");
//        taskDAO.create(task1);
//
//        Task task2=new Task();
//        task2.setTask("Build REST API");
//        task2.setDescription("Building REST API using Hibernate");
//        taskDAO.create(task2);
//
//
//        Task task3=new Task();
//        task3.setTask("Database");
//        task3.setDescription("Learn Relational Database");
//        taskDAO.create(task3);
//
//        // ===== READ =====
//        TaskDTO readTask = taskDAO.read(1L);
//        System.out.println("Read -> " + readTask);
//
//        // ===== GET ALL =====
//        List<TaskDTO> allTasks = taskDAO.getAllTasks();
//        System.out.println("All Tasks:");
//        for (TaskDTO t : allTasks) {
//            System.out.println(t);
//        }
//
//
//        // ===== UPDATE =====
//        TaskDTO updated = taskDAO.update(
//                task1.getId(),
//                "Learn Hibernate Deeply",
//                "Study entity lifecycle and dirty checking"
//        );
//        System.out.println("Updated -> " + updated);
//
//
//        // ===== DELETE =====
//        taskDAO.delete(task1.getId());
//        System.out.println("After delete:");
//        System.out.println(taskDAO.read(task1.getId()));
//
//
//        // ===== CLOSE CONNECTION =====
//        taskDAO.close();
//
//        System.out.println("Finished Successfully");
//    }
//}









//package org.example;
//
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class Main{
//    public static void main(String[] args){
//        System.out.println("Starting JPA...");
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskPU");
//        System.out.println("EntityManagerFactory created successfully");
//        emf.close();
//        System.out.println("Closed Successfully!");
//    }
//}
