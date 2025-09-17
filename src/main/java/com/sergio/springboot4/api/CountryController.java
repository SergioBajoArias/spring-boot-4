package com.sergio.springboot4.api;

import com.sergio.springboot4.model.Country;
import com.sergio.springboot4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable int id) {
        Optional<Country> customerOpt = countryService.findById(id);
        return customerOpt.map(customer ->
                new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping("/byName/{name}")
    public List<Country> findCountriesByName(@PathVariable String name) {
        return countryService.findCountriesByName(name);
    }
}
