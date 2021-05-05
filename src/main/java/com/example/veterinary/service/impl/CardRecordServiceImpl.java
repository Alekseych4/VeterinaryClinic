package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.patient.CardRecordDto;
import com.example.veterinary.domain.entity.CardRecord;
import com.example.veterinary.domain.entity.PatientCard;
import com.example.veterinary.domain.entity.Staff;
import com.example.veterinary.repository.CardRecordRepository;
import com.example.veterinary.repository.PatientCardRepository;
import com.example.veterinary.repository.StaffRepository;
import com.example.veterinary.service.CardRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CardRecordServiceImpl implements CardRecordService {
    private final ConversionService conversionService;
    private final CardRecordRepository cardRecordRepository;
    private final PatientCardRepository patientCardRepository;
    private final StaffRepository staffRepository;

    @Override
    public CardRecordDto create(CardRecordDto cardRecordDto) {
        var patientCard = patientCardRepository.getOne(cardRecordDto.getPatientCardId());
        var staff = staffRepository.getOne(cardRecordDto.getStaffId());

        if (isAppointmentExist(patientCard, staff, cardRecordDto)) {

            CardRecord cardRecord = conversionService.convert(cardRecordDto, CardRecord.class);
            cardRecord.setPatientCard(patientCard);
            cardRecord.setStaff(staff);
            CardRecord result = cardRecordRepository.save(cardRecord);

            return conversionService.convert(result, CardRecordDto.class);
        }

        throw new RuntimeException("No appointment!");
    }

    @Override
    public CardRecordDto update(CardRecordDto cardRecordDto) {
        var patientCard = patientCardRepository.getOne(cardRecordDto.getPatientCardId());
        var staff = staffRepository.getOne(cardRecordDto.getStaffId());

        CardRecord cardRecord = conversionService.convert(cardRecordDto, CardRecord.class);
        cardRecord.setPatientCard(patientCard);
        cardRecord.setStaff(staff);

        CardRecord result = cardRecordRepository.save(cardRecord);
        return conversionService.convert(result, CardRecordDto.class);
    }

    @Override
    public CardRecordDto findById(UUID id) {
        var cardRecord = cardRecordRepository.getOne(id);
        return conversionService.convert(cardRecord, CardRecordDto.class);
    }

    private boolean isAppointmentExist (PatientCard patientCard, Staff staff, CardRecordDto cardRecordDto){
         return patientCard.getAppointments()
                .stream()
                .anyMatch(item -> {
                    var scheduleItem = item.getScheduleItem();
                    var scheduleItemTimeStart = scheduleItem.getTimeStart();
                    var scheduleItemStaffId = scheduleItem.getStaff().getId();

                    boolean isTimeValid = scheduleItemTimeStart.before(cardRecordDto.getDate()) ||
                            scheduleItemTimeStart.equals(cardRecordDto.getDate());
                    boolean isStaffValid = scheduleItemStaffId.equals(staff.getId());

                    return isTimeValid && isStaffValid;
                });
    }
}
