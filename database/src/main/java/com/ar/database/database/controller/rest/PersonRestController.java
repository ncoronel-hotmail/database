package com.ar.database.database.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ar.database.database.entity.Person;
import com.ar.database.database.entity.PersonEntity;
import com.ar.database.database.jdbc.PersonJdbcDao;
import com.ar.database.database.jpa.PersonJpaRepository;

@RestController
public class PersonRestController {

	
	@Autowired
	PersonJdbcDao personJdbcDao;
	
	@Autowired
    PersonJpaRepository personJpaRepository;
	
	
	@GetMapping("/jpa/personById")
	public PersonEntity personByIdJpa(@RequestParam("id") int id){
		
		return personJpaRepository.findById(id);
	}
	
	
	@GetMapping("/listPerson")
	public List<Person> getAllPerson(){
		
		return personJdbcDao.findAll();
	}
	
	@GetMapping("/personById")
	public Person personById(@RequestParam("id") int id){
		
		return personJdbcDao.findById(id);
	}
	
	
	@DeleteMapping("/deletePersonById/{id}")
	public ResponseEntity<Integer> deletePersonById(@PathVariable("id") int id) {
		int value=0;
		ResponseEntity response;

		value = personJdbcDao.deleteById(id);
		
		if(value>0) {
			response= new  ResponseEntity<Integer>(value,HttpStatus.OK);
		}else {
			response= new  ResponseEntity<Integer>(value,HttpStatus.NO_CONTENT);

		}
		 
		return response;
	}
	
	
	@PostMapping("/insertPerson")
		public int insertPerson(@RequestBody Person person) {
			return personJdbcDao.insertPerson(person);
		}
	
	
	@PostMapping("/insertJpaPerson")
	public PersonEntity  insertJpaPerson(@RequestBody PersonEntity person) {
		return personJpaRepository.insertPerson(person);
	}

	
	@PutMapping("/updatePerson")
	public int updatePerson(@RequestBody Person person) {
		return personJdbcDao.insertPerson(person);
	}
	
	@PutMapping("/updateJpaPerson")
	public PersonEntity updateJpaPerson(@RequestBody PersonEntity person) {
		return personJpaRepository.updatePerson(person);
	}
	
	
	@DeleteMapping("/deleteJpaPersonById")
	public void deleteJpaPersonById(@RequestBody PersonEntity person) {
		personJpaRepository.deletePerson(person);
	}
}
