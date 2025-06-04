/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motorphemployees;

/**
 *
 * @author Mark Montero, Lyca Mae Benipayo, Juan Francis Manongdo
 */

import java.util.*;

// Employees classd

class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;
    
    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    
    // Setters
    public void setSalary(double salary) { this.salary = salary; }
    
    @Override
    public String toString() {
        return String.format("ID: %d | %s | %s | ₱%.2f", id, name, position, salary);
    }
}

// Employees Manager 3.0
class EmployeeManager {
    private List<Employee> employees;
    private int nextId;
    
    public EmployeeManager() {
        employees = new ArrayList<>();
        nextId = 1001;
        // Sample data
        addEmployee("Mark Montero", "Developer", 45550);
        addEmployee("Lyca Mae Benipayo", "Developer", 34000);
        addEmployee("Juan Francis Manongdo", "Developer", 36070);
    }
    
    public void addEmployee(String name, String position, double salary) {
        employees.add(new Employee(nextId++, name, position, salary));
        System.out.println("Employee added: " + name);
    }
    
    public void displayAll() {
        System.out.println("\n=== MOTORPH EMPLOYEES ===");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
    
    public Employee findById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) return emp;
        }
        return null;
    }
    
    public void updateSalary(int id, double newSalary) {
        Employee emp = findById(id);
        if (emp != null) {
            emp.setSalary(newSalary);
            System.out.println("Salary updated for " + emp.getName());
        } else {
            System.out.println("Employee not found!");
        }
    }
    
    public void removeEmployee(int id) {
        Employee emp = findById(id);
        if (emp != null) {
            employees.remove(emp);
            System.out.println("Removed: " + emp.getName());
        } else {
            System.out.println("Employee not found!");
        }
    }
}

// The Main Application 3.0

public class MotorPHEmployeesApp {
    private static EmployeeManager manager = new EmployeeManager();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("MotorPH Employee System");
        
        while (true) {
            System.out.println("\n1. View Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Update Salary");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    manager.displayAll();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    updateSalary();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void addEmployee() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        
        manager.addEmployee(name, position, salary);
    }
    
    private static void updateSalary() {
        System.out.print("Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("New Salary: ");
        double salary = scanner.nextDouble();
        
        manager.updateSalary(id, salary);
    }
    
    private static void removeEmployee() {
        System.out.print("Employee ID: ");
        int id = scanner.nextInt();
        
        manager.removeEmployee(id);
    }
}