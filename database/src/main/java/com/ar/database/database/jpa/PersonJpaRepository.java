package com.ar.database.database.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ar.database.database.entity.PersonEntity;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public PersonEntity findById(int id) {

		return entityManager.find(PersonEntity.class, id);

	}

	public PersonEntity insertPerson(PersonEntity person) {

		return entityManager.merge(person);

	}
	
	public PersonEntity updatePerson(PersonEntity person) {

		return entityManager.merge(person);

	}
	
	public void deletePerson(PersonEntity person) {
		
		PersonEntity p= findById(person.getId());
		 entityManager.remove(p);

	}

}
