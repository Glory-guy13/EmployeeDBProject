package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import customException.EmployeeNotFoundException;
import customException.InvalidChoiceException;
import customSorting.SortEmployeeByAge;
import customSorting.SortEmployeeById;
import customSorting.SortEmployeeByName;
import customSorting.SortEmployeeBySal;

public class EmployeeDBManagementSystemImpl implements EmployeeDBManagementSystem {

	Scanner s = new Scanner(System.in);
	Map<String,Employee> db = new LinkedHashMap<String,Employee>();

	@Override
	public void addEmployee() {
		System.out.println("Enter Employee Name:");
		String name= s.next();
		System.out.println("Enter Employee Age:");
		int age = s.nextInt();
		System.out.println("Enter Employee Salary:");
		double sal = s.nextDouble();
		Employee e1 = new Employee(name, age, sal);
		db.put(e1.getId(), e1);
		System.out.println("Employee Added Successfully..!!!!!");
	}

	@Override
	public void displayEmployee() {
		System.out.println("Enter Employee id:");
		String id = s.next().toUpperCase();
		if(db.containsKey(id)) {
			Employee e = db.get(id);
			System.out.println("Employee Id:\t"+e.getId());
			System.out.println("Employee Name:\t"+e.getName());
			System.out.println("Employee Age:\t"+e.getAge());
			System.out.println("EMployee Sal:\t"+e.getSal());
			System.out.println("---------------------------");
		}
		else {
			try {
				String message = id+" this ID Employee not found"; 
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
	}

	@Override
	public void displayAllEmployees() {
		if(db.size()!=0) {
			System.out.println("--------------------Employee records are----------------");
			Set<String> keys = db.keySet();
			for(String key : keys) {
				Employee e = db.get(key);
				System.out.println(e);
			}

		}
		else {
			try {
				String msg = "No Employees Data for display";
				throw new EmployeeNotFoundException(msg);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void deleteEmployee() {
		System.out.println("Enter Id for Delete:");
		String id = s.next().toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Data Deleted Successfully..!!!");
		}
		else {
			try {
				String msg = "No Employees Data for delete";
				throw new EmployeeNotFoundException(msg);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void deleteAllEmployees() {
		if(db.size()!=0) {
			db.clear();
			System.out.println("All Employees data deleted.");
		}
		else {
			try {
				String m = "No data for delete";
				throw new EmployeeNotFoundException(m);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countEmployees() {
		if(db.size()!=0) {
			System.out.println("Number of Employees : "+db.size());
		}
		else {
			try {
				String message = "No Employees data";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void updateEmployee() {

		System.out.println("Enter your Employee Id for update");
		String id = s.next().toUpperCase();
		if(db.containsKey(id)) {
			Employee e = db.get(id);
			System.out.println("1:Update Name\n2:Update Age\n3:Update Salary");
			int choice = s.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Name for update:");
				String name = s.next();
				e.setName(name);
				System.out.println("Name Updated Successfully..!!");
				break;
			case 2:
				System.out.println("Enter a Age for Update:");
				int age = s.nextInt();
				e.setAge(age);
				System.out.println("Age Updated Successfully");
				break;
			case 3:
				System.out.println("Enter Salary for update:");
				double sal = s.nextDouble();
				e.setSal(sal);
				System.out.println("Salary update Successfully");
				break;
			default :
				try {
					String msg = "invalid choice";
					throw new InvalidChoiceException(msg);

				}
				catch(Exception e1) {
					System.out.println(e1.getMessage());

				}
			}
		}
		else {
			try {
				String message = "No Employee data in this ID: "+id;
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void sortEmployees() {
		if(db.size()>=2) {
			Set <String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for(String key : keys) {
				list.add(db.get(key));
			}
			System.out.println("Enter Sorting option");
			System.out.println("1:Sort Employee by id\n2:Sort Employee by Age\n3:Sort employee by name\n4:Sort Employee salary");
			int choice = s.nextInt();
			switch(choice) {
			case 1:
				Collections.sort(list , new SortEmployeeById());
				view(list);
				break;
			case 2:
				Collections.sort(list, new SortEmployeeByAge());
				view(list);
				break;
			case 3:
				Collections.sort(list, new SortEmployeeByName());
				view(list);
				break;
			case 4:
				Collections.sort(list, new SortEmployeeBySal());
				view(list);
				break;
			default :
				try {
					String message = "Enter A Valid choice";
					throw new InvalidChoiceException(message);
				}	
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message = "No Suffient data for sorting";
				throw new EmployeeNotFoundException(message);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	private static void view(List<Employee> listM){
		for(Employee e : listM) {
			System.out.println(e);
		}
	}

	@Override
	public void employeeWithhighestSalary() {
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee> ();
			for(String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortEmployeeBySal());
			System.out.println(list.get(db.size()-1));

		}
		else {
			try {
				String message = "No Suffient data";
				throw new EmployeeNotFoundException(message);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void EMployeeWithLowestSalary() {
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee> ();
			for(String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortEmployeeBySal());
			System.out.println(list.get(0));

		}
		else {
			try {
				String message = "No Suffient data";
				throw new EmployeeNotFoundException(message);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}


	}



}
