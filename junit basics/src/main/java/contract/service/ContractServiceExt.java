package contract.service;

import java.math.BigDecimal;

/**
 * This is external service to receive information about signed contract. We can't implement it!
 * @author rbuchals
 *
 */
public interface ContractServiceExt {
    /**
     * Returns salary for given month and technical identifier of employee.
     * @param employeeId technical identifier of employee.
     * @param month number of month starting with 0 as January
     * @return salary from signed contract
     * 
     * @throws IllegalStateException, when no contract for the given technical identifier of employee was found
     * @throws IllegalArgumentException, when month exceeds 11
     */
    BigDecimal getSalaryFromContract(Long employeeId, Integer month);
}
