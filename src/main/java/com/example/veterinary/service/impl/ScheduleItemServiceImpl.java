package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.schedule.ScheduleItemDto;
import com.example.veterinary.domain.entity.ScheduleItem;
import com.example.veterinary.domain.entity.Staff;
import com.example.veterinary.repository.ScheduleItemRepository;
import com.example.veterinary.repository.StaffRepository;
import com.example.veterinary.service.ScheduleItemService;
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
public class ScheduleItemServiceImpl implements ScheduleItemService {

    private final ScheduleItemRepository scheduleItemRepository;
    private final ConversionService conversionService;
    private final StaffRepository staffRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ScheduleItemDto> getAll() {

        return scheduleItemRepository.findAll()
                .stream()
                .map(item -> conversionService.convert(item, ScheduleItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleItemDto create(ScheduleItemDto scheduleItemDto) {
        Staff staff = staffRepository.getOne(scheduleItemDto.getStaffId());

        ScheduleItem scheduleItem = conversionService.convert(scheduleItemDto, ScheduleItem.class);
        scheduleItem.setStaff(staff);
        ScheduleItem result = scheduleItemRepository.save(scheduleItem);

        return conversionService.convert(result, ScheduleItemDto.class);
    }

    @Override
    public ScheduleItemDto update(ScheduleItemDto scheduleItemDto) {
        Staff staff = staffRepository.getOne(scheduleItemDto.getStaffId());

        ScheduleItem scheduleItem = conversionService.convert(scheduleItemDto, ScheduleItem.class);
        scheduleItem.setStaff(staff);
        ScheduleItem result = scheduleItemRepository.save(scheduleItem);

        return conversionService.convert(result, ScheduleItemDto.class);
    }

    @Override
    public void delete(UUID id) {
        scheduleItemRepository.deleteById(id);
    }
}
