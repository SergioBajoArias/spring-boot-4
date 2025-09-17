package com.sergio.springboot4.service;

import com.sergio.springboot4.model.Country;
import com.sergio.springboot4.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> findCountriesByName(String name) {
        return countryRepository.findCountriesByName(name);
    }

    @Override
    public List<Country> findAll() {
        Iterable<Country> results = countryRepository.findAll();
        List<Country> countries = new ArrayList<>();
        results.forEach(countries::add);
        return countries;
    }
}
