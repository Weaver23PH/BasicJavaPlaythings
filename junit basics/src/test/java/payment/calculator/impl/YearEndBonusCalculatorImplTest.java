package payment.calculator.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.fest.assertions.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import employee.model.Employee;
import employee.model.EmployeeBuilder;
import employee.model.EmploymentStatus;
import payment.calculator.impl.YearEndBonusCalculatorImpl;

public class YearEndBonusCalculatorImplTest {
    private YearEndBonusCalculatorImpl calculator;
    private final BigDecimal SALARY = new BigDecimal(1000);
    private final BigDecimal NO_BONUS = new BigDecimal(0);
    
    @Before
    public void setUp() {
        calculator = new YearEndBonusCalculatorImpl();
    }
    
    @Test
    public void shouldReceive20PercentBonusIfEmployedLongerThan3Years() {
        // given
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withYearsEmployed(4).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        BigDecimal checkAgainst = SALARY.multiply(new BigDecimal(0.2)).setScale(2, RoundingMode.HALF_EVEN);
        // then
        assertEquals(getsBonus, checkAgainst);
    }
    
    @Test
    public void shouldNotReceive20PercentBonusIfEmployedLessThan3Years() {
        // given
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withYearsEmployed(2).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        // then
        assertThat(getsBonus, equalTo(NO_BONUS));
    }
    
    @Test
    public void shouldNotReceive20PercentBonusIfEmployedExactly3Years() {
        // given
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withYearsEmployed(3).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        // then
        assertThat(getsBonus, equalTo(NO_BONUS));
    }
    
    @Test
    public void shouldReceive30PercentBonusIfEmployedLongerThan5Years() {
        // given
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withYearsEmployed(6).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        BigDecimal checkAgainst = SALARY.multiply(new BigDecimal(0.3)).setScale(2, RoundingMode.HALF_EVEN);
        // then
        assertThat(getsBonus, equalTo(checkAgainst));
    }
    
    @Test
    public void shouldNotReceive30PercentBonusIfEmployedLessThan5Years() {
        // given
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withYearsEmployed(4).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        BigDecimal checkAgainst = SALARY.multiply(new BigDecimal(0.3)).setScale(2, RoundingMode.HALF_EVEN);
        // then
        assertThat(getsBonus).isNotEqualTo(checkAgainst);
    }
    
    @Test
    public void shouldNotReceive30PercentBonusIfEmployedExactly5Years() {
        // given
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withYearsEmployed(5).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        BigDecimal checkAgainst = SALARY.multiply(new BigDecimal(0.3)).setScale(2, RoundingMode.HALF_EVEN);
        // then
        assertThat(getsBonus).isNotEqualTo(checkAgainst);
    }
    
    @Test
    public void shouldReceive50PercentBonusIfEmployedLongerThan8Years() {
        // given
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withYearsEmployed(9).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        BigDecimal checkAgainst = SALARY.multiply(new BigDecimal(0.5)).setScale(2, RoundingMode.HALF_EVEN);
        // then
        assertThat(getsBonus, equalTo(checkAgainst));
        ;
    }
    
    @Test
    public void shouldNotReceive50PercentBonusIfEmployedLessThan8Years() {
        // given
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withYearsEmployed(7).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        BigDecimal checkAgainst = SALARY.multiply(new BigDecimal(0.5)).setScale(2, RoundingMode.HALF_EVEN);
        // then
        assertThat(getsBonus).isNotEqualTo(checkAgainst);
    }
    
    @Test
    public void shouldNotReceive50PercentBonusIfEmployedExactly8Years() {
        // given
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withYearsEmployed(8).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        BigDecimal checkAgainst = SALARY.multiply(new BigDecimal(0.5)).setScale(2, RoundingMode.HALF_EVEN);
        // then
        assertThat(getsBonus).isNotEqualTo(checkAgainst);
    }
    
    @Test
    public void shouldNotReceiveBonusIfSelfEmployed() {
        EmploymentStatus employed = EmploymentStatus.SELF_EMPLOYED;
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withEmploymentStatus(employed).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        // then
        assertThat(getsBonus, equalTo(NO_BONUS));
    }
    
    @Test
    public void shouldNotReceiveBonusIfRetired() {
        EmploymentStatus employed = EmploymentStatus.RETIRED;
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withEmploymentStatus(employed).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        // then
        assertThat(getsBonus, equalTo(NO_BONUS));
    }
    
    @Test
    public void shouldNotReceiveBonusIfLeaver() {
        EmploymentStatus employed = EmploymentStatus.LEAVER;
        Employee employee = EmployeeBuilder.anEmployee().correctEmployedEmployee()
                .withEmploymentStatus(employed).Build();
        // when
        BigDecimal getsBonus = calculator.getYearEndBonus(employee, SALARY);
        // then
        assertThat(getsBonus, equalTo(NO_BONUS));
    }
    
}
