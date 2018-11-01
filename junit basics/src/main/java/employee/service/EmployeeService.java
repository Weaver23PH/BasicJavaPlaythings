package employee.service;

import java.math.BigDecimal;

import employee.model.Employee;

public interface EmployeeService {
    /**
     * Retrieves amount of money for the given employee and month.
     * 
     * @param name Name of {@link Employee}
     * @param surname Surname of {@link Employee}
     * @param month number of month starting with 0 as januar
     * @throws NoEmployeeFoundBusinessException when no employee was found
     * @throws PaymentCalculationBusinessException when payment calculation wasn't possible from any reason  
     */
    BigDecimal getPaymentAmountForMonth(String name, String surname, Integer month);
}