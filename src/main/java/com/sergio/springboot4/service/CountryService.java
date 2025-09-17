package com.sergio.springboot4.service;

import com.sergio.springboot4.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(int id);
    List<Country> findCountriesByName(String name);
    List<Country> findAll();
}
