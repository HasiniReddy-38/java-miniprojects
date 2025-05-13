package employedetails;

import java.io.*;
import java.util.*;

public class Employeefile {
	public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("employee.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int empNo = Integer.parseInt(data[0]);
                String name = data[1];
                String dept = data[2];
                String desig = data[3];
                double salary = Double.parseDouble(data[4]);
                employeeList.add(new Employee(empNo, name, dept, desig, salary));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return;
        }
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Employee Number to search (or 0 to list all): ");
            int empNo = Integer.parseInt(scanner.nextLine());

            if (empNo == 0) {
                System.out.println("\nAll Employees:");
                for (Employee emp : employeeList) {
                    emp.display();
                    System.out.println("------------------");
                }
            } else {
                boolean found = false;
                for (Employee emp : employeeList) {
                    if (emp.empNo == empNo) {
                        System.out.println("\nEmployee Details:");
                        emp.display();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Employee not found.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
	
    
}
