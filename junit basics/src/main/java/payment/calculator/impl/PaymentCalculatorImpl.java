package payment.calculator.impl;

import java.math.BigDecimal;

import employee.model.Employee;
import payment.calculator.PaymentCalculator;
import payment.calculator.impl.YearEndBonusCalculatorImpl;

public class PaymentCalculatorImpl implements PaymentCalculator {
    private final int MONTH_WITH_BONUS = 11;
    private YearEndBonusCalculatorImpl endBonusCalc = new YearEndBonusCalculatorImpl();
    
    public BigDecimal getPaymentAmountForMonth(Employee employee, int month, BigDecimal salary) {
        if (month >= 0 && month <= 11) {
            if (month == MONTH_WITH_BONUS) {
                return salary.add(endBonusCalc.getYearEndBonus(employee, salary));
            }
        }
        return salary;
    }
}
