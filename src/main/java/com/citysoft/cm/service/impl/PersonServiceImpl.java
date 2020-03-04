package com.citysoft.cm.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citysoft.cm.dto.PersonDto;
import com.citysoft.cm.mapper.AddressMapper;
import com.citysoft.cm.mapper.PersonMapper;
import com.citysoft.cm.mapper.TitleMapper;
import com.citysoft.cm.model.Person;
import com.citysoft.cm.repository.PersonRepository;
import com.citysoft.cm.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService{
	
	@Autowired
	public PersonRepository personRepository;
	
	@Autowired
	public PersonMapper personMapper;
	
	@Autowired
	public AddressMapper addressMapper;
	
	@Autowired
	public TitleMapper titleMapper;

	@Override
	public PersonDto create(PersonDto personDto) {
		Person person = personMapper.convertToEntity(personDto);

		return personMapper.convertToDto(personRepository.save(person));
	}

	@Override
	public PersonDto update(PersonDto personDto) {
		if (personRepository.existsById(personDto.getId())) {
			Person person = personMapper.convertToEntity(personDto);
			
			return personMapper.convertToDto(personRepository.save(person));
		}else {
			return null;
		}
		
		
	}

	@Override
	public PersonDto get(int id) {
		if(personRepository.existsById(id)) {
			return personMapper.convertToDto(personRepository.getOne(id));
		}else {
			return null;
		}
	}

	@Override
	public void delete(int id) throws Exception {
		if(personRepository.existsById(id)) {
			personRepository.deleteById(id);
		}else {
			throw new Exception("Person "+id+ " not found");
		}
		
	}

	@Override
	public Set<PersonDto> fetch() {
		return personMapper.convertToDto(personRepository.findAll());
	}

}
