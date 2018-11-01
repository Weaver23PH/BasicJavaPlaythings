package employee.service.impl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import employee.model.Employee;
import employee.model.EmployeeBuilder;
import employee.service.NoEmployeeFoundBusinessException;
import employee.service.impl.EmployeeServiceImpl;
import employee.store.EmployeeRepository;
import payment.calculator.PaymentCalculator;
import payment.calculator.impl.YearEndBonusCalculatorImpl;
import contract.service.ContractServiceExt;

public class EmployeeServiceImplTest {
    private EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
    private ContractServiceExt contractService = Mockito.mock(ContractServiceExt.class);
    private PaymentCalculator paymentCalculator = Mockito.mock(PaymentCalculator.class);
    private YearEndBonusCalculatorImpl yearEndBonus;
    private EmployeeServiceImpl employeeServer;
    private Integer month;
    private Employee employee;
    private final BigDecimal SALARY = new BigDecimal(10000);
    
    @Rule public final ExpectedException exception = ExpectedException.none();
   
    @Parameters
    public static int returnMonth() {
        int[] months = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int month : months) {
            return month;
        }
        return 0;
    }
    @Before
    public void setUp() {
        employeeServer = new EmployeeServiceImpl();
        employeeServer.setEmployeeRepository(employeeRepository);
        employeeServer.setContractService(contractService);
        employeeServer.setCalculateFinalPayment(paymentCalculator);
        yearEndBonus = new YearEndBonusCalculatorImpl();
        employee = EmployeeBuilder.anEmployee().correctEmployedEmployee().Build();
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee);
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
        Mockito.when(contractService.getSalaryFromContract(Mockito.any(Long.class), Mockito.any(Integer.class))).thenReturn(SALARY);
        Mockito.when(paymentCalculator.getPaymentAmountForMonth(employee, 11, SALARY))
                .thenReturn(SALARY.add((yearEndBonus.getYearEndBonus(employee, SALARY))));
        Mockito.when(paymentCalculator.getPaymentAmountForMonth(employee, returnMonth(), SALARY)).thenReturn(SALARY);
        // Mockito.when(paymentCalculator.getPaymentAmountForMonth(employee,(AdditionalMatchers.not(Matchers.eq(11))),
        // SALARY)).thenReturn(SALARY);
    }
    
    @Test
    public void shouldReturnCorrectSalaryIfNotBonusMonth() {
        // given
        month = returnMonth();
        // when
        BigDecimal requestedSalary = employeeServer.getPaymentAmountForMonth(employee.getName(), employee.getSurname(),
                month);
        // then
        assertThat(requestedSalary, equalTo(SALARY));
    }
    
    @Test
    public void shouldReturnCorrectSalaryWithBonusIfBonusMonth() {
        // given
        month = 11;
        // when
        BigDecimal requestedSalary = employeeServer.getPaymentAmountForMonth(employee.getName(), employee.getSurname(),
                month);
        BigDecimal expectedSalary = SALARY.add((yearEndBonus.getYearEndBonus(employee, SALARY)));
        // then
        assertThat(requestedSalary, equalTo(expectedSalary));
    }
    
    
    @Test
    public void shouldThrowExceptionIfWrongName() {
        // given
        String wrongName = " ";
        exception.expect(NoEmployeeFoundBusinessException.class);
        // when
        employeeServer.findCorrectEmployee(wrongName, employee.getSurname());
        
    }
    
    @Test
    public void shouldThrowExceptionIfWrongSurname() {
        // given
        String wrongName = " ";
        exception.expect(NoEmployeeFoundBusinessException.class);
        // when
        employeeServer.findCorrectEmployee(employee.getName(), wrongName);
        
    }
}
