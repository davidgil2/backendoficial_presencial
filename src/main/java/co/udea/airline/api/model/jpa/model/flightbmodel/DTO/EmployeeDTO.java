package co.udea.airline.api.model.jpa.model.flightbmodel.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an employee data transfer object (DTO) in the airline domain model.
 * This class encapsulates the information related to an employee, including their ID, name, and job title.
 */
@Setter
@Getter
@ToString
public class EmployeeDTO {
    /**
     * Unique identifier of the employee.
     */
    private Long id;
    /**
     * Name of the employee.
     */
    private String name;
    /**
     * Position of the employee in the company.
     */
    private String jobTitle;
}
