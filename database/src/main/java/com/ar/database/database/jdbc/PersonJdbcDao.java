package com.ar.database.database.jdbc;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ar.database.database.entity.Person;
import com.sun.jmx.snmp.Timestamp;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll(){
		
		return jdbcTemplate.query("select * from PERSON", new BeanPropertyRowMapper(Person.class));
		
		
	}
	
	public Person findById(int id){
		
		return  jdbcTemplate.queryForObject("select * from PERSON where id =?", new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
		
		
	}
	
	public int deleteById(int id){
		
		return  jdbcTemplate.update("delete  from PERSON where id =?", new Object[] {id});
		
	}
	
	public int insertPerson(Person person){
		
		return  jdbcTemplate.update("insert into  person (id,name,location,birth_date) values (?,?,?,?) ", 
				new Object[] {person.getId(),person.getName(),person.getLocation(),  "1989-02-03 00:00:00"});
		
	}
	public int updatePerson(Person person){
		
		return  jdbcTemplate.update("update   PERSON set name =?,location=?,birth_date=? where id =? ", 
				new Object[] {person.getName(),person.getLocation(),  person.getBirthDate(),person.getId()});
		
	}


}
