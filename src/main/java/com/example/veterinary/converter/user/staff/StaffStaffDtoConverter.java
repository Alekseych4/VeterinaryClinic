package com.example.veterinary.converter.user.staff;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.entity.Staff;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StaffStaffDtoConverter implements Converter<Staff, StaffDto> {
    @Override
    public StaffDto convert(Staff source) {
        return new StaffDto(source.getId(), source.getUserType(), source.getName(),
                source.getSurname(), source.getPosition(), source.getExperience());
    }
}
