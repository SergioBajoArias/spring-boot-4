package com.sergio.springboot4.api;

import com.sergio.springboot4.dto.CountryDto;
import com.sergio.springboot4.dto.CountrySmallDto;
import com.sergio.springboot4.model.Country;
import com.sergio.springboot4.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;
    private final ModelMapper modelMapper;

    @Autowired
    public CountryController(CountryService countryService, ModelMapper modelMapper) {
        this.countryService = countryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/{id}", version = "1")
    public ResponseEntity<CountryDto> findById(@PathVariable int id) {
        Optional<Country> countryOpt = countryService.findById(id);
        return countryOpt.map(country ->
                new ResponseEntity<>(convertToDto(country), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(version = "1")
    public List<CountryDto> findAll_v1() {
        return countryService.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(version = "2")
    public List<CountrySmallDto> findAll_v2() {
        return countryService.findAll().stream()
                .map(this::convertToSmallDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/byName/{name}", version = "1")
    public List<CountryDto> findCountriesByName(@PathVariable String name) {
        return countryService.findCountriesByName(name).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CountryDto convertToDto(Country country) {
        return modelMapper.map(country, CountryDto.class);
    }

    private CountrySmallDto convertToSmallDto(Country country) {
        return modelMapper.map(country, CountrySmallDto.class);
    }
}
