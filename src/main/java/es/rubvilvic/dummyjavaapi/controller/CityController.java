package es.rubvilvic.dummyjavaapi.controller;

import es.rubvilvic.dummyjavaapi.model.City;
import es.rubvilvic.dummyjavaapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/")
    public ResponseEntity<Collection<City>> getCities(){
        return new ResponseEntity(cityService.getCities(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable("id") Long id){
        Optional<City> city = cityService.getCityById(id);
        return city.isPresent()?new ResponseEntity(city, HttpStatus.OK):new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
