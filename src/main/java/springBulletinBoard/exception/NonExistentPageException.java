package springBulletinBoard.exception;

public class NonExistentPageException extends RuntimeException {

	public NonExistentPageException(String message) {
		super(message);
	}

}
