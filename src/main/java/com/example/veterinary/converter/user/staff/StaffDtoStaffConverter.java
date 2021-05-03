package com.example.veterinary.converter.user.staff;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.entity.Staff;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StaffDtoStaffConverter implements Converter<StaffDto, Staff> {
    @Override
    public Staff convert(StaffDto source) {
        if (source.getId() == null){
            return Staff.builder()
                    .userType(source.getUserType())
                    .name(source.getName())
                    .surname(source.getSurname())
                    .position(source.getPosition())
                    .experience(source.getExperience())
                    .build();
        }

        return new Staff(source.getId(), source.getUserType(), source.getName(), source.getSurname(),
                source.getPosition(), source.getExperience());
    }
}
