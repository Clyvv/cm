package com.citysoft.cm.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citysoft.cm.dto.AddressDto;
import com.citysoft.cm.model.Address;

@Component
public class AddressMapper {

	@Autowired
    private ModelMapper modelMapper;
	
	public AddressDto convertToDto(Address address) {
		return modelMapper.map(address, AddressDto.class);
		
	}
	
	public Address convertToEntity(AddressDto dto) {
	    return modelMapper.map(dto, Address.class);
	}
	
}
