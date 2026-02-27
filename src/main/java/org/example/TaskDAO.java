package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.stream.Collectors;

public class TaskDAO {
    // Declare EntityManagerFactory field for managing JPA persistence unit
    private final EntityManagerFactory ef;
    // Declare EntityManager field for performing database operations
    private final EntityManager em;

    // Constructor initializes the DAO with EntityManagerFactory and EntityManager
    public TaskDAO() {
        // Create EntityManagerFactory from persistence unit configuration
        this.ef = Persistence.createEntityManagerFactory("taskPU");
        // Create EntityManager instance from the factory
        this.em = ef.createEntityManager();
    }

    // Method to persist a new Task entity and return it as a DTO
    public TaskDTO create(Task task) {
        try {
            // Start a database transaction
            em.getTransaction().begin();
            // Add the task object to the persistence context
            em.persist(task);
            // Commit the transaction to save changes to database
            em.getTransaction().commit();
            // Convert and return the task as a DTO
            return convertToDTO(task);
        } catch (Exception e) {
            // Check if transaction is still active
            if (em.getTransaction().isActive())
                // Rollback transaction on error
                em.getTransaction().rollback();
            // Wrap and throw exception
            throw new RuntimeException(e);
        }
    }

    // Method to retrieve a Task by ID and return it as a DTO
    public TaskDTO findById(Long id) {
        // Query database for Task with given ID
        Task task = em.find(Task.class, id);
        // Return DTO if found, otherwise return null
        return task != null ? convertToDTO(task) : null;
    }

    // Method to retrieve all Tasks from database and return as list of DTOs
    public List<TaskDTO> findAll() {
        // Execute JPQL query to get all Task entities
        List<Task> tasks = em.createQuery("FROM Task", Task.class)
                .getResultList();

        // Convert each Task to DTO using stream and collector
        return tasks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Method to update an existing Task by ID and return updated DTO
    public TaskDTO update(Long id, String newTask, String newDescription) {
        try {
            // Start a database transaction
            em.getTransaction().begin();

            // Retrieve Task entity by ID from database
            Task task = em.find(Task.class, id);
            // Check if Task exists
            if (task == null)
                // Return null if Task not found
                return null;

            // Update task name field
            task.setTask(newTask);
            // Update task description field
            task.setDescription(newDescription);

            // Commit transaction to persist changes
            em.getTransaction().commit();
            // Convert and return updated task as DTO
            return convertToDTO(task);

        } catch (Exception e) {
            // Check if transaction is still active
            if (em.getTransaction().isActive())
                // Rollback transaction on error
                em.getTransaction().rollback();
            // Wrap and throw exception
            throw new RuntimeException(e);
        }
    }

    // Method to delete a Task by ID and return success status
    public boolean delete(Long id) {
        try {
            // Start a database transaction
            em.getTransaction().begin();

            // Retrieve Task entity by ID from database
            Task task = em.find(Task.class, id);
            // Check if Task exists
            if (task == null)
                // Return false if Task not found
                return false;

            // Remove task from persistence context and database
            em.remove(task);
            // Commit transaction to persist deletion
            em.getTransaction().commit();
            // Return true indicating successful deletion
            return true;

        } catch (Exception e) {
            // Check if transaction is still active
            if (em.getTransaction().isActive())
                // Rollback transaction on error
                em.getTransaction().rollback();
            // Wrap and throw exception
            throw new RuntimeException(e);
        }
    }

    // Helper method to convert Task entity to TaskDTO
    private TaskDTO convertToDTO(Task task) {
        // Create new TaskDTO with task fields
        return new TaskDTO(
                // Set DTO ID from task
                task.getId(),
                // Set DTO task name from task
                task.getTask(),
                // Set DTO description from task
                task.getDescription()
        );
    }

    // Method to close EntityManager and EntityManagerFactory resources
    public void close() {
        // Check if EntityManager is open
        if (em.isOpen())
            // Close EntityManager
            em.close();
        // Check if EntityManagerFactory is open
        if (ef.isOpen())
            // Close EntityManagerFactory
            ef.close();
    }
}



//package org.example;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class TaskDAO {
//    private EntityManagerFactory emf;
//    private EntityManager em;
//
//    public TaskDAO(){
//        this.emf= Persistence.createEntityManagerFactory("taskPU");
//        this.em=emf.createEntityManager();
//    }
//
//    public TaskDTO create(Task task){
//        try{
//            em.getTransaction().begin();
//            em.persist(task);
//            em.getTransaction().commit();
//
//            System.out.println("Task created successfully id : "+task.getId());
//
//            return convertToDTO(task);
//
//        }catch (Exception e){
//            if(em.getTransaction().isActive()){
//                em.getTransaction().rollback();
//            }
//            System.out.println(e.getMessage());
//            return null;
//        }
//
//    }
//
//
//    public TaskDTO read(Long id){
//        try{
//            Task task=em.find(Task.class,id);
//            if(task != null){
//                System.out.println("Task found with id : "+id);
//                return convertToDTO(task);
//            }else{
//                System.out.println("Task not found with id : "+id);
//                return null;
//            }
//        }catch (Exception e){
//            System.out.println("Error reading message : "+e.getMessage());
//            return null;
//        }
//    }
//
//
//
//    public TaskDTO update(Long id, String newTask, String newDescription) {
//        try {
//            em.getTransaction().begin();
//
//            Task task = em.find(Task.class, id);
//            if (task == null)
//                return null;
//
//            task.setTask(newTask);
//            task.setDescription(newDescription);
//
//            Task updateTask=em.merge(task);
//
//            em.getTransaction().commit();
//            return convertToDTO(updateTask);
//
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//
//
//    public boolean delete(Long id) {
//        try {
//            em.getTransaction().begin();
//
//            Task task = em.find(Task.class, id);
//            if (task == null)
//                return false;
//
//            em.remove(task);
//            em.getTransaction().commit();
//            return true;
//
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
//
//    public List<TaskDTO> getAllTasks(){
//        List<TaskDTO> taskList=new ArrayList<>();
//
//        try{
//            String jpql="SELECT t FROM Task t";
//            List<Task> tasks=em.createQuery(jpql,Task.class).getResultList();
//
//            for(Task t:tasks){
//                taskList.add(convertToDTO(t));
//            }
//
//            System.out.println("Retrived "+tasks+" tasks from database");
//            return taskList;
//        }catch (Exception e){
//            System.out.println("Error : "+e.getMessage());
//            return null;
//        }
//    }
//
//    public void close() {
//        if (em.isOpen()) em.close();
//        if (emf.isOpen()) emf.close();
//    }
//
//    private TaskDTO convertToDTO(Task task) {
//        return new TaskDTO(
//                task.getId(),
//                task.getTash(),
//                task.getDescription()
//        );
//    }
//}