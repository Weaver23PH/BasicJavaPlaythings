package employee.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import contract.service.ContractServiceExt;
import employee.model.Employee;
import employee.service.EmployeeService;
import employee.service.NoEmployeeFoundBusinessException;
import employee.store.EmployeeRepository;
import payment.calculator.PaymentCalculator;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    ContractServiceExt contractService;
    PaymentCalculator calculateFinalPayment;
    

    public BigDecimal getPaymentAmountForMonth(String name, String surname, Integer month) {
        Employee chosenEmployee = findCorrectEmployee(name, surname);
        BigDecimal salaryFromContract = contractService.getSalaryFromContract(chosenEmployee.getId(), month);
        return calculateFinalPayment.getPaymentAmountForMonth(chosenEmployee, month, salaryFromContract);
        
    }
    
    public Employee findCorrectEmployee(String name, String surname) throws NoEmployeeFoundBusinessException {
        Optional<Employee> switchEmployee = Optional.empty();
        for (Employee chosenEmployee : employeeRepository.findAll()) {
            if (chosenEmployee.getName() == name && chosenEmployee.getSurname() == surname) {
                switchEmployee = Optional.of(chosenEmployee);
                break;
            }
        }
        return switchEmployee.orElseThrow(() -> new NoEmployeeFoundBusinessException(name, surname));
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void setContractService(ContractServiceExt contractService) {
        this.contractService = contractService;
    }

    public void setCalculateFinalPayment(PaymentCalculator calculateFinalPayment) {
        this.calculateFinalPayment = calculateFinalPayment;
    }
}
