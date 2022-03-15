package cm.itrex.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${service.message}")
    private String message;

    public String greeting(){
        return message;
    }

}

