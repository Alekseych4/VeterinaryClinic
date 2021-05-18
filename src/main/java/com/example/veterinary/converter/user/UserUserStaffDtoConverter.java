package com.example.veterinary.converter.user;

import com.example.veterinary.domain.dto.user.UserStaffDto;
import com.example.veterinary.domain.entity.Staff;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserUserStaffDtoConverter implements Converter<Staff, UserStaffDto> {
    @Override
    public UserStaffDto convert(Staff source) {
        return new UserStaffDto(source.getId(), source.getName(), source.getSurname(), source.getPosition(),
                source.getExperience(), source.getEmail(), source.getUserRole());
    }
}
