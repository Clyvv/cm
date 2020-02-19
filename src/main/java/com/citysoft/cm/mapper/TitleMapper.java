package com.citysoft.cm.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citysoft.cm.dto.TitleDto;
import com.citysoft.cm.model.Title;

@Component
public class TitleMapper {

	@Autowired
    private ModelMapper modelMapper;
	
	public TitleDto convertToDto(Title title) {
		return modelMapper.map(title, TitleDto.class);
		
	}
	
	public Title convertToEntity(TitleDto dto) {
	    return modelMapper.map(dto, Title.class);
	}
	public Set<TitleDto> convertToDto(List<Title> titles) {
		
		Set<TitleDto> titleDtos = new HashSet<>();
		for(Title title: titles) {
			titleDtos.add(convertToDto(title));
		}
	    return titleDtos;
	}
}
