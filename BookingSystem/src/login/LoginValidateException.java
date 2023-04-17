package login;


public class LoginValidateException extends RuntimeException {
    public LoginValidateException() {
    }

    public LoginValidateException(String message) {
        super(message);
    }
}