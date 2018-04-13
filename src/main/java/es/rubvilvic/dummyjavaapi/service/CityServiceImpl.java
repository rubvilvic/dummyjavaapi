package es.rubvilvic.dummyjavaapi.service;

import es.rubvilvic.dummyjavaapi.model.City;
import es.rubvilvic.dummyjavaapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Collection<City> getCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }


}
