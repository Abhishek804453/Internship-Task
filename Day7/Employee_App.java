import java.sql.*;
import java.util.Scanner;

class EmployeeDBApp {
    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASSWORD = "Abhi@9808";

    // Driver load karne ka code
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver Loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void testConnection() {
        try (Connection con = getConnection()) {
            System.out.println("Database Connected Successfully");
        } catch (SQLException e) {
            System.out.println("Error Connecting: " + e.getMessage());
        }
    }

    public static void addEmployee(int id, String name, double salary) {
        String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);
            ps.executeUpdate();
            System.out.println("Employee Added");
        } catch (SQLException e) {
            System.out.println("Error Adding Employee: " + e.getMessage());
        }
    }

    public static void viewEmployees() {
        String sql = "SELECT * FROM employee";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("\n---- Employee Records ----");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("--------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error Viewing Employees: " + e.getMessage());
        }
    }

    public static void updateEmployee(int id, double newSalary) {
        String sql = "UPDATE employee SET salary = ? WHERE id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, newSalary);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee Updated");
            else
                System.out.println("Employee Not Found");
        } catch (SQLException e) {
            System.out.println("Error Updating Employee: " + e.getMessage());
        }
    }

    public static void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee Deleted");
            else
                System.out.println("Employee Not Found");
        } catch (SQLException e) {
            System.out.println("Error Deleting Employee: " + e.getMessage());
        }
    }
}

public class Employee_App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // pehle connection test karlo
        EmployeeDBApp.testConnection();

        while (true) {
            System.out.println("\n=== Employee Database App ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    EmployeeDBApp.addEmployee(id, name, salary);
                    break;

                case 2:
                    EmployeeDBApp.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    EmployeeDBApp.updateEmployee(uid, newSalary);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    int did = sc.nextInt();
                    EmployeeDBApp.deleteEmployee(did);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice, Try Again.");
            }
        }
    }
}
