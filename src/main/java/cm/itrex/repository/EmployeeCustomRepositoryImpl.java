package cm.itrex.repository;

import cm.itrex.model.Employee;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class EmployeeCustomRepositoryImpl  implements EmployeeCustomRepository{

    private final EntityManager entityManager;

    public EmployeeCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findCustomQuery() {
        return List.of(Employee.builder().firstName("Olga").build());
    }
}
