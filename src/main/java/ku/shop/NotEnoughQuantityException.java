package ku.shop;

public class NotEnoughQuantityException extends Exception {
    public NotEnoughQuantityException() {}
    public NotEnoughQuantityException(String reason) {
        super(reason);
    }
}
