package es.rubvilvic.dummyjavaapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("init")
public class InitConfig {

    private Boolean populate;

    public Boolean getPopulate() {
        return populate;
    }

    public void setPopulate(Boolean populate) {
        this.populate = populate;
    }
}
