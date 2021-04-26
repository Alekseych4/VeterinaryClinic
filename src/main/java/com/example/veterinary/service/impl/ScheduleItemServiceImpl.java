package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.schedule.ScheduleItemDto;
import com.example.veterinary.domain.entity.ScheduleItem;
import com.example.veterinary.repository.ScheduleItemRepository;
import com.example.veterinary.service.ScheduleItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ScheduleItemServiceImpl implements ScheduleItemService {

    private final ScheduleItemRepository scheduleItemRepository;
    private final ConversionService conversionService;

    @Override
    public List<ScheduleItemDto> getAll() {

        return scheduleItemRepository.findAll()
                .stream()
                .map(item -> conversionService.convert(item, ScheduleItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleItemDto create(ScheduleItemDto scheduleItemDto) {
        ScheduleItem scheduleItem = conversionService.convert(scheduleItemDto, ScheduleItem.class);
        ScheduleItem result = scheduleItemRepository.save(scheduleItem);
        return conversionService.convert(result, ScheduleItemDto.class);
    }

    @Override
    public ScheduleItemDto update(ScheduleItemDto scheduleItemDto) {
        ScheduleItem scheduleItem = conversionService.convert(scheduleItemDto, ScheduleItem.class);
        ScheduleItem result = scheduleItemRepository.save(scheduleItem);
        return conversionService.convert(result, ScheduleItemDto.class);
    }

    @Override
    public void delete(UUID id) {
        scheduleItemRepository.deleteById(id);
    }
}
