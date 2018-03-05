package es.rubvilvic.dummyjavaapi.service;

import es.rubvilvic.dummyjavaapi.model.City;

import java.util.Collection;
import java.util.Optional;

public interface CityService {

    public Collection<City> getCities();

    public Optional<City> getCityById(Long id);
}
