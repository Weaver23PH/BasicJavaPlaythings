package employee.service;

/** 
 * Exception thrown, when no employee is found.
 * @author rbuchals
 *
 */
public class NoEmployeeFoundBusinessException extends RuntimeException {
    private static final long serialVersionUID = 2252289726341350812L;
    
    private final String name;
    private final String surname;
    
    public NoEmployeeFoundBusinessException(String name, String surname) {
        super();
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
