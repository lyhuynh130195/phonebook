package common;

public class EmailException extends Exception{
    public EmailException() {
        super("Email không hợp lệ");
    }
}
