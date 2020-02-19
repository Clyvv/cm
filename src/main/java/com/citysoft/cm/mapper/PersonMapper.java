package com.citysoft.cm.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citysoft.cm.dto.AddressDto;
import com.citysoft.cm.dto.PersonDto;
import com.citysoft.cm.dto.TitleDto;
import com.citysoft.cm.model.Address;
import com.citysoft.cm.model.Person;
import com.citysoft.cm.model.Title;

@Component
public class PersonMapper {

	@Autowired
    private ModelMapper modelMapper;
	
	public PersonDto convertToDto(Person person) {
		PersonDto dto = modelMapper.map(person, PersonDto.class);
		
		dto.setAddress(modelMapper.map(person.getAddress(), AddressDto.class));
		dto.setTitle(modelMapper.map(person.getTitle(), TitleDto.class));
	    return dto;
	}
	
	public Person convertToEntity(PersonDto dto) {
		Person entity = modelMapper.map(dto, Person.class);
		
		entity.setAddress(modelMapper.map(dto.getAddress(), Address.class));
		entity.setTitle(modelMapper.map(dto.getTitle(), Title.class));
	    return entity;
	}
	
	public Set<PersonDto> convertToDto(List<Person> persons) {
		
		Set<PersonDto> personDtos = new HashSet<>();
		for(Person person: persons) {
			personDtos.add(convertToDto(person));
		}
	    return personDtos;
	}
}
