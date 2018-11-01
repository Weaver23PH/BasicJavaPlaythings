package payment.calculator.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

import employee.model.Employee;
import employee.model.EmploymentStatus;
import payment.calculator.YearEndBonusCalculator;

public class YearEndBonusCalculatorImpl implements YearEndBonusCalculator {
    
    @Override
    public BigDecimal getYearEndBonus(Employee employee, BigDecimal salary) {
        LocalDate yearEnd = LocalDate.now();
        LocalDate employed = employee.getDateOfEmployment();
        int period = (Period.between(employed, yearEnd).getYears());
        if (employee.getEmploymentStatus().equals(EmploymentStatus.EMPLOYED)) {
            if (period > 3 && period <= 5) {
                BigDecimal bonus = salary.multiply(new BigDecimal(0.2)).setScale(2, RoundingMode.HALF_EVEN);
                return bonus;
            } else if (period > 5 && period <= 8) {
                BigDecimal bonus = salary.multiply(new BigDecimal(0.3)).setScale(2, RoundingMode.HALF_EVEN);
                return bonus;
            } else if (period > 8) {
                BigDecimal bonus = salary.multiply(new BigDecimal(0.5)).setScale(2, RoundingMode.HALF_EVEN);
                return bonus;
            }
        }
        return new BigDecimal(0);
    }
    
}
