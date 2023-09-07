package customSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByAge implements Comparator<Employee>{
	
	public int compare(Employee e1, Employee e2) {
		Integer a = e1.getAge();
		Integer b = e2.getAge();
		return a.compareTo(b);
	}
}
