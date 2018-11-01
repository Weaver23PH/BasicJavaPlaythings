package payment.calculator.impl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;

import employee.model.Employee;
import employee.model.EmployeeBuilder;
import payment.calculator.impl.PaymentCalculatorImpl;

@RunWith(Parameterized.class)
public class PaymentCalculatorImplParameterizedTest {
    private Employee employee;
    private BigDecimal salary;
    private int month;
    private PaymentCalculatorImpl paymentCalculator;
    private BigDecimal expectedSalary;
    
    @Before
    public void setUp() {
        paymentCalculator = new PaymentCalculatorImpl();
    }
    
    public PaymentCalculatorImplParameterizedTest(int month, BigDecimal salary, BigDecimal expectedSalary) {
        this.employee = EmployeeBuilder.anEmployee().correctEmployedEmployee().Build();
        this.month = month;
        this.salary = salary;
        this.expectedSalary = expectedSalary;
    }
    
    @Parameters
    public static Collection<Object[]> monthAndSalaryServer() {
        BigDecimal basicSalary = new BigDecimal(10000).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal bonusMonthSalary = new BigDecimal(15000).setScale(2, RoundingMode.HALF_EVEN);
        return Arrays.asList(new Object[][] {
                { 0, basicSalary, basicSalary },
                { 1, basicSalary, basicSalary },
                { 2, basicSalary, basicSalary },
                { 3, basicSalary, basicSalary },
                { 4, basicSalary, basicSalary },
                { 5, basicSalary, basicSalary },
                { 6, basicSalary, basicSalary },
                { 7, basicSalary, basicSalary },
                { 8, basicSalary, basicSalary },
                { 9, basicSalary, basicSalary },
                { 10, basicSalary, basicSalary },
                { 11, basicSalary, bonusMonthSalary }
        });
        
    }
    
    @Test
    public void shouldOnlyReceiveBasicSalaryIfBonusMonth() {
        // when
        BigDecimal bonusSalary = paymentCalculator.getPaymentAmountForMonth(employee, month, salary);
        // then
        assertThat(expectedSalary, is(bonusSalary));
    }
    
}
