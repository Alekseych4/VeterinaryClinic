package com.example.veterinary.converter.user.staff;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.entity.Staff;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StaffDtoStaffConverter implements Converter<StaffDto, Staff> {
    @Override
    public Staff convert(StaffDto source) {
        Staff staff = new Staff(source.getUserType(), source.getName(), source.getSurname(),
                source.getPosition(), source.getExperience());
        staff.setId(source.getId());
        return staff;
    }
}
