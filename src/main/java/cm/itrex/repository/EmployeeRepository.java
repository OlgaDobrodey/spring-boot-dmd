package cm.itrex.repository;

import cm.itrex.model.Employee;
import cm.itrex.projection.EmployeeNameView;
import cm.itrex.projection.EmployeeNameViewFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeCustomRepository{

    // @Query("select e from EmployeeEntity e where e.firstName = :name and e.salary = :salary")
//    @Query(value = "select e.* from employee e where e.first_name = :name and e.salary = :salary",
//            nativeQuery = true)
//    List<EmployeeEntity> findAllByFirstNameAndSalary(@Param("name") String firstName, @Param("salary") Integer salary);
    List<Employee> findAllByFirstNameAndSalary(String firstName, Integer salary);

    List<EmployeeNameView> findAllBySalaryGreaterThan(Integer salary);

    @Query(value = "select " +
            "e.id as id," +
            "e.first_name ||' '|| e.last_name as fullName  " +
            "from employee e " +
            "where e.salary > :salary", nativeQuery = true)
    List<EmployeeNameViewFull> findAllBySalaryGreaterThanNative(@Param("salary") Integer salary);
}
