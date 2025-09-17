package com.sergio.springboot4.repository;

import com.sergio.springboot4.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    @Query("SELECT country FROM Country country WHERE country.nicename LIKE %:name%")
    List<Country> findCountriesByName(String name);
}
