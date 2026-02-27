import java.sql.*;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try (Connection conn = DatabaseConfig.getConnection()) {

            int choice;

            do {
                System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Department");
                System.out.println("2. Add Student");
                System.out.println("3. View Students (With Department)");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addDept(conn);
                        break;
                    case 2:
                        addStudent(conn);
                        break;
                    case 3:
                        viewStudents(conn);
                        break;
                    case 4:
                        updateStudent(conn);
                        break;
                    case 5:
                        deleteStudent(conn);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addDept(Connection conn) throws SQLException {

        String sql = "INSERT INTO Dept VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        System.out.print("Enter Dept ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Dept Name: ");
        String name = sc.nextLine();

        ps.setInt(1, id);
        ps.setString(2, name);

        ps.executeUpdate();
        System.out.println("Department Added!");

        ps.close();
    }

    private static void addStudent(Connection conn) throws SQLException {

        String sql = "INSERT INTO Student(name, age, dept_id) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Dept ID: ");
        int deptId = sc.nextInt();
        sc.nextLine();

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, deptId);

        ps.executeUpdate();
        System.out.println("Student Added!");

        ps.close();
    }

    private static void viewStudents(Connection conn) throws SQLException {

        String sql = "SELECT s.id, s.name, s.age, d.dept_name " +
                "FROM Student s JOIN Dept d ON s.dept_id = d.dept_id";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n--- STUDENT LIST ---");

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Department: " + rs.getString("dept_name"));
            System.out.println("-----------------------");
        }

        rs.close();
        stmt.close();
    }

    private static void updateStudent(Connection conn) throws SQLException {

        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "UPDATE Student SET name=?, age=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Student Updated!");
        else
            System.out.println("Student Not Found!");

        ps.close();
    }

    private static void deleteStudent(Connection conn) throws SQLException {

        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM Student WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Student Deleted!");
        else
            System.out.println("Student Not Found!");

        ps.close();
    }
}