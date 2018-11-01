package payment.calculator;

import java.math.BigDecimal;

import employee.model.Employee;

public interface PaymentCalculator {
    public BigDecimal getPaymentAmountForMonth(Employee employee, int month, BigDecimal salary);
}
