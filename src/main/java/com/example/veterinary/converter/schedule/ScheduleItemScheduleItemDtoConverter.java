package com.example.veterinary.converter.schedule;

import com.example.veterinary.domain.dto.schedule.ScheduleItemDto;
import com.example.veterinary.domain.entity.ScheduleItem;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ScheduleItemScheduleItemDtoConverter implements Converter<ScheduleItem, ScheduleItemDto> {
    @Override
    public ScheduleItemDto convert(ScheduleItem source) {
        return new ScheduleItemDto(source.getId(), source.getTimeStart().getTime(), source.getDuration(),
                source.getStaffId(), source.getDescription());
    }
}
