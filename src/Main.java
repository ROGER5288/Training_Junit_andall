import java.sql.*;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try (Connection conn = DatabaseConfig.getConnection()) {

            int choice;

            do {
                System.out.println("\n===== TASK MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Task");
                System.out.println("2. View All Tasks");
                System.out.println("3. Update Task");
                System.out.println("4. Delete Task");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        insertTask(conn);
                        break;
                    case 2:
                        viewTasks(conn);
                        break;
                    case 3:
                        updateTask(conn);
                        break;
                    case 4:
                        deleteTask(conn);
                        break;
                    case 5:
                        System.out.println("Exiting Program...");
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void insertTask(Connection conn) throws SQLException {

        String sql = "INSERT INTO tasks(title, description) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Description: ");
        String desc = sc.nextLine();

        pstmt.setString(1, title);
        pstmt.setString(2, desc);

        int rows = pstmt.executeUpdate();

        if (rows > 0)
            System.out.println("Task Added Successfully!");

        pstmt.close();
    }

    private static void viewTasks(Connection conn) throws SQLException {

        String sql = "SELECT * FROM tasks";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n---- TASK LIST ----");

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Title: " + rs.getString("title"));
            System.out.println("Description: " + rs.getString("description"));
            System.out.println("----------------------");
        }

        rs.close();
        stmt.close();
    }

    private static void updateTask(Connection conn) throws SQLException {

        System.out.print("Enter Task ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "UPDATE tasks SET title=?, description=? WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        System.out.print("Enter New Title: ");
        String title = sc.nextLine();

        System.out.print("Enter New Description: ");
        String desc = sc.nextLine();

        pstmt.setString(1, title);
        pstmt.setString(2, desc);
        pstmt.setInt(3, id);

        int rows = pstmt.executeUpdate();

        if (rows > 0)
            System.out.println("Task Updated Successfully!");
        else
            System.out.println("Task Not Found!");

        pstmt.close();
    }

    private static void deleteTask(Connection conn) throws SQLException {

        System.out.print("Enter Task ID to Delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM tasks WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        int rows = pstmt.executeUpdate();

        if (rows > 0)
            System.out.println("Task Deleted Successfully!");
        else
            System.out.println("Task Not Found!");

        pstmt.close();
    }
}



//import java.sql.*;
//import java.util.Scanner;
//
//public class Main {
//    //User Input
//    public static void main(String[] args) throws Exception {
//
//        Scanner sc = new Scanner(System.in);
//
//        Connection conn = DatabaseConfig.getConnection();
//
//        PreparedStatement pstmt = conn.prepareStatement(
//                "INSERT INTO tasks(title, description) VALUES (?,?)"
//        );
//
//        System.out.print("Enter number of tasks to insert: ");
//        int n = sc.nextInt();
//        sc.nextLine();
//
//        for (int i = 1; i <= n; i++) {
//
//            System.out.println("\nEnter details for Task " + i);
//
//            System.out.print("Enter Title: ");
//            String title = sc.nextLine();
//
//            System.out.print("Enter Description: ");
//            String description = sc.nextLine();
//
//            pstmt.setString(1, title);
//            pstmt.setString(2, description);
//
//            pstmt.executeUpdate();
//
//            System.out.println("Task " + i + " Added Successfully!");
//        }
//
//        pstmt.close();
//        conn.close();
//        sc.close();
//
//        System.out.println("\nAll Tasks Inserted Successfully!");
//    }
//}



//import java.sql.*;
//
//public class Main {
//     Normal Input from given inside class
//    public static void main(String[] args) throws Exception {
//        Connection conn = DatabaseConfig.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tasks(title, description) VALUES (?,?)");
//        pstmt.setString(1, "JDBS Testing");
//        pstmt.setString(2, "This is the jdbc Testing description");
//        pstmt.executeUpdate();
//
//        System.out.println("Task Added!");
//        pstmt.close();
//        conn.close();
//    }
//}