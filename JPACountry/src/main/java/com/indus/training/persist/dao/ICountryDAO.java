package com.indus.training.persist.dao;

import java.util.Set;

import com.indus.training.persist.entity.Country;
import com.indus.training.persist.exception.CountryPersistException;

public interface ICountryDAO 
{

	public Country findCountryByID(String countryId) throws CountryPersistException;

	public Country findCountryByName(String countryName) throws CountryPersistException;

	public Set<Country> findCountryByRegion(int regionId) throws CountryPersistException;

	public Boolean insert(Country country) throws CountryPersistException;

	public Boolean update(Country country) throws CountryPersistException;

	public Boolean delete(String countryId) throws CountryPersistException;
	
}
