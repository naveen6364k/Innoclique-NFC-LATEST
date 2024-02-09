package com.innoclique.service;

import com.innoclique.dto.PatientDetailsDTO;
import com.innoclique.entity.PatientDetails;
import com.innoclique.repositary.PatientdetailsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.NoSuchElementException;

/**
 * @author Naveen Kumar Chintala
 */

@Service
public class PatientDetailsService {

    @Autowired
    private PatientdetailsRepository patientdetailsRepository;

    public PatientDetails save(PatientDetailsDTO patientDetailsDTO) {
        PatientDetails patientDetails = new PatientDetails();
        BeanUtils.copyProperties(patientDetailsDTO, patientDetails);
        patientDetails = patientdetailsRepository.save(patientDetails);
        return patientDetails;
    }

    public void delete(Long id) {

        patientdetailsRepository.deleteById(id);
    }

    public void update(Long id, PatientDetailsDTO vO) {
        PatientDetails bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        patientdetailsRepository.save(bean);
    }

    public PatientDetailsDTO getById(Long id) {
        PatientDetails original = requireOne(id);
        return toDTO(original);
    }

    public Page<PatientDetailsDTO> query(PatientDetailsDTO vO) {
        throw new UnsupportedOperationException();
    }

    private PatientDetailsDTO toDTO(PatientDetails original) {
        PatientDetailsDTO bean = new PatientDetailsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PatientDetails requireOne(Long id) {
        return patientdetailsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
