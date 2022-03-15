package cm.itrex.repository;

import cm.itrex.model.Employee;

import java.util.List;

public interface EmployeeCustomRepository {

    List<Employee> findCustomQuery();
}
