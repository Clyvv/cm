package com.citysoft.cm.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citysoft.cm.mapper.AddressMapper;
import com.citysoft.cm.model.Address;

@SpringBootTest
public class AddressDtoTests {

	@Autowired
    private AddressMapper addressMapper;
	
	
    @Test
    public void whenConvertAddressEntityToAddressDto_thenCorrect() {
    	Address address = new Address();
    	address.setId(1);
        address.setStreet("Main Street");
        address.setHouseNumber("1a");
        address.setPostCode("12345");
        address.setCity("Harare");
        address.setCountry("Zimbabwe");
 
        AddressDto addressDto = addressMapper.convertToDto(address);
        assertEquals(address.getId(), addressDto.getId());
        assertEquals(address.getStreet(), addressDto.getStreet());
        assertEquals(address.getHouseNumber(), addressDto.getHouseNumber());
        assertEquals(address.getPostCode(), addressDto.getPostCode());
        assertEquals(address.getCity(), addressDto.getCity());
        assertEquals(address.getCountry(), addressDto.getCountry());
    }

}
