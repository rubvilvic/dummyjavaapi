package es.rubvilvic.dummyjavaapi.controller;

import es.rubvilvic.dummyjavaapi.model.City;
import es.rubvilvic.dummyjavaapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<City> saveCity(@RequestBody City city){
        City savedCity = cityService.saveCity(city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

}
