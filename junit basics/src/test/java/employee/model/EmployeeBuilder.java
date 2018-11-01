package employee.model;

import java.time.LocalDate;

public  class EmployeeBuilder {
    private static Employee underConstruction = null;
    
    private EmployeeBuilder() {}
    
    public static EmployeeBuilder anEmployee() {
        EmployeeBuilder creator = new EmployeeBuilder();
        EmployeeBuilder.underConstruction = new Employee();
        return creator;
    }
    
    public EmployeeBuilder correctEmployedEmployee() {
        withId(1234567890L);
        withName("James");
        withSurname("Johnson");
        withDateOfEmployment(LocalDate.of(2009, 01, 01));
        withDateOfLeaving(null);
        withEmploymentStatus(EmploymentStatus.EMPLOYED);
        return this;
    }
    
    public EmployeeBuilder withId(Long idNumber) {
        underConstruction.id = idNumber;
        return this;
    }
    
    public EmployeeBuilder withName(String name) {
        underConstruction.name = name;
        return this;
    }
    
    public EmployeeBuilder withSurname(String surname) {
        underConstruction.surname = surname;
        return this;
    }
    
    public EmployeeBuilder withDateOfEmployment(LocalDate ofEmployment) {
        underConstruction.dateOfEmployment = ofEmployment;
        return this;
    }
    
    public EmployeeBuilder withDateOfLeaving(LocalDate ofLeaving) {
        underConstruction.dateOfLeaving = ofLeaving;
        return this;
    }
    
    public EmployeeBuilder withEmploymentStatus(EmploymentStatus status) {
        underConstruction.employmentStatus = status;
        return this;
    }
    public EmployeeBuilder withYearsEmployed(int yearsEmployed) {
        underConstruction.dateOfEmployment = LocalDate.now().minusYears(yearsEmployed);
        return this;
    }
    
    public Employee Build() {
        Employee Built = underConstruction;
        underConstruction = new Employee();
        return Built;
    }
}
