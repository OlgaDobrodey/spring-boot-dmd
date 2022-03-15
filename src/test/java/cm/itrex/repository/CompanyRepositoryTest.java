package cm.itrex.repository;

import cm.itrex.IntegrationTest;
import cm.itrex.model.Company;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CompanyRepositoryTest extends IntegrationTest {

    private static final Integer APPLE_ID = 1;

    @Autowired
    private CompanyRepository companyRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGetById() {
        Optional<Company> id = companyRepository.findById(APPLE_ID);
        assertTrue(id.isPresent());
        id.ifPresent(entity -> {
            assertEquals("Apple", entity.getName());
        });
    }

    @Test
    public void testSave() {
        Company builder = Company.builder()
                .name("Yandex")
                .build();
        companyRepository.save(builder);
        assertNotNull(builder.getId());
    }
}