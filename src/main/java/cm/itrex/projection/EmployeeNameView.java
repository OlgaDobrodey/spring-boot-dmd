package cm.itrex.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNameView {

    @Value("#{target.id+' '+target.firstName}")
    String getFirstName();
    String getLastName();
}
