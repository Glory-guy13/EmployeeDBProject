package customSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeById implements Comparator<Employee>{
	
	public int compare(Employee e1 , Employee e2) {
		String x = e1.getId();
		String y = e2.getId();
		return x.compareTo(y);
	}

}
