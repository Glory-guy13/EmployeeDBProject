package customSorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeBySal implements Comparator<Employee> {
		
	public int compare(Employee e1 , Employee e2) {
		Double b = e1.getSal();//Auto-Boxing
		Double c = e2.getSal();
		return b.compareTo(c);
		
//		e1->object to be inserted         e2->already existing object
	}
}
