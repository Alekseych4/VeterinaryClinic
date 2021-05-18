package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.dto.user.UserRole;
import com.example.veterinary.domain.dto.user.UserStaffDto;
import com.example.veterinary.domain.entity.Staff;
import com.example.veterinary.domain.entity.User;
import com.example.veterinary.exception.controller.NoSuchRecordException;
import com.example.veterinary.repository.StaffRepository;
import com.example.veterinary.repository.UserRepository;
import com.example.veterinary.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StaffServiceImpl implements StaffService {

    private  final ConversionService conversionService;
    private final StaffRepository staffRepository;
    private final UserRepository userRepository;
    //TODO: delete this:
    @Override
    public StaffDto create(StaffDto staffDto) {
        Staff staff = conversionService.convert(staffDto, Staff.class);
        Staff result = staffRepository.save(staff);
        return conversionService.convert(result, StaffDto.class);
    }

    @Override
    public StaffDto update(StaffDto staffDto) {
        User user = userRepository.findById(staffDto.getId()).orElseThrow(() -> new NoSuchRecordException());

        Staff staff = conversionService.convert(staffDto, Staff.class);
        staff.setUser(user);
        Staff res = staffRepository.save(staff);
        return conversionService.convert(res, StaffDto.class);
    }

    @Override
    public StaffDto findById(UUID id) {
        Staff staff = staffRepository.findById(id).orElseThrow(() -> new NoSuchRecordException());
        return conversionService.convert(staff, StaffDto.class);
    }

    @Override
    public List<StaffDto> findByNameAndSurname(String fullName, String surname) {
        return staffRepository.findByNameAndSurname(fullName, surname)
                .stream()
                .map(item -> conversionService.convert(item, StaffDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        staffRepository.deleteById(id);
    }

    @Override
    public List<UserStaffDto> getAll() {
        return staffRepository.findAll().stream()
                .map(item -> conversionService.convert(item, UserStaffDto.class))
                .collect(Collectors.toList());
    }


}
