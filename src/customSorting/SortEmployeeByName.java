package customSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeByName implements Comparator<Employee> {
	
	public int compare(Employee e1 , Employee e2) {
		String a = e1.getName();
		String b = e2.getName();
		return a.compareTo(b);
	}

}
