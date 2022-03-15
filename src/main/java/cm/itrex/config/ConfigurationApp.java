package cm.itrex.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
//@Conditional(FirstConditional.class)
@Configuration
public class ConfigurationApp {

    @PostConstruct
    public void init() {
        log.warn("!!!!! APP!!!!");
    }
}
