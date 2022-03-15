package cm.itrex.repository;

import cm.itrex.IntegrationTest;
import cm.itrex.model.Employee;
import cm.itrex.projection.EmployeeNameView;
import cm.itrex.projection.EmployeeNameViewFull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeRepositoryTest extends IntegrationTest {

    private static final Integer IVAN_ID = 1;

    @Autowired
    EmployeeRepository employeeRepository;

//    @BeforeEach
//    void setUp() {
//        var hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl(POSTGRESQL_CONTAINER.getJdbcUrl());// Получить реальный jdbcUrl
//        hikariConfig.setUsername(POSTGRESQL_CONTAINER.getUsername());// Получить username
//        hikariConfig.setPassword(POSTGRESQL_CONTAINER.getPassword());// Получить password
//        var dataSource = new HikariDataSource(hikariConfig);
//        employeeRepository = new SpringJdbcFrameworkRepository(new FrameworkSimpleJdbcInsert(dataSource),
//                new JdbcTemplate(dataSource), FrameworkRowMapper.getInstance());
//    }

    @Test
    void findById() {
        Optional<Employee> employee = employeeRepository.findById(IVAN_ID);
        assertTrue(employee.isPresent());
    }

    @Test
    void findAllByFirstNameAndSalary() {
        List<Employee> employee = employeeRepository.findAllByFirstNameAndSalary("Ivan", 1000);
        assertThat(employee, hasSize(1));
    }

    @Test
    void findBySalary() {
        List<EmployeeNameView> nameViews = employeeRepository.findAllBySalaryGreaterThan(500);
        assertThat(nameViews, hasSize(2));
        assertEquals(nameViews.get(0).getFirstName(), "1 Ivan");
    }

    @Test
    void findBySalaryFullName() {
        List<EmployeeNameViewFull> nameViews = employeeRepository.findAllBySalaryGreaterThanNative(500);
        assertThat(nameViews, hasSize(2));
        assertEquals(nameViews.get(0).getFullName(), "Ivan Ivanov");
    }

    @Test
    void findCustomQuery() {
        List<Employee> customQuery = employeeRepository.findCustomQuery();

        assertThat(customQuery, hasSize(1));
        assertEquals(customQuery.get(0).getFirstName(), "Olga");
    }
}