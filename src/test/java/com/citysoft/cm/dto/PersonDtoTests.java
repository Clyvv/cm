package com.citysoft.cm.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citysoft.cm.mapper.PersonMapper;
import com.citysoft.cm.model.Address;
import com.citysoft.cm.model.Gender;
import com.citysoft.cm.model.Person;
import com.citysoft.cm.model.Title;

@SpringBootTest
public class PersonDtoTests {

	@Autowired
    private PersonMapper personMapper;
	
    
    @Test
    public void whenConvertPersonEntityToPersonDto_thenCorrect() {
        Person person = new Person();
        person.setId(1);
        person.setFirstName("Clive");
        person.setLastName("Mawoko");
        person.setGender(Gender.MALE);
        
        Title title = new Title();
        title.setId(1);
        title.setName("Frau");
        
        person.setTitle(title);
        
        Address address = new Address();
        address.setId(1);
        address.setStreet("Main Street");
        address.setHouseNumber("1a");
        address.setPostCode("12345");
        address.setCity("Harare");
        address.setCountry("Zimbabwe");
        
        person.setAddress(address);
        
 
        PersonDto personDto = personMapper.convertToDto(person);
        assertEquals(person.getId(), personDto.getId());
        assertEquals(person.getFirstName(), personDto.getFirstName());
        assertEquals(person.getLastName(), personDto.getLastName());
        assertEquals(person.getGender(), personDto.getGender());
        assertEquals(person.getTitle().getId(), personDto.getTitle().getId());
        assertEquals(person.getTitle().getName(), personDto.getTitle().getName());
        assertEquals(person.getAddress().getId(), personDto.getAddress().getId());
        assertEquals(person.getAddress().getStreet(), personDto.getAddress().getStreet());
        assertEquals(person.getAddress().getHouseNumber(), personDto.getAddress().getHouseNumber());
        assertEquals(person.getAddress().getPostCode(), personDto.getAddress().getPostCode());
        assertEquals(person.getAddress().getCity(), personDto.getAddress().getCity());
        assertEquals(person.getAddress().getCountry(), personDto.getAddress().getCountry());
    }

}
