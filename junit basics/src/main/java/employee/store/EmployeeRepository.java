package employee.store;

import employee.model.Employee;

/**
 * The repository for gathering information about employees.
 */
public interface EmployeeRepository {
    /**
     * Saves information about employee.
     * @param entity see {@link Employee}
     * @return saved {@link Employee}
     */
    Employee save(Employee entity);
    
    /**
     * Finds {@link Employee} by technical identifier.
     * @param primaryKey technical identifier
     * @return {@link Employee} or null, when no employee found
     */
    Employee findOne(Long primaryKey);
    
    /**
     * Finds all {@link Employee}s from the database.
     * @return Iterator over all {@link Employee}s.
     */
    Iterable<Employee> findAll();
    
    /**
     * Deletes {@link Employee}.
     * @param entity Employee
     */
    void delete(Employee entity);
    
    /**
     * Returns true, when employee with the given technical identifier was found.
     * @param primaryKey technical identifier of {@link Employee}
     * @return true, when employee with the given technical identifier was found.
     */
    boolean exists(Long primaryKey);
}
