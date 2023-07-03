package employee.crud.ResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {
	 private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

//The serializable class ResourceNotFoundException does not declare a static final serialVersionUID field of type long