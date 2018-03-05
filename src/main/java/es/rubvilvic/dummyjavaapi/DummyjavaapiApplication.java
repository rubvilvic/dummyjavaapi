package es.rubvilvic.dummyjavaapi;

import es.rubvilvic.dummyjavaapi.config.InitConfig;
import es.rubvilvic.dummyjavaapi.util.PopulateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DummyjavaapiApplication {

	@Autowired
	private InitConfig initConfig;

	@Autowired
	private PopulateData populateData;

	public static void main(String[] args) {
		SpringApplication.run(DummyjavaapiApplication.class, args);
	}

	@PostConstruct
	public void configApp(){
		if (initConfig.getPopulate()){
			populateData.populateCities();
		}
	}
}
