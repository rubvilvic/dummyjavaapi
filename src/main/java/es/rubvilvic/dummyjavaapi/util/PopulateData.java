package es.rubvilvic.dummyjavaapi.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.rubvilvic.dummyjavaapi.model.City;
import es.rubvilvic.dummyjavaapi.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class PopulateData {

    private final Logger logger = LoggerFactory.getLogger(PopulateData.class);

    @Autowired
    private CityRepository cityRepository;


    public void populateCities(){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<City>> typeReference = new TypeReference<List<City>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/cities.json");
        try{
            List<City> cities = mapper.readValue(inputStream, typeReference);
            cityRepository.saveAll(cities);
            logger.info("Cities saved.");
        }catch (IOException e){
            logger.error("Error populating cities.", e);
        }

    }

}
