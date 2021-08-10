package exceptions;

public class ValueOutOfRangeException extends Exception {
	
	public String msg ;
	
	public ValueOutOfRangeException(String exceptionMsg) {
		this.msg = exceptionMsg;
	}

}
