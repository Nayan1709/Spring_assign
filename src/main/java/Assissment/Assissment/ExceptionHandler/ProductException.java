package Assissment.Assissment.ExceptionHandler;

public class ProductException extends Exception{

    private String errormessage;

    public ProductException() {
    }

    public ProductException(String message, String errormessage) {
        super(message);
        this.errormessage = errormessage;
    }

    public String getErrormessage() {
        return errormessage;
    }
}