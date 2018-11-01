package employee.model;

import java.time.LocalDate;

public class Employee {
    Long id;
    String name;
    String surname;
    LocalDate dateOfEmployment;
    LocalDate dateOfLeaving;
    EmploymentStatus employmentStatus;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateOfEmployment == null) ? 0 : dateOfEmployment.hashCode());
        result = prime * result + ((dateOfLeaving == null) ? 0 : dateOfLeaving.hashCode());
        result = prime * result + ((employmentStatus == null) ? 0 : employmentStatus.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        if (dateOfEmployment == null) {
            if (other.dateOfEmployment != null) {
                return false;
            }
        } else if (!dateOfEmployment.equals(other.dateOfEmployment)) {
            return false;
        }
        if (dateOfLeaving == null) {
            if (other.dateOfLeaving != null) {
                return false;
            }
        } else if (!dateOfLeaving.equals(other.dateOfLeaving)) {
            return false;
        }
        if (employmentStatus != other.employmentStatus) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (surname == null) {
            if (other.surname != null) {
                return false;
            }
        } else if (!surname.equals(other.surname)) {
            return false;
        }
        return true;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
    
    public LocalDate getDateOfLeaving() {
        return dateOfLeaving;
    }
    
    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }
    
}
