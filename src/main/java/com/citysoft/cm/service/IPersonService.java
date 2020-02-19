package com.citysoft.cm.service;

import java.util.Set;

import com.citysoft.cm.dto.PersonDto;

public interface IPersonService {

	public PersonDto create(PersonDto person);
	public PersonDto update(PersonDto person);
	public PersonDto get(int id);
	public void delete(int id) throws Exception;
	public Set<PersonDto> fetch();
}
