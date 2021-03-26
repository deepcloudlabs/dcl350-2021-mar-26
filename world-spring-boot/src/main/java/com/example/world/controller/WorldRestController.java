package com.example.world.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.world.dao.CountryDao;
import com.example.world.domain.Country;
import com.example.world.dto.CountryRequest;

@RestController
@RequestMapping("countries")
@RequestScope
@CrossOrigin
public class WorldRestController {
	@Autowired // field injection
	private CountryDao countryDao;
	
	// Constructor injection
	public WorldRestController(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	@Autowired // field injection
	public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	// http://localhost:8100/world/api/v1/countries/TUR
	@GetMapping("{code}")
	public Country getCountryByCode(@PathVariable String code) {
		return countryDao.findCountryByCode(code);
	}
	
	// http://localhost:8100/world/api/v1/countries?page=0&size=10&continent=Asia
	@GetMapping(params = {"page", "size", "continent"})
	public Collection<Country> getCountriesByContinent(
			@RequestParam String continent,
			@RequestParam int page,
			@RequestParam int size){
		var offset = page*size;
		var limit = offset + size;
		return countryDao.findCountriesByContinent(continent).subList(offset, limit);
	}
	
	@PostMapping // Java Beans
	public void addCountry(@RequestBody CountryRequest request) {
		
	}
}
