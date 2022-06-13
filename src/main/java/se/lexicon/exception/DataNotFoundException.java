package se.lexicon.exception;

public class DataNotFoundException extends Exception {

    private String objectName;

    public DataNotFoundException(String not_found, String student) {
        super(message);
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }
}
