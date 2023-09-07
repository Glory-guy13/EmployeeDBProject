package edbms;

import java.util.Scanner;

import customException.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		EmployeeDBManagementSystem emp = (EmployeeDBManagementSystem)new EmployeeDBManagementSystemImpl();
		while(true) {
			System.out.println("-------------------------------------");
			System.out.println("Enter your choice from below options");
			System.out.println("1:Add Employee\n2:Display Employee\n3:Display All Employee\n4:Delete Employee\n5:Delete All Employees\n6:Count Employees\n7:Upadate Employee\n8:Sort Employees\n9:Employee With Highest Salary\n10:Employee With Lowest Salary\n11:Exit");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch(choice) {
			case 1:
				emp.addEmployee();
				break;
			case 2:
				emp.displayEmployee();
				break;
			case 3:
				emp.displayAllEmployees();
				break;
			case 4:
				emp.deleteEmployee();
				break;
			case 5:
				emp.deleteAllEmployees();
				break;
			case 6:
				emp.countEmployees();
				break;
			case 7:
				emp.updateEmployee();
				break;
			case 8:
				emp.sortEmployees();
				break;
			case 9:
				emp.employeeWithhighestSalary();
				break;
			case 10:
				emp.EMployeeWithLowestSalary();
				break;
			case 11:
				System.out.println("Thank You Visit again");
				System.exit(0);
				break;
			default :
				try {
					String m = "Invalid choice Enter Valid choice";
					throw new InvalidChoiceException(m);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
