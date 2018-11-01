package employee.service.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import payment.calculator.impl.PaymentCalculatorImplParameterizedTest;
import payment.calculator.impl.YearEndBonusCalculatorImplTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        YearEndBonusCalculatorImplTest.class,
        PaymentCalculatorImplParameterizedTest.class,
        EmployeeServiceImplTest.class
})
public class RunAllTests {
}
