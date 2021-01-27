package com.indus.training.persist.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.indus.training.persist.dao.ICountryDAO;
import com.indus.training.persist.entity.Country;
import com.indus.training.persist.exception.CountryPersistException;


@Repository
public class CountryDAO implements ICountryDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Country findCountryByID(String countryId) throws CountryPersistException {
		Country countryObj = null;

		try {
			countryObj = em.find(Country.class, countryId);
		} catch (Exception ex) {
			throw new CountryPersistException(ex);
		} finally {
			em.close();
		}

		return countryObj;
	}

	@Override
	public Country findCountryByName(String countryName) throws CountryPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Country> findCountryByRegion(int regionId) throws CountryPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insert(Country country) throws CountryPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Country country) throws CountryPersistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String countryId) throws CountryPersistException {
		// TODO Auto-generated method stub
		return null;
	}

}
