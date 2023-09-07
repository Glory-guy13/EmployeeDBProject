package customException;

public class EmployeeNotFoundException extends RuntimeException {

	private String msg;

	public EmployeeNotFoundException(String msg) {
		this.msg=msg;
	}
	public String getMessage() {
		return msg;
	}

}
