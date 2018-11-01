package payment.calculator;

import java.math.BigDecimal;

import employee.model.Employee;

/**
 * This is service for calculating year end bonus with december salary.
 * @author rbuchals
 *
 */
public interface YearEndBonusCalculator {
    
    /**
     * Calculates year end bonus for employee.
     * @param employee see {@link Employee}
     * @param salary salary from contract signed by employee.
     * @return year end bonus. Yipee!!
     */
    BigDecimal getYearEndBonus(Employee employee, BigDecimal salary);
    
}
