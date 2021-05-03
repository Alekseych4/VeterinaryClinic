package com.example.veterinary.converter.schedule;

import com.example.veterinary.domain.dto.schedule.ScheduleItemDto;
import com.example.veterinary.domain.entity.ScheduleItem;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleItemDtoScheduleItemConverter implements Converter<ScheduleItemDto, ScheduleItem> {
    @Override
    public ScheduleItem convert(ScheduleItemDto source) {
        if (source.getId() == null){
            return ScheduleItem.builder()
                    .timeStart(source.getTimeStart())
                    .duration(source.getDuration())
                    .description(source.getDescription())
                    .build();
        }

        return new ScheduleItem(source.getId(), source.getTimeStart(), source.getDuration(), source.getDescription());
    }
}
