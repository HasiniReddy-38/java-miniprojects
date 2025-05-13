package employedetails;

public class Employee {
	 int empNo;
	 String empName;
	 String department;
	 String designation;
	 double salary;  
	 public Employee(int empNo, String empName, String department, String designation, double salary) {
	     this.empNo = empNo;
	     this.empName = empName;
	     this.department = department;
	     this.designation = designation;
	     this.salary = salary;
	    }
	 public void display() {
	     System.out.println("EmpNo: " + empNo);
	     System.out.println("EmpName: " + empName);
	     System.out.println("Department: " + department);
	     System.out.println("Designation: " + designation);
	     System.out.println("Salary: " + salary);
	    }
	
	 

}
