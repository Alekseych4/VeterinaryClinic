package com.example.veterinary.converter.user.staff;

import com.example.veterinary.domain.dto.user.StaffNoIdDto;
import com.example.veterinary.domain.entity.Staff;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StaffNoIdDtoStaffConverter implements Converter<StaffNoIdDto, Staff> {
    @Override
    public Staff convert(StaffNoIdDto source) {
        return new Staff(source.getUserType(), source.getName(), source.getSurname(), source.getPosition(),
                source.getExperience());
    }
}
