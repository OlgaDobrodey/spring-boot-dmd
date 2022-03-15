package cm.itrex.repository;

import cm.itrex.IntegrationTest;
import cm.itrex.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcTemplateTest extends IntegrationTest {

    private static final String INSERT_SQL = "insert into company (name) values (?);";
    private static final String DELETE_RETURNING_SQL = "DELETE FROM company WHERE name = ? RETURNING *";

    @Autowired
    JdbcOperations jdbcOperations;

    @Test
    void testInsert() {
        int result = jdbcOperations.update(INSERT_SQL, "Microsoft");
        assertEquals(1, result);
    }

    @Test
    void testReturning() {
        String companyName = "Microsoft";
        jdbcOperations.update(INSERT_SQL, companyName);

        List<Company> result = jdbcOperations.query(DELETE_RETURNING_SQL,
                (rs, rowNum) -> Company.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build(), companyName);
        assertThat(result, hasSize(1));
        assertEquals(result.get(0).getName(),"Microsoft");
    }
}
