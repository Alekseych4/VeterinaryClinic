package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.entity.Staff;
import com.example.veterinary.repository.StaffRepository;
import com.example.veterinary.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StaffServiceImpl implements StaffService {

    private  final ConversionService conversionService;
    private final StaffRepository staffRepository;

    @Override
    public StaffDto create(StaffDto staffDto) {
        Staff staff = conversionService.convert(staffDto, Staff.class);
        Staff result = staffRepository.save(staff);
        return conversionService.convert(result, StaffDto.class);
    }

    @Override
    public StaffDto update(StaffDto staffDto) {
        Staff staff = conversionService.convert(staffDto, Staff.class);
        Staff res = staffRepository.save(staff);
        return conversionService.convert(res, StaffDto.class);
    }

    @Override
    public StaffDto findById(UUID id) {
        Staff staff = staffRepository.getOne(id);
        return conversionService.convert(staff, StaffDto.class);
    }

    @Override
    public StaffDto findByName(String name) {
        Staff staff = staffRepository.findByName(name);
        return conversionService.convert(staff, StaffDto.class);
    }

    @Override
    public void delete(UUID id) {
        staffRepository.deleteById(id);
    }
}
