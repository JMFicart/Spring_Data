package bstorm.jmficart.demo_jpa.exception;

public class ElementAlreadyExistsException extends RuntimeException {
    public ElementAlreadyExistsException() {
        super("Elément existe déjà !");
    }
}
