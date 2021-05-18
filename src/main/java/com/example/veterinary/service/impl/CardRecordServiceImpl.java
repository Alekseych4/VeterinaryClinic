package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.patient.CardRecordDto;
import com.example.veterinary.domain.entity.Appointment;
import com.example.veterinary.domain.entity.CardRecord;
import com.example.veterinary.domain.entity.PatientCard;
import com.example.veterinary.domain.entity.Staff;
import com.example.veterinary.exception.controller.NoSuchRecordException;
import com.example.veterinary.repository.CardRecordRepository;
import com.example.veterinary.repository.PatientCardRepository;
import com.example.veterinary.repository.StaffRepository;
import com.example.veterinary.service.AppointmentService;
import com.example.veterinary.service.CardRecordService;
import com.example.veterinary.service.ScheduleItemService;
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
    private final ScheduleItemService scheduleItemService;

    @Override
    public CardRecordDto create(CardRecordDto cardRecordDto) {
        var patientCard = patientCardRepository.findById(cardRecordDto.getPatientCardId())
                .orElseThrow(NoSuchRecordException::new);
        var staff = staffRepository.findById(cardRecordDto.getStaffId())
                .orElseThrow(NoSuchRecordException::new);

        Appointment appointment = getAppointmentIfAny(patientCard, staff, cardRecordDto);

        CardRecord cardRecord = conversionService.convert(cardRecordDto, CardRecord.class);
        cardRecord.setPatientCard(patientCard);
        cardRecord.setStaff(staff);
        CardRecord result = cardRecordRepository.save(cardRecord);

        scheduleItemService.delete(appointment.getScheduleItem().getId());

        return conversionService.convert(result, CardRecordDto.class);
    }

    @Override
    public CardRecordDto update(CardRecordDto cardRecordDto) {
        var patientCard = patientCardRepository.findById(cardRecordDto.getPatientCardId())
                .orElseThrow(NoSuchRecordException::new);
        var staff = staffRepository.findById(cardRecordDto.getStaffId())
                .orElseThrow(NoSuchRecordException::new);

        CardRecord cardRecord = conversionService.convert(cardRecordDto, CardRecord.class);
        cardRecord.setPatientCard(patientCard);
        cardRecord.setStaff(staff);

        CardRecord result = cardRecordRepository.save(cardRecord);
        return conversionService.convert(result, CardRecordDto.class);
    }

    @Override
    public CardRecordDto findById(UUID id) {
        var cardRecord = cardRecordRepository.findById(id).orElseThrow(NoSuchRecordException::new);
        return conversionService.convert(cardRecord, CardRecordDto.class);
    }

    private Appointment getAppointmentIfAny(PatientCard patientCard, Staff staff, CardRecordDto cardRecordDto){
         return patientCard.getAppointments()
                .stream()
                .filter(item -> {
                    var scheduleItem = item.getScheduleItem();
                    var scheduleItemTimeStart = scheduleItem.getTimeStart();
                    var scheduleItemStaffId = scheduleItem.getStaff().getId();

                    boolean isTimeValid = scheduleItemTimeStart.before(cardRecordDto.getDate()) ||
                            scheduleItemTimeStart.equals(cardRecordDto.getDate());
                    boolean isStaffValid = scheduleItemStaffId.equals(staff.getId());

                    return isTimeValid && isStaffValid;
                })
                 .findFirst()
                 .orElseThrow(() -> new NoSuchRecordException("No appointment for this client"));
    }
}
